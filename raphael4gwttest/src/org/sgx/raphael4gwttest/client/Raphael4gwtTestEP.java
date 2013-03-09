package org.sgx.raphael4gwttest.client;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.pie.PieOpts;
import org.sgx.raphael4gwt.raphael.Raphael;

import com.google.gwt.core.client.EntryPoint;

public class Raphael4gwtTestEP implements EntryPoint {

	@Override
	public void onModuleLoad() {
//		test0();
		test1();
	}

	private void test1() {
        GPaper paper = (GPaper)Raphael.paper(0,0,600,600);
        PieOpts opts = PieOpts.create(); 
        paper.piechart(200f, 200, 100, new double[]{10, 40, 70, 90}, opts);

	}

}
