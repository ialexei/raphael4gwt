package org.sgx.espinillo.client.impl1.ui;

import org.sgx.espinillo.client.model.Document;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SaveDialog extends DialogBox {
	private Document doc;

	public SaveDialog(Document doc) {
		super();
		this.doc=doc;
		VerticalPanel vp = new VerticalPanel();
		add(vp);
		TextArea input = new TextArea();
		input.setSize("100%", "200px");
		vp.add(new Label("This is \""+doc.getName()+"\" data\nPlease copy&paste it in a text file."));
		vp.add(input);
		FlowPanel buttonPanel = new FlowPanel();
		vp.add(buttonPanel);
		buttonPanel.add(new Button("Cancel", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				SaveDialog.this.hide();
			}
		}));
		buttonPanel.add(new Button("Save", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				
			}
		}));
	}
}
