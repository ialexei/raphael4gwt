package org.sgx.raphael4gwt.raphael.base;
import com.google.gwt.core.client.JavaScriptObject;
/**
 *  TODO: if I dont use $wnd.Math.round() for ensure int gwt compielr complains in devmode.
 * @author sg
 *
 */
public class Point extends JavaScriptObject {
	protected Point(){}
	public native final double getX()/*-{
		return this.x;
	}-*/;
	public native final double getY()/*-{
		return this.y;
	}-*/;
	/**
	 * angle of derivative in degrees
	 * @return
	 */
	public native final double getAlpha()/*-{
		return this.alpha;
	}-*/;
	public native final String print()/*-{
		return this.x+", "+this.y;
	}-*/;
}
