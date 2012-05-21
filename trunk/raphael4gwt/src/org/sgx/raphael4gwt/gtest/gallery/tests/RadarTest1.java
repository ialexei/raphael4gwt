package org.sgx.raphael4gwt.gtest.gallery.tests;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.GShape;
import org.sgx.raphael4gwt.graphael.radar.RadarChart;
import org.sgx.raphael4gwt.graphael.radar.RadarClickListener;
import org.sgx.raphael4gwt.graphael.radar.RadarContext;
import org.sgx.raphael4gwt.graphael.radar.RadarHoverListener;
import org.sgx.raphael4gwt.graphael.radar.RadarOpts;
import org.sgx.raphael4gwt.gtest.gallery.Test;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Glow;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;
/**
 * radar chart test 1
 * @author sg
 *
 */
public class RadarTest1 extends Test {		
 
@Override
public void test() {
	
	getGPaper().text(100,10,"A simple Radar Chart").attr(Attrs.create().fontSize(20));
	//very simple radar chart
	RadarChart radar1 = getGPaper().radar(100,150,100, 
		new double[]{35, 20, 13, 32, 25, 40, 37, 16, 42});
	
	//optional: a mouse hovering listener that shows the value of each node in a popup.
	radar1.hover(new RadarHoverListener() {		
		GShape popup=null;
		@Override
		public void hoverOut(RadarContext ctx) {
			if(popup!=null) {
				popup.remove();
				popup=null;
			}
		}			
		@Override
		public void hoverIn(RadarContext ctx) {
			popup = getGPaper().popup(ctx.getMX(), ctx.getMY(), ctx.getValue()+"");
		}
	});
	
	
	//another radar chart - this time with legend.
	
	getGPaper().text(400,10,"Another with legend").attr(Attrs.create().fontSize(20));	
	RadarOpts opts2 = new RadarOpts();
	opts2.setLegend(new String[]{"Product 123", "Label 333", 
		"Ergo Lorem", "Maths", "Biology 444", "Methods 22", 
		"Persever 5634", "Mesopota 654"});
	opts2.setHelpLines(20);
	RadarChart radar2 = getGPaper().radar(350,150,100, 
			new double[]{35, 20, 13, 32, 25, 40, 37, 16, 42}, opts2);
		
	//optional: a mouse hovering listener that shows the value of each node in a popup.
	radar2.hover(new RadarHoverListener() {			
		private GShape popup2=null;
		private Set glow2=null;
		@Override
		public void hoverOut(RadarContext ctx) {
			if(popup2!=null) {
				popup2.remove();
				popup2=null;
			}
			ctx.getLabel().attr(Attrs.create().fontSize(12).
				fontWeight(Raphael.FONT_WEIGHT_NORMAL));
		}			
		@Override
		public void hoverIn(RadarContext ctx) {
			popup2 = getGPaper().popup(ctx.getMX(), ctx.getMY(), ctx.getValue()+"");
			ctx.getLabel().attr(Attrs.create().fontSize(14).
				fontWeight(Raphael.FONT_WEIGHT_BOLD));
		}
	});
	
	radar2.click(new RadarClickListener() {		
		@Override
		public void click(RadarContext ctx) {
			ctx.getLabel().attr(Attrs.create().transform("S2").fontSize(20));
		}
	});
}

//test class stuff
public RadarTest1(Paper paper, int paperWidth, int paperHeight) {
	super(paper, paperWidth, paperHeight);
	setName("radar1");
	setDescription("radar chart test 1");
}
@Override
public String getJavaClassSource() {
	return TestResources.INSTANCE.RadarTest1().getText();
}

}
