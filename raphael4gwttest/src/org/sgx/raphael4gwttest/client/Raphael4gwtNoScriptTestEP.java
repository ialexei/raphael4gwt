package org.sgx.raphael4gwttest.client;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.GRaphaelLoader;
import org.sgx.raphael4gwt.graphael.pie.PieOpts;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.RaphaelLoader.Listener;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class Raphael4gwtNoScriptTestEP implements EntryPoint {

	@Override
	public void onModuleLoad() {
		RootPanel.get().add(new Button("load graphael example", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				GRaphaelLoader.loadGRaphael(new Listener() {			
					@Override
					public void loaded(Exception error) {
						if(error == null) {
							doGraphaelExample(); 
						}
						else {
							Window.alert("ERROR loading graphael : "+error);
							error.printStackTrace(); 
						}
					}
				}); 
			}
		})); 
		
	}

	private void doGraphaelExample() {
        GPaper paper = Raphael.paper(0,0,600,600).cast();
        PieOpts opts = PieOpts.create(); 
        paper.piechart(200f, 200, 100, new double[]{10, 40, 70, 90}, opts);
	}

}
