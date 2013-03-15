package org.sgx.raphael4gwt.raphy.client.pathmenu;

import java.util.Collection;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

import com.google.gwt.core.client.JsArray;

public class PathMenuItem extends JsObject {
protected PathMenuItem(){}
/**
 * 
 * @return
 */
public native final String label() /*-{
return this["label"]; 
}-*/;

/**
 * 
 * @param val
 * @return this - for setter chaining
 */
public native final PathMenuItem label(String val) /*-{
this["label"] = val; 
return this; 
}-*/;

/**
 * 
 * @return
 */
public native final double value() /*-{
return this["value"]; 
}-*/;

/**
 * 
 * @param val
 * @return this - for setter chaining
 */
public native final PathMenuItem value(double val) /*-{
this["value"] = val; 
return this; 
}-*/;
/**
 * 
 * @return
 */
public native final JsArray<PathMenuItem> children() /*-{
return this["children"]; 
}-*/;

/**
 * 
 * @return
 */
public native final Collection<PathMenuItem> childrenCol() /*-{
return @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJavaCollection(Lcom/google/gwt/core/client/JavaScriptObject;)(this["children"]); 
}-*/;

/**
 * 
 * @param val
 * @return this - for setter chaining
 */
public native final PathMenuItem children(JsArray<PathMenuItem> val) /*-{
this["children"] = val; 
return this; 
}-*/;

}
