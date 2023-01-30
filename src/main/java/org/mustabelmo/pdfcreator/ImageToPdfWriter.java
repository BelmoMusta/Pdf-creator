package org.mustabelmo.pdfcreator;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ImageToPdfWriter extends AbstractImageToPdfWriter {
	
	public ImageToPdfWriter(File outputFile) {
		super(outputFile);
	}
	
	public ImageToPdfWriter(String outputFile) {
		super(new File(outputFile));
	}
	
	@Override
	public void write() {
		final List<File> filteredFiles = getFilteredFiles();
		final Document document = new CustomizedDocument(1080);
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(outputFile));
			document.open();
			for (File file : filteredFiles) {
				final Image image = Image.getInstance(file.getAbsolutePath());
				document.newPage();
				document.add(image);
			}
			document.close();
			
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
	}
}
