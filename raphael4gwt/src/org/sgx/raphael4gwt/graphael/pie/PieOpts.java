package org.sgx.raphael4gwt.graphael.pie;

import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * information object for creating a PieChart
 * @author sg
 *
 */
public class PieOpts{
	
public static final String 
	LEGENDPOS_WEST="west", 
	LEGENDPOS_EAST="east", 
	LEGENDPOS_NORTH="north", 
	LEGENDPOS_SOUTH="south";

//protected PieOpts(){}
String[]legends;
String legendpos;
String[] hrefs;

public PieOpts(String[] legends, String legendpos, String[] hrefs) {
	super();
	this.legends = legends;
	this.legendpos = legendpos;
	this.hrefs = hrefs;
}
public String[] getLegends() {
	return legends;
}
public void setLegends(String[] legends) {
	this.legends = legends;
}
public String getLegendpos() {
	return legendpos;
}
public void setLegendpos(String legendpos) {
	this.legendpos = legendpos;
}
public String[] getHrefs() {
	return hrefs;
}
public void setHrefs(String[] hrefs) {
	this.hrefs = hrefs;
}
public JavaScriptObject toNative() {
	JsArrayString _legends = JsUtil.toJsArray(legends);
	JsArrayString _hrefs = JsUtil.toJsArray(hrefs);
	JavaScriptObject jso = JavaScriptObject.createObject();
	JsUtil.put(jso, "legend", _legends);
	JsUtil.put(jso, "legendpos", legendpos);
	JsUtil.put(jso, "href", _hrefs);
	return jso;
}
}
