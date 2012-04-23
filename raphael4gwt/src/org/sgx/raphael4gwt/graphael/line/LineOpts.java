package org.sgx.raphael4gwt.graphael.line;

import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.core.client.JavaScriptObject;

public class LineOpts {
	
boolean nostroke, smooth, shade, fill;
String axis, symbol;

public JavaScriptObject toNative() {
	JavaScriptObject o = JavaScriptObject.createObject();
	JsUtil.put(o, "symbol", symbol);
	JsUtil.put(o, "axis", axis);
	JsUtil.putBoolean(o, "nostroke", nostroke);
	JsUtil.putBoolean(o, "smooth", smooth);
	JsUtil.putBoolean(o, "shade", shade);
	JsUtil.putBoolean(o, "fill", fill);
	return o;
}

public boolean isNostroke() {
	return nostroke;
}
public void setNostroke(boolean nostroke) {
	this.nostroke = nostroke;
}
public boolean isSmooth() {
	return smooth;
}
public void setSmooth(boolean smooth) {
	this.smooth = smooth;
}
public boolean isShade() {
	return shade;
}
public void setShade(boolean shade) {
	this.shade = shade;
}
public boolean isFill() {
	return fill;
}
public void setFill(boolean fill) {
	this.fill = fill;
}
public String getAxis() {
	return axis;
}
public void setAxis(String axis) {
	this.axis = axis;
}
public String getSymbol() {
	return symbol;
}
public void setSymbol(String symbol) {
	this.symbol = symbol;
}
}
