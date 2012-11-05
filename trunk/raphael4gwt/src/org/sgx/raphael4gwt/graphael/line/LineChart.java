package org.sgx.raphael4gwt.graphael.line;

import org.sgx.raphael4gwt.graphael.GShape;

public class LineChart extends GShape {
	
	protected LineChart(){}
	
	/**
	 * @param l
	 * @return
	 */
	public final native LineChart hoverRow(LineHoverListener l)/*-{
		var hoverIn = $entry(function() {
			l.@org.sgx.raphael4gwt.graphael.line.LineHoverListener::hoverIn(Lorg/sgx/raphael4gwt/graphael/line/LineContext;)(this);
		}); 
		var hoverOut = $entry(function() {
			l.@org.sgx.raphael4gwt.graphael.line.LineHoverListener::hoverOut(Lorg/sgx/raphael4gwt/graphael/line/LineContext;)(this);
		}); 
		this.hover(hoverIn, hoverOut);
		return this;	
	}-*/;
	
	/**
	 * register mouse hover listener for individual lines
	 * @param l
	 * @return
	 */
	public final native LineChart hoverColumn(LineHoverListener l)/*-{
		var hoverIn = $entry(function() {
			l.@org.sgx.raphael4gwt.graphael.line.LineHoverListener::hoverIn(Lorg/sgx/raphael4gwt/graphael/line/LineContext;)(this);
		}); 
		var hoverOut = $entry(function() {
			l.@org.sgx.raphael4gwt.graphael.line.LineHoverListener::hoverOut(Lorg/sgx/raphael4gwt/graphael/line/LineContext;)(this);
		}); 
		this.hoverColumn(hoverIn, hoverOut);
		return this;	
	}-*/;
	
	public final native GShape getSymbols()/*-{
		return this.symbols;
	}-*/;
	public final native GShape getLines()/*-{
		return this.lines;
	}-*/;
	
	public final native GShape getShades()/*-{
		return this.shades;
	}-*/;
	
	public final native GShape getAxis()/*-{
		return this.axis;
	}-*/;
}
