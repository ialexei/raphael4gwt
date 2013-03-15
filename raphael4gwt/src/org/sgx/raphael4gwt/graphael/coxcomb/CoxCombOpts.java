package org.sgx.raphael4gwt.graphael.coxcomb;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

import com.google.gwt.core.client.JavaScriptObject;
/**
 * 
 * @author sg
 *
 */
public class CoxCombOpts extends JsObject {
	
	protected CoxCombOpts() {
	}
	public static final native CoxCombOpts create()/*-{
	return {}; 
	}-*/;

	/**
	 * percentage of radius used for categories
	 * 
	 * @return
	 */
	public native final double categorySize() /*-{
		return this["categorySize"];
	}-*/;

	/**
	 * percentage of radius used for categories
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final CoxCombOpts categorySize(double val) /*-{
		this["categorySize"] = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final int categoryFontSize() /*-{
		return this["categoryFontSize"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final CoxCombOpts categoryFontSize(int val) /*-{
		this["categoryFontSize"] = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final int seriesFontSize() /*-{
		return this["seriesFontSize"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final CoxCombOpts seriesFontSize(int val) /*-{
		this["seriesFontSize"] = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final JavaScriptObject onClick() /*-{
		return this["onClick"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final CoxCombOpts onClick(JavaScriptObject val) /*-{
		this["onClick"] = val;
		return this;
	}-*/;

	public native final CoxCombOpts onClick(CoxCombEventListener l) /*-{
		var f = $entry(function(polygon, text) {
			l.@org.sgx.raphael4gwt.graphael.coxcomb.CoxCombEventListener::notifyEvent(Lorg/sgx/raphael4gwt/raphael/Shape;Ljava/lang/String;)(polygon, text); 
		});
		this["onClick"] = f;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final String stroke() /*-{
		return this["stroke"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final CoxCombOpts stroke(String val) /*-{
		this["stroke"] = val;
		return this;
	}-*/;
}
