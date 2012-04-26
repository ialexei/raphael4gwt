	package org.sgx.raphael4gwt.gtest.gallery.tests;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.bar.BarOpts;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.gtest.gallery.Test;
/**
 * shows 4 different bar graphs
 * @author sg
 *
 */
public class BarChartTest3 extends Test {	
	
 
	@Override
	public void test() {
		double[][] data2 = new double[][]{
			{55, 20, 13, 32, 5, 1, 2, 10}
		};
		double[][] data1 = new double[][]{
			{55, 20, 13, 32, 5, 1, 2, 10},
			{10, 2, 1, 5, 32, 13, 20, 55},
			{12, 20, 30}
		};
		
		Attrs txtattr = Attrs.create().font("12px sans-serif"); 
		
		getPaper().text(160, 10, "Single Series Chart").attr(txtattr);
		getPaper().text(380, 10, "Multiline Series Chart").attr(txtattr);
		getPaper().text(130, 190, "Multiple Series Stacked Chart").attr(txtattr);
		getPaper().text(380, 190, "Multiline Series Stacked Vertical Chart. Type 'round'").attr(txtattr);

		getGPaper().barchart(10, 10, 200, 160, data2, new BarOpts(BarOpts.TYPE_SOFT));
		getGPaper().barchart(230, 10, 200, 160, data1);
		getGPaper().barchart(10, 210, 200, 160, data1, new BarOpts(true));
		getGPaper().barchart(230, 210, 200, 160, data1, new BarOpts(true, BarOpts.TYPE_ROUND));
				
	}

	//test class stuff
	public BarChartTest3(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		setName("bar3");
		setDescription("shows 4 different bar graphs");
	}
	GPaper getGPaper() {
		return (GPaper)paper;
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.BarChartTest3().getText();
	}

}
