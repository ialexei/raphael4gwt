package org.sgx.raphael4gwt.gtest.gallery.tests;

import java.util.logging.Logger;

import org.sgx.raphael4gwt.graphael.GShape;
import org.sgx.raphael4gwt.graphael.pie.PieChart;
import org.sgx.raphael4gwt.graphael.pie.PieOpts;
import org.sgx.raphael4gwt.graphael.pie.PieSector;
import org.sgx.raphael4gwt.graphael.pie.PieSectorCallback;
import org.sgx.raphael4gwt.graphael.pie.PieSectorHoverListener;
import org.sgx.raphael4gwt.gtest.gallery.Test;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.base.Attrs;

import com.google.gwt.user.client.Window;
/**
 * using http://jsfiddle.net/EuMQ5/
 * @author sg
 *
 */
public class DonutChartTest1 extends Test {	
	
	@Override
	public void test() {
		double[] vals = new double[]{55, 20, 13, 32, 1, 5};
		String[] legends = {"Batman", "Superman", "Spiderman", "Lafayette", "Jim Morrison", "Alex de la Iglesia"}; 
		
		GShape chart = getGPaper().donutChart(200, 200, 120, 50, vals, legends, "#000000"); 
		
	}

	//test class stuff
	public DonutChartTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		setName("donutChart1");
		setDescription("using this simple infraestructure: http://jsfiddle.net/EuMQ5/");
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.DonutChartTest1().getText();
	}

	static Logger logger = Logger.getLogger("DonutChartTest1");
}
