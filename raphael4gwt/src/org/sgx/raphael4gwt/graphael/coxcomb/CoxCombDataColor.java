package org.sgx.raphael4gwt.graphael.coxcomb;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;
/**
 * @see https://github.com/guilespi/coxcomb-chart
 * @author sg
 *
 */
public class CoxCombDataColor extends JsObject{
protected CoxCombDataColor(){}

/**
 * 
 * @return
 */
public native final double opacity() /*-{
return this["opacity"]; 
}-*/;

/**
 * 
 * @param val
 * @return this - for setter chaining
 */
public native final CoxCombDataColor opacity(double val) /*-{
this["opacity"] = val; 
return this; 
}-*/;
/**
 * 
 * @return
 */
public native final String fontColor() /*-{
return this["fontColor"]; 
}-*/;

/**
 * 
 * @param val
 * @return this - for setter chaining
 */
public native final CoxCombDataColor fontColor(String val) /*-{
this["fontColor"] = val; 
return this; 
}-*/;

/**
 * 
 * @return
 */
public native final String color() /*-{
return this["color"]; 
}-*/;

/**
 * 
 * @param val
 * @return this - for setter chaining
 */
public native final CoxCombDataColor color(String val) /*-{
this["color"] = val; 
return this; 
}-*/;
}
