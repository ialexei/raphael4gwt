package org.sgx.raphael4gwt.raphael.svg.filter.params.light;

import org.sgx.raphael4gwt.raphael.svg.filter.params.FilterOperationParam;

/**
 * 
 * @see http://www.w3.org/TR/SVG/filters.html#feSpecularLightingElement
 * @author sg
 * 
 */
public class DiffuseLighting extends FilterOperationParam {
	protected DiffuseLighting() {
	}

	public static final native DiffuseLighting create()/*-{
		return {
			"_filterName" : "feDiffuseLighting"
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
	public native final DiffuseLighting surfaceScale(double val) /*-{
		this.surfaceScale = val;
		return this;
	}-*/;

	/**
	 * ks in Phong lighting model. In SVG, this can be any non-negative number. If the attribute is not specified, then the effect is as if a value of 1 were specified.
	 * 
	 * @return
	 */
	public native final double diffuseConstant() /*-{
		return this.diffuseConstant;
	}-*/;

	/**
	 * ks in Phong lighting model. In SVG, this can be any non-negative number. If the attribute is not specified, then the effect is as if a value of 1 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final DiffuseLighting diffuseConstant(double val) /*-{
		this.diffuseConstant = val;
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
	public native final String kernelUnitLength() /*-{
		return this.kernelUnitLength + "";
	}-*/;

	/**
	 * The first number is the dx value. The second number is the <dy> value. If the <dy> value is not specified, it defaults to the same value as dx. Indicates the intended
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
	public native final SpecularLighting kernelUnitLength(int x, int y) /*-{
		this.kernelUnitLength = x + " " + y;
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
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final SpecularLighting kernelUnitLength(String val) /*-{
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
	public native final DiffuseLighting lightSource(LightSource val) /*-{
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
	public native final DiffuseLighting lightningColor(String val) /*-{
		this["lighting-color"] = val;
		return this;
	}-*/;

}
