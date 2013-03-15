package org.sgx.raphael4gwt.raphy.client.pathmenu;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

/**
 * 
 * <pre>
 * Type 	Option 	Description 	Default
 * number 	main_circle_radius 	size of main menu circle 	70
 * number 	child_radius_multiplier 	size of children relative to their parent 	0.15
 * number 	hover_scale_multiplier 	how much bigger items become on mouseover 	1.2
 * number 	outer_radius_multiplier 	how far 1st level menu items appear from their parent 	1.35
 * number 	outer_radius2_multiplier 	how far 2st level menu items appear from their parent 	1.5
 * number 	bounce_radius 	how much menu items "bounce" in animation 	1.2
 * number 	inactive_opacity 	opacity of inactive (unopened items) 	0.4
 * css-color 	fill_color 	color of circles 	#00a6dd
 * </pre>
 * 
 * @author sg
 * 
 */
public class PathMenuOpts extends JsObject {
	protected PathMenuOpts() {
	}

	/**
	 * main_circle_radius size of main menu circle. default 70
	 * 
	 * @return
	 */
	public native final int main_circle_radius() /*-{
		return this["main_circle_radius"];
	}-*/;

	/**
	 * main_circle_radius size of main menu circle. default 70
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PathMenuOpts main_circle_radius(int val) /*-{
		this["main_circle_radius"] = val;
		return this;
	}-*/;

	/**
	 * size of children relative to their parent. Default: 0.15
	 * 
	 * @return
	 */
	public native final double child_radius_multiplier() /*-{
		return this["child_radius_multiplier"];
	}-*/;

	/**
	 * size of children relative to their parent. Default: 0.15
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PathMenuOpts child_radius_multiplier(double val) /*-{
		this["child_radius_multiplier"] = val;
		return this;
	}-*/;

	/**
	 * how much bigger items become on mouseover. default: 1.2
	 * 
	 * @return
	 */
	public native final double hover_scale_multiplier() /*-{
		return this["hover_scale_multiplier"];
	}-*/;

	/**
	 * how much bigger items become on mouseover. default: 1.2
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PathMenuOpts hover_scale_multiplier(double val) /*-{
		this["hover_scale_multiplier"] = val;
		return this;
	}-*/;

	/**
	 * how far 1st level menu items appear from their parent. default: 1.35
	 * 
	 * @return
	 */
	public native final double outer_radius_multiplier() /*-{
		return this["outer_radius_multiplier"];
	}-*/;

	/**
	 * how far 1st level menu items appear from their parent. default: 1.35
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PathMenuOpts outer_radius_multiplier(double val) /*-{
		this["outer_radius_multiplier"] = val;
		return this;
	}-*/;

	/**
	 * how far 2st level menu items appear from their parent . default: 1.5
	 * 
	 * @return
	 */
	public native final double outer_radius2_multiplier() /*-{
		return this["outer_radius2_multiplier"];
	}-*/;

	/**
	 * how far 2st level menu items appear from their parent . default: 1.5
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PathMenuOpts outer_radius2_multiplier(double val) /*-{
		this["outer_radius2_multiplier"] = val;
		return this;
	}-*/;

	/**
	 * how much menu items "bounce" in animation .default: 1.2
	 * 
	 * @return
	 */
	public native final double bounce_radius() /*-{
		return this["bounce_radius"];
	}-*/;

	/**
	 * how much menu items "bounce" in animation .default: 1.2
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PathMenuOpts bounce_radius(double val) /*-{
		this["bounce_radius"] = val;
		return this;
	}-*/;

	/**
	 * opacity of inactive (unopened items) .default: 0.4
	 * 
	 * @return
	 */
	public native final double inactive_opacity() /*-{
		return this["inactive_opacity"];
	}-*/;

	/**
	 * opacity of inactive (unopened items) .default: 0.4
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PathMenuOpts inactive_opacity(double val) /*-{
		this["inactive_opacity"] = val;
		return this;
	}-*/;

	/**
	 * color of circles . default: #00a6dd
	 * 
	 * @return
	 */
	public native final String fill_color() /*-{
		return this["fill_color"];
	}-*/;

	/**
	 * color of circles . default: #00a6dd
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PathMenuOpts fill_color(String val) /*-{
		this["fill_color"] = val;
		return this;
	}-*/;
}
