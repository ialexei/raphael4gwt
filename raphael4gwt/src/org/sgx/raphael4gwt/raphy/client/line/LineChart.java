package org.sgx.raphael4gwt.raphy.client.line;

import org.sgx.raphael4gwt.raphy.client.RaphyChart;

public class LineChart extends RaphyChart {
	protected LineChart() {
	}

	public final native void add_line(Line l)/*-{
		this.add_line(l);
	}-*/;

}
