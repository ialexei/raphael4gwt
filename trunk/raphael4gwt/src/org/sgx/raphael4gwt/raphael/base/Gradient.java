package org.sgx.raphael4gwt.raphael.base;

import com.google.gwt.core.client.JavaScriptObject;

/**java representation of raphael gradients. Constants and utilities are in the Raphael class.
 * Linear gradient format: “‹angle›-‹colour›[-‹colour›[:‹offset›]]*-‹colour›”, example: “90-#fff-#000” – 90° gradient from white to black or “0-#fff-#f00:20-#000” – 0° gradient from white via red (at 20%) to black.
<br/>
radial gradient: “r[(‹fx›, ‹fy›)]‹colour›[-‹colour›[:‹offset›]]*-‹colour›”, example: “r#fff-#000” – gradient from white to black or “r(0.25, 0.75)#fff-#000” – gradient from white to black with focus point at 0.25, 0.75. Focus point coordinates are in 0..1 range. Radial gradients can only be applied to circles and ellipses. 

 * @author sg
 *
 */
public class Gradient {
	
public static final String TYPE_RADIAL="radial";
public static final String TYPE_LINEAR="linear";


// creators 
public static Gradient radial(double rx, double ry, String initColor, 
		Stop[] stops, String finalColor) {
	Gradient g = new Gradient(TYPE_RADIAL);
	g.setStops(stops);
	g.setRx(rx);
	g.setRy(ry);
	g.setInitColor(initColor);
	g.setFinalColor(finalColor);
	return g;
}
public static Gradient radial(double rx, double ry, String initColor, String finalColor) {
	return radial(rx,ry, initColor, null, finalColor);
}
public static Gradient linear(double angle, String initColor, String finalColor) {
	return linear(angle, initColor, null, finalColor);
}
public static Gradient linear(double angle, String initColor, 
		Stop[] stops, String finalColor) {
	Gradient g = new Gradient(TYPE_LINEAR);
	g.setStops(stops);
	g.setAngle(angle);
	g.setInitColor(initColor);
	g.setFinalColor(finalColor);
	return g;
}


//string builders 

/**
 * it will return empty string in case this gradient object has not enought data or is invalid. 
 */
@Override
public String toString() {
	if(type.equals(TYPE_RADIAL))
		return _toStringRadial();
	else if(type.equals(TYPE_LINEAR))
		return _toStringLinear();
	else
		return "";
}

private String _toStringLinear() {
	if(initColor==null||finalColor==null)
		return "";
	String s = angle+"-"+initColor;
	if(stops!=null) {
		for (int i = 0; i < stops.length; i++) {
			s+="-"+stops[i].getColor()+":"+stops[i].getOffset();
		}
	}		
	return s+"-"+finalColor;
}

private String _toStringRadial() {	
	if(initColor==null||finalColor==null)
		return "";
	String s = "r("+rx+","+ry+")"+initColor;	
	if(stops!=null) {
		for (int i = 0; i < stops.length; i++) {
			s+="-"+stops[i].getColor()+":"+stops[i].getOffset();
		}
	}		
	return s+"-"+finalColor;
}

public Gradient(String type) {
	this.type=type;
}

Stop[] stops;
String type;
/** focus point for radial gradient */
double rx, ry;
/** angle for radial gradients */
double angle;

String initColor, finalColor;


public Stop[] getStops() {
	return stops;
}
public void setStops(Stop[] stops) {
	this.stops = stops;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public double getRx() {
	return rx;
}
public void setRx(double rx) {
	this.rx = rx;
}
public double getRy() {
	return ry;
}
public void setRy(double ry) {
	this.ry = ry;
}
public double getAngle() {
	return angle;
}
public void setAngle(double angle) {
	this.angle = angle;
}
public String getInitColor() {
	return initColor;
}
public void setInitColor(String initColor) {
	this.initColor = initColor;
}
public String getFinalColor() {
	return finalColor;
}
public void setFinalColor(String finalColor) {
	this.finalColor = finalColor;
}
	
}
