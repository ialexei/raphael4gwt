package org.sgx.espinillo.client.impl1.ui;

import org.sgx.espinillo.client.impl1.model.Document1;
import org.sgx.espinillo.client.model.Document;
import org.sgx.espinillo.client.model.SelectionListener;
import org.sgx.espinillo.client.model.VEditor;
import org.sgx.raphael4gwt.raphael.Paper;

public class VEditorMain {

public static Document newDocument(VEditor veditor, Paper p, String string, 
		SelectionListener l) {
	Document d = new Document1(veditor, p, "unamed1");
	d.addSelectionListener(l);
	veditor.setCurrentDocument(d);	
	return d;
}

}
