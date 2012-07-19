package org.sgx.raphael4gwt.raphael.jsutil;

import java.util.Map;

import org.sgx.raphael4gwt.raphael.util.Util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * a better JavaScriptObject - with added methods for setting, getting properties, creating objects from java code, etc.
 * see also JsArray . all methods prefixed with obj for not interfeiing with client subclasses.
 * @author sg
 *
 */
public class JsObject extends JavaScriptObject {
protected JsObject(){}

//public native final JsObject put(Object propertyName, String )



public native JsObject objGetJsObject(Object p)/*-{
return this[p];
}-*/;

public native String objGetString(Object p)/*-{
return this[p]; 
}-*/;

public native int objGetInt(Object p)/*-{
return this[p]; 
}-*/;
public native int objGetDouble(Object p)/*-{
return this[p]; 
}-*/;

public native JavaScriptObject objPut(Object pname, Object val)/*-{
	this[pname]=val;
	return this; 
}-*/;
public native JavaScriptObject objPut(Object pname, String val)/*-{
	this[pname]=val;
	return this; 
}-*/;
public native JavaScriptObject objPut(Object pname, int val)/*-{
	this[pname]=val;
	return this; 
}-*/;
public native JavaScriptObject objPut(Object pname, double val)/*-{
	this[pname]=val;
	return this; 
}-*/;
public native JsArrayString objProps()/*-{
	var props = [];
	for(var i in this) {
		props.push(i+"");
	}
	return props;
}-*/;


public native String objDump(boolean printValues)/*-{
	var s = "{"; 
	for(var i in this) {
		s+=i+(printValues ? ": "+obj[i] : "")+", "; 
	}
	return s+"}"; 
}-*/;

}
