package org.sgx.raphael4gwttest.client;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.pie.PieOpts;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.RaphaelLoader;
import org.sgx.raphael4gwt.raphael.RaphaelLoader.Listener;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

public class Raphael4gwtNoScriptTestEP implements EntryPoint {

	@Override
	public void onModuleLoad() {
		RaphaelLoader.loadGRaphael(new Listener() {			
			@Override
			public void loaded(Exception error) {
				if(error == null)
					test1();
				else {
					Window.alert("ERROR loading graphael : "+error);
					error.printStackTrace(); 
				}
			}
		}); 
		test1();
	}

	private void test1() {
        GPaper paper = (GPaper)Raphael.paper(0,0,600,600);
        PieOpts opts = PieOpts.create(); 
        paper.piechart(200f, 200, 100, new double[]{10, 40, 70, 90}, opts);
	}

}
