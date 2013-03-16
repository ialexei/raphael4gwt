package org.sgx.raphael4gwt.raphy.client;

import org.sgx.raphael4gwt.raphy.client.pathmenu.PathMenu;
import org.sgx.raphael4gwt.raphy.client.pathmenu.PathMenuOpts;
import org.sgx.raphael4gwt.raphy.client.index.IndexChartOpts;
import org.sgx.raphael4gwt.raphy.client.line.LineChart;
import org.sgx.raphael4gwt.raphy.client.line.LineChartOpts;

import com.google.gwt.dom.client.Element;
import org.sgx.raphael4gwt.raphy.client.bar.BarChart;
import org.sgx.raphael4gwt.raphy.client.bar.BarChartOpts;
import org.sgx.raphael4gwt.raphy.client.circleprogress.CircleProgressChart;
import org.sgx.raphael4gwt.raphy.client.index.IndexChart;

public class Charts {

	//PathMenu Chart
	
	public static final native PathMenu PathMenu(String id, PathMenuOpts opts)/*-{
		return new $wnd.Charts.PathMenu(id, opts);
	}-*/;

	public static final native PathMenu PathMenu(Element el, PathMenuOpts opts)/*-{
		return new $wnd.Charts.PathMenu(el, opts);
	}-*/;

	public static final native PathMenu PathMenu(String id)/*-{
		return new $wnd.Charts.PathMenu(id, {});
	}-*/;

	public static final native PathMenu PathMenu(Element el)/*-{
		return new $wnd.Charts.PathMenu(el, {});
	}-*/;
	
	

	//Line chart
	
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
	
	
	//Bar chart
	
	public static final native BarChart BarChart(Element el)/*-{
		return new $wnd.Charts.BarChart(el);
	}-*/;
	
	public static final native BarChart BarChart(String id)/*-{
		return new $wnd.Charts.BarChart(id);
	}-*/;
	
	public static final native BarChart BarChart(Element el, BarChartOpts opts)/*-{
		return new $wnd.Charts.BarChart(el, opts);
	}-*/;
	
	public static final native BarChart BarChart(String id, BarChartOpts opts)/*-{
		return new $wnd.Charts.BarChart(id, opts);
	}-*/;

	
	//Index chart
	
	public static final native IndexChart IndexChart(Element el)/*-{
		return new $wnd.Charts.IndexChart(el);
	}-*/;
	
	public static final native IndexChart IndexChart(String id)/*-{
		return new $wnd.Charts.IndexChart(id);
	}-*/;
	
	public static final native IndexChart IndexChart(Element el, IndexChartOpts opts)/*-{
		return new $wnd.Charts.IndexChart(el, opts);
	}-*/;
	
	public static final native IndexChart IndexChart(String id, IndexChartOpts opts)/*-{
		return new $wnd.Charts.IndexChart(id, opts);
	}-*/;
	
	
	//CircleProgressChart	
	
	public static final native CircleProgressChart CircleProgressChart(Element el, String label, int percentage)/*-{
		return new $wnd.Charts.CircleProgress(el, label, percentage);
	}-*/;
	
	public static final native CircleProgressChart CircleProgressChart(String id, String label, int percentage)/*-{
		return new $wnd.Charts.CircleProgress(id, label, percentage);
	}-*/;
	
	public static final native CircleProgressChart CircleProgressChart(Element el, String label, int percentage, IndexChartOpts opts)/*-{
		return new $wnd.Charts.CircleProgress(el, label, percentage, opts);
	}-*/;
	
	public static final native CircleProgressChart CircleProgressChart(String id, String label, int percentage, IndexChartOpts opts)/*-{
		return new $wnd.Charts.CircleProgress(id, label, percentage, opts);
	}-*/;
}
