package org.sgx.raphael4gwt.graphael.org;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

public class OrgData extends JsObject {

	protected OrgData(){}
	/**
	 * 
	 * @return
	 */
	public native final OrgNode root() /*-{
	return this["root"]; 
	}-*/;
	
	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgData root(OrgNode val) /*-{
	this["root"] = val; 
	return this; 
	}-*/;
}
