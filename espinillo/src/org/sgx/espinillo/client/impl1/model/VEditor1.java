package org.sgx.espinillo.client.impl1.model;

import org.sgx.espinillo.client.impl1.tools.Toolbar1;
import org.sgx.espinillo.client.impl1.ui.VEditorWidget;
import org.sgx.espinillo.client.impl1.util.ToolUtil;
import org.sgx.espinillo.client.model.AbstractVEditor;
import org.sgx.espinillo.client.model.Document;

public class VEditor1 extends AbstractVEditor{

//	private VEditorWidget veditorWidget;
	
	public VEditor1() {
		super();
		setToolbar(new Toolbar1());
//		veditorWidget = vew;
	}
	@Override
	public void newDocument(int x, int y) {
		// TODO Auto-generated method stub
		
	}
//	public VEditorWidget getVEditorWidget() {
//		return veditorWidget;
//	}
	@Override
	public void closeDocument(Document d) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setCurrentDocument(Document currentDocument) {
		super.setCurrentDocument(currentDocument);
		ToolUtil.getInstance().showPaperMask(currentDocument);
		ToolUtil.getInstance().hidePaperMask(currentDocument);
	}
}
