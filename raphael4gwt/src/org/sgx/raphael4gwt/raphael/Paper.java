package org.sgx.raphael4gwt.raphael;

import com.google.gwt.core.client.JavaScriptObject;

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
