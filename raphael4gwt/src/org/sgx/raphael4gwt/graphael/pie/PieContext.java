package org.sgx.raphael4gwt.graphael.pie;

import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.Text;

import com.google.gwt.core.client.JavaScriptObject;

public final class PieContext extends JavaScriptObject {

	protected PieContext(){}
	
	public native Shape getLabelIcon()/*-{
		return this.label?this.label[0]:null;
	}-*/;
	public native Text getLabelText()/*-{
		return this.label?this.label[1]:null;
	}-*/;
	public native Shape getSector()/*-{
		return this.sector;
	}-*/;
	public native int getCx()/*-{
		return this.cx;
	}-*/;
	public native int getCy()/*-{
		return this.cy;
	}-*/;

}
