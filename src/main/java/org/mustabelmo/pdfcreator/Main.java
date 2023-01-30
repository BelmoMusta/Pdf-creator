package org.mustabelmo.pdfcreator;

public class Main {
	public static final String PNG = "png";
	private static final String FILE_NAME = "/tmp/out.pdf";
	private static String PATHNAME = "/Users/mac/Desktop/figma/out/";
	
	public static void main(String[] args) {
		ImageToPdfWriter imageToPdfWriter = new ImageToPdfWriter(FILE_NAME);
		imageToPdfWriter.addDirectory(PATHNAME);
		imageToPdfWriter.registerExtension(PNG);
		imageToPdfWriter.write();
		
	}
	
}