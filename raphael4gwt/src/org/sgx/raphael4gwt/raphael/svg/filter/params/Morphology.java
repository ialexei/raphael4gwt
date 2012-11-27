package org.sgx.raphael4gwt.raphael.svg.filter.params;

/**
 * This filter primitive performs "fattening" or "thinning" of artwork. It is particularly useful for fattening or thinning an alpha channel.
 * 
 * Example:
 * 
 * <pre>
 * {operator: "dilate", radius: "2 4"}
 * </pre>
 * 
 * @see http://www.w3.org/TR/SVG/filters.html#feMorphologyElement
 * 
 * 
 * @author sg
 * 
 */
public class Morphology extends FilterOperationParam {
	protected Morphology() {
	}
	
	public static final String OPERATOR_ERODE="erode", OPERATOR_DILATE="dilate"; 

	public static final native Morphology create(String operator, int radius)/*-{
		return {
			"_filterName" : "feMorphology",
			"operator" : operator,
			"radius" : radius + ""
		};
	}-*/;

	public static final native Morphology create(String operator, int xradius, int yradius)/*-{
		return {
			"_filterName" : "feMorphology",
			"operator" : operator,
			"radius" : xradius + " " + yradius
		};
	}-*/;

	/**
	 * operator = "erode | dilate"
	 * 
	 * A keyword indicating whether to erode (i.e., thin) or dilate (fatten) the source graphic. If attribute ‘operator’ is not specified, then the effect is as if a value of erode
	 * were specified.
	 * 
	 * @return
	 */
	public native final String operator() /*-{
		return this.operator;
	}-*/;

	/**
	 * operator = "erode | dilate"
	 * 
	 * A keyword indicating whether to erode (i.e., thin) or dilate (fatten) the source graphic. If attribute ‘operator’ is not specified, then the effect is as if a value of erode
	 * were specified.
	 * 
	 * @return this - for setter chaining
	 */
	public native final Morphology operator(String val) /*-{
		this.operator = val;
		return this;
	}-*/;

	/**
	 * radius = "<number-optional-number>"
	 * 
	 * The radius (or radii) for the operation. If two <number>s are provided, the first number represents a x-radius and the second value represents a y-radius. If one number is
	 * provided, then that value is used for both X and Y. The values are in the coordinate system established by attribute ‘primitiveUnits’ on the ‘filter’ element. A negative
	 * value is an error (see Error processing). A value of zero disables the effect of the given filter primitive (i.e., the result is a transparent black image). If the attribute
	 * is not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @return
	 */
	public native final String radius() /*-{
		return this.radius + "";
	}-*/;

	/**
	 * radius = "<number-optional-number>"
	 * 
	 * The radius (or radii) for the operation. If two <number>s are provided, the first number represents a x-radius and the second value represents a y-radius. If one number is
	 * provided, then that value is used for both X and Y. The values are in the coordinate system established by attribute ‘primitiveUnits’ on the ‘filter’ element. A negative
	 * value is an error (see Error processing). A value of zero disables the effect of the given filter primitive (i.e., the result is a transparent black image). If the attribute
	 * is not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Morphology radius(String val) /*-{
		this.radius = val;
		return this;
	}-*/;
}
