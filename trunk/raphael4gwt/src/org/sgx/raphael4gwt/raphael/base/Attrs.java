package org.sgx.raphael4gwt.raphael.base;
import org.sgx.raphael4gwt.raphael.pathobj.PathObject;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.resources.client.ImageResource;

/**
 * I am a native raphaeljs attrs object. Please instantiate me using Raphael.attrs(), 
 * or cast an empty object <pre>JsUtil.empty()</pre><br/>
 * 
 * It is incorrect to do this 
 * <pre>shape1.attr().fill("red").stroke("brown");</pre> because fill("red") will affect the plain js object attr, and not raphael element. 
 * you should do something lile this: 
 * <pre>
 * shape1.attr(Attrs.create().fill("red").stroke("brown"));
 * </pre>.<br/>
 * 
 * 
 * Please refer to the <a href="http://www.w3.org/TR/SVG/" title="The W3C Recommendation for the SVG language describes these properties in detail.">SVG specification</a> for an explanation of these parameters.</p><ol class="dr-json"><li><span class="dr-json-key">arrow-end</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">arrowhead on the end of the path. The format for string is <code>&lt;type&gt;[-&lt;width&gt;[-&lt;length&gt;]]</code>. Possible types: <code>classic</code>, <code>block</code>, <code>open</code>, <code>oval</code>, <code>diamond</code>, <code>none</code>, width: <code>wide</code>, <code>narrow</code>, <code>midium</code>, length: <code>long</code>, <code>short</code>, <code>midium</code>.</span></li><li><span class="dr-json-key">clip-rect</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">comma or space separated values: x, y, width and height</span></li><li><span class="dr-json-key">cursor</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">CSS type of the cursor</span></li><li><span class="dr-json-key">cx</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">the x-axis coordinate of the center of the circle, or ellipse</span></li><li><span class="dr-json-key">cy</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">the y-axis coordinate of the center of the circle, or ellipse</span></li><li><span class="dr-json-key">fill</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">colour, gradient or image</span></li><li><span class="dr-json-key">fill-opacity</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">font</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">font-family</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">font-size</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">font size in pixels</span></li><li><span class="dr-json-key">font-weight</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">height</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">href</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">URL, if specified element behaves as hyperlink</span></li><li><span class="dr-json-key">opacity</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">path</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">SVG path string format</span></li><li><span class="dr-json-key">r</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">radius of the circle, ellipse or rounded corner on the rect</span></li><li><span class="dr-json-key">rx</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">horisontal radius of the ellipse</span></li><li><span class="dr-json-key">ry</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">vertical radius of the ellipse</span></li><li><span class="dr-json-key">src</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">image URL, only works for <a href="#Element.image" class="dr-link">Element.image</a> element</span></li><li><span class="dr-json-key">stroke</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">stroke colour</span></li><li><span class="dr-json-key">stroke-dasharray</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">["", "<code>-</code>", "<code>.</code>", "<code>-.</code>", "<code>-..</code>", "<code>. </code>", "<code>- </code>", "<code>--</code>", "<code>- .</code>", "<code>--.</code>", "<code>--..</code>"]</span></li><li><span class="dr-json-key">stroke-linecap</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">["<code>butt</code>", "<code>square</code>", "<code>round</code>"]</span></li><li><span class="dr-json-key">stroke-linejoin</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">["<code>bevel</code>", "<code>round</code>", "<code>miter</code>"]</span></li><li><span class="dr-json-key">stroke-miterlimit</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">stroke-opacity</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">stroke-width</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">stroke width in pixels, default is '1'</span></li><li><span class="dr-json-key">target</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">used with href</span></li><li><span class="dr-json-key">text</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">contents of the text element. Use <code>\n</code> for multiline text</span></li><li><span class="dr-json-key">text-anchor</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">["<code>start</code>", "<code>middle</code>", "<code>end</code>"], default is "<code>middle</code>"</span></li><li><span class="dr-json-key">title</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">will create tooltip with a given text</span></li><li><span class="dr-json-key">transform</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">see <a href="#Element.transform" class="dr-link">Element.transform</a></span></li><li><span class="dr-json-key">width</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">x</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">y</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">&nbsp;</span></li></ol><p class="header">Gradients
</p><p>Linear gradient format: "<code>‹angle›-‹colour›[-‹colour›[:‹offset›]]*-‹colour›</code>", example: "<code>90-#fff-#000</code>" – 90°
gradient from white to black or "<code>0-#fff-#f00:20-#000</code>" – 0° gradient from white via red (at 20%) to black.

</p><p>radial gradient: "<code>r[(‹fx›, ‹fy›)]‹colour›[-‹colour›[:‹offset›]]*-‹colour›</code>", example: "<code>r#fff-#000</code>" –
gradient from white to black or "<code>r(0.25, 0.75)#fff-#000</code>" – gradient from white to black with focus point
at 0.25, 0.75. Focus point coordinates are in 0..1 range. Radial gradients can only be applied to circles and ellipses.
</p><p class="header">Path String
</p><p>Please refer to <a href="http://www.w3.org/TR/SVG/paths.html#PathData" title="Details of a path’s params attribute’s format are described in the SVG specification.">SVG documentation regarding path string</a>. Raphaël fully supports it.</p><p class="header">Colour Parsing
</p><ul><li>Colour name ("<code>red</code>", "<code>green</code>", "<code>cornflowerblue</code>", etc)</li><li>#••• — shortened HTML colour: ("<code>#000</code>", "<code>#fc0</code>", etc)</li><li>#•••••• — full length HTML colour: ("<code>#000000</code>", "<code>#bd2300</code>")</li><li>rgb(•••, •••, •••) — red, green and blue channels’ values: ("<code>rgb(200,&nbsp;100,&nbsp;0)</code>")</li><li>rgb(•••%, •••%, •••%) — same as above, but in %: ("<code>rgb(100%,&nbsp;175%,&nbsp;0%)</code>")</li><li>rgba(•••, •••, •••, •••) — red, green and blue channels’ values: ("<code>rgba(200,&nbsp;100,&nbsp;0, .5)</code>")</li><li>rgba(•••%, •••%, •••%, •••%) — same as above, but in %: ("<code>rgba(100%,&nbsp;175%,&nbsp;0%, 50%)</code>")</li><li>hsb(•••, •••, •••) — hue, saturation and brightness values: ("<code>hsb(0.5,&nbsp;0.25,&nbsp;1)</code>")</li><li>hsb(•••%, •••%, •••%) — same as above, but in %</li><li>hsba(•••, •••, •••, •••) — same as above, but with opacity</li><li>hsl(•••, •••, •••) — almost the same as hsb, see <a href="http://en.wikipedia.org/wiki/HSL_and_HSV" title="HSL and HSV - Wikipedia, the free encyclopedia">Wikipedia page</a></li><li>hsl(•••%, •••%, •••%) — same as above, but in %</li><li>hsla(•••, •••, •••, •••) — same as above, but with opacity</li><li>Optionally for hsb and hsl you could specify hue as a degree: "<code>hsl(240deg,&nbsp;1,&nbsp;.5)</code>" or, if you want to go fancy, "<code>hsl(240°,&nbsp;1,&nbsp;.5)</code>"</li>
 * 
 * @author sg
 *
 */
public class Attrs extends JavaScriptObject {
		
	//attrs names constants
	public static final String 
		ARROW_END="arrow-end", 
		CLIP_RECT="clip-rect",
		CURSOR="cursor",
		CX="cx",CY="cy",
		FILL="fill",
		FILL_OPACITY="fill-opacity",
		FONT="font", 
		FONT_FAMILY="font-family", 
		FONT_SIZE="font-size", 
		FONT_WEIGHT="font-weight",
		HEIGHT="height", 
		HREF="href", 
		OPACITY="opacity",
		PATH="path",
		R="r",
		RX="rx",
		RY="ry",
		STROKE="stroke",
		STROKE_DASHARRAY="stroke-dasharray",
		STROKE_LINECAP="stroke-linecap",
		STROKE_MITERLIMIT="stroke-miterlimit",
		STROKE_OPACITY="stroke-opacity",
		STROKE_WIDTH="stroke-width",
		TEXT="text",
		TEXT_ANCHOR="text-anchor",
		TITLE="title",
		TRANSFORM="transform",
		WIDTH="width",
		X="x",
		Y="y"
		;
	
	
	public static final native Attrs create()/*-{
		return {};
	}-*/;
 
	protected Attrs(){}	
	
	
	public final native String get(String attr)/*-{
		return this[attr];
	}-*/;
	
	public final native Attrs set(String attr, Object val)/*-{
		this[attr]=val;
		return this;
	}-*/;
	
	
	
	/* *** FILL *** */
	
	public final native String getFill()/*-{
		return this["fill"];
	}-*/;
	public final native void setFill(String val)/*-{
		this["fill"]=val;
	}-*/;
	public final native Attrs fill(String val)/*-{
		this["fill"]=val;
		return this;
	}-*/;
	/**
	 * @see org.sgx.raphael4gwt.raphael.Paper.image(ImageResource, int, int, int, int)
	 * @param img an imageresource annotated with @ImageOptions(preventInlining=true)
	 * @return
	 */
	public final native Attrs fill(ImageResource img)/*-{
		var url = @org.sgx.raphael4gwt.raphael.Paper::getImageResourceUrl(Lcom/google/gwt/resources/client/ImageResource;)(img);	
		this["fill"]="url("+url+")";
		//$wnd.alert(url);
		return this;
	}-*/;

	public final native Attrs fill(Gradient g)/*-{
		this["fill"]=g.@org.sgx.raphael4gwt.raphael.base.Gradient::toString()();
		return this;
	}-*/;

	/**
	 * the y-ayis coordinate of the center of the circle, or ellipse
	 * @return
	 */
	public final native double getFillOpacity()/*-{
		return this["fill-opacity"];
	}-*/;
	/**
	 * the y-ayis coordinate of the center of the circle, or ellipse
	 * @param val
	 */
	public final native void setFillOpacity(double val)/*-{
		this["fill-opacity"]=val;
	}-*/;
	/**
	 * the y-ayis coordinate of the center of the circle, or ellipse
	 * @param val
	 * @return
	 */
	public final native Attrs fillOpacity(double val)/*-{
		this["fill-opacity"]=val;
		return this;
	}-*/;
	
	
	
	
	/* *** STROKE *** */
	
	
	public final native String getStroke()/*-{
		return this["stroke"];
	}-*/;
	public final native void setStroke(String val)/*-{
		this["stroke"]=val;
	}-*/;
	public final native Attrs stroke(String val)/*-{
		this["stroke"]=val;
		return this;
	}-*/;
	/**
	 * stroke width in pixels, default is '1'
	 * @return
	 */
	public final native int getStrokeWidth()/*-{
		return this["stroke-width"];
	}-*/;
	/**
	 * stroke width in pixels, default is '1'
	 * @param val
	 */
	public final native void setStrokeWidth(int val)/*-{
		this["stroke-width"]=val;
	}-*/;
	/**
	 * stroke width in pixels, default is '1'
	 * @param val
	 * @return
	 */
	public final native Attrs strokeWidth(int val)/*-{
		this["stroke-width"]=val;
		return this;
	}-*/;
	/**
	 * stroke width in pixels, default is '1'
	 * @param val
	 * @return
	 */
	public final native Attrs strokeWidth(double val)/*-{
		this["stroke-width"]=val;
		return this;
	}-*/;
	/**
	 * @return One of the following strings: "", "-", ".", "-.", "-..", ". ", "- ", "--", "- .", "--.", "--.."
	 */
	public final native String getStrokeDashArray()/*-{
		return this["stroke-dasharray"];
	}-*/;
	/**
	 * @param val One of the following strings: "", "-", ".", "-.", "-..", ". ", "- ", "--", "- .", "--.", "--.."
	 * @return
	 */
	public final native void setStrokeDashArray(String val)/*-{
		this["stroke-dasharray"]=val;
	}-*/;
	/**
	 * @param val One of the following strings: "", "-", ".", "-.", "-..", ". ", "- ", "--", "- .", "--.", "--.."
	 * @return
	 */
	public final native Attrs strokeDashArray(String val)/*-{
		this["stroke-dasharray"]=val;
		return this;
	}-*/;
	
	/**
	 * "butt", "square", "round"
	 * @return
	 */
	public final native String getStrokeLinecap()/*-{
		return this["stroke-linecap"];
	}-*/;
	/**
	 * 
	 * @param val "butt", "square", "round"
	 */
	public final native void setStrokeLinecap(String val)/*-{
		this["stroke-linecap"]=val;
	}-*/;
	/**
	 * 
	 * @param val"butt", "square", "round"
	 * @return
	 */
	public final native Attrs strokeLinecap(String val)/*-{
		this["stroke-linecap"]=val;
		return this;
	}-*/;
	
	
	public final native int getStrokeMiterLimit()/*-{
		return this["stroke-miterlimit"];
	}-*/;
	public final native void setStrokeMiterLimit(int val)/*-{
		this["stroke-miterlimit"]=val;
	}-*/;
	public final native Attrs strokeMiterLimit(int val)/*-{
		this["stroke-miterlimit"]=val;
		return this;
	}-*/;
	public final native double getStrokeOpacity()/*-{
		return this["stroke-opacity"];
	}-*/;
	public final native void setStrokeOpacity(double val)/*-{
		this["stroke-opacity"]=val;
	}-*/;
	public final native Attrs strokeOpacity(double val)/*-{
		this["stroke-opacity"]=val;
		return this;
	}-*/;

	
	
	
	public final native String getTransform()/*-{
		return this["transform"];
	}-*/;
	public final native void setTransform(String val)/*-{
		this["transform"]=val;
	}-*/;
	public final native Attrs transform(String val)/*-{
		this["transform"]=val;
		return this;
	}-*/;
	
	
	
	
	
	//arrowhead on the end of the path. The format for string is <type>[-<width>[-<length>]]. Possible types: classic, block, open, oval, diamond, none, width: wide, narrow, midium, length: long, short, midium.
	/**arrowhead on the end of the path.<br/>
	 * you can use the base.Arrow class to easily define them, like
	 * <pre>attr.arrowEnd(Arrow.build(Arrow.TYPE_CLASSIC, Arrow.WIDTH_SHORT, ARROW.LENGTH_MIDIUM));</pre>
	 * or you can build an string yourself follwoing:<br/>
	 * . The format for string is <type>[-<width>[-<length>]]. Possible types: classic, block, open, oval, diamond, none, width: wide, narrow, midium, length: long, short, midium.
	 */
	public final native String getArrowEnd()/*-{
		return this["arrow-end"];
	}-*/;
	/**arrowhead on the end of the path.<br/>
	 * you can use the base.Arrow class to easily define them, like
	 * <pre>attr.arrowEnd(Arrow.build(Arrow.TYPE_CLASSIC, Arrow.WIDTH_SHORT, ARROW.LENGTH_MIDIUM));</pre>
	 * or you can build an string yourself follwoing:<br/>
	 * . The format for string is <type>[-<width>[-<length>]]. Possible types: classic, block, open, oval, diamond, none, width: wide, narrow, midium, length: long, short, midium.
	 */
	public final native void setArrowEnd(String val)/*-{
		this["arrow-end"]=val;
	}-*/;
	
	/**arrowhead on the end of the path.<br/>
	 * you can use the base.Arrow class to easily define them, like
	 * <pre>attr.arrowEnd(Arrow.build(Arrow.TYPE_CLASSIC, Arrow.WIDTH_SHORT, ARROW.LENGTH_MIDIUM));</pre>
	 * or you can build an string yourself follwoing:<br/>
	 * . The format for string is <type>[-<width>[-<length>]]. Possible types: classic, block, open, oval, diamond, none, width: wide, narrow, midium, length: long, short, midium.
	 */
	public final native Attrs setArrowEnd(Arrow a)/*-{		
		this["arrow-end"]=a.@org.sgx.raphael4gwt.raphael.base.Arrow::toString()();;
		return this;
	}-*/;
	
	
	/**arrowhead on the end of the path.<br/>
	 * you can use the base.Arrow class to easily define them, like
	 * <pre>attr.arrowEnd(Arrow.build(Arrow.TYPE_CLASSIC, Arrow.WIDTH_SHORT, ARROW.LENGTH_MIDIUM));</pre>
	 * or you can build an string yourself follwoing:<br/>
	 * . The format for string is <type>[-<width>[-<length>]]. Possible types: classic, block, open, oval, diamond, none, width: wide, narrow, midium, length: long, short, midium.
	 */
	public final native Attrs arrowEnd(String val)/*-{
		this["arrow-end"]=val;
		return this;
	}-*/;
	/**arrowhead on the end of the path.<br/>
	 * you can use the base.Arrow class to easily define them, like
	 * <pre>attr.arrowEnd(Arrow.build(Arrow.TYPE_CLASSIC, Arrow.WIDTH_SHORT, ARROW.LENGTH_MIDIUM));</pre>
	 * or you can build an string yourself follwoing:<br/>
	 * . The format for string is <type>[-<width>[-<length>]]. Possible types: classic, block, open, oval, diamond, none, width: wide, narrow, midium, length: long, short, midium.
	 */
	public final native Attrs arrowEnd(Arrow a)/*-{		
		this["arrow-end"]=a.@org.sgx.raphael4gwt.raphael.base.Arrow::toString()();;
		return this;
	}-*/;
	
	
	/**
	 * comma or space separated values: x, y, width and height
	 * @return
	 */
	public final native String getClipRect()/*-{
		return this["clip-rect"];
	}-*/;
	/**
	 * comma or space separated values: x, y, width and height
	 * @param val
	 */
	public final native void setClipRect(String val)/*-{
		this["clip-rect"]=val;
	}-*/;
	/**
	 * comma or space separated values: x, y, width and height
	 * @param val
	 * @return
	 */
	public final native Attrs clipRect(String val)/*-{
		this["clip-rect"]=val;
		return this;
	}-*/;

	/**
	 * CSS type of the cursor
	 * @return
	 */
	public final native String getCursor()/*-{
		return this["cursor"];
	}-*/;
	/**
	 * CSS type of the cursor
	 * @param val
	 */
	public final native void setCursor(String val)/*-{
		this["cursor"]=val;
	}-*/;
	/**
	 * CSS type of the cursor
	 * @param val
	 * @return
	 */
	public final native Attrs cursor(String val)/*-{
		this["cursor"]=val;
		return this;
	}-*/;

	/**
	 * the x-axis coordinate of the center of the circle, or ellipse
	 * @return
	 */
	public final native int getCx()/*-{
		return this["cx"];
	}-*/;
	/**
	 * the x-axis coordinate of the center of the circle, or ellipse
	 * @param val
	 */
	public final native void setCx(int val)/*-{
		this["cx"]=val;
	}-*/;
	/**
	 * the x-axis coordinate of the center of the circle, or ellipse
	 * @param val
	 * @return
	 */
	public final native Attrs cx(int val)/*-{
		this["cx"]=val;
		return this;
	}-*/;
	/**
	 * the x-axis coordinate of the center of the circle, or ellipse
	 * @param val
	 * @return
	 */
	public final native Attrs cx(double val)/*-{
		this["cx"]=val;
		return this;
	}-*/;
	/**
	 * the y-ayis coordinate of the center of the circle, or ellipse
	 * @return
	 */
	public final native int getCy()/*-{
		return this["cy"];
	}-*/;
	/**
	 * the y-ayis coordinate of the center of the circle, or ellipse
	 * @param val
	 */
	public final native void setCy(int val)/*-{
		this["cy"]=val;
	}-*/;
	/**
	 * the y-ayis coordinate of the center of the circle, or ellipse
	 * @param val
	 * @return
	 */
	public final native Attrs cy(int val)/*-{
		this["cy"]=val;
		return this;
	}-*/;
	/**
	 * the y-ayis coordinate of the center of the circle, or ellipse
	 * @param val
	 * @return
	 */
	public final native Attrs cy(double val)/*-{
		this["cy"]=val;
		return this;
	}-*/;
	
	public final native int getWidth()/*-{
		return this["width"];
	}-*/;
	public final native void setWidth(int val)/*-{
		this["width"]=val;
	}-*/;
	public final native Attrs width(int val)/*-{
		this["width"]=val;
		return this;
	}-*/;
	public final native Attrs width(double val)/*-{
		this["width"]=val;
		return this;
	}-*/;

	public final native int getHeight()/*-{
		return this["height"];
	}-*/;
	public final native void setHeight(int val)/*-{
		this["height"]=val;
	}-*/;
	public final native Attrs height(int val)/*-{
		this["height"]=val;
		return this;
	}-*/;
	public final native Attrs height(double val)/*-{
		this["height"]=val;
		return this;
	}-*/;
	
	
	public final native int getX()/*-{
		return this["x"];
	}-*/;
	public final native void setX(int val)/*-{
		this["x"]=val;
	}-*/;
	public final native Attrs x(int val)/*-{
		this["x"]=val;
		return this;
	}-*/;
	public final native Attrs x(double val)/*-{
		this["x"]=val;
		return this;
	}-*/;
	public final native int getY()/*-{
		return this["y"];
	}-*/;
	public final native void setY(int val)/*-{
		this["y"]=val;
	}-*/;
	public final native Attrs y(int val)/*-{
		this["y"]=val;
		return this;
	}-*/;
	public final native Attrs y(double val)/*-{
		this["y"]=val;
		return this;
	}-*/;
	
	/* *** TEXT *** */
	
	public final native String getFontFamily()/*-{
		return this["font-family"];
	}-*/;
	public final native void setFontFamily(String val)/*-{
		this["font-family"]=val;
	}-*/;
	public final native Attrs fontFamily(String val)/*-{
		this["font-family"]=val;
		return this;
	}-*/;
	public final native String getFontWeight()/*-{
		return this["font-weight"];
	}-*/;
	public final native void setFontWeight(String val)/*-{
		this["font-weight"]=val;
	}-*/;
	public final native Attrs fontWeight(String val)/*-{
		this["font-weight"]=val;
		return this;
	}-*/;
	public final native Attrs fontWeight(double val)/*-{
		this["font-weight"]=val;
		return this;
	}-*/;
	public final native int getFontSize()/*-{
		return this["font-size"];
	}-*/;
	public final native void setFontSize(int val)/*-{
		this["font-size"]=val;
	}-*/;
	public final native Attrs fontSize(int val)/*-{
		this["font-size"]=val;
		return this;
	}-*/;
	public final native Attrs fontSize(double val)/*-{
		this["font-size"]=val;
		return this;
	}-*/;
	public final native String getFont()/*-{
		return this["font"];
	}-*/;
	public final native void setFont(String val)/*-{
		this["font"]=val;
	}-*/;
	public final native Attrs font(String val)/*-{
		this["font"]=val;
		return this;
	}-*/;
	/**
	 * CSS font style - accept some of the following values normal, italic, oblique. some of the Raphael.FONT_STYLE_* properties
	 */
	public final native String getFontStyle()/*-{
		return this["fontStyle"];
	}-*/;
	/**
	 * CSS font style - accept some of the following values normal, italic, oblique. some of the Raphael.FONT_STYLE_* properties
	 */
	public final native void setFontStyle(String val)/*-{
		this["fontStyle"]=val;
	}-*/;
	/**
	 * CSS font style - accept some of the following values normal, italic, oblique. some of the Raphael.FONT_STYLE_* properties
	 */
	public final native Attrs fontStyle(String val)/*-{
		this["fontStyle"]=val;
		return this;
	}-*/;
	
	
	/**
	 * contents of the text element. Use \n for multiline text
	 * @return
	 */
	public final native String getText()/*-{
		return this["text"];
	}-*/;
	/**
	 * contents of the text element. Use \n for multiline text
	 * @param val
	 */
	public final native void setText(String val)/*-{
		this["text"]=val;
	}-*/;
	/**
	 * contents of the text element. Use \n for multiline text
	 * @param val
	 * @return
	 */
	public final native Attrs text(String val)/*-{
		this["text"]=val;
		return this;
	}-*/;
	/**
	 * ["start", "middle", "end"], default is "middle"
	 * @return
	 */
	public final native String getTextAnchor()/*-{
		return this["text-anchor"];
	}-*/;
	/**
	 * ["start", "middle", "end"], default is "middle"
	 * @param val
	 */
	public final native void setTextAnchor(String val)/*-{
		this["text-anchor"]=val;
	}-*/;
	/**
	 * ["start", "middle", "end"], default is "middle"
	 * @param val
	 * @return
	 */
	public final native Attrs textAnchor(String val)/*-{
		this["text-anchor"]=val;
		return this;
	}-*/;
	/**
	 * will create tooltip with a given text
	 * @return
	 */
	public final native String getTitle()/*-{
		return this["title"];
	}-*/;
	/**
	 * will create tooltip with a given text
	 * @param val
	 */
	public final native void setTitle(String val)/*-{
		this["title"]=val;
	}-*/;
	/**
	 * 
	 * @param val
	 * @return
	 */
	public final native Attrs title(String val)/*-{
		this["title"]=val;
		return this;
	}-*/;
	
	
	
	
	/**
	 * URL, if specified element behaves as hyperlink
	 * @return
	 */
	public final native String getHRef()/*-{
		return this["href"];
	}-*/;
	/**
	 * URL, if specified element behaves as hyperlink
	 * @param val
	 */
	public final native void setHRef(String val)/*-{
		this["href"]=val;
	}-*/;
	/**
	 * URL, if specified element behaves as hyperlink
	 * @param val
	 * @return
	 */
	public final native Attrs href(String val)/*-{
		this["href"]=val;
		return this;
	}-*/;
	
	public final native double getOpacity()/*-{
		return this["opacity"];
	}-*/;
	public final native void setOpacity(double val)/*-{
		this["opacity"]=val;
	}-*/;
	public final native Attrs opacity(double val)/*-{
		this["opacity"]=val;
		return this;
	}-*/;
	
	public final native String getPath()/*-{
		return this["path"]+"";
	}-*/;
	public final native void setPath(String val)/*-{
		this["path"]=val;
	}-*/;
	public final native void setPath(PathObject val)/*-{
		this["path"]=val;
	}-*/;
	public final native Attrs path(String val)/*-{
		this["path"]=val;
		return this;
	}-*/;
	public final native Attrs path(PathObject val)/*-{
		this["path"]=val;
		return this;
	}-*/;
	
	public final native int getRadius()/*-{
		return this["r"];
	}-*/;
	public final native void setRadius(int val)/*-{
		this["r"]=val;
	}-*/;
	public final native Attrs r(int val)/*-{
		this["r"]=val;
		return this;
	}-*/;

	public final native Attrs r(double val)/*-{
		this["r"]=val;
		return this;
	}-*/;
	public final native int getRadiusX()/*-{
		return this["rx"];
	}-*/;
	public final native void setRadiusX(int val)/*-{
		this["rx"]=val;
	}-*/;
	public final native Attrs rx(int val)/*-{
		this["rx"]=val;
		return this;
	}-*/;
	public final native int getRadiusY()/*-{
		return this["ry"];
	}-*/;
	public final native void setRadiusY(int val)/*-{
		this["ry"]=val;
	}-*/;
	public final native Attrs ry(int val)/*-{
		this["ry"]=val;
		return this;
	}-*/;
	
	
	//API extensions
	public final native String print()/*-{		
		return "Attrs"+$wnd.r4g.dump(this ,true)+"";
	}-*/;
	/**
	 * artificially added only for load and save() work with JSArray<Attrs>. 
	 * Has no meaning in other usage scenarios
	 */
	public final native String getType()/*-{
		return this.type ? this.type : "";
	}-*/;
	/**
	 * artificially added only for load and save() work with JSArray<Attrs>. 
	 * Has no meaning in other usage scenarios
	 */
	public final native String type()/*-{
		return this.type ? this.type : "";
	}-*/;
	/**
	 * artificially added only for load and save() work with JSArray<Attrs>. 
	 * Has no meaning in other usage scenarios
	 */
	public final native String type(String t)/*-{
		return this.type ? this.type : "";
	}-*/;
}
