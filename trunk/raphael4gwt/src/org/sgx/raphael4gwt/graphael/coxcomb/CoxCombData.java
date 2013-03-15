package org.sgx.raphael4gwt.graphael.coxcomb;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

import com.google.gwt.core.client.JavaScriptObject;
/**
 * 
 * @see https://github.com/guilespi/coxcomb-chart
 * @author sg
 *
 */
public class CoxCombData extends JsObject{
protected CoxCombData(){}
public static final native CoxCombData create()/*-{
	return {}; 
}-*/;

/**
 * 
 * @return
 */
public native final JsMap<JsMapDouble> data() /*-{
return this["data"]; 
}-*/;

/**
 * 
 * @param val
 * @return this - for setter chaining
 */
public native final CoxCombData data(JsMap<JsMapDouble> val) /*-{
this["data"] = val; 
return this; 
}-*/;

/**
 * 
 * @return
 */
public native final CoxCombDataColors colors() /*-{
return this["colors"]; 
}-*/;

/**
 * 
 * @param val
 * @return this - for setter chaining
 */
public native final CoxCombData colors(CoxCombDataColors val) /*-{
this["colors"] = val; 
return this; 
}-*/;
}
