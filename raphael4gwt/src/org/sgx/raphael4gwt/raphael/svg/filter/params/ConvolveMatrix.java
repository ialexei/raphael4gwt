package org.sgx.raphael4gwt.raphael.svg.filter.params;

import com.google.gwt.core.client.JsArrayNumber;

/**
 * feConvolveMatrix applies a matrix convolution filter effect. A convolution combines pixels in the input image with neighboring pixels to produce a resulting image. A wide
 * variety of imaging operations can be achieved through convolutions, including blurring, edge detection, sharpening, embossing and beveling.
 * 
 * @see http://www.w3.org/TR/SVG/filters.html#feConvolveMatrixElement
 * 
 * @author sg
 * 
 */
public class ConvolveMatrix extends FilterOperationParam {
	protected ConvolveMatrix() {
	}

	public static final native ConvolveMatrix create(String operator, int radius)/*-{
		return {
			"_filterName" : "feConvolveMatrix",
			"order" : 3,
			"kernelMatrix" : [ 0, 1, 1, -1, 0, 1, -1, -1, 0 ].join(" "),
			"bias" : 1
		};
	}-*/;
	public static final native ConvolveMatrix create()/*-{
		return {
			"_filterName" : "feConvolveMatrix",
			"order" : 3,
			"kernelMatrix" : [ 0, 1, 1, -1, 0, 1, -1, -1, 0 ].join(" "),
			"bias" : 1
		};
	}-*/;
	

	/**
	 * order = "<number-optional-number>"
	 * 
	 * Indicates the number of cells in each dimension for ‘kernelMatrix’. The values provided must be <integer>s greater than zero. The first number, <orderX>, indicates the
	 * number of columns in the matrix. The second number, <orderY>, indicates the number of rows in the matrix. If <orderY> is not provided, it defaults to <orderX>. A typical
	 * value is order="3". It is recommended that only small values (e.g., 3) be used; higher values may result in very high CPU overhead and usually do not produce results that
	 * justify the impact on performance. If the attribute is not specified, the effect is as if a value of 3 were specified.
	 * 
	 * @return
	 */
	public native final String order() /*-{
		return this.order + "";
	}-*/;

	/**
	 * order = "<number-optional-number>"
	 * 
	 * Indicates the number of cells in each dimension for ‘kernelMatrix’. The values provided must be <integer>s greater than zero. The first number, <orderX>, indicates the
	 * number of columns in the matrix. The second number, <orderY>, indicates the number of rows in the matrix. If <orderY> is not provided, it defaults to <orderX>. A typical
	 * value is order="3". It is recommended that only small values (e.g., 3) be used; higher values may result in very high CPU overhead and usually do not produce results that
	 * justify the impact on performance. If the attribute is not specified, the effect is as if a value of 3 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ConvolveMatrix order(int val) /*-{
		this.order = val + "";
		return this;
	}-*/;

	/**
	 * order = "<number-optional-number>"
	 * 
	 * Indicates the number of cells in each dimension for ‘kernelMatrix’. The values provided must be <integer>s greater than zero. The first number, <orderX>, indicates the
	 * number of columns in the matrix. The second number, <orderY>, indicates the number of rows in the matrix. If <orderY> is not provided, it defaults to <orderX>. A typical
	 * value is order="3". It is recommended that only small values (e.g., 3) be used; higher values may result in very high CPU overhead and usually do not produce results that
	 * justify the impact on performance. If the attribute is not specified, the effect is as if a value of 3 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ConvolveMatrix order(String val) /*-{
		this.order = val + "";
		return this;
	}-*/;

	/**
	 * order = "<number-optional-number>"
	 * 
	 * Indicates the number of cells in each dimension for ‘kernelMatrix’. The values provided must be <integer>s greater than zero. The first number, <orderX>, indicates the
	 * number of columns in the matrix. The second number, <orderY>, indicates the number of rows in the matrix. If <orderY> is not provided, it defaults to <orderX>. A typical
	 * value is order="3". It is recommended that only small values (e.g., 3) be used; higher values may result in very high CPU overhead and usually do not produce results that
	 * justify the impact on performance. If the attribute is not specified, the effect is as if a value of 3 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ConvolveMatrix order(int ox, int oy) /*-{
		this.order = ox + " " + oy;
		return this;
	}-*/;

	/**
	 * The list of <number>s that make up the kernel matrix for the convolution. Values are separated by space characters and/or a comma. The number of entries in the list must
	 * equal <orderX> times <orderY>.
	 * 
	 * @return
	 */
	public native final String kernelMatrix() /*-{
		return this.kernelMatrix;
	}-*/;

	/**
	 * The list of <number>s that make up the kernel matrix for the convolution. Values are separated by space characters and/or a comma. The number of entries in the list must
	 * equal <orderX> times <orderY>.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ConvolveMatrix kernelMatrix(String val) /*-{
		this.kernelMatrix = val;
		return this;
	}-*/;

	/**
	 * The list of <number>s that make up the kernel matrix for the convolution. Values are separated by space characters and/or a comma. The number of entries in the list must
	 * equal <orderX> times <orderY>.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ConvolveMatrix kernelMatrix(JsArrayNumber val) /*-{
		this.kernelMatrix = val.join(" ");
		return this;
	}-*/;

	/**
	 * The list of <number>s that make up the kernel matrix for the convolution. Values are separated by space characters and/or a comma. The number of entries in the list must
	 * equal <orderX> times <orderY>.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ConvolveMatrix kernelMatrix(double[] val) /*-{
		this.kernelMatrix = @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([D)(val)
				.join(" ");
		return this;
	}-*/;

	/**
	 * After applying the ‘kernelMatrix’ to the input image to yield a number, that number is divided by ‘divisor’ to yield the final destination color value. A divisor that is the
	 * sum of all the matrix values tends to have an evening effect on the overall color intensity of the result. It is an error to specify a divisor of zero. The default value is
	 * the sum of all values in kernelMatrix, with the exception that if the sum is zero, then the divisor is set to 1.
	 * 
	 * @return
	 */
	public native final double divisor() /*-{
		return this.divisor;
	}-*/;

	/**
	 * After applying the ‘kernelMatrix’ to the input image to yield a number, that number is divided by ‘divisor’ to yield the final destination color value. A divisor that is the
	 * sum of all the matrix values tends to have an evening effect on the overall color intensity of the result. It is an error to specify a divisor of zero. The default value is
	 * the sum of all values in kernelMatrix, with the exception that if the sum is zero, then the divisor is set to 1.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ConvolveMatrix divisor(double val) /*-{
		this.divisor = val;
		return this;
	}-*/;

	/**
	 * After applying the ‘kernelMatrix’ to the input image to yield a number and applying the ‘divisor’, the ‘bias’ attribute is added to each component. One application of ‘bias’
	 * is when it is desirable to have .5 gray value be the zero response of the filter. The bias property shifts the range of the filter. This allows representation of values that
	 * would otherwise be clamped to 0 or 1. If ‘bias’ is not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @return
	 */
	public native final double bias() /*-{
		return this.bias;
	}-*/;

	/**
	 * After applying the ‘kernelMatrix’ to the input image to yield a number and applying the ‘divisor’, the ‘bias’ attribute is added to each component. One application of ‘bias’
	 * is when it is desirable to have .5 gray value be the zero response of the filter. The bias property shifts the range of the filter. This allows representation of values that
	 * would otherwise be clamped to 0 or 1. If ‘bias’ is not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ConvolveMatrix bias(double val) /*-{
		this.bias = val;
		return this;
	}-*/;

	/**
	 * Determines the positioning in X of the convolution matrix relative to a given target pixel in the input image. The leftmost column of the matrix is column number zero. The
	 * value must be such that: 0 <= targetX < orderX. By default, the convolution matrix is centered in X over each pixel of the input image (i.e., targetX = floor ( orderX / 2
	 * )).
	 * 
	 * @return
	 */
	public native final int targetX() /*-{
		return this.targetX;
	}-*/;

	/**
	 * Determines the positioning in X of the convolution matrix relative to a given target pixel in the input image. The leftmost column of the matrix is column number zero. The
	 * value must be such that: 0 <= targetX < orderX. By default, the convolution matrix is centered in X over each pixel of the input image (i.e., targetX = floor ( orderX / 2
	 * )).
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ConvolveMatrix targetX(int val) /*-{
		this.targetX = val;
		return this;
	}-*/;

	/**
	 * Determines the positioning in Y of the convolution matrix relative to a given target pixel in the input image. The topmost row of the matrix is row number zero. The value
	 * must be such that: 0 <= targetY < orderY. By default, the convolution matrix is centered in Y over each pixel of the input image (i.e., targetY = floor ( orderY / 2 )).
	 * 
	 * @return
	 */
	public native final int targetY() /*-{
		return this.targetY;
	}-*/;

	/**
	 * Determines the positioning in Y of the convolution matrix relative to a given target pixel in the input image. The topmost row of the matrix is row number zero. The value
	 * must be such that: 0 <= targetY < orderY. By default, the convolution matrix is centered in Y over each pixel of the input image (i.e., targetY = floor ( orderY / 2 )).
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ConvolveMatrix targetY(int val) /*-{
		this.targetY = val;
		return this;
	}-*/;

	/**
	 * edgeMode = "duplicate | wrap | none"
	 * 
	 * Determines how to extend the input image as necessary with color values so that the matrix operations can be applied when the kernel is positioned at or near the edge of the
	 * input image.
	 * 
	 * @return
	 */
	public native final String edgeMode() /*-{
		return this.edgeMode;
	}-*/;

	/**
	 * edgeMode = "duplicate | wrap | none"
	 * 
	 * Determines how to extend the input image as necessary with color values so that the matrix operations can be applied when the kernel is positioned at or near the edge of the
	 * input image.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ConvolveMatrix edgeMode(String val) /*-{
		this.edgeMode = val;
		return this;
	}-*/;

	/**
	 * The first number is the <dx> value. The second number is the <dy> value. If the <dy> value is not specified, it defaults to the same value as <dx>. Indicates the intended
	 * distance in current filter units (i.e., units as determined by the value of attribute ‘primitiveUnits’) between successive columns and rows, respectively, in the
	 * ‘kernelMatrix’. By specifying value(s) for ‘kernelUnitLength’, the kernel becomes defined in a scalable, abstract coordinate system. If ‘kernelUnitLength’ is not specified,
	 * the default value is one pixel in the offscreen bitmap, which is a pixel-based coordinate system, and thus potentially not scalable. For some level of consistency across
	 * display media and user agents, it is necessary that a value be provided for at least one of ‘filterRes’ and ‘kernelUnitLength’. In some implementations, the most consistent
	 * results and the fastest performance will be achieved if the pixel grid of the temporary offscreen images aligns with the pixel grid of the kernel. A negative or zero value
	 * is an error (see Error processing).
	 * 
	 * @return
	 */
	public native final String kernelUnitLength() /*-{
		return this.kernelUnitLength;
	}-*/;

	/**
	 * The first number is the <dx> value. The second number is the <dy> value. If the <dy> value is not specified, it defaults to the same value as <dx>. Indicates the intended
	 * distance in current filter units (i.e., units as determined by the value of attribute ‘primitiveUnits’) between successive columns and rows, respectively, in the
	 * ‘kernelMatrix’. By specifying value(s) for ‘kernelUnitLength’, the kernel becomes defined in a scalable, abstract coordinate system. If ‘kernelUnitLength’ is not specified,
	 * the default value is one pixel in the offscreen bitmap, which is a pixel-based coordinate system, and thus potentially not scalable. For some level of consistency across
	 * display media and user agents, it is necessary that a value be provided for at least one of ‘filterRes’ and ‘kernelUnitLength’. In some implementations, the most consistent
	 * results and the fastest performance will be achieved if the pixel grid of the temporary offscreen images aligns with the pixel grid of the kernel. A negative or zero value
	 * is an error (see Error processing).
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ConvolveMatrix kernelUnitLength(String val) /*-{
		this.kernelUnitLength = val;
		return this;
	}-*/;

	/**
	 * The first number is the <dx> value. The second number is the <dy> value. If the <dy> value is not specified, it defaults to the same value as <dx>. Indicates the intended
	 * distance in current filter units (i.e., units as determined by the value of attribute ‘primitiveUnits’) between successive columns and rows, respectively, in the
	 * ‘kernelMatrix’. By specifying value(s) for ‘kernelUnitLength’, the kernel becomes defined in a scalable, abstract coordinate system. If ‘kernelUnitLength’ is not specified,
	 * the default value is one pixel in the offscreen bitmap, which is a pixel-based coordinate system, and thus potentially not scalable. For some level of consistency across
	 * display media and user agents, it is necessary that a value be provided for at least one of ‘filterRes’ and ‘kernelUnitLength’. In some implementations, the most consistent
	 * results and the fastest performance will be achieved if the pixel grid of the temporary offscreen images aligns with the pixel grid of the kernel. A negative or zero value
	 * is an error (see Error processing).
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ConvolveMatrix kernelUnitLength(int val) /*-{
		this.kernelUnitLength = val + "";
		return this;
	}-*/;

	/**
	 * The first number is the <dx> value. The second number is the <dy> value. If the <dy> value is not specified, it defaults to the same value as <dx>. Indicates the intended
	 * distance in current filter units (i.e., units as determined by the value of attribute ‘primitiveUnits’) between successive columns and rows, respectively, in the
	 * ‘kernelMatrix’. By specifying value(s) for ‘kernelUnitLength’, the kernel becomes defined in a scalable, abstract coordinate system. If ‘kernelUnitLength’ is not specified,
	 * the default value is one pixel in the offscreen bitmap, which is a pixel-based coordinate system, and thus potentially not scalable. For some level of consistency across
	 * display media and user agents, it is necessary that a value be provided for at least one of ‘filterRes’ and ‘kernelUnitLength’. In some implementations, the most consistent
	 * results and the fastest performance will be achieved if the pixel grid of the temporary offscreen images aligns with the pixel grid of the kernel. A negative or zero value
	 * is an error (see Error processing).
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ConvolveMatrix kernelUnitLength(int x, int y) /*-{
		this.kernelUnitLength = x + " " + y;
		return this;
	}-*/;

	/**
	 * A value of false indicates that the convolution will apply to all channels, including the alpha channel
	 * 
	 * @return
	 */
	public native final boolean preserveAlpha() /*-{
		return this.preserveAlpha;
	}-*/;

	/**
	 * A value of false indicates that the convolution will apply to all channels, including the alpha channel
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ConvolveMatrix preserveAlpha(boolean val) /*-{
		this.preserveAlpha = val;
		return this;
	}-*/;
}
