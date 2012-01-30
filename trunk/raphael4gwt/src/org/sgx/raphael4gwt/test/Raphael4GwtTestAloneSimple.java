package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Circle;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * a gwt entry points that shows a very simple use case.
 * @author sg
 */
public class Raphael4GwtTestAloneSimple implements EntryPoint {
	@Override
	public void onModuleLoad() {
		//we will use a simple panel in which to put our aphael paper:
		SimplePanel paperPanel = new SimplePanel();
		
		//ensure the element is attach to document before crating raphael paper
		RootPanel.get().add(paperPanel); 
			
		//create the raphael paper using the simplepanel
		Paper paper = Raphael.paper(paperPanel.getElement(), 1500, 1500);
		
		//draw something
		Circle circle1 = paper.circle(150, 150, 40);
		circle1.setAttribute("fill", "red");	
	}	
}
