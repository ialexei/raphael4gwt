package org.sgx.raphael4gwt.graphael.bar;

import com.google.gwt.core.client.JsArray;

public class BarContext extends BarChart {
protected BarContext(){}
public native final Bar getBar()/*-{
	return this.bar;
}-*/;
public native final JsArray<Bar> getBars()/*-{
	return this.bars;
}-*/;

}
