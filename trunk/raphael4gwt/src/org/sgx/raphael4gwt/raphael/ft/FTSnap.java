package org.sgx.raphael4gwt.raphael.ft;

import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * an object to represent snap information rotate, scale drag
 * @author sg
 *
 */
public class FTSnap {
double rotate, scale, drag;

public FTSnap(double rotate, double scale, double drag) {
	super();
	this.rotate = rotate;
	this.scale = scale;
	this.drag = drag;
}
public JavaScriptObject toNative() {
	JavaScriptObject o = JavaScriptObject.createObject();
	JsUtil.put(o, "rotate", rotate);
	JsUtil.put(o, "scale", scale);
	JsUtil.put(o, "drag", drag);
	return o; 
}
public static FTSnap fromNative(JavaScriptObject o) {
	return new FTSnap(JsUtil.getDouble(o, "rotate"), JsUtil.getDouble(o, "scale"), JsUtil.getDouble(o, "drag"));
}
public double getRotate() {
	return rotate;
}

public void setRotate(double rotate) {
	this.rotate = rotate;
}

public double getScale() {
	return scale;
}

public void setScale(double scale) {
	this.scale = scale;
}

public double getDrag() {
	return drag;
}

public void setDrag(double drag) {
	this.drag = drag;
} 

}
