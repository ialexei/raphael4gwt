package org.sgx.raphael4gwt.graphael.sunburst;

import com.google.gwt.core.client.JavaScriptObject;
/**
 * thi is the sunburst sector event handler context object
 * @author sg
 *
 */
public class SunBurstContext extends JavaScriptObject {
	protected SunBurstContext(){}
	public final native SunBurstSector getSector()/*-{
		return this.sector;
	}-*/;
	public final native double getCX()/*-{
		return this.cx;
	}-*/;
	public final native double getCY()/*-{
		return this.cy;
	}-*/;
	public final native double getMX()/*-{
		return this.mx;
	}-*/;
	public final native double getMY()/*-{
		return this.my;
	}-*/;
	public final native double getMangle()/*-{
		return this.mangle;
	}-*/;
}
