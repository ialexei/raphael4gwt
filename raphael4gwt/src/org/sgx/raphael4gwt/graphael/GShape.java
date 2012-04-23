package org.sgx.raphael4gwt.graphael;

import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
/**
 * main responsability of this class is to represent a chart builded with graphael. charts are set of shapes. 
 * another responsability of this class is to add functions from g.raphael.js that enrich all elements with new methods...
 * @author sg
 *
 */
public class GShape extends Set {
	
	protected GShape(){}
	
	/**
	 * Puts the context Element in a 'popup' tooltip. Can also be used on sets. <p>Usage</p>
	 <pre>
	  paper.circle(50, 50, 5).attr({
	      stroke: "#fff",
	      fill: "0-#c9de96-#8ab66b:44-#398235"
	  }).popup();
	 </pre>
	 * @param dir (string) location of Element relative to the tail: `'down'`, `'left'`, `'up'` [default], or `'right'`.
	 * @param size (number) amount of bevel/padding around the Element, as well as half the width and height of the tail [default: `5`]
	 * @param x (number) x coordinate of the popup's tail [default: Element's `x` or `cx`]
	 * @param y (number) y coordinate of the popup's tail [default: Element's `y` or `cy`]
	 * @return (object) path element of the popup
	 \*/
	public final native GShape popup(String dir, double size, double x, double y)/*-{
		return this.popup(dir, size, x, y);
	}-*/;
	/**
	 * Puts the context Element in a 'popup' tooltip. Can also be used on sets. <p>Usage</p>
	 <pre>
	  paper.circle(50, 50, 5).attr({
	      stroke: "#fff",
	      fill: "0-#c9de96-#8ab66b:44-#398235"
	  }).popup();
	 </pre>
	 * @param dir (string) location of Element relative to the tail: `'down'`, `'left'`, `'up'` [default], or `'right'`.
	 * @return (object) path element of the popup
	 \*/
	public final native GShape popup(String dir)/*-{
		return this.popup(dir);
	}-*/;
	/**
	 * Puts the context Element in a 'popup' tooltip. Can also be used on sets.<p>Usage</p>
	 <pre>
	  paper.circle(50, 50, 5).attr({
	      stroke: "#fff",
	      fill: "0-#c9de96-#8ab66b:44-#398235"
	  }).popup();
	 </pre>
	 * @return (object) path element of the popup
	 \*/
	public final native GShape popup()/*-{
		return this.popup();
	}-*/;
	
	/** Puts the context Element in a 'tag' tooltip. Can also be used on sets.> Usage
	 <pre>
	  paper.circle(50, 50, 15).attr({
	      stroke: "#fff",
	      fill: "0-#c9de96-#8ab66b:44-#398235"
	  }).tag(60)
	 * @param angle (number) angle of orientation in degrees [default: `0`]
	 * @param r (number) radius of the loop [default: `5`]
	 * @param x (number) x coordinate of the center of the tag loop [default: Element's `x` or `cx`]
	 * @param y (number) y coordinate of the center of the tag loop [default: Element's `x` or `cx`]
	 @return  (object) path element of the tag
	 </pre>
	 \*/
	public final native GShape tag(double angle, double r, double x, double y)/*-{
		return this.tag(angle, r, x, y);
	}-*/;
	
	/** Puts the context Element in a 'tag' tooltip. Can also be used on sets.> Usage
	 <pre>
	  paper.circle(50, 50, 15).attr({
	      stroke: "#fff",
	      fill: "0-#c9de96-#8ab66b:44-#398235"
	  }).tag(60);
	 * @param angle (number) angle of orientation in degrees [default: `0`]
	 @return  (object) path element of the tag
	 </pre>
	 \*/
	public final native GShape tag(double angle)/*-{
		return this.tag(angle);
	}-*/;
	/** Puts the context Element in a 'tag' tooltip. Can also be used on sets.> Usage
	 <pre>
	  paper.circle(50, 50, 15).attr({
	      stroke: "#fff",
	      fill: "0-#c9de96-#8ab66b:44-#398235"
	  }).tag(60);
	 @return  (object) path element of the tag
	 </pre>
	 \*/
	public final native GShape tag()/*-{
		return this.tag();
	}-*/;
	/**
	 * Puts the context Element in a 'drop' tooltip. Can also be used on sets. <br/>
	 > Usage
	 <pre> paper.circle(50, 50, 8).attr({
	      stroke: "#fff",
	      fill: "0-#c9de96-#8ab66b:44-#398235"
	  }).drop(60);</pre>
	 @param angle (number) angle of orientation in degrees [default: `0`]
	 @param x (number) x coordinate of the drop's point [default: Element's `x` or `cx`]
	 @param y (number) y coordinate of the drop's point [default: Element's `x` or `cx`]
	 @return  path element of the drop
	 \*/
	public final native GShape drop(double angle, double x, double y)/*-{
		return this.drop(angle,x, y);
	}-*/;	
	/**
	 * Puts the context Element in a 'drop' tooltip. Can also be used on sets. <br/>
	 @return  path element of the drop
	 \*/
	public final native GShape drop()/*-{
		return this.drop();
	}-*/;	
	
	/**
	 * Puts the context Element in a 'drop' tooltip. Can also be used on sets.<br/>
	 > Usage
	 <pre> paper.circle(50, 50, 8).attr({
	      stroke: "#fff",
	      fill: "0-#c9de96-#8ab66b:44-#398235"
	  }).drop(60);</pre>
	 @param angle (number) angle of orientation in degrees [default: `0`]
	 @return  path element of the drop
	 \*/
	public final native GShape drop(double angle)/*-{
		return this.drop(angle);
	}-*/;
	
	/**Puts the context Element in a 'flag' tooltip. Can also be used on sets.> Usage:
	 <pre> paper.circle(50, 50, 10).attr({
	      stroke: "#fff",
	      fill: "0-#c9de96-#8ab66b:44-#398235"
	  }).flag(60);</pre>
	 @param angle (number) angle of orientation in degrees [default: `0`]
	 @param x (number) x coordinate of the flag's point [default: Element's `x` or `cx`]
	 @param y (number) y coordinate of the flag's point [default: Element's `x` or `cx`]
	 @return path element of the flag	 
	 \*/
	public final native GShape flag(double angle, double x, double y)/*-{
		return this.flag(angle,x, y);
	}-*/;
	
	/**Puts the context Element in a 'flag' tooltip. Can also be used on sets.
	 * <br/>Usage:
	 <pre> paper.circle(50, 50, 10).attr({
	      stroke: "#fff",
	      fill: "0-#c9de96-#8ab66b:44-#398235"
	  }).flag(60);</pre>
	 @param angle (number) angle of orientation in degrees [default: `0`]
	 @return path element of the flag	 
	 \*/
	public final native GShape flag(double angle)/*-{
		return this.flag(angle);
	}-*/;
	

	/** Puts the context Element in a 'label' tooltip. Can also be used on sets.
	 *  Usage<pre>
	  paper.circle(50, 50, 10).attr({
	      stroke: "#fff",
	      fill: "0-#c9de96-#8ab66b:44-#398235"
	  }).label();</pre>
	 @return path element of the label. 
 	\*/
	public final native GShape label()/*-{
		return this.label();
	}-*/;

	/**Puts the context Element in a 'blob' tooltip. Can also be used on sets. Usage
	  <pre>paper.circle(50, 50, 8).attr({
	      stroke: "#fff",
	      fill: "0-#c9de96-#8ab66b:44-#398235"
	  }).blob(60);</pre>
	 @param angle (number) angle of orientation in degrees [default: `0`]
	 @param x (number) x coordinate of the blob's tail [default: Element's `x` or `cx`]
	 @param y (number) y coordinate of the blob's tail [default: Element's `x` or `cx`]	 
	 \*/
	public final native GShape blob(double angle, double x, double y)/*-{
		return this.blob(angle,x, y);
	}-*/;
	/**Puts the context Element in a 'blob' tooltip. Can also be used on sets. Usage
	  <pre>paper.circle(50, 50, 8).attr({
	      stroke: "#fff",
	      fill: "0-#c9de96-#8ab66b:44-#398235"
	  }).blob(60);</pre>
	 @param angle (number) angle of orientation in degrees [default: `0`]
	 @param x (number) x coordinate of the blob's tail [default: Element's `x` or `cx`]
	 \*/
	public final native GShape blob(double angle, double x)/*-{
		return this.blob(angle,x);
	}-*/;
	/**Puts the context Element in a 'blob' tooltip. Can also be used on sets. Usage
	  <pre>paper.circle(50, 50, 8).attr({
	      stroke: "#fff",
	      fill: "0-#c9de96-#8ab66b:44-#398235"
	  }).blob(60);</pre>
	 @param angle (number) angle of orientation in degrees [default: `0`]
	 \*/
	public final native GShape blob(double angle)/*-{
		return this.blob(angle);
	}-*/;
	/**Puts the context Element in a 'blob' tooltip. Can also be used on sets. Usage
	  <pre>paper.circle(50, 50, 8).attr({
	      stroke: "#fff",
	      fill: "0-#c9de96-#8ab66b:44-#398235"
	  }).blob(60);</pre>
	 \*/
	public final native GShape blob()/*-{
		return this.blob();
	}-*/;
	
	/**
	 * Makes the context element lighter by increasing the brightness and reducing the saturation by a given factor. Can be called on Sets.
	 *  Usage
	 *  <pre>
	  paper.circle(50, 50, 20).attr({
	      fill: "#ff0000",
	      stroke: "#fff",
	      "stroke-width": 2
	  }).lighter(6);
	  </pre>
	 * @param times (number) adjustment factor [default: `2`]
	
	 \*/
	public final native GShape lighter(double times)/*-{
		return this.lighter(times);
	}-*/;
	
	/**
	 * Makes the context element darker by decreasing the brightness and increasing the saturation by a given factor. Can be called on Sets.
	 *  Usage
	 *  <pre>
	  paper.circle(50, 50, 20).attr({
	      fill: "#ff0000",
	      stroke: "#fff",
	      "stroke-width": 2
	  }).lighter(6);
	  </pre>
	 * @param times (number) adjustment factor [default: `2`]
	
	 \*/
	public final native GShape darker(double times)/*-{
		return this.darker(times);
	}-*/;
	
	/**  Resets brightness and saturation levels to their original values. See @Element.lighter and @Element.darker. Can be called on Sets.
	 Usage
	 <pre> paper.circle(50, 50, 20).attr({
	      fill: "#ff0000",
	      stroke: "#fff",
	      "stroke-width": 2
	  }).lighter(6).resetBrightness();
	  </pre>
	 \*/
	public final native GShape resetBrightness()/*-{
		return this.resetBrightness();
	}-*/;
}


