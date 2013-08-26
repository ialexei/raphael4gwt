package org.sgx.raphael4gwt.raphael.base;

import org.sgx.raphael4gwt.raphael.Shape;

import com.google.gwt.core.client.JavaScriptObject;

public class AnimStatus extends JavaScriptObject {
	protected AnimStatus() {
	}

	/**
	 * 
	 * @return
	 */
	public native final Animation anim() /*-{
		return this["anim"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final AnimStatus anim(Animation val) /*-{
		this["anim"] = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final double status() /*-{
		return this["status"];
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final AnimStatus status(double val) /*-{
		this["status"] = val;
		return this;
	}-*/;
}