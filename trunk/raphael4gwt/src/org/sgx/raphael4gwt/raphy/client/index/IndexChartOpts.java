package org.sgx.raphael4gwt.raphy.client.index;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

import com.google.gwt.core.client.JsArrayNumber;

public class IndexChartOpts extends JsObject {
	protected IndexChartOpts() {
	}

	public static native final IndexChartOpts create() /*-{
		return {};
	}-*/;

	/**
	 * left hand x padding
	 * 
	 * @return
	 */
	public native final int x_padding() /*-{
		return this["x_padding"];
	}-*/;

	/**
	 * left hand x padding
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final IndexChartOpts x_padding(int val) /*-{
		this["x_padding"] = val;
		return this;
	}-*/;

	/**
	 * right hand x padding
	 * 
	 * @return
	 */
	public native final int x_padding_right() /*-{
		return this["x_padding_right"];
	}-*/;

	/**
	 * right hand x padding
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final IndexChartOpts x_padding_right(int val) /*-{
		this["x_padding_right"] = val;
		return this;
	}-*/;

	/**
	 * y padding
	 * 
	 * @return
	 */
	public native final int y_padding() /*-{
		return this["y_padding"];
	}-*/;

	/**
	 * y padding
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final IndexChartOpts y_padding(int val) /*-{
		this["y_padding"] = val;
		return this;
	}-*/;

	/**
	 * size of labels
	 * 
	 * @return
	 */
	public native final int label_size() /*-{
		return this["label_size"];
	}-*/;

	/**
	 * size of labels
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final IndexChartOpts label_size(int val) /*-{
		this["label_size"] = val;
		return this;
	}-*/;

	/**
	 * font stack to use
	 * 
	 * @return
	 */
	public native final String font_family() /*-{
		return this["font_family"];
	}-*/;

	/**
	 * font stack to use
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final IndexChartOpts font_family(String val) /*-{
		this["font_family"] = val;
		return this;
	}-*/;

	/**
	 * how thick to draw guider lines
	 * 
	 * @return
	 */
	public native final int dash_width() /*-{
		return this["dash_width"];
	}-*/;

	/**
	 * how thick to draw guider lines
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final IndexChartOpts dash_width(int val) /*-{
		this["dash_width"] = val;
		return this;
	}-*/;

	/**
	 * spacing between bars
	 * 
	 * @return
	 */
	public native final int bar_margin() /*-{
		return this["bar_margin"];
	}-*/;

	/**
	 * spacing between bars
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final IndexChartOpts bar_margin(int val) /*-{
		this["bar_margin"] = val;
		return this;
	}-*/;

	/**
	 * background color of bar
	 * 
	 * @return
	 */
	public native final String bar_bg_color() /*-{
		return this["bar_bg_color"];
	}-*/;

	/**
	 * background color of bar
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final IndexChartOpts bar_bg_color(String val) /*-{
		this["bar_bg_color"] = val;
		return this;
	}-*/;

	/**
	 * color of bar when lower than 100 index
	 * 
	 * @return
	 */
	public native final String bar1_color() /*-{
		return this["bar1_color"];
	}-*/;

	/**
	 * color of bar when lower than 100 index
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final IndexChartOpts bar1_color(String val) /*-{
		this["bar1_color"] = val;
		return this;
	}-*/;

	/**
	 * color of bar when higher than 100 index
	 * 
	 * @return
	 */
	public native final String bar2_color() /*-{
		return this["bar2_color"];
	}-*/;

	/**
	 * color of bar when higher than 100 index
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final IndexChartOpts bar2_color(String val) /*-{
		this["bar2_color"] = val;
		return this;
	}-*/;

	/**
	 * color of bar displaying the raw values
	 * 
	 * @return
	 */
	public native final String raw_value_bar_color() /*-{
		return this["raw_value_bar_color"];
	}-*/;

	/**
	 * color of bar displaying the raw values
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final IndexChartOpts raw_value_bar_color(String val) /*-{
		this["raw_value_bar_color"] = val;
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
	public native final IndexChartOpts rounding(int val) /*-{
		this["rounding"] = val;
		return this;
	}-*/;

	/**
	 * controls how big the background bar is relative to its contents (px)
	 * 
	 * @return
	 */
	public native final int bg_bar_padding() /*-{
		return this["bg_bar_padding"];
	}-*/;

	/**
	 * controls how big the background bar is relative to its contents (px)
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final IndexChartOpts bg_bar_padding(int val) /*-{
		this["bg_bar_padding"] = val;
		return this;
	}-*/;
}
