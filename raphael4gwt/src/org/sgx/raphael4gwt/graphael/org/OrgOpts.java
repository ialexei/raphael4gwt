package org.sgx.raphael4gwt.graphael.org;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
/**
 * Options for creating OrgCharts
 * @author sg
 *
 */
public class OrgOpts extends JsObject {
	protected OrgOpts() {
	}

	/**
	 * name of the DIV where the chart will be drawn
	 * 
	 * @return
	 */
	public native final String container() /*-{
		return this["container"];
	}-*/;

	/**
	 * name of the DIV where the chart will be drawn
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts container(String val) /*-{
		this["container"] = val;
		return this;
	}-*/;

	/**
	 * size of the smallest vertical line of connectors
	 * 
	 * @return
	 */
	public native final int vline() /*-{
		return this["vline"];
	}-*/;

	/**
	 * size of the smallest vertical line of connectors
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts vline(int val) /*-{
		this["vline"] = val;
		return this;
	}-*/;

	/**
	 * size of the smallest horizontal line of connectors
	 * 
	 * @return
	 */
	public native final int hline() /*-{
		return this["hline"];
	}-*/;

	/**
	 * size of the smallest horizontal line of connectors
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts hline(int val) /*-{
		this["hline"] = val;
		return this;
	}-*/;

	/**
	 * space from text to box border
	 * 
	 * @return
	 */
	public native final int inner_padding() /*-{
		return this["inner_padding"];
	}-*/;

	/**
	 * space from text to box border
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts inner_padding(int val) /*-{
		this["inner_padding"] = val;
		return this;
	}-*/;

	/**
	 * fill color of boxes
	 * 
	 * @return
	 */
	public native final String box_color() /*-{
		return this["box_color"];
	}-*/;

	/**
	 * fill color of boxes
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts box_color(String val) /*-{
		this["box_color"] = val;
		return this;
	}-*/;

	/**
	 * fill color of boxes when mouse is over them
	 * 
	 * @return
	 */
	public native final String box_color_hover() /*-{
		return this["box_color_hover"];
	}-*/;

	/**
	 * fill color of boxes when mouse is over them
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts box_color_hover(String val) /*-{
		this["box_color_hover"] = val;
		return this;
	}-*/;

	/**
	 * stroke color of boxes
	 * 
	 * @return
	 */
	public native final String box_border_color() /*-{
		return this["box_border_color"];
	}-*/;

	/**
	 * stroke color of boxes
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts box_border_color(String val) /*-{
		this["box_border_color"] = val;
		return this;
	}-*/;

	/**
	 * color of connectors
	 * 
	 * @return
	 */
	public native final String line_color() /*-{
		return this["line_color"];
	}-*/;

	/**
	 * color of connectors
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts line_color(String val) /*-{
		this["line_color"] = val;
		return this;
	}-*/;

	/**
	 * color of titles
	 * 
	 * @return
	 */
	public native final String title_color() /*-{
		return this["title_color"];
	}-*/;

	/**
	 * color of titles
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts title_color(String val) /*-{
		this["title_color"] = val;
		return this;
	}-*/;

	/**
	 * color of subtitles
	 * 
	 * @return
	 */
	public native final String subtitle_color() /*-{
		return this["subtitle_color"];
	}-*/;

	/**
	 * color of subtitles
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts subtitle_color(String val) /*-{
		this["subtitle_color"] = val;
		return this;
	}-*/;

	/**
	 * size of font used for displaying titles inside boxes
	 * 
	 * @return
	 */
	public native final int title_font_size() /*-{
		return this["title_font_size"];
	}-*/;

	/**
	 * size of font used for displaying titles inside boxes
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts title_font_size(int val) /*-{
		this["title_font_size"] = val;
		return this;
	}-*/;

	/**
	 * size of font used for displaying subtitles inside boxes
	 * 
	 * @return
	 */
	public native final int subtitle_font_size() /*-{
		return this["subtitle_font_size"];
	}-*/;

	/**
	 * size of font used for displaying subtitles inside boxes
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts subtitle_font_size(int val) /*-{
		this["subtitle_font_size"] = val;
		return this;
	}-*/;

	/**
	 * size (x, y) of a char of the font used for displaying titles
	 * 
	 * @return
	 */
	public native final JsArrayNumber title_char_size() /*-{
		return this["title_char_size"];
	}-*/;

	/**
	 * size (x, y) of a char of the font used for displaying titles
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts title_char_size(JsArrayNumber val) /*-{
		this["title_char_size"] = val;
		return this;
	}-*/;

	/**
	 * size (x, y) of a char of the font used for displaying titles
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts title_char_size(int x, int y) /*-{
		this["title_char_size"] = [ x, y ];
		return this;
	}-*/;

	/**
	 * size (x, y) of a char of the font used for displaying subtitles
	 * 
	 * @return
	 */
	public native final JsArrayNumber subtitle_char_size() /*-{
		return this["title_char_size"];
	}-*/;

	/**
	 * size (x, y) of a char of the font used for displaying subtitles
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts subtitle_char_size(JsArrayNumber val) /*-{
		this["title_char_size"] = val;
		return this;
	}-*/;

	/**
	 * size (x, y) of a char of the font used for displaying subtitles
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts subtitle_char_size(int x, int y) /*-{
		this["title_char_size"] = [ x, y ];
		return this;
	}-*/;

	/**
	 * max width (in chars) of each line of text ('0' for no limit)
	 * 
	 * @return
	 */
	public native final int max_text_width() /*-{
		return this["max_text_width"];
	}-*/;

	/**
	 * max width (in chars) of each line of text ('0' for no limit)
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts max_text_width(int val) /*-{
		this["max_text_width"] = val;
		return this;
	}-*/;

	/**
	 * font family to use (should be monospaced)
	 * 
	 * @return
	 */
	public native final String text_font() /*-{
		return this["text_font"];
	}-*/;

	/**
	 * font family to use (should be monospaced)
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts text_font(String val) /*-{
		this["text_font"] = val;
		return this;
	}-*/;

	/**
	 * use images within boxes?
	 * 
	 * @return
	 */
	public native final boolean use_images() /*-{
		return this["use_images"];
	}-*/;

	/**
	 * use images within boxes?
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts use_images(boolean val) /*-{
		this["use_images"] = val;
		return this;
	}-*/;

	/**
	 * base url of the images to be embeeded in boxes, with a trailing slash, example: './images/'
	 * 
	 * @return
	 */
	public native final String images_base_url() /*-{
		return this["images_base_url"];
	}-*/;

	/**
	 * base url of the images to be embeeded in boxes, with a trailing slash, example: './images/'
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts images_base_url(String val) /*-{
		this["images_base_url"] = val;
		return this;
	}-*/;

	/**
	 * size (x, y) of the images to be embeeded in boxes
	 * 
	 * @return
	 */
	public native final JsArrayNumber images_size() /*-{
		return this["images_size"];
	}-*/;

	/**
	 * size (x, y) of the images to be embeeded in boxes
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts images_size(JsArrayNumber val) /*-{
		this["images_size"] = val;
		return this;
	}-*/;

	/**
	 * size (x, y) of the images to be embeeded in boxes
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts images_size(int x, int y) /*-{
		this["images_size"] = [ x, y ];
		return this;
	}-*/;

	/**
	 * handler (function) called on click on boxes (set to null if no handler)
	 * 
	 * @return
	 */
	public native final JavaScriptObject box_click_handler() /*-{
		return this["box_click_handler"];
	}-*/;

	/**
	 * handler (function) called on click on boxes (set to null if no handler)
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts box_click_handler(JavaScriptObject val) /*-{
		this["box_click_handler"] = val;
		return this;
	}-*/;

	/**
	 * handler (function) called on click on boxes (set to null if no handler)
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgOpts box_click_handler(OrgEventHandler val) /*-{
		var f = $entry(function(event, box) {
			return val.@org.sgx.raphael4gwt.graphael.org.OrgEventHandler::notifyEvent(Lcom/google/gwt/dom/client/NativeEvent;Lorg/sgx/raphael4gwt/graphael/org/OrgNode;)(event, box);
		});
		this["box_click_handler"] = f;
		return this;
	}-*/;
}
