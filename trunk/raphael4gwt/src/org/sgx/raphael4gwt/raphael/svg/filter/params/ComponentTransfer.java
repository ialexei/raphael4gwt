package org.sgx.raphael4gwt.raphael.svg.filter.params;

/**
 * This filter primitive performs component-wise remapping of data for every pixel. It allows operations like brightness adjustment, contrast adjustment, color balance or
 * thresholding.
 * 
 * @see http://www.w3.org/TR/SVG/filters.html#feComponentTransferElement
 * 
 * @author sg
 * 
 */
public class ComponentTransfer extends FilterOperationParam {
	protected ComponentTransfer() {
	}

	public static final native ComponentTransfer create()/*-{
		return {
			"_filterName" : "feComponentTransfer",

			feFuncR : {
				type : "linear",
				slope : 1.01
			},
			feFuncG : {
				type : "linear",
				intercept : 0.1
			},
			feFuncB : {
				type : "linear",
				slope : 1.11,
				intercept : 0.112
			}

		};
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final ComponentTransferFunction funcR() /*-{
		return this.funcR;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ComponentTransfer funcR(ComponentTransferFunction val) /*-{
		this.funcR = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final ComponentTransferFunction funcG() /*-{
		return this.funcG;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ComponentTransfer funcG(ComponentTransferFunction val) /*-{
		this.funcG = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final ComponentTransferFunction funcB() /*-{
		return this.funcB;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ComponentTransfer funcB(ComponentTransferFunction val) /*-{
		this.funcB = val;
		return this;
	}-*/;

	/**
	 * 
	 * @return
	 */
	public native final ComponentTransfer funcA() /*-{
		return this.funcA;
	}-*/;

	/**
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ComponentTransfer funcA(ComponentTransfer val) /*-{
		this.funcA = val;
		return this;
	}-*/;

}
