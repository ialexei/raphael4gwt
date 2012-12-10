package org.sgx.raphael4gwt.raphael.svg.filter.params;

import com.google.gwt.core.client.JsArrayString;

/**
 * <p>
 * This filter primitive composites input image layers on top of each other using the over operator with Input1 (corresponding to the first ‘feMergeNode’ child element) on the
 * bottom and the last specified input, InputN (corresponding to the last ‘feMergeNode’ child element), on top.
 * </p>
 * 
 * <p>
 * Many effects produce a number of intermediate layers in order to create the final output image. This filter allows us to collapse those into a single image. Although this could
 * be done by using n-1 Composite-filters, it is more convenient to have this common operation available in this form, and offers the implementation some additional flexibility.
 * </p>
 * 
 * <p>
 * Each ‘feMerge’ element can have any number of ‘feMergeNode’ subelements, each of which has an ‘in’ attribute.
 * </p>
 * 
 * <p>
 * The canonical implementation of feMerge is to render the entire effect into one RGBA layer, and then render the resulting layer on the output device. In certain cases (in
 * particular if the output device itself is a continuous tone device), and since merging is associative, it might be a sufficient approximation to evaluate the effect one layer at
 * a time and render each layer individually onto the output device bottom to top.
 * </p>
 * 
 * <p>
 * If the topmost image input is SourceGraphic and this ‘feMerge’ is the last filter primitive in the filter, the implementation is encouraged to render the layers up to that
 * point, and then render the SourceGraphic directly from its vector description on top.
 * </p>
 * 
 * @see http://www.w3.org/TR/SVG/filters.html#feMergeElement
 * 
 * @author sg
 * 
 */
public class Merge extends FilterOperationParam {
	protected Merge() {
	}

	public static final native Merge create()/*-{
		return {
			"_filterName" : "feMerge"
		};
	}-*/;

	public static final native Merge create(String... merge)/*-{
		return {
			"_filterName" : "feMerge",
			"merge" : @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([Ljava/lang/String;)(merge)
		};
	}-*/;

	/**
	 * the array of filter results names to merge
	 * 
	 * @return
	 */
	public native final JsArrayString merge() /*-{
		return this.merge;
	}-*/;

	/**
	 * the array of filter results names to merge
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Merge merge(JsArrayString val) /*-{
		this.merge = val;
		return this;
	}-*/;

	/**
	 * the array of filter results names to merge
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Merge merge(String[] val) /*-{
		this.merge = @org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([Ljava/lang/String;)(val);
		return this;
	}-*/;
}
