package org.sgx.raphael4gwt.gtest.gallery.tests;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.pie.PieSector;
import org.sgx.raphael4gwt.graphael.pie.PieSectorCallback;
import org.sgx.raphael4gwt.graphael.pie.PieSectorHoverListener;
import org.sgx.raphael4gwt.graphael.pie.PieOpts;
import org.sgx.raphael4gwt.graphael.pie.PieChart;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.gtest.gallery.Test;

import com.google.gwt.user.client.Window;
/**
 * similar example as http://g.raphaeljs.com/piechart2.html
 * @author sg
 *
 */
public class PieChartTest1 extends Test {	
	
	@Override
	public void test() {
		double[] vals = new double[]{10,40,60,80};
		
		PieOpts opts = new PieOpts(
			new String[]{"%%.%% - Enterprise Users", "IE Users"}, 
			PieOpts.LEGENDPOS_WEST, 
			new String[]{"http://raphaeljs.com", "http://g.raphaeljs.com"}
		);
		
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
					c.getLabelText().attr(Attrs.create().fontWeight(800));
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
		
		//a simple example of using sectorEach() for iterating through pie chart sectors
		final StringBuffer sb = new StringBuffer("sectors labels: ");
		piechart.sectorEach(new PieSectorCallback() {			
			@Override
			public void call(PieSector ctx) {
				if(ctx.getLabelText()!=null) {
					sb.append(ctx.getLabelText().getAttribute("text")+", ");
				}
			}
		});
		Window.alert(sb.toString());
	}

	//test class stuff
	public PieChartTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		setName("piechart2");
		setDescription("similar example as http://g.raphaeljs.com/piechart2.html");
	}
	GPaper getGPaper() {
		return (GPaper)paper;
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.PieChartTest1().getText();
	}

}
