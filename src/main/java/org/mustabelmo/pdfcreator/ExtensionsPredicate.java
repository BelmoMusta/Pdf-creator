package org.mustabelmo.pdfcreator;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class ExtensionsPredicate implements Predicate<File> {
	private final List<String> extensions;
	
	public ExtensionsPredicate(List<String> extensions) {
		this.extensions = extensions;
	}
	
	public static ExtensionsPredicate forExtensions(List<String> extensions) {
		return new ExtensionsPredicate(extensions);
	}
	public static ExtensionsPredicate forSingleExtension(String extension) {
		return new ExtensionsPredicate(Collections.singletonList(extension));
	}
	
	@Override
	public boolean test(File aFile) {
		return extensions
				.stream()
				.anyMatch(extension -> aFile.getName().endsWith("." + extension));
		
	}
}
