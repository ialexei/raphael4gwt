package org.sgx.raphael4gwt.graphael.pie;

import org.sgx.raphael4gwt.graphael.GShape;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.Text;

/**
 * IO represent a pie chart. I'm a shape with some methods related to pie chart,
 * @author sg
 *
 */
public class PieChart extends GShape {
	
protected PieChart(){}

/**
 * register mouse hover listener for sectors. listeners will be provided 
 * with a PieSector object with hovered sector information
 * @param l
 * @return
 */
public final native PieChart sectorHover(PieSectorHoverListener l)/*-{
	var hoverIn = $entry(function() {
		l.@org.sgx.raphael4gwt.graphael.pie.PieSectorHoverListener::hoverIn(Lorg/sgx/raphael4gwt/graphael/pie/PieSector;)(this);
	}); 
	var hoverOut = $entry(function() {
		l.@org.sgx.raphael4gwt.graphael.pie.PieSectorHoverListener::hoverOut(Lorg/sgx/raphael4gwt/graphael/pie/PieSector;)(this);
	}); 
	this.hover(hoverIn, hoverOut);
	return this;	
}-*/;

public final native PieChart inject(Shape s)/*-{
	this.inject(s);
	return this;
}-*/;

/**
 * iterated throw current pie sectors. 
 * @param l
 * @return
 */

public final native PieChart sectorEach(PieSectorCallback l)/*-{
	var f = $entry(function() {
		l.@org.sgx.raphael4gwt.graphael.pie.PieSectorCallback::call(Lorg/sgx/raphael4gwt/graphael/pie/PieSector;)(this);
	}); 
	this.each(f);
	return this;	
}-*/;

/**
 * register mouse clicks for individual sectors. listeners will be provided 
 * with a PieSector object with clicked sector information
 * @param l
 * @return
 */
public final native PieChart click(PieSectorCallback l)/*-{
	var f = $entry(function() {
		l.@org.sgx.raphael4gwt.graphael.pie.PieSectorCallback::call(Lorg/sgx/raphael4gwt/graphael/pie/PieSector;)(this);
	}); 
	this.click(f);
	return this;	
}-*/;
}
