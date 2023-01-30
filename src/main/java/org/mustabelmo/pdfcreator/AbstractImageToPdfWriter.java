package org.mustabelmo.pdfcreator;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractImageToPdfWriter {
	private final List<File> files = new ArrayList<>();
	private final List<String> extensions = new ArrayList<>();
	protected final File outputFile;
	
	public AbstractImageToPdfWriter(File outputFile) {
		this.outputFile = outputFile;
	}
	
	public AbstractImageToPdfWriter(String outputFile) {
		this(new File(outputFile));
	}
	
	public void registerExtension(String extension) {
		extensions.add(extension);
	}
	
	public void addSingleFile(String fullPath) {
		addSingleFile(new File(fullPath));
	}
	
	public void addSingleFile(File file) {
		files.add(file);
	}
	
	public void addDirectory(File directory) {
		File[] subFiles = directory.listFiles();
		if (subFiles != null) {
			files.addAll(Arrays.asList(subFiles));
		}
	}
	
	public void addDirectory(String directoryPath) {
		addDirectory(new File(directoryPath));
	}
	
	protected List<File> getFilteredFiles() {
		return files.stream()
				.filter(ExtensionsPredicate.forExtensions(extensions))
				.sorted(Comparator.comparing(File::getName))
				.collect(Collectors.toList());
	}
	
	public abstract void write() ;
}
