package org.sgx.raphael4gwt.graphael.sunburst;

import org.sgx.raphael4gwt.graphael.GShape;
import org.sgx.raphael4gwt.graphael.bar.BarChart;
import org.sgx.raphael4gwt.graphael.bar.BarSectorHoverListener;

public class SunBurstChart extends GShape {
protected SunBurstChart(){};

/**
 * register mouse hover listener for individual chart sectors. listeners will be provided 
 * with a BarContext object with hovered sector information
 * @param l
 * @return
 */
public native final BarChart hover(SunBurstHoverListener l)/*-{
	var hoverIn = $entry(function() {
		l.@org.sgx.raphael4gwt.graphael.sunburst.SunBurstHoverListener::hoverIn(Lorg/sgx/raphael4gwt/graphael/sunburst/SunBurstContext;)(this);
	}); 
	var hoverOut = $entry(function() {
		l.@org.sgx.raphael4gwt.graphael.sunburst.SunBurstHoverListener::hoverOut(Lorg/sgx/raphael4gwt/graphael/sunburst/SunBurstContext;)(this);
	}); 
	this.hover(hoverIn, hoverOut);
	return this;	
}-*/;
public native final BarChart click(SunBurstClickListener l)/*-{
	var f = $entry(function() {
		l.@org.sgx.raphael4gwt.graphael.sunburst.SunBurstClickListener::click(Lorg/sgx/raphael4gwt/graphael/sunburst/SunBurstContext;)(this);
	}); 
	
	this.click(f);
	return this;	
}-*/;
}
