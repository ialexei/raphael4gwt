package org.sgx.raphael4gwt.raphael;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public class Paper extends JavaScriptObject {
	
	protected Paper(){}
	
	/**
	 * 
	 * @param x - x coordinate of the centre
	 * @param y - y coordinate of the centre
	 * @param r - radius
	 * @return a new Circle Shape
	 */
	public final native Circle circle(int x, int y, int r)/*-{
		return this.circle(x, y, r);
	}-*/;
	/**
	 * Draws a text string. If you need line breaks, put “\n” in the string. 
	 * @param x
	 * @param y
	 * @param text
	 * @return
	 */
	public final native Text text(int x, int y, String text)/*-{
		return this.text(x, y, text);
	}-*/;
	 /**
	  * If you need to change dimensions of the canvas call this method 
	  * @param w - new paper width
	  * @param h - new paper height
	  */
	public final native void setSize(int w, int h)/*-{
		this.setSize(w, h);
	}-*/;
	/**
	 * Points to the topmost element on the paper 
	 * @return
	 */
	public final native Shape top()/*-{
		this.top;
	}-*/;
	
	public final native Element getCanvasElement()/*-{
		return this.canvas;
	}-*/;
	/**
	 * Clears the paper, i.e. removes all the elements. 
	 */
	public final native void clear()/*-{
		this.clear();
	}-*/;


	public final native Rect rect(int x, int y, int w, int h)/*-{
//		alert(this.canvas);
		return this.rect(x, y, w, h);
	}-*/;
	/**
	 * Draws a rectangle. 
	 * @param x x coordinate of the top left corner
	 * @param y y coordinate of the top left corner
	 * @param w width
	 * @param h height
	 * @param r radius for rounded corners, default is 0
	 * @return a new Rect shape.
	 */
	public final native Rect rect(int x, int y, int w, int h, int r) /*-{
		return this.rect(x, y, w, h, r);
	}-*/;


	
	/* *** SETS *** */
//	/**
//	 * Creates array-like object to keep and operate several elements at once.
//	 * @return
//	 */
//	public final native Set set()/*-{
//		return this.set();
//	}-*/;
//
//	public final native void setStart()/*-{
//		this.setStart();
//	}-*/;
//	/**
//	 * This method finishes catching and returns resulting set.
//	 * @return the new set
//	 */
//	public final native Set setFinish()/*-{
//		return this.setFinish();
//	}-*/;

}
