package org.sgx.raphael4gwt.graphael.radar;

import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * radar chart options
 * 
var default_opts = {
    meshwidth:    1,
    strokewidth:  2,
    stroke:       "#f90",
    meshcolor:    "#999",
    helplines:    5,
    circleradius:   10,
    numbers:      true,
    numberscolor: "#fff"
};
 * @author sg
 *
 */
public class RadarOpts {
int meshWidth=1, strokeWidth=2, helpLines=5, circleRadius=10;
String stroke="#f90", meshColor="#999", numbersColor="#fff";
String[] legend=null;
boolean numbers=true;
public int getMeshWidth() {
	return meshWidth;
}
public void setMeshWidth(int meshWidth) {
	this.meshWidth = meshWidth;
}
public int getStrokeWidth() {
	return strokeWidth;
}
public void setStrokeWidth(int strokeWidth) {
	this.strokeWidth = strokeWidth;
}
public int getHelpLines() {
	return helpLines;
}
public void setHelpLines(int helpLines) {
	this.helpLines = helpLines;
}
public int getCircleRadius() {
	return circleRadius;
}
public void setCircleRadius(int circleRadius) {
	this.circleRadius = circleRadius;
}
public String getStroke() {
	return stroke;
}
public void setStroke(String stroke) {
	this.stroke = stroke;
}
public String getMeshColor() {
	return meshColor;
}
public void setMeshColor(String meshColor) {
	this.meshColor = meshColor;
}
public String getNumbersColor() {
	return numbersColor;
}
public void setNumbersColor(String numbersColor) {
	this.numbersColor = numbersColor;
}
public boolean isNumbers() {
	return numbers;
}
public void setNumbers(boolean numbers) {
	this.numbers = numbers;
}

public String[] getLegend() {
	return legend;
}
public void setLegend(String[] legend) {
	this.legend = legend;
}
public JavaScriptObject toNative() {
	JavaScriptObject o = JavaScriptObject.createObject();	
	JsUtil.put(o, "meshwidth", getMeshWidth());
	JsUtil.put(o, "strokewidth", getStrokeWidth());
	JsUtil.put(o, "stroke", getStroke());
	JsUtil.put(o, "meshcolor", getMeshColor());
	JsUtil.put(o, "helplines", getHelpLines());
	JsUtil.put(o, "circleradius", getCircleRadius());
	JsUtil.put(o, "numbers", isNumbers());
	JsUtil.put(o, "numberscolor", getNumbersColor());
	JsUtil.put(o, "legend", JsUtil.toJsArray(getLegend()));
	return o;
}
}
