package org.sgx.raphael4gwt.raphael.svg.filter.params.light;

/**
 * <p>
 * The following diagram illustrates the angles which ‘azimuth’ and ‘elevation’ represent in an XYZ coordinate system.
 * </p>
 * <img width="480" height="360" alt="Angles which azimuth and elevation represent" src="http://www.w3.org/TR/SVG/images/filters/azimuth-elevation.png">
 * 
 * @see http://www.w3.org/TR/SVG/filters.html#feDistantLightElement
 * @author sg
 * 
 */
public class DistantLight extends LightSource {
	protected DistantLight() {
	}

	public static final native DistantLight create()/*-{
		return {
			"lightSourceName" : "feDistantLight"
		};
	}-*/;

	/**
	 * Direction angle for the light source on the XY plane (clockwise), in degrees from the x axis. If the attribute is not specified, then the effect is as if a value of 0 were
	 * specified.
	 * 
	 * @return
	 */
	public native final double azimuth() /*-{
		return this.azimuth;
	}-*/;

	/**
	 * Direction angle for the light source on the XY plane (clockwise), in degrees from the x axis. If the attribute is not specified, then the effect is as if a value of 0 were
	 * specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final DistantLight azimuth(double val) /*-{
		this.azimuth = val;
		return this;
	}-*/;

	/**
	 * Direction angle for the light source from the XY plane towards the z axis, in degrees. Note the positive Z-axis points towards the viewer of the content. If the attribute is
	 * not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @return
	 */
	public native final double elevation() /*-{
		return this.elevation;
	}-*/;

	/**
	 * Direction angle for the light source from the XY plane towards the z axis, in degrees. Note the positive Z-axis points towards the viewer of the content. If the attribute is
	 * not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final DistantLight elevation(double val) /*-{
		this.elevation = val;
		return this;
	}-*/;
}
