package org.sgx.raphael4gwt.raphael.svg.filter.params;

import org.sgx.raphael4gwt.raphael.jsutil.JsObject;

/**
 * an overlay for svg filter operation params
 * 
 * @author sg
 * 
 */
public abstract class FilterOperationParam extends JsObject {
	protected FilterOperationParam() {
	}

	/**
	 * The minimum x coordinate for the subregion which restricts calculation and rendering of the given filter primitive.
	 * 
	 * @return
	 */
	public native final double x() /*-{
		return this.x;
	}-*/;

	/**
	 * The minimum x coordinate for the subregion which restricts calculation and rendering of the given filter primitive. See <a
	 * href="filters.html#FilterPrimitiveSubRegion">filter primitive subregion</a>.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final FilterOperationParam x(double val) /*-{
		this.x = val;
		return this;
	}-*/;

	/**
	 * The minimum y coordinate for the subregion which restricts calculation and rendering of the given filter primitive. See <a
	 * href="filters.html#FilterPrimitiveSubRegion">filter primitive subregion</a>.
	 * 
	 * @return
	 */
	public native final double y() /*-{
		return this.y;
	}-*/;

	/**
	 * The minimum y coordinate for the subregion which restricts calculation and rendering of the given filter primitive
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final FilterOperationParam y(double val) /*-{
		this.y = val;
		return this;
	}-*/;

	/**
	 * The width of the subregion which restricts calculation and rendering of the given filter primitive. See <a href="filters.html#FilterPrimitiveSubRegion">filter primitive
	 * subregion</a>. A negative value is an error (see Error processing). A value of zero disables the effect of the given filter primitive (i.e., the result is a transparent
	 * black image).
	 * 
	 * @return
	 */
	public native final double width() /*-{
		return this.width;
	}-*/;

	/**
	 * The width of the subregion which restricts calculation and rendering of the given filter primitive. See <a href="filters.html#FilterPrimitiveSubRegion">filter primitive
	 * subregion</a>. A negative value is an error (see Error processing). A value of zero disables the effect of the given filter primitive (i.e., the result is a transparent
	 * black image).
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final FilterOperationParam width(double val) /*-{
		this.width = val;
		return this;
	}-*/;

	/**
	 * <p>
	 * The height of the subregion which restricts calculation and rendering of the given filter primitive. See <a href="filters.html#FilterPrimitiveSubRegion">filter primitive
	 * subregion</a>.
	 * </p>
	 * <p>
	 * A negative value is an error (see Error processing). A value of zero disables the effect of the given filter primitive (i.e., the result is a transparent black image).
	 * </p>
	 * 
	 * @return
	 */
	public native final double height() /*-{
		return this.height;
	}-*/;

	/**
	 * <p>
	 * The height of the subregion which restricts calculation and rendering of the given filter primitive. See <a href="filters.html#FilterPrimitiveSubRegion">filter primitive
	 * subregion</a>.
	 * </p>
	 * <p>
	 * A negative value is an error (see Error processing). A value of zero disables the effect of the given filter primitive (i.e., the result is a transparent black image).
	 * </p>
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final FilterOperationParam height(double val) /*-{
		this.height = val;
		return this;
	}-*/;

	/**
	 * <p>
	 * result = "<filter-primitive-reference>"
	 * </p>
	 * 
	 * <p>
	 * Assigned name for this filter primitive. If supplied, then graphics that result from processing this filter primitive can be referenced by an ‘in’ attribute on a subsequent
	 * filter primitive within the same ‘filter’ element. If no value is provided, the output will only be available for re-use as the implicit input into the next filter primitive
	 * if that filter primitive provides no value for its ‘in’ attribute.
	 * </p>
	 * 
	 * <p>
	 * Note that a <filter-primitive-reference> is not an XML ID; instead, a <filter-primitive-reference> is only meaningful within a given ‘filter’ element and thus have only
	 * local scope. It is legal for the same <filter-primitive-reference> to appear multiple times within the same ‘filter’ element. When referenced, the
	 * <filter-primitive-reference> will use the closest preceding filter primitive with the given result.
	 * </p>
	 * 
	 * @return
	 */
	public native final String result() /*-{
		return this.result;
	}-*/;

	/**
	 * <p>
	 * result = "<filter-primitive-reference>"
	 * </p>
	 * 
	 * <p>
	 * Assigned name for this filter primitive. If supplied, then graphics that result from processing this filter primitive can be referenced by an ‘in’ attribute on a subsequent
	 * filter primitive within the same ‘filter’ element. If no value is provided, the output will only be available for re-use as the implicit input into the next filter primitive
	 * if that filter primitive provides no value for its ‘in’ attribute.
	 * </p>
	 * 
	 * <p>
	 * Note that a <filter-primitive-reference> is not an XML ID; instead, a <filter-primitive-reference> is only meaningful within a given ‘filter’ element and thus have only
	 * local scope. It is legal for the same <filter-primitive-reference> to appear multiple times within the same ‘filter’ element. When referenced, the
	 * <filter-primitive-reference> will use the closest preceding filter primitive with the given result.
	 * </p>
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final FilterOperationParam result(String val) /*-{
		this.result = val;
		return this;
	}-*/;

	public native final String getFilterName()/*-{
		return this._filterName || null;
	}-*/;

	/**
	 * <span>in</span> = "<em><a>SourceGraphic</a> | <a>SourceAlpha</a> | <a>BackgroundImage</a> | <a>BackgroundAlpha</a> | <a>FillPaint</a> | <a>StrokePaint</a> |
<filter-primitive-reference></em>"
	 * <dl>
	 * <dd>Identifies input for the given filter primitive. The value can be either one of six keywords or can be a string which matches a previous <a><span>‘result’</span></a>
	 * attribute value within the same <a><span>‘filter’</span></a> element. If no value is provided and this is the first filter primitive, then this filter primitive will use
	 * <a><span>SourceGraphic</span></a> as its input. If no value is provided and this is a subsequent filter primitive, then this filter primitive will use the result from the
	 * previous filter primitive as its input.
	 * 
	 * <p>
	 * If the value for <a><span>‘result’</span></a> appears multiple times within a given <a><span>‘filter’</span></a> element, then a reference to that result will use the
	 * closest preceding filter primitive with the given value for attribute <a><span>‘result’</span></a>. Forward references to results are <a>an error</a>.
	 * </p>
	 * 
	 * <p>
	 * Definitions for the six keywords:
	 * </p>
	 * 
	 * </dd>
	 * </dl>
	 * 
	 * <dl>
	 * <dt><span>SourceGraphic</span></dt>
	 * <dd>This keyword represents the <a>graphics elements</a> that were the original input into the <a><span>‘filter’</span></a> element. For raster effects filter primitives,
	 * the <a>graphics elements</a> will be rasterized into an initially clear RGBA raster in image space. Pixels left untouched by the original graphic will be left clear. The
	 * image is specified to be rendered in linear RGBA pixels. The alpha channel of this image captures any anti-aliasing specified by SVG. (Since the raster is linear, the alpha
	 * channel of this image will represent the exact percent coverage of each pixel.)</dd>
	 * <dt><span>SourceAlpha</span></dt>
	 * <dd>This keyword represents the <a>graphics elements</a> that were the original input into the <a><span>‘filter’</span></a> element. <span>SourceAlpha</span> has all of the
	 * same rules as <a><span>SourceGraphic</span></a> except that only the alpha channel is used. The input image is an RGBA image consisting of implicitly black color values for
	 * the RGB channels, but whose alpha channel is the same as <a><span>SourceGraphic</span></a>. If this option is used, then some implementations might need to rasterize the
	 * <a>graphics elements</a> in order to extract the alpha channel.</dd>
	 * <dt><span>BackgroundImage</span></dt>
	 * <dd>This keyword represents an image snapshot of the canvas under the <a><span>filter region</span></a> at the time that the <a><span>‘filter’</span></a> element was
	 * invoked. See <a>Accessing the background image</a>.</dd>
	 * 
	 * <dt><span>BackgroundAlpha</span></dt>
	 * <dd>Same as <a>BackgroundImage</a> except only the alpha channel is used. See <a><span>SourceAlpha</span></a> and <a>Accessing the background image</a>.</dd>
	 * <dt><span>FillPaint</span></dt>
	 * <dd>This keyword represents the value of the <a><span>‘fill’</span></a> property on the target element for the filter effect. The FillPaint image has conceptually infinite
	 * extent. Frequently this image is opaque everywhere, but it might not be if the "paint" itself has alpha, as in the case of a gradient or pattern which itself includes
	 * transparent or semi-transparent parts.</dd>
	 * 
	 * <dt><span>StrokePaint</span></dt>
	 * <dd>This keyword represents the value of the <a><span>‘stroke’</span></a> property on the target element for the filter effect. The StrokePaint image has conceptually
	 * infinite extent. Frequently this image is opaque everywhere, but it might not be if the "paint" itself has alpha, as in the case of a gradient or pattern which itself
	 * includes transparent or semi-transparent parts.</dd>
	 * </dl>
	 * 
	 * <p>
	 * The <a><span>‘in’</span></a> attribute is available on all filter primitive elements that require an input.
	 * </p>
	 * 
	 * @return
	 */
	public native final String in() /*-{
		return this["in"]; 
	}-*/;

	/**
	 * <span>in</span> = "<em><a>SourceGraphic</a> | <a>SourceAlpha</a> | <a>BackgroundImage</a> | <a>BackgroundAlpha</a> | <a>FillPaint</a> | <a>StrokePaint</a> |
<filter-primitive-reference></em>"
	 * <dl>
	 * <dd>Identifies input for the given filter primitive. The value can be either one of six keywords or can be a string which matches a previous <a><span>‘result’</span></a>
	 * attribute value within the same <a><span>‘filter’</span></a> element. If no value is provided and this is the first filter primitive, then this filter primitive will use
	 * <a><span>SourceGraphic</span></a> as its input. If no value is provided and this is a subsequent filter primitive, then this filter primitive will use the result from the
	 * previous filter primitive as its input.
	 * 
	 * <p>
	 * If the value for <a><span>‘result’</span></a> appears multiple times within a given <a><span>‘filter’</span></a> element, then a reference to that result will use the
	 * closest preceding filter primitive with the given value for attribute <a><span>‘result’</span></a>. Forward references to results are <a>an error</a>.
	 * </p>
	 * 
	 * <p>
	 * Definitions for the six keywords:
	 * </p>
	 * 
	 * </dd>
	 * </dl>
	 * 
	 * <dl>
	 * <dt><span>SourceGraphic</span></dt>
	 * <dd>This keyword represents the <a>graphics elements</a> that were the original input into the <a><span>‘filter’</span></a> element. For raster effects filter primitives,
	 * the <a>graphics elements</a> will be rasterized into an initially clear RGBA raster in image space. Pixels left untouched by the original graphic will be left clear. The
	 * image is specified to be rendered in linear RGBA pixels. The alpha channel of this image captures any anti-aliasing specified by SVG. (Since the raster is linear, the alpha
	 * channel of this image will represent the exact percent coverage of each pixel.)</dd>
	 * <dt><span>SourceAlpha</span></dt>
	 * <dd>This keyword represents the <a>graphics elements</a> that were the original input into the <a><span>‘filter’</span></a> element. <span>SourceAlpha</span> has all of the
	 * same rules as <a><span>SourceGraphic</span></a> except that only the alpha channel is used. The input image is an RGBA image consisting of implicitly black color values for
	 * the RGB channels, but whose alpha channel is the same as <a><span>SourceGraphic</span></a>. If this option is used, then some implementations might need to rasterize the
	 * <a>graphics elements</a> in order to extract the alpha channel.</dd>
	 * <dt><span>BackgroundImage</span></dt>
	 * <dd>This keyword represents an image snapshot of the canvas under the <a><span>filter region</span></a> at the time that the <a><span>‘filter’</span></a> element was
	 * invoked. See <a>Accessing the background image</a>.</dd>
	 * 
	 * <dt><span>BackgroundAlpha</span></dt>
	 * <dd>Same as <a>BackgroundImage</a> except only the alpha channel is used. See <a><span>SourceAlpha</span></a> and <a>Accessing the background image</a>.</dd>
	 * <dt><span>FillPaint</span></dt>
	 * <dd>This keyword represents the value of the <a><span>‘fill’</span></a> property on the target element for the filter effect. The FillPaint image has conceptually infinite
	 * extent. Frequently this image is opaque everywhere, but it might not be if the "paint" itself has alpha, as in the case of a gradient or pattern which itself includes
	 * transparent or semi-transparent parts.</dd>
	 * 
	 * <dt><span>StrokePaint</span></dt>
	 * <dd>This keyword represents the value of the <a><span>‘stroke’</span></a> property on the target element for the filter effect. The StrokePaint image has conceptually
	 * infinite extent. Frequently this image is opaque everywhere, but it might not be if the "paint" itself has alpha, as in the case of a gradient or pattern which itself
	 * includes transparent or semi-transparent parts.</dd>
	 * </dl>
	 * 
	 * <p>
	 * The <a><span>‘in’</span></a> attribute is available on all filter primitive elements that require an input.
	 * </p>
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final FilterOperationParam in(String val) /*-{
		this["in"] = val; 
		return this; 
	}-*/;
}
