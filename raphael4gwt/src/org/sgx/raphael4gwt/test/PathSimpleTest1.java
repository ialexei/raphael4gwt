package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;

import com.google.gwt.user.client.ui.Image;

public class PathSimpleTest1 extends Test {

	public PathSimpleTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void test() {
//		getPaper().path();
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.PathSimpleTest1().getText();
		
	}

}
