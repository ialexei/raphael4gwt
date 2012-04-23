package org.sgx.raphael4gwt.graphael.bar;

import org.sgx.raphael4gwt.graphael.GShape;

public class BarChart extends GShape {
	
protected BarChart(){}

/**
 * register mouse hover listener for sectors. listeners will be provided 
 * with a BarContext object with hovered sector information
 * @param l
 * @return
 */
public native final BarChart hoverRow(BarSectorHoverListener l)/*-{
	var hoverIn = $entry(function() {
		l.@org.sgx.raphael4gwt.graphael.bar.BarSectorHoverListener::hoverIn(Lorg/sgx/raphael4gwt/graphael/bar/BarContext;)(this);
	}); 
	var hoverOut = $entry(function() {
		l.@org.sgx.raphael4gwt.graphael.bar.BarSectorHoverListener::hoverOut(Lorg/sgx/raphael4gwt/graphael/bar/BarContext;)(this);
	}); 
	this.hover(hoverIn, hoverOut);
	return this;	
}-*/;

/**
 * register mouse hover listener for sectors. listeners will be provided 
 * with a PieSector object with hovered sector information
 * @param l
 * @return
 */
public native final BarChart hoverColumn(BarSectorHoverListener l)/*-{
	var hoverIn = $entry(function() {
		l.@org.sgx.raphael4gwt.graphael.bar.BarSectorHoverListener::hoverIn(Lorg/sgx/raphael4gwt/graphael/bar/BarContext;)(this);
	}); 
	var hoverOut = $entry(function() {
		l.@org.sgx.raphael4gwt.graphael.bar.BarSectorHoverListener::hoverOut(Lorg/sgx/raphael4gwt/graphael/bar/BarContext;)(this);
	}); 
	this.hoverColumn(hoverIn, hoverOut);
	return this;	
}-*/;

/**@param labels
 * @return this
 */
public native final BarChart label(String[][]labels, boolean isRight)/*-{	
	return this.label(
		@org.sgx.raphael4gwt.raphael.jsutil.JsUtil::to2DJsArray([[Ljava/lang/String;)(labels),
		isRight
	);
}-*/;

//chart.label = function (labels, isRight)
//
//iterated each row bar
//chart.eachRow = function (f)
//
//iterated each column bar
//chart.eachColumn = function (f)
//
//clickRow
//
//clickColumn
}
