package org.sgx.raphael4gwt.graphael.dot;

import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.core.client.JavaScriptObject;

public class DotOpts {

	String symbol, axis, axisxtype, axisytype;
	double max, axisxstep, axisystep;
	boolean heat;
	String [] axisxlabels, axisylabels;
	
	public JavaScriptObject toNative() {
		JavaScriptObject o = JavaScriptObject.createObject();
		JsUtil.putNumber(o, "max", max);
		JsUtil.putNumber(o, "axisxstep", axisxstep);
		JsUtil.putNumber(o, "axisystep", axisystep);
		JsUtil.putBoolean(o, "heat", heat);
		JsUtil.put(o, "symbol", symbol);
		JsUtil.put(o, "axis", axis);
		JsUtil.put(o, "axisxtype", axisytype);
		JsUtil.put(o, "axisytype", symbol);
		JsUtil.put(o, "symbol", symbol);
		return o;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getAxis() {
		return axis;
	}

	public void setAxis(String axis) {
		this.axis = axis;
	}

	public String getAxisxtype() {
		return axisxtype;
	}

	public void setAxisxtype(String axisxtype) {
		this.axisxtype = axisxtype;
	}

	public String getAxisytype() {
		return axisytype;
	}

	public void setAxisytype(String axisytype) {
		this.axisytype = axisytype;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getAxisxstep() {
		return axisxstep;
	}

	public void setAxisxstep(double axisxstep) {
		this.axisxstep = axisxstep;
	}

	public double getAxisystep() {
		return axisystep;
	}

	public void setAxisystep(double axisystep) {
		this.axisystep = axisystep;
	}

	public boolean isHeat() {
		return heat;
	}

	public void setHeat(boolean heat) {
		this.heat = heat;
	}

	public String[] getAxisxlabels() {
		return axisxlabels;
	}

	public void setAxisxlabels(String[] axisxlabels) {
		this.axisxlabels = axisxlabels;
	}

	public String[] getAxisylabels() {
		return axisylabels;
	}

	public void setAxisylabels(String[] axisylabels) {
		this.axisylabels = axisylabels;
	}
	
	
}
