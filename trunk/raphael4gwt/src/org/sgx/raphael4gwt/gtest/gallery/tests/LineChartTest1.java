package org.sgx.raphael4gwt.gtest.gallery.tests;

import java.util.logging.Logger;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.line.LineChart;
import org.sgx.raphael4gwt.graphael.line.LineContext;
import org.sgx.raphael4gwt.graphael.line.LineHoverListener;
import org.sgx.raphael4gwt.graphael.line.LineOpts;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.gtest.gallery.Test;
/**
 * shows bargraph with columns hovering 
 * @author sg
 *
 */
public class LineChartTest1 extends Test {

	static Logger logger = Logger.getLogger("LineChartTest1");
	protected Set tags3;
	
	@Override
	public void test() {
		double[][] valuesx = new double[][]{
			{1, 2, 3, 4, 5, 6, 7},
			{3.5, 4.5, 5.5, 6.5, 7, 8}
		};		
		double[][] valuesy = new double[][]{
			{12, 32, 23, 15, 17, 27, 22},
			{10, 20, 30, 25, 15, 28}
		};
		LineOpts opts1 = new LineOpts();
		getGPaper().linechart(0, 0, 200,200, valuesx, valuesy, opts1);
		
		opts1.setAxis("0 0 1 1");
		opts1.setFill(true);
		getGPaper().linechart(220, 0, 200,200, valuesx, valuesy, opts1);
		
		opts1.setAxis(null);
		opts1.setFill(false);
		opts1.setShade(true);
		opts1.setSmooth(true);
		opts1.setWidth(3);
		opts1.setDash(Raphael.STROKE_DASHARRAY_DASH_DASH); 
		opts1.setColors(new String[]{"#f23", "#23f"}); 
		opts1.setSymbol("circle");
		final LineChart linechart3 = getGPaper().
				linechart(0, 220, 300, 300, valuesx, valuesy, opts1);
		linechart3.hoverColumn(new LineHoverListener() {			
			@Override
			public void hoverOut(LineContext ctx) {
				tags3.remove();
			}
			@Override
			public void hoverIn(LineContext ctx) {
				GPaper r = getGPaper();
				tags3 = r.set();
				for (int i = 0; i < ctx.getY().length; i++) {
					tags3.push(r.tag(ctx.getX(), ctx.getY()[i], ctx.getValues()[i]+"", 160, 10).insertBefore(ctx));
				}
			}
		});
	}

	//test class stuff
	public LineChartTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		setName("line");
		setDescription("line charts - the third with hover listeners.");
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.LineChartTest1().getText();
	}

}
