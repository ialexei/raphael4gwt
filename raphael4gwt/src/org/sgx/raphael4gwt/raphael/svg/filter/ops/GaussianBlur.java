package org.sgx.raphael4gwt.raphael.svg.filter.ops;

import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterFactory;
import org.sgx.raphael4gwt.raphael.svg.filter.params.FilterOperationParam;
import org.sgx.raphael4gwt.raphael.svg.filter.params.GaussianBlurParam;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * feGaussianBlurElement -
 * http://www.w3.org/TR/SVG/filters.html#feGaussianBlurElement This filter
 * primitive performs a Gaussian blur on the input image.
 * 
 * The Gaussian blur kernel is an approximation of the normalized convolution
 * 
 * @param stdDeviation
 *            - an array with one or two numbers. The standard deviation for the
 *            blur operation. If two <number>s are provided, the first number
 *            represents a standard deviation value along the x-axis of the
 *            coordinate system established by attribute ‘primitiveUnits’ on the
 *            ‘filter’ element. The second value represents a standard deviation
 *            in Y. If one number is provided, then that value is used for both
 *            X and Y. A negative value is an error (see Error processing). A
 *            value of zero disables the effect of the given filter primitive
 *            (i.e., the result is the filter input image). If ‘stdDeviation’ is
 *            0 in only one of X or Y, then the effect is that the blur is only
 *            applied in the direction that has a non-zero value. If the
 *            attribute is not specified, then the effect is as if a value of 0
 *            were specified.
 * 
 * @author sg
 */
public class GaussianBlur extends FilterOpDef {
	String stdDeviation;
	
	public GaussianBlur(String stdDeviation) {
		super();
		this.stdDeviation = stdDeviation;
	}
	public GaussianBlur(double stdDeviation) {
		super();
		this.stdDeviation = stdDeviation+"";
	}
	public GaussianBlur(double stdDeviationX, double stdDeviationY) {
		super();
		this.stdDeviation = stdDeviationX+" "+stdDeviationY;
	}
	
	
	public String getStdDeviation() {
		return stdDeviation;
	}

	public void setStdDeviation(String stdDeviation) {
		this.stdDeviation = stdDeviation;
	}

	@Override
	public GaussianBlurParam toNative() {
		return JsUtil.put(super.toNative(), "stdDeviation", stdDeviation).cast();
	}
	@Override
	public String getFilterOperationName() {
		return FilterFactory.feGaussianBlur;
	}
}
