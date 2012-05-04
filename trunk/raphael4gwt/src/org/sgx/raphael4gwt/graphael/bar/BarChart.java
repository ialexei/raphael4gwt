package org.sgx.raphael4gwt.graphael.bar;

import org.sgx.raphael4gwt.graphael.GShape;
import org.sgx.raphael4gwt.raphael.Set;
/**
 * 
 * @author sg
 *
 */
public class BarChart extends GShape {
	
protected BarChart(){}

/**
 * register mouse hover listener for individual chart sectors. listeners will be provided 
 * with a BarContext object with hovered sector information
 * @param l
 * @return
 */
public native final BarChart hover(BarSectorHoverListener l)/*-{
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
 * register mouse hover listener for individual chart  sectors. listeners will be provided 
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
/**
 * iterate though individual chart sectors
 * @param c
 * @return
 */
public native final BarChart eachColumn(BarSectorCallback c)/*-{
	var f = $entry(function(){
		return c.@org.sgx.raphael4gwt.graphael.bar.BarSectorCallback::call(Lorg/sgx/raphael4gwt/graphael/bar/BarContext;)(this);
	})	
	return this.eachColumn(f);
}-*/;
/**
 * iterate though individual chart sectors
 * @param c
 * @return
 */
public native final BarChart each(BarSectorCallback c)/*-{
	var f = $entry(function(o){
		return c.@org.sgx.raphael4gwt.graphael.bar.BarSectorCallback::call(Lorg/sgx/raphael4gwt/graphael/bar/BarContext;)(this);
	})	
	return this.each(f);
}-*/;
/**
 * add click handler to individual sector 
 * @param l
 * @return
 */
public native final BarChart click(BarSectorCallback l)/*-{
	var f = $entry(function() {
		l.@org.sgx.raphael4gwt.graphael.bar.BarSectorCallback::call(Lorg/sgx/raphael4gwt/graphael/bar/BarContext;)(this);
	}); 
	this.click(f);
	return this;	
}-*/;
/**
 * add click handler to individual sector 
 * @param l
 * @return
 */
public native final BarChart clickColumn(BarSectorCallback l)/*-{
	var f = $entry(function() {
		l.@org.sgx.raphael4gwt.graphael.bar.BarSectorCallback::call(Lorg/sgx/raphael4gwt/graphael/bar/BarContext;)(this);
	}); 
	this.clickColumn(f);
	return this;	
}-*/;
/**
 * it is a set of sets of paths. getBars[0] correspond to the set of bars for first value set
 * @return
 */
public native final Set getBars()/*-{
	return this.bars
}-*/;
/**covers is where mouse events are registered.
 * it is a set of rects
 * @return
 */
public native final Set getCovers()/*-{
	return this.covers;
}-*/;
//jsArray<jsarray<Path> bars
//jsarray<rect> covers;


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
