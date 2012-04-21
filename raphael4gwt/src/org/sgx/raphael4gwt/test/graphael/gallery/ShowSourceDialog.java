package org.sgx.raphael4gwt.test.graphael.gallery;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.TextArea;

public class ShowSourceDialog extends FlexTable {
	public ShowSourceDialog(String s) {
		
		Label lblNewLabel = new Label("java test class source code: ");
		setWidget(0, 0, lblNewLabel);
		getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_TOP);
		
		TextArea textArea = new TextArea();
		setWidget(1, 0, textArea);
		textArea.setSize("100%", "100%");
		textArea.setText(s);
	}

}
