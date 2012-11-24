package org.sgx.raphael4gwt.raphael;

import org.sgx.raphael4gwt.raphael.base.Animation;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Color;
import org.sgx.raphael4gwt.raphael.base.Matrix;
import org.sgx.raphael4gwt.raphael.base.PathIntersectPoint;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.base.RGB;
import org.sgx.raphael4gwt.raphael.base.Rectangle;
import org.sgx.raphael4gwt.raphael.event.Callback;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;

/**
 * this is the main entry point to raphael4gwt library. 
 * This class also contain many utilities and constant values of raphael
 * 
 * 
 * impl note: while this has static native methods, This class IS NOT an gwt overlay type,
 * 
 * @author sg
 *
 */
public class Raphael {
	
	
//First some constants and raphael built in utilities
	
/* *** shape types *** */
public static final String 
	SHAPE_RECT="rect", 
	SHAPE_IMAGE="image",
	SHAPE_PATH="path",
	SHAPE_TEXT="text",
	SHAPE_CIRCLE="circle",
	SHAPE_ELLIPSE="eliipse";

	
	
/* *** EASING *** */
	
public static final String 
	EASING_LINEAR="linear", 
	EASING_EASEIN="easeIn",
	EASING_EASEOUT="easeOut",
	EASING_EASEINOUT="easeInOut",
	EASING_BACKIN="backIn",
	EASING_BACKOUT="backOut",
	EASING_ELASTIC="elastic",
	EASING_BOUNCE="bounce"
	;
public static final String[] EASING_ALL = {EASING_LINEAR, 
	EASING_EASEIN, EASING_EASEOUT, EASING_EASEINOUT,EASING_EASEINOUT,EASING_BACKIN,
	EASING_BACKOUT,EASING_BACKOUT,EASING_ELASTIC,EASING_BOUNCE};

/* *** PATHS *** */

public static final String 
	PATH_MOVETO="M", 
	PATH_CLOSEPATH="Z", 
	PATH_LINETO="L", 
	PATH_HLINETO="H",
	PATH_VLINETO="V", 
	PATH_CURVETO="C", 
	PATH_SMOOTH_CURVETO="S", 
	PATH_QUADBESIER_CURVETO="Q",
	PATH_SMOOTH_QUADBESIER_CURVETO="T",
	PATH_ELLIPTICAL_ARC="A",
	PATH_CATMULLROM_CURVETO="R",
	
	PATH_MOVETO_REL="m", 
	PATH_LINETO_REL="l", 
	PATH_HLINETO_REL="h",
	PATH_VLINETO_REL="v", 
	PATH_CURVETO_REL="c", 
	PATH_SMOOTH_CURVETO_REL="s", 
	PATH_QUADBESIER_CURVETO_REL="q",
	PATH_SMOOTH_QUADBESIER_CURVETO_REL="t",
	PATH_ELLIPTICAL_ARC_REL="a",
	PATH_CATMULLROM_CURVETO_REL="r"
	;

public static final String 
	STROKE_DASHARRAY_NORMAL="",STROKE_DASHARRAY_DASH="-", STROKE_DASHARRAY_POINT=".",
	STROKE_DASHARRAY_DASH_POINT="-.",STROKE_DASHARRAY_DASH_POINT_POINT="-..",
	STROKE_DASHARRAY_POINT_SPACE=". ",STROKE_DASHARRAY_DASH_SPACE="- ",
	STROKE_DASHARRAY_DASH_DASH="--",STROKE_DASHARRAY_DASH_SPACE_POINT="- .",
	STROKE_DASHARRAY_DASH_DASH_POINT="--.",STROKE_DASHARRAY_DASH_DASH_POINT_POINT="--..";

public static final String[] STROKE_DASHARRAY_ALL = {
	STROKE_DASHARRAY_NORMAL, STROKE_DASHARRAY_DASH, STROKE_DASHARRAY_POINT,
	STROKE_DASHARRAY_DASH_POINT,STROKE_DASHARRAY_DASH_POINT_POINT,	
	STROKE_DASHARRAY_POINT_SPACE,STROKE_DASHARRAY_DASH_SPACE,
	STROKE_DASHARRAY_DASH_DASH,STROKE_DASHARRAY_DASH_SPACE_POINT,
	STROKE_DASHARRAY_DASH_DASH_POINT,STROKE_DASHARRAY_DASH_DASH_POINT_POINT
};
/* *** ARROW *** */



public static final String FONT_STYLE_ITALIC = "italic", 
	FONT_STYLE_OBLIQUE = "oblique", FONT_STYLE_NORMAL = "normal";



public static final String FONT_WEIGHT_NORMAL = "normal", FONT_WEIGHT_BOLD="bold";	
	
	
	
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
public static native Paper paper(Element container, String w, String h)/*-{
	if(!container)
		return null;
	return $wnd.Raphael(container, w, h);
}-*/;
public static native Paper paper(Element container)/*-{
	if(!container)
		return null;
	return $wnd.Raphael(container);
}-*/;
public static native Paper paper(String container)/*-{
	if(!container)
		return null;
	return $wnd.Raphael(container);
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
		callback.@org.sgx.raphael4gwt.raphael.event.Callback::call(Lorg/sgx/raphael4gwt/raphael/Shape;)(this);
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
		callback.@org.sgx.raphael4gwt.raphael.event.Callback::call(Lorg/sgx/raphael4gwt/raphael/Shape;)(this);
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
* Colour name ("red", "green", "cornflowerblue", etc)<br/>
* #••• — shortened HTML colour: ("#000", "#fc0", etc)<br/>
* #•••••• — full length HTML colour: ("#000000", "#bd2300")<br/>
* rgb(•••, •••, •••) — red, green and blue channels’ values: ("rgb(200, 100, 0)")<br/>
* rgb(•••%, •••%, •••%) — same as above, but in %: ("rgb(100%, 175%, 0%)")<br/>
* hsb(•••, •••, •••) — hue, saturation and brightness values: ("hsb(0.5, 0.25, 1)")<br/>
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
/**
 * Snaps given value to given grid. 
 * @param snapDiff given array of values to which to snap to
 * @param value value to adjust
 * @param tolerance tolerance for snapping, default is 10
 * @return adjusted value.
 */
public static native int snapTo(double [] snapDiff, double value, double tolerance)/*-{
	return $wnd.Raphael.snapTo(@org.sgx.raphael4gwt.raphael.jsutil.JsUtil::toJsArray([D)(snapDiff), value, tolerance<0?10:tolerance);
}-*/;

/**
 * Snaps given value to given grid. 
 * @param snapDiff step of the grid in pixels
 * @param value value to adjust
 * @param tolerance tolerance for snapping, default is 10
 * @return adjusted value.
 */
public static native int snapTo(double snapDiff, double value, double tolerance)/*-{
	return $wnd.Raphael.snapTo(snapDiff, value, tolerance<0?10:tolerance);
}-*/;

/**
 * Transform angle to degrees 
 * @param deg angle in radians
 * @return angle in degrees
 */
public static native int deg(int deg)/*-{
	return $wnd.Raphael.deg(deg);
}-*/;

//public native static void addCustomAttribute(Paper paper, 
//	String caName, final CustomAttribute ca)/*-{
//		
////		$wnd._
//		
//	var f = $entry(function(o) {
//		$wnd.document.getElementById("anchor1").innerHTML +=
//			" ----- "+ this+" - "+o+" - "+arguments.length;
//		return ca.@org.sgx.raphael4gwt.raphael.base.CustomAttribute::make(Lorg/sgx/raphael4gwt/raphael/Shape;Ljava/lang/Object;)(this,o);
//	});	
////	var f = function(o) {
////		$wnd.document.getElementById("anchor1").innerHTML +=
////			" ----- "+ this+" - "+o+" - "+arguments.length;
////		return ca.@org.sgx.raphael4gwt.raphael.base.CustomAttribute::make(*)(this,o);
////	};	
//	
//	paper.customAttributes[caName]=f;
//}-*/;


//{
//}
//public final native void setCustomAttribute(String caName, CustomAttribute ca)/*-{
//var name = ca.@org.sgx.raphael4gwt.raphael.ca.CustomAttribute::getName()(), 
//	
//var f = $entry(function(o) {
//	ca.@org.sgx.raphael4gwt.raphael.ca.CustomAttribute::make(Ljava/lang/Object;)(o);
//});
//
//this.customAttributes[name]=f;	
//}-*/;


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

//public static int getPaperWidth(Paper p) {
//	return p.getCanvasElement().getClientWidth();//.g.getAbsoluteRight()-p.getCanvasElement().getAbsoluteLeft();
//}
//
//public static int getPaperHeight(Paper p) {
//	return p.getCanvasElement().getClientHeight();//.getAbsoluteBottom()-p.getCanvasElement().getAbsoluteTop();
//}


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
//public static Point[][] createPoint2DArray(int rows, int cols) {
//	
//}
public static native JsArray<Point> createPoint1DJsArray(int rows)/*-{
	var a = [];
	for (var i = 0; i < rows; i++) {
		a.push({"x":1,"y":1});
	}
	return a;
}-*/;
public static native JsArray<JsArray<Point>> createPoint2DJsArray(int rows, int cols)/*-{
	var a = [];
	for (var i = 0; i < rows; i++) {
		var b = [];
		for (var j = 0; j < cols; j++) {
			b.push({"x":1,"y":1});
		}
		a.push(b);
	}
	return a;
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
		e.getClientX() - p.getCanvasElement().getAbsoluteLeft()+Document.get().getBodyOffsetLeft(),
		e.getClientY() - p.getCanvasElement().getAbsoluteTop()+Document.get().getBodyOffsetTop()
	);
	
//	return createPoint(
//		e.getClientX(),
//		e.getClientY()
//	);
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


 
/**
 * Utility method Returns true if two bounding boxes intersect
 * @param bb1 bounding box
 * @param bb2 bounding box
 * @return
 */
public static native boolean isBBoxIntersect(String bb1, String bb2)/*-{
	return $wnd.Raphael.isBBoxIntersect(bb1, bb2);
}-*/;


/**
 * Utility method Returns true if given point is inside bounding boxes. 
 * @param bb bounding box
 * @param x x coordinate of the point
 * @param y y coordinate of the point
 * @return
 */
public static native boolean isPointInsideBBox(String bb, double x, double y)/*-{
	return $wnd.Raphael.isBBoxIntersect(bb, x, y);
}-*/;

/**
 * Utility method Returns true if given point is inside a given closed path. 
 * @param path path string
 * @param x x of the point
 * @param y y of the point
 * @return
 */
public static native boolean isPointInsidePath(String path, double x, double y)/*-{
	return $wnd.Raphael.isPointInsidePath(path, x, y);
}-*/;

/**
 * Utility method Returns true if given point is inside a given closed path. 
 * @param path path string
 * @param m a matrix instance
 * @return transformed path string
 */
public static native String mapPath(String path, Matrix m)/*-{
	return $wnd.Raphael.mapPath(path, x, y);
}-*/;


//parsing utilities
/**
 * tility method Parses given path string into an array of arrays of path segments.
 * Use together with PathCmd for a more java friendly access, like this:
 * <pre>
 * PathCmd c = new PathCmd(Raphael.parsePathString("a path str..."));
 * </pre>  
 * @param pathString path string
 * @return array of segments.
 */
public static native JsArray<JsArrayMixed> parsePathString(String pathString)/*-{
	return $wnd.Raphael.parsePathString(pathString);
}-*/;
/**
 * Utility method Parses given path string into an array of transformations. 
 * @param pathString transform string
 * @return array of transformations.
 */
public static native JsArray parseTransformString(String pathString)/*-{
	return $wnd.Raphael.parseTransformString(pathString);
}-*/;
/**
 * Utility method Converts path to a new path where all segments are cubic bezier curves. 
 * @param pathString path string
 * @return array of segments.
 */
public static native JsArray path2curve(String pathString)/*-{
	return $wnd.Raphael.path2curve(pathString);
}-*/;
/**
 * Utility method Return bounding box of a given path 
 * @param pathString
 * @return
 */
public static native Rectangle pathBBox(String pathString)/*-{
	return $wnd.Raphael.pathBBox(pathString);
}-*/;
/**
 * Utility method Finds intersections of two paths 
 * @param pathString
 * @return dots of intersection
 */
public static native JsArray<PathIntersectPoint> pathIntersection(String path1, String path2)/*-{
	return $wnd.Raphael.pathBBox(pathString);
}-*/;
/**
 * Utility method Converts path to relative form 
 * @param pathString path string or array of segments
 * @return array of segments.
 */
public static native JsArray pathToRelative(String pathString)/*-{
	return $wnd.Raphael.pathToRelative(pathString);
}-*/;

/**
 * @return true if browser supports SVG. 
 */
public static native boolean isSVG()/*-{
	return $wnd.Raphael.SVG;
}-*/;
/**
 * @return true if browser supports VML. 
 */
public static native boolean isVML()/*-{
	return $wnd.Raphael.VML;
}-*/;
/**
 * Can be "SVG" or "VML" or empty, depending on browser support
 */
public static native String type()/*-{
	return $wnd.Raphael.type;
}-*/;

/**
 * @return Raphael version  
 */
public static native String version()/*-{
	return $wnd.Raphael.version+"";
}-*/;

/**
 * Used when you need to draw in <iframe>. Switched window to the iframe one. 
 * @param newWindow new window object
 */
public static native void setWindow(Window newWindow)/*-{
	Raphael.setWindow(newWindow);
}-*/;


//extensions
/**
 * artificial method for creating a set passing shaes in a cvararg java method
 */
public static Set set(Paper paper, Shape...shapes) {
	Set s = paper.set();
	for (int i = 0; i < shapes.length; i++) {
		s.push(shapes[i]);
	}
	return s;
}


}

