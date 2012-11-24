package org.sgx.raphael4gwt.graphael.raphalytics;

import org.sgx.raphael4gwt.graphael.GShape;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Raphalytics Chart - https://github.com/tataencu/raphalytics
 * 
 * @author sg
 * 
 */
public class RaphalyticsChart extends GShape {
	protected RaphalyticsChart() {
	}

	public static final native RaphalyticsOpts create() /*-{
		return {};
	}-*/;

}
