package org.sgx.raphael4gwt.gtest.gallery.tests;

import java.util.logging.Logger;

import org.sgx.raphael4gwt.graphael.raphalytics.RaphalyticsChart;
import org.sgx.raphael4gwt.graphael.raphalytics.RaphalyticsOpts;
import org.sgx.raphael4gwt.gtest.gallery.Test;
import org.sgx.raphael4gwt.raphael.Paper;
/**
 * shows use of Raphalytics charts
 * @author sg
 *
 */
public class RaphalyticsTest1 extends Test {

	static Logger logger = Logger.getLogger("RaphalyticsTest1");
	
	@Override
	public void test() {
		double[][] data = new double[][]{
			{100, 300, 200, 400},
			{340, 310, 100, 120}
		};		
		String[] labels = {"1st", "2nd", "3rd", "4th"};
		
		String[][] tooltips = {
			{"tooltip 1", "some other", "information", "that can be somewhat long"},
			{"2 tooltip 2", "2 some other 2", "2 information 2", "2 that can be somewhat long 2"}
		}; 
		
		RaphalyticsOpts opts1 = RaphalyticsOpts.create()
				.width(600)
				.height(500)
				.gridtype("full_grid")
				.fill(true)
				.color(new String[]{"red", "green"}); 
		
		RaphalyticsChart chart1 = getGPaper().raphalytics(data, labels , tooltips, opts1); 
		
	}

	//test class stuff
	public RaphalyticsTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		setName("Raphalytics1");
		setDescription("RaphalyticsChart - https://github.com/tataencu/raphalytics");
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.RaphalyticsTest1().getText();
	}
	

}
