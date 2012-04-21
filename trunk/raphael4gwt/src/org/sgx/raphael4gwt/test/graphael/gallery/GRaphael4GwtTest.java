package org.sgx.raphael4gwt.test.graphael.gallery;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class GRaphael4GwtTest implements EntryPoint {

	@Override
	public void onModuleLoad() {
		testMainPanel();
	}
	
	private void testMainPanel() {
		RootPanel.get().add(new MainPanel());
	}

}
