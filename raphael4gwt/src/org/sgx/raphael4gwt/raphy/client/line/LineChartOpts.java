package org.sgx.raphael4gwt.raphy.client.line;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

import com.google.gwt.core.client.JsArrayNumber;

public class LineChartOpts extends JsObject {
	protected LineChartOpts() {
	}

	public static native final LineChartOpts create() /*-{
		return {};
	}-*/;

	/**
	 * "bar" or "line"
	 * @return
	 */
	public native final String render() /*-{
	return this["render"]; 
	}-*/;
	
	/**
	 * "bar" or "line"
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final LineChartOpts render(String val) /*-{
	this["render"] = val; 
	return this; 
	}-*/;
/**
 * width of bars (px)
 * @return
 */
public native final int bar_width() /*-{
return this["bar_width"]; 
}-*/;

/**
 * width of bars (px)
 * @param val
 * @return this - for setter chaining
 */
public native final LineChartOpts bar_width(int val) /*-{
this["bar_width"] = val; 
return this; 
}-*/;
	/**
	 * 
	 * @return
	 */
	public native final boolean show_grid() /*-{
		return this["show_grid"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final LineChartOpts show_grid(boolean val) /*-{
		this["show_grid"] = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final boolean multi_axis() /*-{
		return this["multi_axis"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final LineChartOpts multi_axis(boolean val) /*-{
		this["multi_axis"] = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final int x_padding() /*-{
		return this["x_padding"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final LineChartOpts x_padding(int val) /*-{
		this["x_padding"] = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final int y_padding() /*-{
		return this["y_padding"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final LineChartOpts y_padding(int val) /*-{
		this["y_padding"] = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final JsArrayNumber y_axis_scale() /*-{
		return this["y_axis_scale"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final LineChartOpts y_axis_scale(JsArrayNumber val) /*-{
		this["y_axis_scale"] = val;
		return this;
	}-*/;
	
	
	
	
	//line options
/**
 * display x axis labels
 * @return
 */
public native final boolean show_x_labels() /*-{
return this["show_x_labels"]; 
}-*/;

/**
 * display x axis labels
 * @param val
 * @return this - for setter chaining
 */
public native final LineChartOpts show_x_labels(boolean val) /*-{
this["show_x_labels"] = val; 
return this; 
}-*/;

/**
 * show y axis labels
 * @return
 */
public native final boolean show_y_labels() /*-{
return this["show_y_labels"]; 
}-*/;

/**
 * show y axis labels
 * @param val
 * @return this - for setter chaining
 */
public native final LineChartOpts show_y_labels(boolean val) /*-{
this["show_y_labels"] = val; 
return this; 
}-*/;

/**
 * label max point of line with tooltip
 * @return
 */
public native final boolean label_max() /*-{
return this["label_max"]; 
}-*/;

/**
 * label max point of line with tooltip
 * @param val
 * @return this - for setter chaining
 */
public native final LineChartOpts label_max(boolean val) /*-{
this["label_max"] = val; 
return this; 
}-*/;

/**
 * label min point of line with tooltip
 * @return
 */
public native final boolean label_min() /*-{
return this["label_min"]; 
}-*/;

/**
 * label min point of line with tooltip
 * @param val
 * @return this - for setter chaining
 */
public native final LineChartOpts label_min(boolean val) /*-{
this["label_min"] = val; 
return this; 
}-*/;
/**
 * max number of x axis labels to show
 * @return
 */
public native final int max_x_labels() /*-{
return this["max_x_labels"]; 
}-*/;

/**
 * max number of x axis labels to show
 * @param val
 * @return this - for setter chaining
 */
public native final LineChartOpts max_x_labels(int val) /*-{
this["max_x_labels"] = val; 
return this; 
}-*/;
/**
 * max number of y axis labels to show
 * @return
 */
public native final int max_y_labels() /*-{
return this["max_y_labels"]; 
}-*/;

/**
 * max number of y axis labels to show
 * @param val
 * @return this - for setter chaining
 */
public native final LineChartOpts max_y_labels(int val) /*-{
this["max_y_labels"] = val; 
return this; 
}-*/;
/**
 * size of x labels (pixels)
 * @return
 */
public native final int x_label_size() /*-{
return this["x_label_size"]; 
}-*/;

/**
 * size of x labels (pixels)
 * @param val
 * @return this - for setter chaining
 */
public native final LineChartOpts x_label_size(int val) /*-{
this["x_label_size"] = val; 
return this; 
}-*/;

/**
 * size of y labels (pixels)
 * @return
 */
public native final int y_label_size() /*-{
return this["y_label_size"]; 
}-*/;

/**
 * size of y labels (pixels)
 * @param val
 * @return this - for setter chaining
 */
public native final LineChartOpts y_label_size(int val) /*-{
this["y_label_size"] = val; 
return this; 
}-*/;
/**
 * which font to use
 * @return
 */
public native final String font_family() /*-{
return this["font_family"]; 
}-*/;

/**
 * which font to use
 * @param val
 * @return this - for setter chaining
 */
public native final LineChartOpts font_family(String val) /*-{
this["font_family"] = val; 
return this; 
}-*/;
/**
 * format string for date labels 	"%m%d"
 * @return
 */
public native final String label_format() /*-{
return this["label_format"]; 
}-*/;

/**
 * format string for date labels 	"%m%d"
 * @param val
 * @return this - for setter chaining
 */
public native final LineChartOpts label_format(String val) /*-{
this["label_format"] = val; 
return this; 
}-*/;
}
