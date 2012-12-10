package org.sgx.raphael4gwt.raphael.svg.filter.params;


/**
 * <p>
 * This filter performs the combination of the two input images pixel-wise in image space using one of the Porter-Duff [PORTERDUFF] compositing operations: over, in, atop, out, xor
 * [SVG-COMPOSITING]. Additionally, a component-wise arithmetic operation (with the result clamped between [0..1]) can be applied.
 * </p>
 * 
 * <p>
 * The arithmetic operation is useful for combining the output from the ‘feDiffuseLighting’ and ‘feSpecularLighting’ filters with texture data. It is also useful for implementing
 * dissolve. If the arithmetic operation is chosen, each result pixel is computed using the following formula:
 * </p>
 * 
 * <pre>
 * result = k1 * i1 * i2 + k2 * i1 + k3 * i2 + k4
 * </pre>
 * 
 * <p>
 * where:
 * </p>
 * 
 * <p>
 * i1 and i2 indicate the corresponding pixel channel values of the input image, which map to in and in2 respectively
 * </p>
 * <p>
 * k1, k2, k3 and k4 indicate the values of the attributes with the same name
 * </p>
 * 
 * <p>
 * For this filter primitive, the extent of the resulting image might grow as described in the section that describes the filter primitive subregion.
 * </p>
 * 
 * 
 * @see http://www.w3.org/TR/SVG/filters.html#feCompositeElement
 * 
 * @author sg
 * 
 */
public class Composite extends FilterOperationParam {
	protected Composite() {
	}

	public static final native Composite create()/*-{
		return {
			"_filterName" : "feComposite"
		};
	}-*/;

	/**
	 * operator = "over | in | out | atop | xor | arithmetic" The compositing operation that is to be performed. All of the ‘operator’ types except arithmetic match the
	 * corresponding operation as described in [PORTERDUFF]. The arithmetic operator is described above. If attribute ‘operator’ is not specified, then the effect is as if a value
	 * of over were specified.
	 * 
	 * @return
	 */
	public native final String operator() /*-{
		return this.operator;
	}-*/;

	/**
	 * operator = "over | in | out | atop | xor | arithmetic" The compositing operation that is to be performed. All of the ‘operator’ types except arithmetic match the
	 * corresponding operation as described in [PORTERDUFF]. The arithmetic operator is described above. If attribute ‘operator’ is not specified, then the effect is as if a value
	 * of over were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Composite operator(String val) /*-{
		this.operator = val;
		return this;
	}-*/;

	/**
	 * Only applicable if operator="arithmetic". If the attribute is not specified, the effect is as if a value of 0 were specified.
	 * 
	 * @return
	 */
	public native final double k1() /*-{
		return this.k1;
	}-*/;

	/**
	 * Only applicable if operator="arithmetic". If the attribute is not specified, the effect is as if a value of 0 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Composite k1(double val) /*-{
		this.k1 = val;
		return this;
	}-*/;

	/**
	 * Only applicable if operator="arithmetic". If the attribute is not specified, the effect is as if a value of 0 were specified.
	 * 
	 * @return
	 */
	public native final double k2() /*-{
		return this.k2;
	}-*/;

	/**
	 * Only applicable if operator="arithmetic". If the attribute is not specified, the effect is as if a value of 0 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Composite k2(double val) /*-{
		this.k2 = val;
		return this;
	}-*/;

	/**
	 * Only applicable if operator="arithmetic". If the attribute is not specified, the effect is as if a value of 0 were specified.
	 * 
	 * @return
	 */
	public native final double k3() /*-{
		return this.k3;
	}-*/;

	/**
	 * Only applicable if operator="arithmetic". If the attribute is not specified, the effect is as if a value of 0 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Composite k3(double val) /*-{
		this.k3 = val;
		return this;
	}-*/;

	/**
	 * Only applicable if operator="arithmetic". If the attribute is not specified, the effect is as if a value of 0 were specified.
	 * 
	 * @return
	 */
	public native final double k4() /*-{
		return this.k4;
	}-*/;

	/**
	 * Only applicable if operator="arithmetic". If the attribute is not specified, the effect is as if a value of 0 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Composite k4(double val) /*-{
		this.k4 = val;
		return this;
	}-*/;

	/**
	 * The second input image to the compositing operation. This attribute can take on the same values as the ‘in’ attribute.
	 * 
	 * @return
	 */
	public native final String in2() /*-{
		return this.in2;
	}-*/;

	/**
	 * The second input image to the compositing operation. This attribute can take on the same values as the ‘in’ attribute.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Composite in2(String val) /*-{
		this.in2 = val;
		return this;
	}-*/;

}