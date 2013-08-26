package org.sgx.raphael4gwt.graphael.bar;

import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.core.client.JavaScriptObject;

public class BarOpts {

	public static final String 
		TYPE_SOFT="soft", TYPE_ROUND="round",
		TYPE_SHARP="sharp", TYPE_SQUARE="square";
		
	boolean stacked, stretch;
	String type, gutter, vgutter;
	double to;
	String [] colors;	
	
	public BarOpts(){
		this(false, TYPE_SOFT);
	}	
	public BarOpts(boolean stacked, String type) {
		super();
		this.stacked = stacked;
		this.type = type;
	}
	public BarOpts(boolean stacked) {
		this(stacked, TYPE_SOFT);
	}
	public BarOpts(String type) {
		this(false, type);
	}
	public boolean isStacked() {
		return stacked;
	}
	public void setStacked(boolean stacked) {
		this.stacked = stacked;
	}

	/**
	 * type of endings of the bar. Default: 'square'. Other options are: 'round', 'sharp', 'soft'. One of TYPE_* constants
	 * @param type
	 */
	public String getType() {
		return type;
	}
	/**
	 * type of endings of the bar. Default: 'square'. Other options are: 'round', 'sharp', 'soft'. One of TYPE_* constants
	 * @param type
	 */	
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * separation between bars, Must be a valid float number or something like "17%". Default value "20%"
	 * @return
	 */
	public String getGutter() {
		return gutter;
	}
	/**
	 * separation between bars, Must be a valid float number or something like "17%". Default value "20%"
	 * @param gutter
	 */
	public void setGutter(String gutter) {
		this.gutter = gutter;
	}
	/**
	 * separation between bars, Must be a valid float number or something like "17%". Default value "20%"
	 * @param gutter
	 */
	public String getVgutter() {
		return vgutter;
	}/**
	 * separation between bars, Must be a valid float number or something like "17%". Default value "20%"
	 * @param gutter
	 */
	public void setVgutter(String vgutter) {
		this.vgutter = vgutter;
	}
//	public String getAxis() {
//		return axis;
//	}
//	public void setAxis(String axis) {
//		this.axis = axis;
//	}	
//	public String[] getAxisXLabels() {
//		return axisXLabels;
//	}
//	public void setAxisXLabels(String[] axisXLabels) {
//		this.axisXLabels = axisXLabels;
//	}
//	public String[] getAxisYLabels() {
//		return axisYLabels;
//	}
//	public void setAxisYLabels(String[] axisYLabels) {
//		this.axisYLabels = axisYLabels;
//	}
	
	public String[] getColors() {
		return colors;
	}
	public void setColors(String[] colors) {
		this.colors = colors;
	}
	
	public boolean isStretch() {
		return stretch;
	}
	public void setStretch(boolean stretch) {
		this.stretch = stretch;
	}
	public double getTo() {
		return to;
	}
	public void setTo(double to) {
		this.to = to;
	}
	public JavaScriptObject toNative() {
		JavaScriptObject o = JavaScriptObject.createObject();
		JsUtil.putBoolean(o, "stacked", stacked);
		JsUtil.putBoolean(o, "stretch", stretch);
		JsUtil.put(o, "to", to);
		JsUtil.put(o, "type", type);
//		JsUtil.put(o, "axis", axis);
		JsUtil.put(o, "gutter", gutter);
		JsUtil.put(o, "vgutter", vgutter);
		JsUtil.put(o, "colors", JsUtil.toJsArray(colors));
//		JsUtil.put(o, "axisxlabels", JsUtil.toJsArray(axisXLabels));
//		JsUtil.put(o, "axisylabels", JsUtil.toJsArray(axisYLabels));
		return o;
	}
}

