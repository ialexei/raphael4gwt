package org.sgx.raphael4gwt.raphael.base;

import com.google.gwt.core.client.JavaScriptObject;

public class AnimStatus extends JavaScriptObject {
protected AnimStatus(){}
public native final Animation getAnimation()/*-{
	return this.anim;
}-*/;
public native final double getStatus()/*-{
	return this.status;
}-*/;

}
