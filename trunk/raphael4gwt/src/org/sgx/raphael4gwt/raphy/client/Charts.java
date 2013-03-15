package org.sgx.raphael4gwt.raphy.client;

import org.sgx.raphael4gwt.raphy.client.pathmenu.PathMenu;
import org.sgx.raphael4gwt.raphy.client.pathmenu.PathMenuOpts;
import org.sgx.raphael4gwt.raphy.client.line.LineChart;
import org.sgx.raphael4gwt.raphy.client.line.LineChartOpts;

import com.google.gwt.dom.client.Element;

public class Charts {

	public static final native PathMenu PathMenu(String id, PathMenuOpts opts)/*-{
		return new $wnd.Charts.PathMenu(id, opts);
	}-*/;

	public static final native PathMenu PathMenu(Element el, PathMenuOpts opts)/*-{
		return new $wnd.Charts.PathMenu(el, opts);
	}-*/;

	public static final native LineChart LineChart(Element el)/*-{
		return new $wnd.Charts.LineChart(el);
	}-*/;
	
	public static final native LineChart LineChart(String id)/*-{
		return new $wnd.Charts.LineChart(id);
	}-*/;

	
	public static final native LineChart LineChart(Element el, LineChartOpts opts)/*-{
		return new $wnd.Charts.LineChart(el, opts);
	}-*/;

	public static final native LineChart LineChart(String id, LineChartOpts opts)/*-{
		return new $wnd.Charts.LineChart(id, opts);
	}-*/;

}
