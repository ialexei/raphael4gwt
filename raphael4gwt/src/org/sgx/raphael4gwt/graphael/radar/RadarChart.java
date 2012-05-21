package org.sgx.raphael4gwt.graphael.radar;

import org.sgx.raphael4gwt.graphael.GShape;
/**
 * 
 * @author sg
 *
 */
public class RadarChart extends GShape {
protected RadarChart(){}

/**
 * register mouse hover listener for individual chart sectors. listeners are provided 
 * with a BarContext object with hovered sector information
 * @param l
 * @return
 */
public native final RadarChart hover(RadarHoverListener l)/*-{
	var hoverIn = $entry(function() {
		l.@org.sgx.raphael4gwt.graphael.radar.RadarHoverListener::hoverIn(Lorg/sgx/raphael4gwt/graphael/radar/RadarContext;)(this);
	}); 
	var hoverOut = $entry(function() {
		l.@org.sgx.raphael4gwt.graphael.radar.RadarHoverListener::hoverOut(Lorg/sgx/raphael4gwt/graphael/radar/RadarContext;)(this);
	}); 
	this.hover(hoverIn, hoverOut);
	return this;	
}-*/;
/**
 * adds a click listener for this chart -  listeners are provided 
 * with a BarContext object with hovered sector information
 * @param l
 * @return
 */
public native final RadarChart click(RadarClickListener l)/*-{
	var f = $entry(function() {
		l.@org.sgx.raphael4gwt.graphael.radar.RadarClickListener::click(Lorg/sgx/raphael4gwt/graphael/radar/RadarContext;)(this);
	});	
	this.click(f);
	return this;	
}-*/;
}
