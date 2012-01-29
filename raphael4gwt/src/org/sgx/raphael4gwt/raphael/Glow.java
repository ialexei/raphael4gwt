package org.sgx.raphael4gwt.raphael;

import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.core.client.JavaScriptObject;
/**
 * <pre>
    width - size of the glow, default is 10
    fill - will it be filled, default is false
    opacity - opacity, default is 0.5
    offsetx - horizontal offset, default is 0
    offsety - vertical offset, default is 0
    color - glow colour, default is black 
 * </pre>
 * @author sg
 *
 */
public class Glow {
int width;
boolean fill;
double opacity;
int offsetX, offsetY;
String color;
public Glow(int width, boolean fill, double opacity, int offsetX, int offsetY,
		String color) {
	super();
	this.width = width;
	this.fill = fill;
	this.opacity = opacity;
	this.offsetX = offsetX;
	this.offsetY = offsetY;
	this.color = color;
}
public Glow(int width) {
	this(width, false, 0.5, 0, 0, "black");
//	this.width=width;
}
public int getWidth() {
	return width;
}
public void setWidth(int width) {
	this.width = width;
}
public boolean isFill() {
	return fill;
}
public void setFill(boolean fill) {
	this.fill = fill;
}
public double getOpacity() {
	return opacity;
}
public void setOpacity(double opacity) {
	this.opacity = opacity;
}
public int getOffsetX() {
	return offsetX;
}
public void setOffsetX(int offsetX) {
	this.offsetX = offsetX;
}
public int getOffsetY() {
	return offsetY;
}
public void setOffsetY(int offsetY) {
	this.offsetY = offsetY;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public native final JavaScriptObject getNative()/*-{
	var o = {};
	o["width"]=this.@org.sgx.raphael4gwt.raphael.Glow::getWidth()();
	o["fill"]=this.@org.sgx.raphael4gwt.raphael.Glow::isFill()();
	o["opacity"]=this.@org.sgx.raphael4gwt.raphael.Glow::getOpacity()();
	o["offsetx"]=this.@org.sgx.raphael4gwt.raphael.Glow::getOffsetX()();
	o["offsety"]=this.@org.sgx.raphael4gwt.raphael.Glow::getOffsetY()();
	o["color"]=this.@org.sgx.raphael4gwt.raphael.Glow::getColor()();
	return o;
}-*/;
// {
//	JavaScriptObject o = JsUtil.empty();
//	JsUtil.put(o, "width", getWidth());
//	JsUtil.put(o, "fill", isFill());
//	JsUtil.put(o, "opacity", getOpacity());
//	JsUtil.put(o, "offsetx", getOffsetX());
//	JsUtil.put(o, "offsety", getOffsetY());
//	JsUtil.put(o, "color", getColor());
//	return o;
//	
//}
}
