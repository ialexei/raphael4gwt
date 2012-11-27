package org.sgx.raphael4gwt.raphael.svg.filter;

import org.sgx.raphael4gwt.raphael.svg.filter.params.FilterOperationParam;

/**
 * responsible of creating Filter objects. Responsible of creating FilterOperation objects from FilterOpDef instances. objects to FilterOperation objects
 * 
 * @author sg
 * 
 */
public class FilterFactory {
	private static FilterFactory instance;

	private FilterFactory() {
	}

	public static FilterFactory getInstance() {
		if (null == instance) {
			instance = new FilterFactory();
		}
		return instance;
	}

	// some filter operations
	public static final String 
		feComponentTransfer = "feComponentTransfer", 
		feColorMatrix = "feColorMatrix",
		feGaussianBlur = "feGaussianBlur", 
		feConvolveMatrix = "feConvolveMatrix";

	// public FilterOperation createFilterOperation(FilterOpDef filterOpDef) {
	// return _createFilterOperation(filterOpDef.getFilterOperationName(), filterOpDef.toNative());
	// }
	public FilterOperation createFilterOperation(FilterOperationParam filterOpParam) {
		return _createFilterOperation(filterOpParam.getFilterName(), filterOpParam);
	}

	public final native FilterOperation _createFilterOperation(String fopName, FilterOperationParam fopParams)/*-{

		var fn = $wnd.Raphael.filterOps[fopName];
		if (fn) {
			var ret = fn(fopParams);
			return ret;
		} else
			return null;

	}-*/;

}
