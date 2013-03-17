package org.sgx.raphael4gwt.gtest.gallery.tests;

import java.util.logging.Logger;

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
 * similar example as http://g.raphaeljs.com/piechart2.html
 * @author sg
 *
 */
public class PieChartTest2 extends Test {	
	
	@Override
	public void test() {
		double[] vals = new double[]{55, 20, 13, 32, 1, 5};
		
		
		//old - deprecated - using PieOptsOld
		
		PieOpts opts = PieOpts.create()
			.legend(new String[]{"%%.%% - Enterprise Users", "IE Users"})
			.legendpos("west")
			.href(new String[]{"http://55.com", "http://20.com", "http://13.com", "http://32.com"}); 
		
		final PieChart piechart = getGPaper().piechart(300, 200, 100, vals, opts);
		
		// a simple example of sectorHover() for registering listeners when individual sector hovering.
		piechart.sectorHover(new PieSectorHoverListener() {		
			@Override
			public void hoverIn(PieSector c) {
				c.getSector().stop();
				c.getSector().scale(1.1, 1.1, c.getCx(), c.getCy());
				if(c.getLabelIcon()!=null) {
					c.getLabelIcon().stop();
					c.getLabelIcon().attr(Attrs.create().r(7.5));
				}
				if(c.getLabelText()!=null) { 
					c.getLabelText().attr(Attrs.create().fontWeight(800).
						stroke(c.getSector().attr("fill")));
				}
			}			
			@Override
			public void hoverOut(PieSector c) {
				c.getSector().animate(Attrs.create().transform("s1 1 "+c.getCx()+" "+c.getCy()), 500, "bounce");
				if(c.getLabelIcon()!=null) {
					c.getLabelIcon().animate(Attrs.create().r(5), 500, "bounce");
				}
				if(c.getLabelText()!=null) {
					c.getLabelText().attr(Attrs.create().fontWeight(400));
				}
			}	
		});
		
	}

	//test class stuff
	public PieChartTest2(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		setName("piechart1");
		setDescription("similar example as http://g.raphaeljs.com/piechart2.html");
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.PieChartTest1().getText();
	}

	static Logger logger = Logger.getLogger("PieChartTest1");
}
