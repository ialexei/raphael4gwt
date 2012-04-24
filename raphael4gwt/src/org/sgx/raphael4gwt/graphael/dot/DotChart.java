package org.sgx.raphael4gwt.graphael.dot;

import org.sgx.raphael4gwt.graphael.GShape;

public class DotChart extends GShape {
	
	protected DotChart(){}
	
	/**
	 * @param l
	 * @return
	 */
	public final native DotChart hoverDot(DotHoverListener l)/*-{
		var hoverIn = $entry(function() {
			l.@org.sgx.raphael4gwt.graphael.dot.DotHoverListener::hoverIn(Lorg/sgx/raphael4gwt/graphael/dot/DotContext;)(this);
		}); 
		var hoverOut = $entry(function() {
			l.@org.sgx.raphael4gwt.graphael.dot.DotHoverListener::hoverOut(Lorg/sgx/raphael4gwt/graphael/dot/DotContext;)(this);
		}); 
		this.hover(hoverIn, hoverOut);
		return this;	
	}-*/;
	
//	tag(this.x, this.y, this.value, 0, this.r + 2)
//	hover()
	
	
}
