package org.sgx.raphael4gwt.raphy.client.gantt;

import java.util.Collection;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

import com.google.gwt.core.client.JsArray;

public class GanttPhase extends JsObject {
	protected GanttPhase() {
	}

	public static native final GanttPhase create() /*-{
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
	public native final GanttPhase name(String val) /*-{
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
	public native final GanttPhase startDate(String val) /*-{
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
	public native final GanttPhase endDate(String val) /*-{
	this["endDate"] = val; 
	return this; 
	}-*/;
	
/**
 * 
 * @return
 */
public native final JsArray<GanttTask> tasks() /*-{
return this["tasks"]; 
}-*/;
/**
 * 
 * @return
 */
public native final Collection<GanttTask> tasksCol() /*-{
return @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJavaCollection(Lcom/google/gwt/core/client/JavaScriptObject;)(this["tasks"]); 
}-*/;
/**
 * 
 * @param val
 * @return this - for setter chaining
 */
public native final GanttPhase tasks(JsArray<GanttTask> val) /*-{
this["tasks"] = val; 
return this; 
}-*/;
/**
 * 
 * @param val
 * @return this - for setter chaining
 */
public native final GanttPhase tasks(GanttTask...val) /*-{
this["tasks"] = @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([Lcom/google/gwt/core/client/JavaScriptObject;)(val); 
return this; 
}-*/;
}
