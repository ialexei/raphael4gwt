package org.sgx.raphael4gwt.raphy.client.pathmenu;

import com.google.gwt.core.client.JavaScriptObject;

public class PathMenu extends JavaScriptObject{
protected PathMenu(){}
public final native PathMenu add(PathMenuItem item)/*-{
	this.add(item); 
	return this;
}-*/;
}
