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
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;

import com.google.gwt.dom.client.NativeEvent;
/**
 * this example shows a bar chart that changes its values dynamically (bar by bar, without destroying and creating all over again)
 * @author sg
 *
 */
public class BarChartDynamicUpdate extends Test {	
	
	private GPaper bars;
	protected GShape flag=null;
	private double[][] bdata;
	private BarChart chart;
 
	@Override
	public void test() {
		bars = getGPaper();
		
		bars.text(50, 10, "select area").attr(Attrs.create().
			font("100 14px Serifa-Reg, Arial, sans-serif").
			fill("#333333").fontStyle(Raphael.FONT_STYLE_ITALIC));
		
		final double[][] b1data = {{319309},{305303},{434917}};
		final double[][] b2data = {{268210}, {263097}, {359183}};
		final double[][] b3data = {{373217}, {64199}, {201510}};
		
		bdata = b1data;
		
		BarOpts baropts = new BarOpts(true, BarOpts.TYPE_SOFT);
		baropts.setStacked(false);
//		baropts.setAxis("0 0 1 1");
//		baropts.setAxisXLabels(new String[]{"2008", "2009", "2010"});
		baropts.setColors(new String[]{"#999999","#333333","#666666"});
		
		chart = bars.barchart(100,0,300,400,bdata,baropts);
		chart.hover(new BarSectorHoverListener() {			
			@Override
			public void hoverOut(BarContext ctx) {
				if(flag!=null) {
					flag.remove();
					flag=null;
				}				
			}			
			@Override
			public void hoverIn(BarContext ctx) {
				flag = bars.popup(ctx.getBar().getX(), ctx.getBar().getY(), ctx.getBar().getValue()+"");
			}
		});		
		
		bars.tag(50,50,"params 1", 0).click(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				doChangeVals(b1data);
			}
		});
		bars.tag(50,100,"params 2", 0).click(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				doChangeVals(b2data);
			}
		});
		bars.tag(50,150,"params 3", 0).click(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				doChangeVals(b3data);
			}
		});
	}
	
	protected void doChangeVals(double[][] d) {
		BarOpts baropts = new BarOpts(true, BarOpts.TYPE_SOFT);
		baropts.setStacked(false);
//		baropts.setAxis("0 0 1 1");
//		baropts.setAxisXLabels(new String[]{"2008", "2009", "2010"});
		
		final BarChart c2 = bars.barchart(100, 0, 300, 400, d, baropts);		
		final Set barSet = chart.getBars().<Set>cast(), 
			 newBarSet = c2.getBars().<Set>cast();
		
		barSet.forEach(new ForEachCallback() {			
			@Override
			public boolean call(Shape s, int index) {				
				Bar shape = barSet.item(index).<Set>cast().item(0).<Bar>cast();
				Bar newShape = newBarSet.item(index).<Set>cast().item(0).<Bar>cast();
				shape.animate(Attrs.create().path(newShape.attr("path")), 1000, "bounce");
				shape.<Bar>cast().setValue(newShape.getValue());
				return true;
			}
		});
		c2.remove();
		
	}
			    
			    

	//test class stuff
	public BarChartDynamicUpdate(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		setName("bar dyn update");
		setDescription("this example shows a bar chart that changes its values dynamically (bar by bar, without destroying and creating all over again)");
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.BarChartDynamicUpdate().getText();
	}

}
