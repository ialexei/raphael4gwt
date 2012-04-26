package org.sgx.raphael4gwt.gtest.gallery.tests;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.bar.BarChart;
import org.sgx.raphael4gwt.graphael.bar.BarContext;
import org.sgx.raphael4gwt.graphael.bar.BarOpts;
import org.sgx.raphael4gwt.graphael.bar.BarSectorHoverListener;
import org.sgx.raphael4gwt.gtest.gallery.Test;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.Callback;
/**
 * shows bargraph with columns hovering 
 * @author sg
 *
 */
public class BarChartTest2 extends Test {

	static Logger logger = Logger.getLogger("BarChartTest2");
	
	Set flag=null;
	BarChart barchart=null;
	private BarChart hbarchart;

	protected Set flag2;
	
	@Override
	public void test() {
		double[][] data2 = new double[][]{
			{55, 20, 13, 32, 5, 1, 2, 10}
		};

		barchart = getGPaper().barchart(10, 10, 200, 220, data2, new BarOpts(BarOpts.TYPE_SOFT));
		BarSectorHoverListener hoverHandler1 = new BarSectorHoverListener() {				
			@Override
			public void hoverOut(BarContext ctx) {
				flag.animate(Attrs.create().opacity(0), 300, ">", new Callback() {					
					@Override
					public void call(Shape src) {
						src.remove();
					}
				});
			}			
			@Override
			public void hoverIn(BarContext ctx) {
				logger.log(Level.INFO, ctx.getBars().length()+"");
				flag = getGPaper().popup(ctx.getBar().getX(), ctx.getBar().getY(), ctx.getBar().getValue()+"");
			}
		};
		barchart.hoverRow(hoverHandler1);
		
		BarSectorHoverListener hoverHandler2 = new BarSectorHoverListener() {				
			@Override
			public void hoverOut(BarContext ctx) {
//				flag2.remove();
				flag.animate(Attrs.create().opacity(0), 100, ">", new Callback() {					
					@Override
					public void call(Shape src) {
						src.remove();
					}
				});
			}			
			@Override
			public void hoverIn(BarContext ctx) {
//				logger.log(Level.INFO, ctx.getBars().length()+"");
				flag2 = getGPaper().popup(ctx.getBars().get(0).getX(), 
						ctx.getBars().get(0).getY(), ctx.getBars().get(0).getValue()+"");
			}
		};
		hbarchart = getGPaper().hbarchart(210, 10, 200, 220, data2, new BarOpts(true, BarOpts.TYPE_SOFT));
		hbarchart.hoverColumn(hoverHandler2);		
	}

	//test class stuff
	public BarChartTest2(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		setName("bar2");
		setDescription("shows bargraph with columns hovering ");
	}
	GPaper getGPaper() {
		return (GPaper)paper;
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.BarChartTest2().getText();
	}

}
