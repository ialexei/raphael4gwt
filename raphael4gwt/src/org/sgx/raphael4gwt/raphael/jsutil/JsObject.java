package org.sgx.raphael4gwt.raphael.jsutil;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * a better JavaScriptObject - with added methods for setting, getting properties, creating objects from java code, etc.
 * see also JsArray . all methods prefixed with obj for not interfeiing with client subclasses.
 * 
 * for creation, getters and setters it support a short method "_"
 * @author sg
 *
 */
public class JsObject extends JavaScriptObject {
protected JsObject(){}

/**
 * creates a new empty javascript object. 
 * @return a new empty javascript object. 
 */
public static final native JsObject empty()/*-{
	return {}; 
}-*/;
/**
 * creates a new javascript object with the given property setted
 * @param pname property name
 * @param val property value
 * @return a new javascript object with the given property setted
 */
public static final native JsObject empty(Object pname, Object val)/*-{
	return {}; 
}-*/;


//public native final JsObject put(Object propertyName, String )



public native final JsObject objGetJsObject(Object p)/*-{
return this[p];
}-*/;

public native final String objGetString(Object p)/*-{
return this[p]; 
}-*/;

public native final int objGetInt(Object p)/*-{
return this[p]; 
}-*/;
public native final int objGetDouble(Object p)/*-{
return this[p]; 
}-*/;
public final native Object _(Object p)/*-{
return this[p]; 
}-*/;
public native final JavaScriptObject objPut(Object pname, Object val)/*-{
	this[pname]=val;
	return this; 
}-*/;
public native final JavaScriptObject objPut(Object pname, String val)/*-{
	this[pname]=val;
	return this; 
}-*/;
public native final JavaScriptObject objPut(Object pname, int val)/*-{
	this[pname]=val;
	return this; 
}-*/;
public native final JavaScriptObject objPut(Object pname, double val)/*-{
	this[pname]=val;
	return this; 
}-*/;

public final native JsObject _(Object pname, Object val)/*-{
	this[pnema]=val; 
	return this; 
}-*/;


public native final JsArrayString objProps()/*-{
	var props = [];
	for(var i in this) {
		props.push(i+"");
	}
	return props;
}-*/;


public native final String objDump(boolean printValues)/*-{
	var s = "{"; 
	for(var i in this) {
		s+=i+(printValues ? ": "+obj[i] : "")+", "; 
	}
	return s+"}"; 
}-*/;
/**
 * simple - not recursive - property cloning
 */
public native final JsObject clone()/*-{
var o = {}; 
for(var i in this) {
	o[i] = this[i]; 
}
return o;
}-*/;
/**
 * simple - not recursive - property cloning
 */
public native final JsObject removeProperty(String propName)/*-{
delete this[propName]; 
return this; 
}-*/;
}
