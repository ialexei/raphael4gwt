package org.sgx.raphael4gwt.raphy.client.bar;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;
import org.sgx.raphael4gwt.raphy.client.line.LineChartOpts;

public class BarChartOpts extends JsObject {
	protected BarChartOpts() {
	}

	public static native final BarChartOpts create() /*-{
		return {};
	}-*/;

	/**
	 * render a background grid
	 * 
	 * @return
	 */
	public native final boolean show_grid() /*-{
		return this["show_grid"];
	}-*/;

	/**
	 * render a background grid
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final LineChartOpts show_grid(boolean val) /*-{
		this["show_grid"] = val;
		return this;
	}-*/;

	/**
	 * display bar labels
	 * 
	 * @return
	 */
	public native final boolean show_x_labels() /*-{
		return this["show_x_labels"];
	}-*/;

	/**
	 * display bar labels
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final BarChartOpts show_x_labels(boolean val) /*-{
		this["show_x_labels"] = val;
		return this;
	}-*/;

	/**
	 * display bar values
	 * 
	 * @return
	 */
	public native final boolean show_y_labels() /*-{
		return this["show_y_labels"];
	}-*/;

	/**
	 * display bar values
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final BarChartOpts show_y_labels(boolean val) /*-{
		this["show_y_labels"] = val;
		return this;
	}-*/;

	/**
	 * size of bar labels
	 * 
	 * @return
	 */
	public native final int x_label_size() /*-{
		return this["x_label_size"];
	}-*/;

	/**
	 * size of bar labels
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final BarChartOpts x_label_size(int val) /*-{
		this["x_label_size"] = val;
		return this;
	}-*/;

	/**
	 * size of bar values
	 * 
	 * @return
	 */
	public native final int y_label_size() /*-{
		return this["y_label_size"];
	}-*/;

	/**
	 * size of bar values
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final BarChartOpts y_label_size(int val) /*-{
		this["y_label_size"] = val;
		return this;
	}-*/;

	/**
	 * color of bar label
	 * 
	 * @return
	 */
	public native final String x_label_color() /*-{
		return this["x_label_color"];
	}-*/;

	/**
	 * color of bar label
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final BarChartOpts x_label_color(String val) /*-{
		this["x_label_color"] = val;
		return this;
	}-*/;

	/**
	 * color of bar values
	 * 
	 * @return
	 */
	public native final String y_label_color() /*-{
		return this["y_label_color"];
	}-*/;

	/**
	 * color of bar values
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final BarChartOpts y_label_color(String val) /*-{
		this["y_label_color"] = val;
		return this;
	}-*/;

	/**
	 * how much to pad the x-axis (px)
	 * 
	 * @return
	 */
	public native final int x_padding() /*-{
		return this["x_padding"];
	}-*/;

	/**
	 * how much to pad the x-axis (px)
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final BarChartOpts x_padding(int val) /*-{
		this["x_padding"] = val;
		return this;
	}-*/;

	/**
	 * how much to pad the y-axis (px)
	 * 
	 * @return
	 */
	public native final int y_padding() /*-{
		return this["y_padding"];
	}-*/;

	/**
	 * how much to pad the y-axis (px)
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final BarChartOpts y_padding(int val) /*-{
		this["y_padding"] = val;
		return this;
	}-*/;

	/**
	 * font stack to use for the labels
	 * 
	 * @return
	 */
	public native final String font_family() /*-{
		return this["font_family"];
	}-*/;

	/**
	 * font stack to use for the labels
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final BarChartOpts font_family(String val) /*-{
		this["font_family"] = val;
		return this;
	}-*/;
	
	/**
	 * width of the bars
	 * 
	 * @return
	 */
	public native final int bar_width() /*-{
		return this["bar_width"];
	}-*/;

	/**
	 * width of the bars
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final BarChartOpts bar_width(int val) /*-{
		this["bar_width"] = val;
		return this;
	}-*/;

	/**
	 * how far apart to place bars
	 * 
	 * @return
	 */
	public native final int bar_spacing() /*-{
		return this["bar_spacing"];
	}-*/;

	/**
	 * how far apart to place bars
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final BarChartOpts bar_spacing(int val) /*-{
		this["bar_spacing"] = val;
		return this;
	}-*/;

	/**
	 * color of the bar's fill
	 * 
	 * @return
	 */
	public native final String bar_color() /*-{
		return this["bar_color"];
	}-*/;

	/**
	 * color of the bar's fill
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final BarChartOpts bar_color(String val) /*-{
		this["bar_color"] = val;
		return this;
	}-*/;

	/**
	 * how much to round the bars (0 makes square bars)
	 * 
	 * @return
	 */
	public native final int rounding() /*-{
		return this["rounding"];
	}-*/;

	/**
	 * how much to round the bars (0 makes square bars)
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final BarChartOpts rounding(int val) /*-{
		this["rounding"] = val;
		return this;
	}-*/;
	
}
