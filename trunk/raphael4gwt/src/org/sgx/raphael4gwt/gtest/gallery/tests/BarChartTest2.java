package org.sgx.raphael4gwt.gtest.gallery.tests;

import java.util.logging.Logger;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.GShape;
import org.sgx.raphael4gwt.graphael.bar.Bar;
import org.sgx.raphael4gwt.graphael.bar.BarChart;
import org.sgx.raphael4gwt.graphael.bar.BarContext;
import org.sgx.raphael4gwt.graphael.bar.BarOpts;
import org.sgx.raphael4gwt.graphael.bar.BarSectorHoverListener;
import org.sgx.raphael4gwt.gtest.gallery.Test;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Rectangle;
import org.sgx.raphael4gwt.raphael.event.Callback;
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

protected GShape popup;

private BarChart hbarchart2;

@Override
public void test() {
	double[][] data2 = new double[][]{
		{55, 20, 13, 32, 5, 1, 2, 10}
	};
	
	BarOpts opts1 = new BarOpts();
	opts1.setType(BarOpts.TYPE_SOFT); 
	
	barchart = getGPaper().barchart(10, 10, 400, 420, data2, opts1);
	barchart.label(new String[][]{{"2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015"}}, false); 
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
				flag2.attr(Attrs.create().fill("blue").stroke("brown")); 
			}	
			if(flag1==null){
				Rectangle bb = ctx.getBar().getBBox();
				flag1 = 
						getGPaper().rect(bb.getX(), bb.getY()+bb.getHeight(), 
						bb.getWidth(), 10).attr(Attrs.create().fill("red")); 
			}	
		}
	};
	barchart.hover(hoverHandler1);	
	
	
	double[][] stackedData = new double[][] { { 55, 20, 13, 32, 5, 1, 2, 10 }, { 20, 15, 30, 12, 10, 5, 1, 2 } };
    BarSectorHoverListener hoverHandlerStacked = new BarSectorHoverListener() {
        @Override
        public void hoverOut(BarContext ctx) {
            if (popup != null) {
                popup.animate(Attrs.create().opacity(0), 100, ">", new Callback() {
                    @Override
                    public void call(Shape src) {
                        src.remove();
                    }
                });
            }
        }
        @Override
        public void hoverIn(BarContext ctx) {
        	Bar bar = (Bar) ctx.getBars().firstShape();
            popup = getGPaper().tag(bar.getX(), bar.getY(),
            		bar.getValue() + "", 0, 8);
        }
    };

	BarOpts opts2 = new BarOpts();
	opts2.setType(BarOpts.TYPE_ROUND); 
	opts2.setStacked(true); 
	
    hbarchart2 = getGPaper().hbarchart(300, 10, 200, 220, stackedData, opts2);
    hbarchart2.hover(hoverHandlerStacked);

}

//test class stuff
public BarChartTest2(Paper paper, int paperWidth, int paperHeight) {
	super(paper, paperWidth, paperHeight);
	setName("bar2");
	setDescription("shows bargraph with columns hovering ");
}
@Override
public String getJavaClassSource() {
	return TestResources.INSTANCE.BarChartTest2().getText();
}

}
