package org.sgx.raphael4gwt.graphael.pie;

import org.sgx.raphael4gwt.graphael.GShape;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.Text;

public final class Piechart extends GShape {
protected Piechart(){}

public native void sectorHover(PieHoverListener l)/*-{
	var hoverIn = $entry(function() {
		l.@org.sgx.raphael4gwt.graphael.pie.PieHoverListener::hoverIn(Lorg/sgx/raphael4gwt/graphael/pie/PieContext;)(this);
	}); 
	var hoverOut = $entry(function() {
		l.@org.sgx.raphael4gwt.graphael.pie.PieHoverListener::hoverOut(Lorg/sgx/raphael4gwt/graphael/pie/PieContext;)(this);
	}); 
	return this.hover(hoverIn, hoverOut);	
}-*/;
}
