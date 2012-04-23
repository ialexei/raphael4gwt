package org.sgx.raphael4gwt.test.graphael.gallery.tests;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.pie.PieSector;
import org.sgx.raphael4gwt.graphael.pie.PieSectorCallback;
import org.sgx.raphael4gwt.graphael.pie.PieSectorHoverListener;
import org.sgx.raphael4gwt.graphael.pie.PieOpts;
import org.sgx.raphael4gwt.graphael.pie.PieChart;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.test.Test;

import com.google.gwt.user.client.Window;
/**
 * similar example as http://g.raphaeljs.com/piechart2.html
 * @author sg
 *
 */
public class DotChartTest1 extends Test {	
	
	@Override
	public void test() {
		
	}

	//test class stuff
	public DotChartTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		setName("dot1");
		setDescription("");
	}
	GPaper getGPaper() {
		return (GPaper)paper;
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.DotChartTest1().getText();
	}

}
