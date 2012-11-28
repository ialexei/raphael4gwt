package org.sgx.raphael4gwt.raphael.svg.filter.params;

/**
 * <p>
 * This filter applies a matrix transformation:
 * </p>
 * 
 * <pre>
 * | R' |     | a00 a01 a02 a03 a04 |   | R |
 * | G' |     | a10 a11 a12 a13 a14 |   | G |
 * | B' |  =  | a20 a21 a22 a23 a24 | * | B |
 * | A' |     | a30 a31 a32 a33 a34 |   | A |
 * | 1  |     |  0   0   0   0   1  |   | 1 |
 * </pre>
 * 
 * <p>
 * on the RGBA color and alpha values of every pixel on the input graphics to produce a result with a new set of RGBA color and alpha values.
 * </p>
 * 
 * <p>
 * The calculations are performed on non-premultiplied color values. If the input graphics consists of premultiplied color values, those values are automatically converted into
 * non-premultiplied color values for this operation.
 * </p>
 * 
 * <p>
 * These matrices often perform an identity mapping in the alpha channel. If that is the case, an implementation can avoid the costly undoing and redoing of the premultiplication
 * for all pixels with A = 1.
 * </p>
 * 
 * 
 * @see http://www.w3.org/TR/SVG/filters.html#feColorMatrixElement
 * @author sg
 * 
 */
public class ColorMatrix extends FilterOperationParam {
	protected ColorMatrix() {
	}

	public static final native ColorMatrix create()/*-{
		return {
			"_filterName" : "feColorMatrix"
		};
	}-*/;
	public static final String TYPE_MATRIX="matrix", 
			TYPE_SATURATE="saturate", TYPE_HUEROTATE="hueRotate", 
			TYPE_LUMINANCETOALPHA="luminanceToAlpha"; 
	
	/**
	 * type = "matrix | saturate | hueRotate | luminanceToAlpha"
	 * 
	 * <p>
	 * Indicates the type of matrix operation. The keyword 'matrix' indicates that a full 5x4 matrix of values will be provided. The other keywords represent convenience shortcuts
	 * to allow commonly used color operations to be performed without specifying a complete matrix. If attribute ‘type’ is not specified, then the effect is as if a value of
	 * matrix were specified.
	 * </p>
	 * 
	 * @return
	 */
	public native final String type() /*-{
		return this.type;
	}-*/;

	/**
	 * type = "matrix | saturate | hueRotate | luminanceToAlpha"
	 * 
	 * <p>
	 * Indicates the type of matrix operation. The keyword 'matrix' indicates that a full 5x4 matrix of values will be provided. The other keywords represent convenience shortcuts
	 * to allow commonly used color operations to be performed without specifying a complete matrix. If attribute ‘type’ is not specified, then the effect is as if a value of
	 * matrix were specified.
	 * </p>
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ColorMatrix type(String val) /*-{
		this.type = val;
		return this;
	}-*/;

	/**
	 * <ul>
	 * <li>
	 * For <span>type="matrix"</span>, <a><span>‘values’</span></a> is a list of 20 matrix values (a00 a01 a02 a03 a04 a10 a11 ... a34), separated by whitespace and/or a comma. For
	 * example, the identity matrix could be expressed as:
	 * 
	 * <pre>
	 * type="matrix" 
	 * values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 1 0"
	 * </pre>
	 * 
	 * </li>
	 * <li>
	 * For <span>type="saturate"</span>, <a><span>‘values’</span></a> is a single real number value (0 to 1). A <span>saturate</span> operation is equivalent to the following
	 * matrix operation:
	 * 
	 * <pre>
	 * | R' |     |0.213+0.787s  0.715-0.715s  0.072-0.072s 0  0 |   | R |
	 * | G' |     |0.213-0.213s  0.715+0.285s  0.072-0.072s 0  0 |   | G |
	 * | B' |  =  |0.213-0.213s  0.715-0.715s  0.072+0.928s 0  0 | * | B |
	 * | A' |     |           0            0             0  1  0 |   | A |
	 * | 1  |     |           0            0             0  0  1 |   | 1 |
	 * </pre>
	 * 
	 * </li>
	 * <li>
	 * For <span>type="hueRotate"</span>, <a><span>‘values’</span></a> is a single one real number value (degrees). A <span>hueRotate</span> operation is equivalent to the
	 * following matrix operation:
	 * 
	 * <pre>
	 * | R' |     | a00  a01  a02  0  0 |   | R |
	 * | G' |     | a10  a11  a12  0  0 |   | G |
	 * | B' |  =  | a20  a21  a22  0  0 | * | B |
	 * | A' |     | 0    0    0    1  0 |   | A |
	 * | 1  |     | 0    0    0    0  1 |   | 1 |
	 * </pre>
	 * 
	 * where the terms a00, a01, etc. are calculated as follows:
	 * 
	 * <pre>
	 * | a00 a01 a02 |    [+0.213 +0.715 +0.072]
	 * | a10 a11 a12 | =  [+0.213 +0.715 +0.072] +
	 * | a20 a21 a22 |    [+0.213 +0.715 +0.072]
	 *                         [+0.787 -0.715 -0.072]
	 * cos(hueRotate value) *  [-0.213 +0.285 -0.072] +
	 *                         [-0.213 -0.715 +0.928]
	 *                         [-0.213 -0.715+0.928]
	 * sin(hueRotate value) *  [+0.143 +0.140-0.283]
	 *                         [-0.787 +0.715+0.072]
	 * </pre>
	 * 
	 * Thus, the upper left term of the hue matrix turns out to be:
	 * 
	 * <pre>
	 * .213 + cos(hueRotate value)*.787 - sin(hueRotate value)*.213
	 * </pre>
	 * 
	 * </li>
	 * <li>
	 * For <span>type="luminanceToAlpha"</span>, <a><span>‘values’</span></a> is not applicable. A <span>luminanceToAlpha</span> operation is equivalent to the following matrix
	 * operation:
	 * 
	 * <pre>
	 *    | R' |     |      0        0        0  0  0 |   | R |
	 *    | G' |     |      0        0        0  0  0 |   | G |
	 *    | B' |  =  |      0        0        0  0  0 | * | B |
	 *    | A' |     | 0.2125   0.7154   0.0721  0  0 |   | A |
	 *    | 1  |     |      0        0        0  0  1 |   | 1 |
	 * </pre>
	 * 
	 * </li>
	 * </ul>
	 * <p>
	 * If the attribute is not specified, then the default behavior depends on the value of attribute <a><span>‘type’</span></a>. If <span>type="matrix"</span>, then this attribute
	 * defaults to the identity matrix. If <span>type="saturate"</span>, then this attribute defaults to the value <span>1</span>, which results in the identity matrix. If
	 * <span>type="hueRotate"</span>, then this attribute defaults to the value <span>0</span>, which results in the identity matrix.
	 * </p>
	 * <span><a>Animatable</a>: yes.</span>
	 * 
	 * @return
	 */
	public native final String values() /*-{
		return this.values;
	}-*/;

	/**
	 * <ul>
	 * <li>
	 * For <span>type="matrix"</span>, <a><span>‘values’</span></a> is a list of 20 matrix values (a00 a01 a02 a03 a04 a10 a11 ... a34), separated by whitespace and/or a comma. For
	 * example, the identity matrix could be expressed as:
	 * 
	 * <pre>
	 * type="matrix" 
	 * values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 1 0"
	 * </pre>
	 * 
	 * </li>
	 * <li>
	 * For <span>type="saturate"</span>, <a><span>‘values’</span></a> is a single real number value (0 to 1). A <span>saturate</span> operation is equivalent to the following
	 * matrix operation:
	 * 
	 * <pre>
	 * | R' |     |0.213+0.787s  0.715-0.715s  0.072-0.072s 0  0 |   | R |
	 * | G' |     |0.213-0.213s  0.715+0.285s  0.072-0.072s 0  0 |   | G |
	 * | B' |  =  |0.213-0.213s  0.715-0.715s  0.072+0.928s 0  0 | * | B |
	 * | A' |     |           0            0             0  1  0 |   | A |
	 * | 1  |     |           0            0             0  0  1 |   | 1 |
	 * </pre>
	 * 
	 * </li>
	 * <li>
	 * For <span>type="hueRotate"</span>, <a><span>‘values’</span></a> is a single one real number value (degrees). A <span>hueRotate</span> operation is equivalent to the
	 * following matrix operation:
	 * 
	 * <pre>
	 * | R' |     | a00  a01  a02  0  0 |   | R |
	 * | G' |     | a10  a11  a12  0  0 |   | G |
	 * | B' |  =  | a20  a21  a22  0  0 | * | B |
	 * | A' |     | 0    0    0    1  0 |   | A |
	 * | 1  |     | 0    0    0    0  1 |   | 1 |
	 * </pre>
	 * 
	 * where the terms a00, a01, etc. are calculated as follows:
	 * 
	 * <pre>
	 * | a00 a01 a02 |    [+0.213 +0.715 +0.072]
	 * | a10 a11 a12 | =  [+0.213 +0.715 +0.072] +
	 * | a20 a21 a22 |    [+0.213 +0.715 +0.072]
	 *                         [+0.787 -0.715 -0.072]
	 * cos(hueRotate value) *  [-0.213 +0.285 -0.072] +
	 *                         [-0.213 -0.715 +0.928]
	 *                         [-0.213 -0.715+0.928]
	 * sin(hueRotate value) *  [+0.143 +0.140-0.283]
	 *                         [-0.787 +0.715+0.072]
	 * </pre>
	 * 
	 * Thus, the upper left term of the hue matrix turns out to be:
	 * 
	 * <pre>
	 * .213 + cos(hueRotate value)*.787 - sin(hueRotate value)*.213
	 * </pre>
	 * 
	 * </li>
	 * <li>
	 * For <span>type="luminanceToAlpha"</span>, <a><span>‘values’</span></a> is not applicable. A <span>luminanceToAlpha</span> operation is equivalent to the following matrix
	 * operation:
	 * 
	 * <pre>
	 *    | R' |     |      0        0        0  0  0 |   | R |
	 *    | G' |     |      0        0        0  0  0 |   | G |
	 *    | B' |  =  |      0        0        0  0  0 | * | B |
	 *    | A' |     | 0.2125   0.7154   0.0721  0  0 |   | A |
	 *    | 1  |     |      0        0        0  0  1 |   | 1 |
	 * </pre>
	 * 
	 * </li>
	 * </ul>
	 * <p>
	 * If the attribute is not specified, then the default behavior depends on the value of attribute <a><span>‘type’</span></a>. If <span>type="matrix"</span>, then this attribute
	 * defaults to the identity matrix. If <span>type="saturate"</span>, then this attribute defaults to the value <span>1</span>, which results in the identity matrix. If
	 * <span>type="hueRotate"</span>, then this attribute defaults to the value <span>0</span>, which results in the identity matrix.
	 * </p>
	 * <span><a>Animatable</a>: yes.</span>
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final ColorMatrix values(String val) /*-{
		this.values = val;
		return this;
	}-*/;
}
