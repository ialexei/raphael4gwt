package org.sgx.raphael4gwt.graphael.raphalytics;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

import com.google.gwt.core.client.JsArrayString;

/**
 * options for the Raphalytics chart. https://github.com/tataencu/raphalytics
 * 
 * @author sg
 * 
 */
public class RaphalyticsOpts extends JsObject {
	protected RaphalyticsOpts() {
	}

	public static final native RaphalyticsOpts create() /*-{
		return {};
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final int width() /*-{
		return this.width;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts width(int val) /*-{
		this.width = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final int height() /*-{
		return this.height;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts height(int val) /*-{
		this.height = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final int leftgutter() /*-{
		return this.leftgutter;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts leftgutter(int val) /*-{
		this.leftgutter = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final int bottomgutter() /*-{
		return this.bottomgutter;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts bottomgutter(int val) /*-{
		this.bottomgutter = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final int topgutter() /*-{
		return this.topgutter;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts topgutter(int val) /*-{
		this.topgutter = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final int rightgutter() /*-{
		return this.rightgutter;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts rightgutter(int val) /*-{
		this.rightgutter = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final boolean normalize() /*-{
		return this.normalize;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts normalize(boolean val) /*-{
		this.normalize = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final boolean smooth() /*-{
		return this.smooth;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts smooth(boolean val) /*-{
		this.smooth = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final boolean fill() /*-{
		return this.fill;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts fill(boolean val) /*-{
		this.fill = val;
		return this;
	}-*/;

	/**
	 * Possible values: 'y_grid', 'full_grid', 'minimalist', 'x_grid' . Default value: minimalist
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final String gridtype() /*-{
		return this.gridtype;
	}-*/;

	/**
	 * Possible values: 'y_grid', 'full_grid', 'minimalist', 'x_grid' . Default value: minimalist
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts gridtype(String val) /*-{
		this.gridtype = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final String gridcolor() /*-{
		return this.gridcolor;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts gridcolor(String val) /*-{
		this.gridcolor = val;
		return this;
	}-*/;

	/**
	 * Valid grid border type values are : "minimalist", "xoy", "full". Default value: minimalist
	 * 
	 * @return
	 */
	public native final String gridbordertype() /*-{
		return this.gridbordertype;
	}-*/;

	/**
	 * Valid grid border type values are : "minimalist", "xoy", "full". Default value: minimalist
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts gridbordertype(String val) /*-{
		this.gridbordertype = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final String gridbordercolor() /*-{
		return this.gridbordercolor;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts gridbordercolor(String val) /*-{
		this.gridbordercolor = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final String color() /*-{
		return this.color;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts color(String[] val) /*-{
		this.color = @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([Ljava/lang/String;)(val);
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final JsArrayString tooltipcolor() /*-{
		return this.tooltipcolor;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts tooltipcolor(String val) /*-{
		this.tooltipcolor = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final String tooltipbordercolor() /*-{
		return this.tooltipbordercolor;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts tooltipbordercolor(String val) /*-{
		this.tooltipbordercolor = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final String tooltiptextcolor() /*-{
		return this.tooltiptextcolor;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts tooltiptextcolor(String val) /*-{
		this.tooltiptextcolor = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final String labelcolor() /*-{
		return this.labelcolor;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts labelcolor(String val) /*-{
		this.labelcolor = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final int y_labels_number() /*-{
		return this.y_labels_number;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts y_labels_number(int val) /*-{
		this.y_labels_number = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final boolean y_label_0() /*-{
		return this.y_label_0;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts y_label_0(boolean val) /*-{
		this.y_label_0 = val;
		return this;
	}-*/;

	/**
	 * Values can be : "inside", "outside". Default value: "inside".
	 * 
	 * @return
	 */
	public native final String y_labels_position() /*-{
		return this.y_labels_position;
	}-*/;

	/**
	 * Values can be : "inside", "outside". Default value: "inside".
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final RaphalyticsOpts y_labels_position(String val) /*-{
		this.y_labels_position = val;
		return this;
	}-*/;
}
