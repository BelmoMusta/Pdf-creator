package org.mustabelmo.pdfcreator;

import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;

public class CustomizedDocument extends Document {
	public CustomizedDocument(int width, int height){
		addCreationDate();
		Rectangle pageSize = new Rectangle(width, height);
		setPageSize(pageSize);
		setMargins(0, 0, 0, 0);
	}
	public CustomizedDocument(int width){
		this(width, width);
	}
}
