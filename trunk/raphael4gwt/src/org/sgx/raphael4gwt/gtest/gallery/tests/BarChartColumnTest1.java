	package org.sgx.raphael4gwt.gtest.gallery.tests;

import java.util.logging.Logger;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.bar.BarChart;
import org.sgx.raphael4gwt.graphael.bar.BarContext;
import org.sgx.raphael4gwt.graphael.bar.BarOpts;
import org.sgx.raphael4gwt.graphael.bar.BarSectorCallback;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.AnimKeyFrames;
import org.sgx.raphael4gwt.raphael.base.Animation;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.util.Util;
import org.sgx.raphael4gwt.gtest.gallery.Test;

import com.google.gwt.user.client.Window;
/**
 * show horizontal bar charts with event listeners
 * @author sg
 *
 */
public class BarChartColumnTest1 extends Test {	

@Override
public void test() {
	
	double[][] data1 = new double[][]{
		{55, 20, 13, 32, 5, 1, 2, 10},
		{10, 2, 1, 5, 32, 13, 20, 55},
		{12, 20, 30}
	};
	
	Attrs txtattr = Attrs.create().font("12px sans-serif"); 
	
	getPaper().text(160, 10, "horizontal not stacked").attr(txtattr);
	
	BarChart chart1 = getGPaper().hbarchart(10, 10, 200, 160, data1, 
			new BarOpts(false, BarOpts.TYPE_SOFT));
	
	getPaper().text(460, 10, "horizontal stacked - click and hover the bars").attr(txtattr);
	
	BarChart chart2 = getGPaper().hbarchart(220, 10, 200, 160, data1, 
			new BarOpts(true, BarOpts.TYPE_SOFT));
	
	chart2.each(new BarSectorCallback() {
		
		@Override
		public boolean call(BarContext ctx) {
			ctx.getBars().attr(Attrs.create().
				strokeWidth(3).
				strokeDashArray(".").
				stroke(Util.randomColor())
			);
			return true;
		}
	});
	
	chart2.click(new BarSectorCallback() {		
		@Override
		public boolean call(BarContext ctx) {
//			Window.alert(ctx+"");
			AnimKeyFrames kf = AnimKeyFrames.create().
			  	put("20%" ,Attrs.create().fill(Util.randomColor())).
			    put("100%", Attrs.create().fill(Util.randomColor())); 
			ctx.getBars().animate(kf, 2000);
//			ctx.getBars().attr(Attrs.create().fill(Util.randomColor()));
			return true;
		}
	});
	
}

//test class stuff
static Logger logger = Logger.getLogger("BarChartColumnTest1");
 
public BarChartColumnTest1(Paper paper, int paperWidth, int paperHeight) {
	super(paper, paperWidth, paperHeight);
	setName("bar4");
	setDescription("show horizontal bar charts with event listeners");
}
GPaper getGPaper() {
	return (GPaper)paper;
}
@Override
public String getJavaClassSource() {
	return TestResources.INSTANCE.BarChartColumnTest1().getText();
}

}
