package org.sgx.raphael4gwt.raphy.client.circleprogress;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

public class CircleProgressChartOpts extends JsObject {
	protected CircleProgressChartOpts() {
	}

	public static native final CircleProgressChartOpts create() /*-{
		return {};
	}-*/;

	/**
	 * radius of circle (how big chart is)
	 * 
	 * @return
	 */
	public native final int radius() /*-{
		return this["radius"];
	}-*/;

	/**
	 * radius of circle (how big chart is)
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final CircleProgressChartOpts radius(int val) /*-{
		this["radius"] = val;
		return this;
	}-*/;

	/**
	 * size of colored indicator on outside of circle
	 * 
	 * @return
	 */
	public native final int stroke_width() /*-{
		return this["stroke_width"];
	}-*/;

	/**
	 * size of colored indicator on outside of circle
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final CircleProgressChartOpts stroke_width(int val) /*-{
		this["stroke_width"] = val;
		return this;
	}-*/;

	/**
	 * color of circle
	 * 
	 * @return
	 */
	public native final String fill_color() /*-{
		return this["fill_color"];
	}-*/;

	/**
	 * color of circle
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final CircleProgressChartOpts fill_color(String val) /*-{
		this["fill_color"] = val;
		return this;
	}-*/;

	/**
	 * color of indicator outside of circle
	 * 
	 * @return
	 */
	public native final String stroke_color() /*-{
		return this["stroke_color"];
	}-*/;

	/**
	 * color of indicator outside of circle
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final CircleProgressChartOpts stroke_color(String val) /*-{
		this["stroke_color"] = val;
		return this;
	}-*/;

	/**
	 * color of font inside circle
	 * 
	 * @return
	 */
	public native final String font_color() /*-{
		return this["font_color"];
	}-*/;

	/**
	 * color of font inside circle
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final CircleProgressChartOpts font_color(String val) /*-{
		this["font_color"] = val;
		return this;
	}-*/;

	/**
	 * color of label outside circle
	 * 
	 * @return
	 */
	public native final String label_color() /*-{
		return this["label_color"];
	}-*/;

	/**
	 * color of label outside circle
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final CircleProgressChartOpts label_color(String val) /*-{
		this["label_color"] = val;
		return this;
	}-*/;

	/**
	 * text shadow on label
	 * 
	 * @return
	 */
	public native final String text_shadow() /*-{
		return this["text_shadow"];
	}-*/;

	/**
	 * text shadow on label
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final CircleProgressChartOpts text_shadow(String val) /*-{
		this["text_shadow"] = val;
		return this;
	}-*/;
}
