package org.mustabelmo.pdfcreator;

import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;

public class CustomizedDocument extends Document {
	public CustomizedDocument(int width, int height) {
		addCreationDate();
		Rectangle pageSize = new Rectangle(width, height);
		setPageSize(pageSize);
		resetMargins();
	}
	
	private void resetMargins() {
		setMargins(0, 0, 0, 0);
	}
	
	public CustomizedDocument(int width) {
		this(width, width);
	}
	
	public CustomizedDocument() {
		resetMargins();
	}
	
	public void setDimensions(float width, float height) {
		setPageSize(new Rectangle(width, height));
	}
}
