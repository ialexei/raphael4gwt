package org.sgx.raphael4gwt.test.graphael.gallery.tests;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.GShape;
import org.sgx.raphael4gwt.graphael.dot.DotChart;
import org.sgx.raphael4gwt.graphael.dot.DotContext;
import org.sgx.raphael4gwt.graphael.dot.DotHoverListener;
import org.sgx.raphael4gwt.graphael.dot.DotOpts;
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
 * similar example as http://g.raphaeljs.com/dotchart.html
 * @author sg
 *
 */
public class DotChartTest1 extends Test {	
	
	protected GShape tag;
	@Override
	public void test() {
		double[] xs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 
				0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 
				0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 
				0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 
				0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 
				0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 
				0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
		
		double[] ys = {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 
				6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 
				5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 
				4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 
				3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 
				2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		
		double[] data = {294, 300, 204, 255, 348, 383, 334, 217, 114, 33, 44, 26, 41, 39, 
				52, 17, 13, 2, 0, 2, 5, 6, 64, 153, 294, 313, 195, 280, 365, 392, 340, 184, 
				87, 35, 43, 55, 53, 79, 49, 19, 6, 1, 0, 1, 1, 10, 50, 181, 246, 246, 220, 
				249, 355, 373, 332, 233, 85, 54, 28, 33, 45, 72, 54, 28, 5, 5, 0, 1, 2, 3, 
				58, 167, 206, 245, 194, 207, 334, 290, 261, 160, 61, 28, 11, 26, 33, 46, 36, 
				5, 6, 0, 0, 0, 0, 0, 0, 9, 9, 10, 7, 10, 14, 3, 3, 7, 0, 3, 4, 4, 6, 28, 24, 
				3, 5, 0, 0, 0, 0, 0, 0, 4, 3, 4, 4, 3, 4, 13, 10, 7, 2, 3, 6, 1, 9, 33, 32, 6, 
				2, 1, 3, 0, 0, 4, 40, 128, 212, 263, 202, 248, 307, 306, 284, 222, 79, 39, 26, 
				33, 40, 61, 54, 17, 3, 0, 0, 0, 3, 7, 70, 199};
		
		String[] axisy = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
		String[] axisx = {"12am", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12pm", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
		
		DotOpts opts = new DotOpts();
		opts.setSymbol("o");
		opts.setMax(10);
		opts.setHeat(true);	
		opts.setAxis("0 0 1 1");
		opts.setAxisxlabels(axisx); 
		opts.setAxisylabels(axisy);
		
		final DotChart c1 = getGPaper().dotchart(10, 10, 620, 260, xs, ys, data, opts);
		c1.hoverDot(new DotHoverListener() {
			
			@Override
			public void hoverOut(DotContext ctx) {
				if(tag!=null)
					tag.remove();
			}
			
			@Override
			public void hoverIn(DotContext ctx) {
					tag = (GShape) getGPaper().tag(ctx.getX(), ctx.getY(), ctx.getValue()+"", 0, ctx.getR()+2).
							insertBefore(ctx).show();
			}
		});
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
