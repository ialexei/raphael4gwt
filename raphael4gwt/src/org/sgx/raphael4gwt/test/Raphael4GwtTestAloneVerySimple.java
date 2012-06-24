package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Attr;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.base.Gradient;
import org.sgx.raphael4gwt.raphael.base.Stop;

import com.google.gwt.core.client.EntryPoint;

/**
 * a gwt entry points that shows a very simple use case.
 * @author sg
 */
public class Raphael4GwtTestAloneVerySimple implements EntryPoint {
	@Override
	public void onModuleLoad() {
		Paper paper = Raphael.paper(0, 0, 600, 600);
		Gradient g1 = Gradient.linear(0, "#fff", new Stop[]{new Stop("#f00", 20)}, "#000");
		paper.rect(20,  10, 220, 250, 14).attr(new Attr().fill(g1));
	}	
}
