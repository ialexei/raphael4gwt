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
			"lightSourceName" : "feSpotLight"
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

	/**
	 * X location in the coordinate system established by attribute ‘primitiveUnits’ on the ‘filter’ element of the point at which the light source is pointing. If the attribute is
	 * not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @return
	 */
	public native final double pointsAtX() /*-{
		return this.pointsAtX;
	}-*/;

	/**
	 * X location in the coordinate system established by attribute ‘primitiveUnits’ on the ‘filter’ element of the point at which the light source is pointing. If the attribute is
	 * not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PointLight pointsAtX(double val) /*-{
		this.pointsAtX = val;
		return this;
	}-*/;

	/**
	 * Y location in the coordinate system established by attribute ‘primitiveUnits’ on the ‘filter’ element of the point at which the light source is pointing. If the attribute is
	 * not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @return
	 */
	public native final double pointsAtY() /*-{
		return this.pointsAtY;
	}-*/;

	/**
	 * Y location in the coordinate system established by attribute ‘primitiveUnits’ on the ‘filter’ element of the point at which the light source is pointing. If the attribute is
	 * not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PointLight pointsAtY(double val) /*-{
		this.pointsAtY = val;
		return this;
	}-*/;

	/**
	 * Z location in the coordinate system established by attribute ‘primitiveUnits’ on the ‘filter’ element of the point at which the light source is pointing, assuming that, in
	 * the initial coordinate system, the positive Z-axis comes out towards the person viewing the content and assuming that one unit along the Z-axis equals one unit in X and Y.
	 * If the attribute is not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @return
	 */
	public native final double pointsAtZ() /*-{
		return this.pointsAtZ;
	}-*/;

	/**
	 * Z location in the coordinate system established by attribute ‘primitiveUnits’ on the ‘filter’ element of the point at which the light source is pointing, assuming that, in
	 * the initial coordinate system, the positive Z-axis comes out towards the person viewing the content and assuming that one unit along the Z-axis equals one unit in X and Y.
	 * If the attribute is not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PointLight pointsAtZ(double val) /*-{
		this.pointsAtZ = val;
		return this;
	}-*/;

	/**
	 * Exponent value controlling the focus for the light source. If the attribute is not specified, then the effect is as if a value of 1 were specified.
	 * 
	 * @return
	 */
	public native final double specularExponent() /*-{
		return this.specularExponent;
	}-*/;

	/**
	 * Exponent value controlling the focus for the light source. If the attribute is not specified, then the effect is as if a value of 1 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PointLight specularExponent(double val) /*-{
		this.specularExponent = val;
		return this;
	}-*/;

	/**
	 * A limiting cone which restricts the region where the light is projected. No light is projected outside the cone. ‘limitingConeAngle’ represents the angle in degrees between
	 * the spot light axis (i.e. the axis between the light source and the point to which it is pointing at) and the spot light cone. User agents should apply a smoothing technique
	 * such as anti-aliasing at the boundary of the cone. If no value is specified, then no limiting cone will be applied.
	 * 
	 * @return
	 */
	public native final double limitingConeAngle() /*-{
		return this.limitingConeAngle;
	}-*/;

	/**
	 * A limiting cone which restricts the region where the light is projected. No light is projected outside the cone. ‘limitingConeAngle’ represents the angle in degrees between
	 * the spot light axis (i.e. the axis between the light source and the point to which it is pointing at) and the spot light cone. User agents should apply a smoothing technique
	 * such as anti-aliasing at the boundary of the cone. If no value is specified, then no limiting cone will be applied.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final PointLight limitingConeAngle(double val) /*-{
		this.limitingConeAngle = val;
		return this;
	}-*/;
}
