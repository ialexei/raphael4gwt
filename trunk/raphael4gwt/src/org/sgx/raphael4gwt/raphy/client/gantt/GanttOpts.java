package org.sgx.raphael4gwt.raphy.client.gantt;

import java.util.Collection;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

import com.google.gwt.core.client.JsArray;

public class GanttOpts extends JsObject {
	protected GanttOpts() {
	}

	public static native final GanttOpts create() /*-{
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
	public native final GanttOpts name(String val) /*-{
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
	public native final GanttOpts startDate(String val) /*-{
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
	public native final GanttOpts endDate(String val) /*-{
	this["endDate"] = val; 
	return this; 
	}-*/;
	
	
/**
 * 
 * @return
 */
public native final JsArray<GanttPhase> phases() /*-{
return this["phases"]; 
}-*/;
/**
 * 
 * @return
 */
public native final Collection<GanttPhase> phasesCol() /*-{
return @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJavaCollection(Lcom/google/gwt/core/client/JavaScriptObject;)(this["phases"]); 
}-*/;
/**
 * 
 * @param val
 * @return this - for setter chaining
 */
public native final GanttOpts phases(JsArray<GanttPhase> val) /*-{
this["phases"] = val; 
return this; 
}-*/;
/**
 * 
 * @param val
 * @return this - for setter chaining
 */
public native final GanttOpts phases(GanttPhase...val) /*-{
this["phases"] = @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([Lcom/google/gwt/core/client/JavaScriptObject;)(val); 
return this; 
}-*/;
	 
}
