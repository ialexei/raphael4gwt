package org.sgx.raphael4gwt.raphael.base;
import com.google.gwt.core.client.JavaScriptObject;

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
 * Please refer to the <a href="http://www.w3.org/TR/SVG/" title="The W3C Recommendation for the SVG language describes these properties in detail.">SVG specification</a> for an explanation of these parameters.</p><ol class="dr-json"><li><span class="dr-json-key">arrow-end</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">arrowhead on the end of the path. The format for string is <code>&lt;type&gt;[-&lt;width&gt;[-&lt;length&gt;]]</code>. Possible types: <code>classic</code>, <code>block</code>, <code>open</code>, <code>oval</code>, <code>diamond</code>, <code>none</code>, width: <code>wide</code>, <code>narrow</code>, <code>midium</code>, length: <code>long</code>, <code>short</code>, <code>midium</code>.</span></li><li><span class="dr-json-key">clip-rect</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">comma or space separated values: x, y, width and height</span></li><li><span class="dr-json-key">cursor</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">CSS type of the cursor</span></li><li><span class="dr-json-key">cx</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">the x-axis coordinate of the center of the circle, or ellipse</span></li><li><span class="dr-json-key">cy</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">the y-axis coordinate of the center of the circle, or ellipse</span></li><li><span class="dr-json-key">fill</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">colour, gradient or image</span></li><li><span class="dr-json-key">fill-opacity</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">font</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">font-family</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">font-size</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">font size in pixels</span></li><li><span class="dr-json-key">font-weight</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">height</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">href</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">URL, if specified element behaves as hyperlink</span></li><li><span class="dr-json-key">opacity</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">path</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">SVG path string format</span></li><li><span class="dr-json-key">r</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">radius of the circle, ellipse or rounded corner on the rect</span></li><li><span class="dr-json-key">rx</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">horisontal radius of the ellipse</span></li><li><span class="dr-json-key">ry</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">vertical radius of the ellipse</span></li><li><span class="dr-json-key">src</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">image URL, only works for <a href="#Element.image" class="dr-link">Element.image</a> element</span></li><li><span class="dr-json-key">stroke</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">stroke colour</span></li><li><span class="dr-json-key">stroke-dasharray</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">[“”, “<code>-</code>”, “<code>.</code>”, “<code>-.</code>”, “<code>-..</code>”, “<code>. </code>”, “<code>- </code>”, “<code>--</code>”, “<code>- .</code>”, “<code>--.</code>”, “<code>--..</code>”]</span></li><li><span class="dr-json-key">stroke-linecap</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">[“<code>butt</code>”, “<code>square</code>”, “<code>round</code>”]</span></li><li><span class="dr-json-key">stroke-linejoin</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">[“<code>bevel</code>”, “<code>round</code>”, “<code>miter</code>”]</span></li><li><span class="dr-json-key">stroke-miterlimit</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">stroke-opacity</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">stroke-width</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">stroke width in pixels, default is '1'</span></li><li><span class="dr-json-key">target</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">used with href</span></li><li><span class="dr-json-key">text</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">contents of the text element. Use <code>\n</code> for multiline text</span></li><li><span class="dr-json-key">text-anchor</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">[“<code>start</code>”, “<code>middle</code>”, “<code>end</code>”], default is “<code>middle</code>”</span></li><li><span class="dr-json-key">title</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">will create tooltip with a given text</span></li><li><span class="dr-json-key">transform</span><span class="dr-type"><em class="dr-type-string">string</em></span><span class="dr-json-description">see <a href="#Element.transform" class="dr-link">Element.transform</a></span></li><li><span class="dr-json-key">width</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">x</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">&nbsp;</span></li><li><span class="dr-json-key">y</span><span class="dr-type"><em class="dr-type-number">number</em></span><span class="dr-json-description">&nbsp;</span></li></ol><p class="header">Gradients
</p><p>Linear gradient format: “<code>‹angle›-‹colour›[-‹colour›[:‹offset›]]*-‹colour›</code>”, example: “<code>90-#fff-#000</code>” – 90°
gradient from white to black or “<code>0-#fff-#f00:20-#000</code>” – 0° gradient from white via red (at 20%) to black.

</p><p>radial gradient: “<code>r[(‹fx›, ‹fy›)]‹colour›[-‹colour›[:‹offset›]]*-‹colour›</code>”, example: “<code>r#fff-#000</code>” –
gradient from white to black or “<code>r(0.25, 0.75)#fff-#000</code>” – gradient from white to black with focus point
at 0.25, 0.75. Focus point coordinates are in 0..1 range. Radial gradients can only be applied to circles and ellipses.
</p><p class="header">Path String
</p><p>Please refer to <a href="http://www.w3.org/TR/SVG/paths.html#PathData" title="Details of a path’s data attribute’s format are described in the SVG specification.">SVG documentation regarding path string</a>. Raphaël fully supports it.</p><p class="header">Colour Parsing
</p><ul><li>Colour name (“<code>red</code>”, “<code>green</code>”, “<code>cornflowerblue</code>”, etc)</li><li>#••• — shortened HTML colour: (“<code>#000</code>”, “<code>#fc0</code>”, etc)</li><li>#•••••• — full length HTML colour: (“<code>#000000</code>”, “<code>#bd2300</code>”)</li><li>rgb(•••, •••, •••) — red, green and blue channels’ values: (“<code>rgb(200,&nbsp;100,&nbsp;0)</code>”)</li><li>rgb(•••%, •••%, •••%) — same as above, but in %: (“<code>rgb(100%,&nbsp;175%,&nbsp;0%)</code>”)</li><li>rgba(•••, •••, •••, •••) — red, green and blue channels’ values: (“<code>rgba(200,&nbsp;100,&nbsp;0, .5)</code>”)</li><li>rgba(•••%, •••%, •••%, •••%) — same as above, but in %: (“<code>rgba(100%,&nbsp;175%,&nbsp;0%, 50%)</code>”)</li><li>hsb(•••, •••, •••) — hue, saturation and brightness values: (“<code>hsb(0.5,&nbsp;0.25,&nbsp;1)</code>”)</li><li>hsb(•••%, •••%, •••%) — same as above, but in %</li><li>hsba(•••, •••, •••, •••) — same as above, but with opacity</li><li>hsl(•••, •••, •••) — almost the same as hsb, see <a href="http://en.wikipedia.org/wiki/HSL_and_HSV" title="HSL and HSV - Wikipedia, the free encyclopedia">Wikipedia page</a></li><li>hsl(•••%, •••%, •••%) — same as above, but in %</li><li>hsla(•••, •••, •••, •••) — same as above, but with opacity</li><li>Optionally for hsb and hsl you could specify hue as a degree: “<code>hsl(240deg,&nbsp;1,&nbsp;.5)</code>” or, if you want to go fancy, “<code>hsl(240°,&nbsp;1,&nbsp;.5)</code>”</li>
 * 
 * @author sg
 *
 */
public class Attrs extends JavaScriptObject {
	
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
	
	public final native int getStrokeWidth()/*-{
		return this["stroke-width"];
	}-*/;
	public final native void setStrokeWidth(int val)/*-{
		this["stroke-width"]=val;
	}-*/;
	public final native Attrs strokeWidth(int val)/*-{
		this["stroke-width"]=val;
		return this;
	}-*/;
	/**
	 * @return One of the following strings: "”, "-”, ".”, "-.”, "-..”, ". ”, "- ”, "--”, "- .”, "--.”, "--..”
	 */
	public final native String getStrokeDashArray()/*-{
		return this["stroke-dasharray"];
	}-*/;
	/**
	 * @param val One of the following strings: "”, "-”, ".”, "-.”, "-..”, ". ”, "- ”, "--”, "- .”, "--.”, "--..”
	 * @return
	 */
	public final native void setStrokeDashArray(String val)/*-{
		this["stroke-dasharray"]=val;
	}-*/;
	/**
	 * @param val One of the following strings: "”, "-”, ".”, "-.”, "-..”, ". ”, "- ”, "--”, "- .”, "--.”, "--..”
	 * @return
	 */
	public final native Attrs strokeDashArray(String val)/*-{
		this["stroke-dasharray"]=val;
		return this;
	}-*/;
	
	/**
	 * “butt”, “square”, “round”
	 * @return
	 */
	public final native String getStrokeLinecap()/*-{
		return this["stroke-linecap"];
	}-*/;
	/**
	 * 
	 * @param val “butt”, “square”, “round”
	 */
	public final native void setStrokeLinecap(String val)/*-{
		this["stroke-linecap"]=val;
	}-*/;
	/**
	 * 
	 * @param val“butt”, “square”, “round”
	 * @return
	 */
	public final native Attrs strokeLinecap(String val)/*-{
		this["stroke-linecap"]=val;
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
	public final native Attrs arrowEnd(String val)/*-{
		this["arrow-end"]=val;
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
	
	public final native String getFontSize()/*-{
		return this["font-size"];
	}-*/;
	public final native void setFontSize(String val)/*-{
		this["font-size"]=val;
	}-*/;
	public final native Attrs fontSize(String val)/*-{
		this["font-size"]=val;
		return this;
	}-*/;
	
}
