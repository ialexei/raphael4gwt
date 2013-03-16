package org.sgx.raphael4gwt.raphy.client.bar;

import org.sgx.raphael4gwt.raphy.client.RaphyChart;

public class BarChart extends RaphyChart {
	protected BarChart() {
	}

	public native final BarChart add(Bar bar) /*-{
		this.add(bar);
		return this;
	}-*/;
}
