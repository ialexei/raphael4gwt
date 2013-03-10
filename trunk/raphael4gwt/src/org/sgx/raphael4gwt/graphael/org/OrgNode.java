package org.sgx.raphael4gwt.graphael.org;

import java.util.Collection;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

import com.google.gwt.core.client.JsArray;

public class OrgNode extends JsObject {
	protected OrgNode() {
	}

	public static final String TYPE_COLLATERAL = "collateral", TYPE_STAFF = "staff", TYPE_SUBORDINATE = "subordinate";

	/**
	 * 
	 * @return
	 */
	public native final String title() /*-{
		return this["title"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgNode title(String val) /*-{
		this["title"] = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final String subtitle() /*-{
		return this["subtitle"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgNode subtitle(String val) /*-{
		this["subtitle"] = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final JsArray<OrgNode> children() /*-{
		return this["children"];
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final Collection<OrgNode> childrenCol() /*-{
		return @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJavaCollection(Lcom/google/gwt/core/client/JavaScriptObject;)(this["children"]);
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgNode children(JsArray<OrgNode> val) /*-{
		this["children"] = val;
		return this;
	}-*/;
	
	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgNode children(OrgNode...nodes) /*-{
		this["children"] = @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([Lcom/google/gwt/core/client/JavaScriptObject;)(nodes);
		return this;
	}-*/;

	/**
	 * 
	 * @return one of TYPE_* constants
	 */
	public native final String type() /*-{
		return this["type"];
	}-*/;

	/**
	 * @param val
	 *            one of TYPE_* constants
	 * @return this - for setter chaining
	 */
	public native final OrgNode type(String val) /*-{
		this["type"] = val;
		return this;
	}-*/;

	/**
	 * see
	 * 
	 * @return
	 */
	public native final String image() /*-{
		return this["image"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgNode image(String val) /*-{
		this["image"] = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final String id() /*-{
		return this["id"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final OrgNode id(String val) /*-{
		this["id"] = val;
		return this;
	}-*/;
}
