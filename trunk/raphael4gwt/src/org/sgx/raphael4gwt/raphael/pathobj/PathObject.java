package org.sgx.raphael4gwt.raphael.pathobj;

import com.google.gwt.core.client.JsArray;
/**
 * a path can be represented both with an string and with an object path. This overlays the later native objects. 
 * native example of a path command: [["M", 50, 50], ["l", 20, 0, 0, 20, 50, 5], ["z"]]
 * Internally a path command is an array of path commands, see pathcm
 * @author sg
 *
 */
public class PathObject extends JsArray<PathCmd> {
	
protected PathObject(){}
/**
 * creates a new path object that starts with absolute Move command (M) at given coords. remember all paths must start with a M command. 
 * @param x
 * @param y
 * @return a new path object with the only command M x y
 */
public static final native PathObject create(double x, double y)/*-{	
	return [["M", x, y]]; 
}-*/;
public final native PathCmd getCommand(int index)/*-{
	return this[index]; 
}-*/;

public final native PathObject Z()/*-{
	this.push(["Z"]); 
	return this; 
}-*/;
public final native PathObject z()/*-{
	this.push(["z"]); 
	return this; 
}-*/;
public final native PathObject M(double x, double y)/*-{
	this.push(["M", x, y]); 
	return this; 	
}-*/;
public final native PathObject m(double x, double y)/*-{
	this.push(["m", x, y]);
	return this;  	
}-*/;
public final native PathObject L(double x, double y)/*-{
	this.push(["L", x, y]); 	
	return this; 
}-*/;
public final native PathObject l(double x, double y)/*-{
	this.push(["L", x, y]); 	
	return this; 
}-*/;
public final native PathObject T(double x, double y)/*-{
	this.push(["T", x, y]); 	
	return this; 
}-*/;
public final native PathObject t(double x, double y)/*-{
	this.push(["t", x, y]); 	
	return this; 
}-*/;

}
