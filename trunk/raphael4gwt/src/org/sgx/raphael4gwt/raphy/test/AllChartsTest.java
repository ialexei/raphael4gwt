package org.sgx.raphael4gwt.raphy.test;

import org.sgx.raphael4gwt.raphy.test.app.AllCharts;
import org.sgx.raphael4gwt.raphy.test.app.MainPanel;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class AllChartsTest implements EntryPoint {

	@Override
	public void onModuleLoad() {
		RootPanel.get().add(new AllCharts()); 
	}


}
