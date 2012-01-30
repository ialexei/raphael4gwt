package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Circle;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;

/**
 * a gwt entry points that shows a very simple use case using 
 * gwt.client.dom for creating an element in the body and attach 
 * a raphael paper to it. Has nothing to do with GWT widgets. 
 * @author sg
 */
public class Raphael4GwtTestAloneNoWidget implements EntryPoint {
	@Override
	public void onModuleLoad() {
		DivElement el1 = Document.get().createDivElement();
		
		//ensure the element is attach to document before crating raphael paper
		Document.get().getBody().appendChild(el1);
		
		//create the raphael paper using the simplepanel
		Paper paper = Raphael.paper(el1, 1500, 1500);
		
		//draw something
		Circle circle1 = paper.circle(150, 150, 40);
		circle1.setAttribute("fill", "red");	
	}	
}
