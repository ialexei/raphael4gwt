package org.sgx.raphael4gwt.raphael.svg.filter;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.svg.filter.params.FilterOperationParam;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * overlay type for javascript filter object
 * 
 * @author sg
 * 
 */
public class Filter extends JavaScriptObject {
	protected Filter() {
	}

	public final native String getFilterId()/*-{
		return this.filterId;
	}-*/;

	public final native Paper getPaper()/*-{
		return this.paper;
	}-*/;

	public final native void appendOperation(FilterOperation fop)/*-{
		return this.appendOperation(fop);
	}-*/;

	public final native void appendOperation(FilterOperationParam param)/*-{
		var factory = @org.sgx.raphael4gwt.raphael.svg.filter.FilterFactory::getInstance()();
		var op = factory.@org.sgx.raphael4gwt.raphael.svg.filter.FilterFactory::createFilterOperation(Lorg/sgx/raphael4gwt/raphael/svg/filter/params/FilterOperationParam;)(param);
		return this.appendOperation(op);
	}-*/;

	public final native void removeOperation(FilterOperation fop)/*-{
		return this.removeOperation(fop);
	}-*/;
}
