package org.sgx.raphael4gwt.raphy.client;

import com.google.gwt.core.client.JavaScriptObject;

public class RaphyChart extends JavaScriptObject {
	protected RaphyChart() {
	}

	public final native void draw()/*-{
		this.draw();
	}-*/;
}
