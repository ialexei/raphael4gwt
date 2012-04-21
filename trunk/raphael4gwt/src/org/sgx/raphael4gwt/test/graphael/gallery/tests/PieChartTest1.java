package org.sgx.raphael4gwt.test.graphael.gallery.tests;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.pie.PieContext;
import org.sgx.raphael4gwt.graphael.pie.PieHoverListener;
import org.sgx.raphael4gwt.graphael.pie.PieOpts;
import org.sgx.raphael4gwt.graphael.pie.Piechart;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.test.Test;
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
		
		final Piechart piechart = getGPaper().piechart(300, 200, 100, vals, opts);
		
		piechart.sectorHover(new PieHoverListener() {		
			@Override
			public void hoverIn(PieContext c) {
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
			public void hoverOut(PieContext c) {
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
