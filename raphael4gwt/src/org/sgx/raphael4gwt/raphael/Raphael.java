package org.sgx.raphael4gwt.raphael;

//import com.google.gwt.core.client.JavaScriptObject;
import org.sgx.raphael4gwt.raphael.base.Animation;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.Callback;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public class Raphael {
	
//protected Raphael(){}

public static native Paper paper(Element container, int w, int h)/*-{
	if(!container)
		return null;
	return $wnd.Raphael(container, w, h);
}-*/;

public static native Paper paper(int x, int y, int width, int height)/*-{
	return $wnd.Raphael(x, y, width, height);
//	return {circle: function(){}};
}-*/;

/**
 * Returns angle between three points 
 */
public static native float angle(int x1, int y1, int x2, int y2, int x3, int y3)/*-{
	return $wnd.Raphael.angle(x1, y1, x2, y2, x3, y3);
}-*/;

/**
 * Creates an animation object that can be passed to the Element.animate or Element.animateWith methods. See also Animation.delay and Animation.repeat methods. 
 * @param params final attributes for the element, see also Element.attr
 * @param ms number of milliseconds for animation to run
 * @param easing easing type. Accept one of Raphael.easing_formulas or CSS format: cubic‐bezier(XX, XX, XX, XX)
 * @param callback callback function. Will be called at the end of animation.
 * @return an animation object that can be passed to the Element.animate or Element.animateWith methods.
 */
public static native Animation animation(JavaScriptObject params, int ms, String easing, Callback callback)/*-{
	return $wnd.Raphael.animation(params, ms, easing, function() {
		callback.@org.sgx.raphael4gwt.raphael.event.Callback::call()();
	});
}-*/;
/**
 *  Creates an animation object that can be passed to the Element.animate or Element.animateWith methods. See also Animation.delay and Animation.repeat methods. 
 * @param params final attributes for the element, see also Element.attr
 * @param ms number of milliseconds for animation to run
 * @param easing easing type. Accept one of Raphael.easing_formulas or CSS format: cubic‐bezier(XX, XX, XX, XX)
 * @param callback callback function. Will be called at the end of animation.
 * @return an animation object that can be passed to the Element.animate or Element.animateWith methods.
 */
public static native Animation animation(Attrs params, int ms, String easing, Callback callback)/*-{
	var p = params.@org.sgx.raphael4gwt.raphael.base.Attrs::getNativeAttrs()();
	return $wnd.Raphael.animation(p, ms, easing, function() {
		callback.@org.sgx.raphael4gwt.raphael.event.Callback::call()();
	});
}-*/;
/**
 * Parses the color string and returns object with all values for the given color. 
 * @param s
 * @return
 */
public static native Color color(String s)/*-{
	return $wnd.Raphael.color(s);
}-*/;
public static native String getColor(int value)/*-{
	return $wnd.Raphael.getColor(value);
}-*/;
public static native String getColor()/*-{
return $wnd.Raphael.getColor();
}-*/;
/**
 * Parses colour string as RGB object. Accepted string formats:
* Colour name (“red”, “green”, “cornflowerblue”, etc)<br/>
* #••• — shortened HTML colour: (“#000”, “#fc0”, etc)<br/>
* #•••••• — full length HTML colour: (“#000000”, “#bd2300”)<br/>
* rgb(•••, •••, •••) — red, green and blue channels’ values: (“rgb(200, 100, 0)”)<br/>
* rgb(•••%, •••%, •••%) — same as above, but in %: (“rgb(100%, 175%, 0%)”)<br/>
* hsb(•••, •••, •••) — hue, saturation and brightness values: (“hsb(0.5, 0.25, 1)”)<br/>
* hsb(•••%, •••%, •••%) — same as above, but in %<br/>
* hsl(•••, •••, •••) — same as hsb<br/>
* hsl(•••%, •••%, •••%) — same as hsb<br/>
 */
public static native RGB getRGB(String v)/*-{
	return $wnd.Raphael.getRGB(v);
}-*/;
public static native String rgb(int r, int g, int b)/*-{
	return $wnd.Raphael.rgb(r,g,b);
}-*/;
public static native String hsv(int h, int s, int v)/*-{
	return $wnd.Raphael.hsv(h, s, v);
}-*/;
public static native String hsl(int h, int s, int l)/*-{
	return $wnd.Raphael.hsl(h, s, l);
}-*/;
public static native RGB hsv2rgb(int h, int s, int v)/*-{
return $wnd.Raphael.hsv2rgb(h, s, v);
}-*/;
public static native Matrix matrix(int a, int b, int c, int d, int e, int f)/*-{
	return $wnd.Raphael.matrix(a, b, c, d, e, f);
}-*/;
/**
 * @return RFC4122, version 4 ID 
 */
public static native String createUUID()/*-{
	return $wnd.Raphael.createUUID();
}-*/;

/**
 * Transform angle to degrees 
 * @param deg angle in radians
 * @return angle in degrees
 */
public static native int deg(int deg)/*-{
	return $wnd.Raphael.deg(deg);
}-*/;

}
