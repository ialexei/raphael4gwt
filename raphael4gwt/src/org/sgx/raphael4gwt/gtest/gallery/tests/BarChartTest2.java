package org.sgx.raphael4gwt.gtest.gallery.tests;

import java.util.logging.Logger;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.GShape;
import org.sgx.raphael4gwt.graphael.bar.BarChart;
import org.sgx.raphael4gwt.graphael.bar.BarContext;
import org.sgx.raphael4gwt.graphael.bar.BarOpts;
import org.sgx.raphael4gwt.graphael.bar.BarSectorHoverListener;
import org.sgx.raphael4gwt.gtest.gallery.Test;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Rectangle;
/**
 * shows bargraph with columns hovering 
 * @author sg
 *
 */
public class BarChartTest2 extends Test {

static Logger logger = Logger.getLogger("BarChartTest2");

BarChart barchart=null;

private GShape flag2=null;

protected Shape flag1;

@Override
public void test() {
	double[][] data2 = new double[][]{
		{55, 20, 13, 32, 5, 1, 2, 10}
	};
	final String[] tags = {"ene", "feb", "mar", "abr", "may", "jun", "jul", "ago", "sep"};
	
	barchart = getGPaper().barchart(10, 10, 200, 220, data2, new BarOpts(BarOpts.TYPE_SOFT));
	BarSectorHoverListener hoverHandler1 = new BarSectorHoverListener() {				
		@Override
		public void hoverOut(BarContext ctx) {
			flag1.remove();
			flag1=null;
			flag2.remove();
			flag2=null;
		}
		@Override
		public void hoverIn(BarContext ctx) {
			if(flag2==null){
				flag2=getGPaper().tag(ctx.getBar().getX(), 
						ctx.getBar().getY(), ctx.getBar().getValue()+"", 0);
			}	
			if(flag1==null){
				Rectangle bb = ctx.getBar().getBBox();
				flag1 = 
//				getGPaper().blob(bb.getX(), bb.getY()+bb.getHeight(), text, angle)
						getGPaper().rect(bb.getX(), bb.getY()+bb.getHeight(), 
						bb.getWidth(), 10).attr(Attrs.create().fill("red")); 
			}	
		}
	};
	barchart.hover(hoverHandler1);	
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
