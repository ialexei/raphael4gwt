package org.sgx.raphael4gwt.raphy.client.gantt;

import org.sgx.raphael4gwt.raphy.client.RaphyChart;

import com.google.gwt.core.client.JsArray;

/**
 * Note: the original javascript library is not raphy charts, but https://github.com/erikthered/raphael-gantt
 * 
 * <p>But because the API is very similar, I put it on this GWT (RaphyCharts) module.</p>
 * 
 * @author sg
 * 
 */
public class GanttChart extends RaphyChart {
	protected GanttChart() {
	}

	public native final GanttChart loadData(JsArray<GanttOpts> data) /*-{
		this.loadData(data);
		return this;
	}-*/;
	public native final GanttChart loadData(GanttOpts... data) /*-{
	this.loadData(@org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([Lcom/google/gwt/core/client/JavaScriptObject;)(data));
	return this;
}-*/;
}
