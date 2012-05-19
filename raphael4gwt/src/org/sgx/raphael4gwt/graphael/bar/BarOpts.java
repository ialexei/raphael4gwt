package org.sgx.raphael4gwt.graphael.bar;

import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.core.client.JavaScriptObject;

public class BarOpts {

	public static final String 
		TYPE_SOFT="soft", TYPE_ROUND="round",
		TYPE_SHARP="sharp", TYPE_SQUARE="square";
		
	boolean stacked;
	String type, axis;
	String [] axisXLabels, axisYLabels, colors;	
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAxis() {
		return axis;
	}
	public void setAxis(String axis) {
		this.axis = axis;
	}	
	public String[] getAxisXLabels() {
		return axisXLabels;
	}
	public void setAxisXLabels(String[] axisXLabels) {
		this.axisXLabels = axisXLabels;
	}
	public String[] getAxisYLabels() {
		return axisYLabels;
	}
	public void setAxisYLabels(String[] axisYLabels) {
		this.axisYLabels = axisYLabels;
	}
	
	public String[] getColors() {
		return colors;
	}
	public void setColors(String[] colors) {
		this.colors = colors;
	}
	public JavaScriptObject toNative() {
		JavaScriptObject o = JavaScriptObject.createObject();
		JsUtil.putBoolean(o, "stacked", stacked);
		JsUtil.put(o, "type", type);
		JsUtil.put(o, "axis", axis);
		JsUtil.put(o, "colors", JsUtil.toJsArray(colors));
		JsUtil.put(o, "axisxlabels", JsUtil.toJsArray(axisXLabels));
		JsUtil.put(o, "axisylabels", JsUtil.toJsArray(axisYLabels));
		return o;
	}
}
