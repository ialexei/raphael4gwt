package org.sgx.raphael4gwt.raphael.base;
import com.google.gwt.core.client.JavaScriptObject;

public class Point extends JavaScriptObject {
	protected Point(){}
	public native final int getX()/*-{
		return this.x;
	}-*/;
	public native final int getY()/*-{
		return this.y;
	}-*/;
	public native final int getAlpha()/*-{
		return this.alpha;
	}-*/;
}
