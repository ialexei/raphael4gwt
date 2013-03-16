package org.sgx.raphael4gwt.raphy.client.index;

import org.sgx.raphael4gwt.raphy.client.RaphyChart;


public class IndexChart extends RaphyChart {
protected IndexChart(){}

	/**
	 * 
	 * @param label
	 * @param rawValue
	 * @param indexScore index score of 100 == average
	 * @return
	 */
	public native final IndexChart add(String label, int rawValue, int indexScore) /*-{
		this.add(label, rawValue, indexScore);
		return this; 
	}-*/;
	
	/**
	 * 
	 * @param label
	 * @param indexScore index score of 100 == average
	 * @param opacity
	 * @return
	 */
	public native final IndexChart add_guide_line(String label, int indexScore, double opacity) /*-{
		this.add_guide_line(label, indexScore, opacity);
		return this; 
	}-*/;
	
	public native final IndexChart add_raw_label(String label) /*-{
		this.add_raw_label(label);
		return this; 
	}-*/;
}
