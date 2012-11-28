package org.sgx.raphael4gwt.raphael.svg.filter.params.light;

/**
 * 
 * @see http://www.w3.org/TR/SVG/filters.html#feDistantLightElement
 * @author sg
 * 
 */
public class PointLight extends LightSource {
	protected PointLight() {
	}

	public static final native PointLight create()/*-{
		return {
			"lightSourceName" : "fePointLight"
		};
	}-*/;

	/**
	 * X location for the light source in the coordinate system established by attribute ‘primitiveUnits’ on the ‘filter’ element. If the attribute is not specified, then the
	 * effect is as if a value of 0 were specified.
	 * 
	 * @return
	 */
	public native final double x() /*-{
		return this.x;
	}-*/;

	/**
	 * X location for the light source in the coordinate system established by attribute ‘primitiveUnits’ on the ‘filter’ element. If the attribute is not specified, then the
	 * effect is as if a value of 0 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PointLight x(double val) /*-{
		this.x = val;
		return this;
	}-*/;

	/**
	 * Y location for the light source in the coordinate system established by attribute ‘primitiveUnits’ on the ‘filter’ element. If the attribute is not specified, then the
	 * effect is as if a value of 0 were specified.
	 * 
	 * @return
	 */
	public native final double y() /*-{
		return this.y;
	}-*/;

	/**
	 * Y location for the light source in the coordinate system established by attribute ‘primitiveUnits’ on the ‘filter’ element. If the attribute is not specified, then the
	 * effect is as if a value of 0 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PointLight y(double val) /*-{
		this.y = val;
		return this;
	}-*/;

	/**
	 * Z location for the light source in the coordinate system established by attribute ‘primitiveUnits’ on the ‘filter’ element, assuming that, in the initial coordinate system,
	 * the positive Z-axis comes out towards the person viewing the content and assuming that one unit along the Z-axis equals one unit in X and Y. If the attribute is not
	 * specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @return
	 */
	public native final double z() /*-{
		return this.z;
	}-*/;

	/**
	 * Z location for the light source in the coordinate system established by attribute ‘primitiveUnits’ on the ‘filter’ element, assuming that, in the initial coordinate system,
	 * the positive Z-axis comes out towards the person viewing the content and assuming that one unit along the Z-axis equals one unit in X and Y. If the attribute is not
	 * specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PointLight z(double val) /*-{
		this.z = val;
		return this;
	}-*/;

}
