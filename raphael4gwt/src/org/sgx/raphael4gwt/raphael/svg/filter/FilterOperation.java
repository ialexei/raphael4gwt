package org.sgx.raphael4gwt.raphael.svg.filter;

import com.google.gwt.core.client.JavaScriptObject;
/**
 * overlay type for filter operation
 * @author sg
 *
 */
public class FilterOperation extends JavaScriptObject {
protected FilterOperation(){}
public final native Filter getFilter()/*-{
	return this.filter;
}-*/;
public final native String getFilterOperationId()/*-{
	return this.filterOperationId;
}-*/;
//public final native 
}
