package org.sgx.raphael4gwt.raphy.client.gantt;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

public class GanttTask extends JsObject {
protected GanttTask(){}

public static native final GanttTask create() /*-{
	return {};
}-*/;
/**
 * 
 * @return
 */
public native final String name() /*-{
return this["name"]; 
}-*/;

/**
 * 
 * @param val
 * @return this - for setter chaining
 */
public native final GanttTask name(String val) /*-{
this["name"] = val; 
return this; 
}-*/;

/**
 * 
 * @return
 */
public native final String startDate() /*-{
return this["startDate"]; 
}-*/;

/**
 * 
 * @param val
 * @return this - for setter chaining
 */
public native final GanttTask startDate(String val) /*-{
this["startDate"] = val; 
return this; 
}-*/;
/**
 * 
 * @return
 */
public native final String endDate() /*-{
return this["endDate"]; 
}-*/;

/**
 * 
 * @param val
 * @return this - for setter chaining
 */
public native final GanttTask endDate(String val) /*-{
this["endDate"] = val; 
return this; 
}-*/;
}
