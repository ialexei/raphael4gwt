package org.sgx.raphael4gwt.graphael.bar;

/**
 * listener used in hover() and hoverColumn() methods for BarChart 
 * @author sg
 *
 */
public interface BarSectorHoverListener {
	void hoverIn(BarContext ctx);
	void hoverOut(BarContext ctx);
}
