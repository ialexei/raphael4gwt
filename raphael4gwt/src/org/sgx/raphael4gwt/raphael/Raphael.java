package org.sgx.raphael4gwt.raphael;

//import com.google.gwt.core.client.JavaScriptObject;
import org.sgx.raphael4gwt.raphael.base.Animation;
import org.sgx.raphael4gwt.raphael.base.Arrow;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Color;
import org.sgx.raphael4gwt.raphael.base.Matrix;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.base.RGB;
import org.sgx.raphael4gwt.raphael.base.Rectangle;
import org.sgx.raphael4gwt.raphael.event.Callback;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;

/**
 * this is the main entry point to raphael4gwt library. 
 * This class also contain many utilities and constant values of raphael
 * This class IS NOT a gwt overlay type, it is used statically
 * 
 * @author sg
 *
 */
public class Raphael {
	
	
//First some constants and raphael built in utilities
	
	
/* *** EASING *** */
	
public static final String 
	EASING_LINEAR="linear", 
	EASING_EASEIN="easeIn",
	EASING_EASEOUT="easeOut",
	EASING_EASEINOUT="easeInOut",
	EASING_BACKIN="backIn",
	EASING_BACKOUT="backOut",
	EASING_ELASTIC="elastic",
	EASING_BOUNCE="bounce";





/* *** ARROW *** */	
	
	
	
//protected Raphael(){}
/**
 * container must be attached to the document. Be careful to add container's parent to the doucment before calling this constructor. 
 * @param container
 * @param w
 * @param h
 * @return
 */
public static native Paper paper(Element container, int w, int h)/*-{
	if(!container)
		return null;
	return $wnd.Raphael(container, w, h);
}-*/;
/**
 * container must be attached to the document. Be careful to add container's parent to the doucment before calling this constructor.
 * @param x
 * @param y
 * @param width
 * @param height
 * @return
 */
public static native Paper paper(int x, int y, int width, int height)/*-{
	return $wnd.Raphael(x, y, width, height);
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
	//var p = params.@org.sgx.raphael4gwt.raphael.base.Attrs::getNativeAttrs()();
	return $wnd.Raphael.animation(params, ms, easing, function() {
		callback.@org.sgx.raphael4gwt.raphael.event.Callback::call()();
	});
}-*/;
/**
 *  Creates an animation object that can be passed to the Element.animate or Element.animateWith methods. See also Animation.delay and Animation.repeat methods. 
 * @param params final attributes for the element, see also Element.attr
 * @param ms number of milliseconds for animation to run
 * @param easing easing type. Accept one of Raphael.easing_formulas or CSS format: cubic‐bezier(XX, XX, XX, XX)
 * @return an animation object that can be passed to the Element.animate or Element.animateWith methods.
 */
public static native Animation animation(Attrs params, int ms, String easing)/*-{
//var p = params.@org.sgx.raphael4gwt.raphael.base.Attrs::getNativeAttrs()();
return $wnd.Raphael.animation(params, ms, easing);
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
//public static int snapTo(int[]snapValues, int value, int tolerance) {
//	return _snapTo(JsUtil.toJsArrayNumber(snapValues), value, tolerance);
//}
//private static native int _snapTo(JsArrayNumber snapValues, int value, int tolerance)/*-{
//return $wnd.Raphael.snapTo(snapValues, value, tolerance);
//}-*/;
public static native int snapTo(int snapDiff, int value, int tolerance)/*-{
	return $wnd.Raphael.snapTo(snapDiff, value, tolerance);
}-*/;
/**
 * Transform angle to degrees 
 * @param deg angle in radians
 * @return angle in degrees
 */
public static native int deg(int deg)/*-{
	return $wnd.Raphael.deg(deg);
}-*/;


///** helper utility for getting paper bounds in the document, based on gwt client dom.*/
//public static final native Rectangle getPaperBounds(Paper paper)/*-{
//	var el = paper.@org.sgx.raphael4gwt.raphael.Paper::getCanvasElement();
//	return {
//		"x": el.getAbsoluteLeft(), 
//		"y": el.getAbsoluteTop(),
//		"width": el.getClientWidth(),  
//		"height": el.getClientHeight(), 
//	};
//}-*/;


///** helper utility for getting paper bounds in the document, based on gwt client dom.*/
//public static Rectangle getPaperBounds(Paper paper) {
//	return (Rectangle) JsUtil.obj(
//		"x", paper.getCanvasElement().getAbsoluteLeft(), 
//		"y", paper.getCanvasElement().getAbsoluteTop(), 
//		"width", paper.getCanvasElement().getClientWidth(), 
//		"height", paper.getCanvasElement().getClientHeight()
//	);
//}


public static native Point createPoint(double x, double y)/*-{
	return {"x": x, "y": y};
}-*/;
public static native Rectangle createRectangle(int x, int y, int width, int height)/*-{
	return {"x": x, "y": y, "width": width, "height": height};
}-*/;
/**
 * get a mouse events coorinates relative to a paper.
 * Based on gwt's paper's p.getCanvasElement().getAbsolute.. 
 * for knowing the coords of a native event in a paper's shape, relative to the paper, for example for tools.-
 * @param p
 * @param e a native event inside that paper.
 * @return
 */
public static Point getCoordsInPaper(Paper p, NativeEvent e) {
	return createPoint(
		e.getClientX() - p.getCanvasElement().getAbsoluteLeft(),
		e.getClientY() - p.getCanvasElement().getAbsoluteTop()
	);
}
/**
 * get the mouse event coords relative to a shape, using getCoordsInPaper and shape.getBBox()
 * @param p
 * @param shape
 * @param e
 * @return
 */
public static Point getCoordsInShape(Paper p, Shape shape,
		boolean isWithoutTransform, NativeEvent e) {
	
	return createPoint(
		e.getClientX() - p.getCanvasElement().getAbsoluteLeft() - shape.getBBox(isWithoutTransform).getX(),
		e.getClientY() - p.getCanvasElement().getAbsoluteTop() - shape.getBBox(isWithoutTransform).getY()
	);
}
public static Point getCoordsInShape(Paper paper, Shape shape,
		NativeEvent e) {
	return getCoordsInShape(paper, shape, false, e);
}

//{
//	return (Point) JsUtil.obj(
//		"x", e.getClientX() - paper.getCanvasElement().getAbsoluteLeft(), 
//		"y", e.getClientY() - paper.getCanvasElement().getAbsoluteTop()
//	);
//}

//public static final native Attrs attrs()/*-{
//	return {};
//}-*/;


}

