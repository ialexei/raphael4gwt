package org.sgx.raphael4gwt.tut;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Raphael4GwTTutorial implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Raphael4GwtManual m = new Raphael4GwtManual(); 
		RootPanel.get().add(m);
//		TutUtils.registerTutorialNatives(); 
//		MainPanel mp = new MainPanel(); 
//		RootPanel.get().add(mp); 
	}
;


}
