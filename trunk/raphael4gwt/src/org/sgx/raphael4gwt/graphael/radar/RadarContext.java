package org.sgx.raphael4gwt.graphael.radar;

import org.sgx.raphael4gwt.graphael.GShape;
import org.sgx.raphael4gwt.raphael.Set;

import com.google.gwt.core.client.JavaScriptObject;

public class RadarContext extends JavaScriptObject {
	protected RadarContext(){}
	public final native GShape getArm()/*-{
		return this.arm;
	}-*/;
//	public final native GShape getText()/*-{
//		return this.text;
//	}-*/;
	public final native Set getCover()/*-{
		return this.cover;
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
	public final native double getValue()/*-{
		return this.value;
	}-*/;
	public final native Set getLabel()/*-{
		return this.label;
	}-*/;
}
