package org.sgx.raphael4gwt.raphy.client.line;

import com.google.gwt.core.client.JavaScriptObject;

public class LineOpts extends JavaScriptObject{
	protected LineOpts() {
	}

	public static native final LineOpts create() /*-{
		return {};
	}-*/;

//	/**
//	 * "bar" or "line"
//	 * @return
//	 */
//	public native final String render() /*-{
//	return this["render"]; 
//	}-*/;
//	
//	/**
//	 * "bar" or "line"
//	 * @param val
//	 * @return this - for setter chaining
//	 */
//	public native final LineOpts render(String val) /*-{
//	this["render"] = val; 
//	return this; 
//	}-*/;
	
	/**
	 * width of line
	 * @return
	 */
	public native final int line_width() /*-{
		return this["line_width"];
	}-*/;

	/**width of line
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final LineOpts line_width(int val) /*-{
		this["line_width"] = val;
		return this;
	}-*/;

	/**
	 * color of line
	 * @return
	 */
	public native final String line_color() /*-{
		return this["line_color"];
	}-*/;

	/**
	 * color of line
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final LineOpts line_color(String val) /*-{
		this["line_color"] = val;
		return this;
	}-*/;

	/**
	 * 0.0 to 1.0, 0 = no smoothing, 1.0= ultra smoothing
	 * @return
	 */
	public native final double smoothing() /*-{
		return this["smoothing"];
	}-*/;

	/**
	 * 0.0 to 1.0, 0 = no smoothing, 1.0= ultra smoothing
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final LineOpts smoothing(double val) /*-{
		this["smoothing"] = val;
		return this;
	}-*/;

	/**
	 * shade the area under a line
	 * @return
	 */
	public native final boolean fill_area() /*-{
		return this["fill_area"];
	}-*/;

	/**
	 * shade the area under a line
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final LineOpts fill_area(boolean val) /*-{
		this["fill_area"] = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final String area_color() /*-{
		return this["area_color"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final LineOpts area_color(String val) /*-{
		this["area_color"] = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final double area_opacity() /*-{
		return this["area_opacity"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final LineOpts area_opacity(double val) /*-{
		this["area_opacity"] = val;
		return this;
	}-*/;
}
