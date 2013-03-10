package org.sgx.raphael4gwt.graphael.sunburst;

import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * array attributes should have the same length.
 * @author sg
 *
 */
public class SunBurstOpts {
	
String rootLabel, stroke;
double offsetAngle;

int strokeWidth;
int[] levelWidths;
// Colors array, by default used per slice
String[] colors, gradients;
public SunBurstOpts(){}
public String getRootLabel() {
	return rootLabel;
}
public void setRootLabel(String rootLabel) {
	this.rootLabel = rootLabel;
}
public double getOffsetAngle() {
	return offsetAngle;
}
public void setOffsetAngle(double offsetAngle) {
	this.offsetAngle = offsetAngle;
}
public int[] getLevelWidths() {
	return levelWidths;
}
public void setLevelWidths(int[] levelWidths) {
	this.levelWidths = levelWidths;
}
public String[] getColors() {
	return colors;
}
public void setColors(String[] colors) {
	this.colors = colors;
}
public String[] getGradients() {
	return gradients;
}
public void setGradients(String[] gradients) {
	this.gradients = gradients;
}
public String getStroke() {
	return stroke;
}
public void setStroke(String stroke) {
	this.stroke = stroke;
}
public int getStrokeWidth() {
	return strokeWidth;
}
public void setStrokeWidth(int strokeWidth) {
	this.strokeWidth = strokeWidth;
}

public JavaScriptObject toNative() {
	JavaScriptObject o = JavaScriptObject.createObject();
	JsUtil.put(o, "rootLabel", getRootLabel());
	JsUtil.put(o, "offsetAngle", getOffsetAngle());
	JsUtil.put(o, "levelWidths", JsUtil.toJsArray(getLevelWidths()));
	JsUtil.put(o, "colors", JsUtil.toJsArray(getColors()));
	JsUtil.put(o, "gradients", JsUtil.toJsArray(getGradients()));
	JsUtil.put(o, "stroke", getStroke());
	JsUtil.put(o, "strokewidth", getStrokeWidth());
	return o;
}   
}
