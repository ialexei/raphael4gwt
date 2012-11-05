package org.sgx.raphael4gwt.raphael.base;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @see Raphael.color() full color representation.
 * @author sg
 * 
 */
public class Color extends JavaScriptObject {
	protected Color() {
	}

	public final native int getRed()/*-{
		return this.r;
	}-*/;

	public final native int getGreen()/*-{
		return this.g;
	}-*/;

	public final native int getBlue()/*-{
		return this.b;
	}-*/;

	/**
	 * 
	 * @return color in HTML/CSS format: #••••••
	 */
	public final native String getHex()/*-{
		return this.hex;
	}-*/;

	public final native boolean isError()/*-{
		return this.error;
	}-*/;

	public final native int getHue()/*-{
		return this.h;
	}-*/;

	public final native int getSaturation()/*-{
		return this.s;
	}-*/;

	public final native int getBrightness()/*-{
		return this.v;
	}-*/;

	public final native int getLuminosity()/*-{
		return this.l;
	}-*/;
	
}
