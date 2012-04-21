package org.sgx.raphael4gwt.graphael;

import org.sgx.raphael4gwt.raphael.Shape;
/**
 * graphael enrich all elements with new methods...
 * @author sg
 *
 */
public class GShape extends Shape {
	protected GShape(){}
	/**
	 * Puts the context Element in a 'popup' tooltip. Can also be used on sets.
	 * @param dir (string) location of Element relative to the tail: `'down'`, `'left'`, `'up'` [default], or `'right'`.
	 * @param size (number) amount of bevel/padding around the Element, as well as half the width and height of the tail [default: `5`]
	 * @param x (number) x coordinate of the popup's tail [default: Element's `x` or `cx`]
	 * @param y (number) y coordinate of the popup's tail [default: Element's `y` or `cy`]
	 * @return (object) path element of the popup
	 <p>Usage</p>
	 <pre>
	  paper.circle(50, 50, 5).attr({
	      stroke: "#fff",
	      fill: "0-#c9de96-#8ab66b:44-#398235"
	  }).popup();
	 </pre>
	 \*/
	public final native GShape popup(String dir, double size, double x, double y)/*-{
		return this.popup(dir, size, x, y);
	}-*/;
	/**
	 * Puts the context Element in a 'popup' tooltip. Can also be used on sets.
	 * @return (object) path element of the popup
	 <p>Usage</p>
	 <pre>
	  paper.circle(50, 50, 5).attr({
	      stroke: "#fff",
	      fill: "0-#c9de96-#8ab66b:44-#398235"
	  }).popup();
	 </pre>
	 \*/
	public final native GShape popup()/*-{
		return this.popup();
	}-*/;
	
	/** Puts the context Element in a 'tag' tooltip. Can also be used on sets.
	 * @param angle (number) angle of orientation in degrees [default: `0`]
	 * @param r (number) radius of the loop [default: `5`]
	 * @param x (number) x coordinate of the center of the tag loop [default: Element's `x` or `cx`]
	 * @param y (number) y coordinate of the center of the tag loop [default: Element's `x` or `cx`]
	 @return  (object) path element of the tag
	 > Usage
	 <pre>
	  paper.circle(50, 50, 15).attr({
	      stroke: "#fff",
	      fill: "0-#c9de96-#8ab66b:44-#398235"
	  }).tag(60);
	 </pre>
	 \*/
	public final native GShape tag(double angle, double r, double x, double y)/*-{
		return this.tag(angle, r, x, y);
	}-*/;
}
