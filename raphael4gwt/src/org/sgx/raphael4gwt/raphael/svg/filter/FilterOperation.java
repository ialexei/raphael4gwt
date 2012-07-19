package org.sgx.raphael4gwt.raphael.svg.filter;

import com.google.gwt.core.client.JavaScriptObject;
/**
 * overlay type for filter operation native object
 * @author sg
 *
 */
public class FilterOperation extends JavaScriptObject {
protected FilterOperation(){}
public final native Filter getFilter()/*-{
	return this.filter;
}-*/;
/**
 * note: the filter operation id will be loaded AFTER aFilter.appendOperation() is called - else will return empty string ""
 * @return
 */
public final native String getFilterOperationId()/*-{
	return this.filterOperationId || "";
}-*/;

//TODO : params - parameter object
//TODO: internal appendToFilterEl(Element) ? 
public final native JavaScriptObject getParams()/*-{
	return this.params; 
}-*/;

}
