package org.sgx.raphael4gwt.graphael.pie;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

import com.google.gwt.core.client.JsArrayString;

/**
 * options for PieChart
 * 
 * @author sg
 * 
 */
public class PieOpts extends JsObject {
	protected PieOpts() {
	}

	public static final native PieOpts create() /*-{
		return {};
	}-*/;

	/**
	 * minimal percent threshold which will have a slice rendered. Sliced corresponding to data points below this threshold will be collapsed into 1 additional slice. [default `1`]
	 * 
	 * @return
	 */
	public native final int minPercent() /*-{
		return this.minPercent;
	}-*/;

	/**
	 * minimal percent threshold which will have a slice rendered. Sliced corresponding to data points below this threshold will be collapsed into 1 additional slice. [default `1`]
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PieOpts minPercent(int val) /*-{
		this.minPercent = val;
		return this;
	}-*/;

	/**
	 * a threshold for how many slices should be rendered before collapsing all remaining slices into 1 additional slice (to focus on most important data points). [default `100`]
	 * 
	 * @return
	 */
	public native final int maxSlices() /*-{
		return this.maxSlices;
	}-*/;

	/**
	 * a threshold for how many slices should be rendered before collapsing all remaining slices into 1 additional slice (to focus on most important data points). [default `100`]
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PieOpts maxSlices(int val) /*-{
		this.maxSlices = val;
		return this;
	}-*/;

	/**
	 * color of the circle stroke in HTML color format [default `"#FFF"`]
	 * 
	 * @return
	 */
	public native final String stroke() /*-{
		return this.stroke;
	}-*/;

	/**
	 * color of the circle stroke in HTML color format [default `"#FFF"`]
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PieOpts stroke(String val) /*-{
		this.stroke = val;
		return this;
	}-*/;

	/**
	 * width of the chart stroke [default `1`]
	 * 
	 * @return
	 */
	public native final int strokewidth() /*-{
		return this.strokewidth;
	}-*/;

	/**
	 * width of the chart stroke [default `1`]
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PieOpts strokewidth(int val) /*-{
		this.strokewidth = val;
		return this;
	}-*/;

	/**
	 * whether or not to show animation when the chart is ready [default `false`]
	 * 
	 * @return
	 */
	public native final boolean init() /*-{
		return this.init;
	}-*/;

	/**
	 * whether or not to show animation when the chart is ready [default `false`]
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PieOpts init(boolean val) /*-{
		this.init = val;
		return this;
	}-*/;

	/**
	 * colors be used to plot the chart
	 * 
	 * @return
	 */
	public native final JsArrayString colors() /*-{
		return this.colors;
	}-*/;

	/**
	 * colors be used to plot the chart
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PieOpts colors(JsArrayString val) /*-{
		this.colors = val;
		return this;
	}-*/;

	/**
	 * colors be used to plot the chart
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PieOpts colors(String[] val) /*-{
		this.colors = @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([Ljava/lang/String;)(val);
		return this;
	}-*/;

	/**
	 * urls to to set up clicks on chart slices
	 * 
	 * @return
	 */
	public native final JsArrayString href() /*-{
		return this.href;
	}-*/;

	/**
	 * urls to to set up clicks on chart slices
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PieOpts href(JsArrayString val) /*-{
		this.href = val;
		return this;
	}-*/;

	/**
	 * urls to to set up clicks on chart slices
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PieOpts href(String[] val) /*-{
		this.href = this.href = @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([Ljava/lang/String;)(val);
		return this;
	}-*/;

	/**
	 * array containing strings that will be used in a legend. Other label options work if legend is defined.
	 * 
	 * @return
	 */
	public native final JsArrayString legend() /*-{
		return this.legend;
	}-*/;

	/**
	 * array containing strings that will be used in a legend. Other label options work if legend is defined.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PieOpts legend(JsArrayString val) /*-{
		this.legend = val;
		return this;
	}-*/;

	/**
	 * array containing strings that will be used in a legend. Other label options work if legend is defined.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PieOpts legend(String[] val) /*-{
		this.href = this.legend = @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([Ljava/lang/String;)(val);
		return this;
	}-*/;

	/**
	 * color of text in legend [default `"#000"`]
	 * 
	 * @return
	 */
	public native final String legendcolor() /*-{
		return this.legendcolor;
	}-*/;

	/**
	 * color of text in legend [default `"#000"`]
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PieOpts legendcolor(String val) /*-{
		this.legendcolor = val;
		return this;
	}-*/;

	/**
	 * text that will be used in legend to describe options that are collapsed into 1 slice, because they are too small to render [default `"Others"`]
	 * 
	 * @return
	 */
	public native final String legendothers() /*-{
		return this.legendothers;
	}-*/;

	/**
	 * text that will be used in legend to describe options that are collapsed into 1 slice, because they are too small to render [default `"Others"`]
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PieOpts legendothers(String val) /*-{
		this.legendothers = val;
		return this;
	}-*/;

	/**
	 * symbol used as a bullet point in legend that has the same colour as the chart slice [default `"circle"`]
	 * 
	 * @return
	 */
	public native final String legendmark() /*-{
		return this.legendmark;
	}-*/;

	/**
	 * symbol used as a bullet point in legend that has the same colour as the chart slice [default `"circle"`]
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PieOpts legendmark(String val) /*-{
		this.legendmark = val;
		return this;
	}-*/;

	/**
	 * position of the legend on the chart [default `"east"`]. Other options are `"north"`, `"south"`, `"west"`
	 * 
	 * @return
	 */
	public native final String legendpos() /*-{
		return this.legendpos;
	}-*/;

	/**
	 * position of the legend on the chart [default `"east"`]. Other options are `"north"`, `"south"`, `"west"`
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PieOpts legendpos(String val) /*-{
		this.legendpos = val;
		return this;
	}-*/;
}
