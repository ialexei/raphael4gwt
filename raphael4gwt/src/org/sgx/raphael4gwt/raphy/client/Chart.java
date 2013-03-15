package org.sgx.raphael4gwt.raphy.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Chart extends JavaScriptObject {
	protected Chart() {
	}

	public final native void draw()/*-{
		this.draw();
	}-*/;
}
