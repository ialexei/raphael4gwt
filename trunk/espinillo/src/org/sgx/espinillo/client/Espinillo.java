package org.sgx.espinillo.client;

import org.sgx.espinillo.client.impl1.ui.VEditorWidget;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 */
public class Espinillo implements EntryPoint {
	public void onModuleLoad() {
		
		RootPanel.get().add(VEditorWidget.getInstance());
		
//		RootPanel.get().add(new TestPanel1());
		
	}
}
