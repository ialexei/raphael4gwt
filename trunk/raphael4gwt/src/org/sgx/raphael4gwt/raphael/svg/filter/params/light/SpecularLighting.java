package org.sgx.raphael4gwt.raphael.svg.filter.params.light;

import org.sgx.raphael4gwt.raphael.svg.filter.params.FilterOperationParam;

/**
 * 
 * <p>
 * This filter primitive lights a source graphic using the alpha channel as a bump map. The resulting image is an RGBA image based on the light color. The lighting calculation
 * follows the standard specular component of the Phong lighting model. The resulting image depends on the light color, light position and surface geometry of the input bump map.
 * The result of the lighting calculation is added. The filter primitive assumes that the viewer is at infinity in the z direction (i.e., the unit vector in the eye direction is
 * (0,0,1) everywhere).
 * </p>
 * 
 * <p>
 * This filter primitive produces an image which contains the specular reflection part of the lighting calculation. Such a map is intended to be combined with a texture using the
 * add term of the arithmetic ‘feComposite’ method. Multiple light sources can be simulated by adding several of these light maps before applying it to the texture image.
 * </p>
 * 
 * <p>
 * The resulting RGBA image is computed as follows:
 * </p>
 * 
 * <p class="filterformula">
 * S<sub>r</sub> = k<sub>s</sub> * pow(N.H, specularExponent) * L<sub>r<br>
 * </sub> S<sub>g</sub> = k<sub>s</sub> * pow(N.H, specularExponent) * L<sub>g<br>
 * </sub> S<sub>b</sub> = k<sub>s</sub> * pow(N.H, specularExponent) * L<sub>b<br>
 * </sub> S<sub>a</sub> = max(S<sub>r,</sub> S<sub>g,</sub> S<sub>b</sub>)
 * </p>
 * 
 * <p>
 * Where
 * </p>
 * 
 * <dd>k<sub>s</sub> = specular lighting constant<br>
 * N = surface normal unit vector, a function of x and y<br>
 * H = "halfway" unit vector between eye unit vector and light unit vector<br>
 * <br>
 * L<sub>r</sub>,L<sub>g</sub>,L<sub>b</sub> = RGB components of light</dd>
 * 
 * <p>
 * Unlike the ‘feDiffuseLighting’, the ‘feSpecularLighting’ filter produces a non-opaque image. This is due to the fact that the specular result (Sr,Sg,Sb,Sa) is meant to be added
 * to the textured image. The alpha channel of the result is the max of the color components, so that where the specular light is zero, no additional coverage is added to the image
 * and a fully white highlight will add opacity.
 * </p>
 * 
 * <p>
 * The ‘feDiffuseLighting’ and ‘feSpecularLighting’ filters will often be applied together. An implementation may detect this and calculate both maps in one pass, instead of two.
 * </p>
 * 
 * 
 * 
 * @see http://www.w3.org/TR/SVG/filters.html#feSpecularLightingElement
 * @author sg
 * 
 */
public class SpecularLighting extends FilterOperationParam {
	protected SpecularLighting() {
	}

	public static final native SpecularLighting create()/*-{
		return {
			"_filterName" : "feSpecularLighting"
		};
	}-*/;

	/**
	 * height of surface when Ain = 1. If the attribute is not specified, then the effect is as if a value of 1 were specified.
	 * 
	 * @return
	 */
	public native final double surfaceScale() /*-{
		return this.surfaceScale;
	}-*/;

	/**
	 * height of surface when Ain = 1. If the attribute is not specified, then the effect is as if a value of 1 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final SpecularLighting surfaceScale(double val) /*-{
		this.surfaceScale = val;
		return this;
	}-*/;

	/**
	 * ks in Phong lighting model. In SVG, this can be any non-negative number. If the attribute is not specified, then the effect is as if a value of 1 were specified.
	 * 
	 * @return
	 */
	public native final double specularConstant() /*-{
		return this.specularConstant;
	}-*/;

	/**
	 * ks in Phong lighting model. In SVG, this can be any non-negative number. If the attribute is not specified, then the effect is as if a value of 1 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final SpecularLighting specularConstant(double val) /*-{
		this.specularConstant = val;
		return this;
	}-*/;

	/**
	 * Exponent for specular term, larger is more "shiny". Range 1.0 to 128.0. If the attribute is not specified, then the effect is as if a value of 1 were specified.
	 * 
	 * @return
	 */
	public native final double specularExponent() /*-{
		return this.specularExponent;
	}-*/;

	/**
	 * Exponent for specular term, larger is more "shiny". Range 1.0 to 128.0. If the attribute is not specified, then the effect is as if a value of 1 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final SpecularLighting specularExponent(double val) /*-{
		this.specularExponent = val;
		return this;
	}-*/;

	/**
	 * The first number is the <dx> value. The second number is the <dy> value. If the <dy> value is not specified, it defaults to the same value as <dx>. Indicates the intended
	 * distance in current filter units (i.e., units as determined by the value of attribute ‘primitiveUnits’) for dx and dy, respectively, in the surface normal calculation
	 * formulas. By specifying value(s) for ‘kernelUnitLength’, the kernel becomes defined in a scalable, abstract coordinate system. If ‘kernelUnitLength’ is not specified, the dx
	 * and dy values should represent very small deltas relative to a given (x,y) position, which might be implemented in some cases as one pixel in the intermediate image
	 * offscreen bitmap, which is a pixel-based coordinate system, and thus potentially not scalable. For some level of consistency across display media and user agents, it is
	 * necessary that a value be provided for at least one of ‘filterRes’ and ‘kernelUnitLength’. Discussion of intermediate images are in the Introduction and in the description
	 * of attribute ‘filterRes’. A negative or zero value is an error (see Error processing).
	 * 
	 * @return
	 */
	public native final int kernelUnitLength() /*-{
		return this.kernelUnitLength;
	}-*/;

	/**
	 * The first number is the <dx> value. The second number is the <dy> value. If the <dy> value is not specified, it defaults to the same value as <dx>. Indicates the intended
	 * distance in current filter units (i.e., units as determined by the value of attribute ‘primitiveUnits’) for dx and dy, respectively, in the surface normal calculation
	 * formulas. By specifying value(s) for ‘kernelUnitLength’, the kernel becomes defined in a scalable, abstract coordinate system. If ‘kernelUnitLength’ is not specified, the dx
	 * and dy values should represent very small deltas relative to a given (x,y) position, which might be implemented in some cases as one pixel in the intermediate image
	 * offscreen bitmap, which is a pixel-based coordinate system, and thus potentially not scalable. For some level of consistency across display media and user agents, it is
	 * necessary that a value be provided for at least one of ‘filterRes’ and ‘kernelUnitLength’. Discussion of intermediate images are in the Introduction and in the description
	 * of attribute ‘filterRes’. A negative or zero value is an error (see Error processing).
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final SpecularLighting kernelUnitLength(int val) /*-{
		this.kernelUnitLength = val;
		return this;
	}-*/;
	
/**
 * 
 * @return
 */
public native final LightSource lightSource() /*-{
return this.lightSource; 
}-*/;

/**
 * 
 * @param val
 * @return this - for setter chaining
 */
public native final SpecularLighting lightSource(LightSource val) /*-{
this.lightSource = val; 
return this; 
}-*/;

/**
 * The ‘lighting-color’ property defines the color of the light source for filter primitives ‘feDiffuseLighting’ and ‘feSpecularLighting’.
 * 
 * @return
 */
public native final String lightningColor() /*-{
	return this["lighting-color"];
}-*/;

/**
 * The ‘lighting-color’ property defines the color of the light source for filter primitives ‘feDiffuseLighting’ and ‘feSpecularLighting’.
 * 
 * @param val
 * @return this - for setter chaining
 */
public native final SpecularLighting lightningColor(String val) /*-{
	this["lighting-color"] = val;
	return this;
}-*/;

}
