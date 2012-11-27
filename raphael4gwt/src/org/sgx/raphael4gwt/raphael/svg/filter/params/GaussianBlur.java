package org.sgx.raphael4gwt.raphael.svg.filter.params;

/**
 * feGaussianBlur This filter primitive performs a Gaussian blur on the input image.
 * 
 * @see http://www.w3.org/TR/SVG/filters.html#feGaussianBlurElement
 * 
 * @author sg
 * 
 */
public class GaussianBlur extends FilterOperationParam {
	protected GaussianBlur() {
	}

	public static final native GaussianBlur create(double stdDeviationX, double stdDeviationY)/*-{
		return {
			"_filterName" : "feGaussianBlur",
			"stdDeviation" : stdDeviationX + " " + stdDeviationY
		};
	}-*/;

	public static final native GaussianBlur create(double stdDeviation)/*-{
		return {
			"_filterName" : "feGaussianBlur",
			"stdDeviation" : stdDeviation + ""
		};
	}-*/;

	/**
	 * stdDeviation = "<number-optional-number>"
	 * 
	 * The standard deviation for the blur operation. If two <number>s are provided, the first number represents a standard deviation value along the x-axis of the coordinate
	 * system established by attribute ‘primitiveUnits’ on the ‘filter’ element. The second value represents a standard deviation in Y. If one number is provided, then that value
	 * is used for both X and Y. A negative value is an error (see Error processing). A value of zero disables the effect of the given filter primitive (i.e., the result is the
	 * filter input image). If ‘stdDeviation’ is 0 in only one of X or Y, then the effect is that the blur is only applied in the direction that has a non-zero value. If the
	 * attribute is not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @return
	 */
	public native final String getStdDeviation()/*-{
		return this.stdDeviation + "";
	}-*/;

	/**
	 * stdDeviation = "<number-optional-number>"
	 * 
	 * The standard deviation for the blur operation. If two <number>s are provided, the first number represents a standard deviation value along the x-axis of the coordinate
	 * system established by attribute ‘primitiveUnits’ on the ‘filter’ element. The second value represents a standard deviation in Y. If one number is provided, then that value
	 * is used for both X and Y. A negative value is an error (see Error processing). A value of zero disables the effect of the given filter primitive (i.e., the result is the
	 * filter input image). If ‘stdDeviation’ is 0 in only one of X or Y, then the effect is that the blur is only applied in the direction that has a non-zero value. If the
	 * attribute is not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @return
	 */
	public native final void setStdDeviation(String stdDeviation)/*-{
		this.stdDeviation = stdDeviation;
	}-*/;

	/**
	 * stdDeviation = "<number-optional-number>"
	 * 
	 * The standard deviation for the blur operation. If two <number>s are provided, the first number represents a standard deviation value along the x-axis of the coordinate
	 * system established by attribute ‘primitiveUnits’ on the ‘filter’ element. The second value represents a standard deviation in Y. If one number is provided, then that value
	 * is used for both X and Y. A negative value is an error (see Error processing). A value of zero disables the effect of the given filter primitive (i.e., the result is the
	 * filter input image). If ‘stdDeviation’ is 0 in only one of X or Y, then the effect is that the blur is only applied in the direction that has a non-zero value. If the
	 * attribute is not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @return
	 */
	public native final String stdDeviation() /*-{
		return this.stdDeviation;
	}-*/;

	/**
	 * stdDeviation = "<number-optional-number>"
	 * 
	 * The standard deviation for the blur operation. If two <number>s are provided, the first number represents a standard deviation value along the x-axis of the coordinate
	 * system established by attribute ‘primitiveUnits’ on the ‘filter’ element. The second value represents a standard deviation in Y. If one number is provided, then that value
	 * is used for both X and Y. A negative value is an error (see Error processing). A value of zero disables the effect of the given filter primitive (i.e., the result is the
	 * filter input image). If ‘stdDeviation’ is 0 in only one of X or Y, then the effect is that the blur is only applied in the direction that has a non-zero value. If the
	 * attribute is not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final GaussianBlur stdDeviation(String val) /*-{
		this.stdDeviation = val;
		return this;
	}-*/;
}
