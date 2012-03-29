package org.sgx.raphael4gwt.raphael.util;

import java.util.HashMap;
import java.util.Map;

import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * Utility class for parsing shape's attributes in css format, and vice versa, 
 * dump a shape atribute to CSS
 * @author sg
 *
 */
public class AttrsUtil {
	
public static Attrs fromCss(String cssSrc) {
	Map<String, String> css = parseCss(cssSrc);
	Attrs a = Attrs.create();
	return poblateAttrs(a, css);
}
/**
 * 
 * @param a the attr object to poblate
 * @param css - native js object storing css names -> values (js object used as a map)
 * @return the poiblated attr object
 */
public static Attrs poblateAttrs(Attrs a, Map<String, String> css) {
	for(String name : css.keySet()) {
		setAttr(a,name, css.get(name));
	}	
	return a;
}
public static void setAttr(Attrs a, String name, String val) {
	try {
		if(name.equals(Attrs.ARROW_END)) {
			a.arrowEnd(val);
		}
		else if(name.equals(Attrs.CLIP_RECT)) {
			a.clipRect(val);
		}
		else if(name.equals(Attrs.CURSOR)) {
			a.cursor(val);
		}
		else if(name.equals(Attrs.CX)) {
			a.cx(Double.parseDouble(val));
		}
		else if(name.equals(Attrs.CY)) {
			a.cy(Double.parseDouble(val));
		}
		else if(name.equals(Attrs.FILL)) {
			a.fill(val);
		}
		else if(name.equals(Attrs.FILL_OPACITY)) {
			a.fillOpacity(Double.parseDouble(val));
		}
		else if(name.equals(Attrs.FONT)) {
			a.font(val);
		}
		else if(name.equals(Attrs.FONT_FAMILY)) {
			a.fontFamily(val);
		}
		else if(name.equals(Attrs.FONT_SIZE)) {
			a.fontSize(Double.parseDouble(val));
		}
		else if(name.equals(Attrs.FONT_WEIGHT)) {
			a.fontWeight(val);
		}
		else if(name.equals(Attrs.HEIGHT)) {
			a.height(Double.parseDouble(val));
		}
		else if(name.equals(Attrs.HREF)) {
			a.href(val);
		}
		else if(name.equals(Attrs.OPACITY)) {
			a.opacity(Double.parseDouble(val));
		}
		else if(name.equals(Attrs.PATH)) {
			a.fillOpacity(Double.parseDouble(val));
		}
		else if(name.equals(Attrs.FILL_OPACITY)) {
			a.fillOpacity(Double.parseDouble(val));
		}
		Element e;
//				HREF="href", 
//				OPACITY="opacity",
//				PATH="path",
//				R="r",
//				RX="rx",
//				RY="ry",
//				STROKE="stroke",
//				STROKE_DASHARRAY="stroke-dasharray",
//				STROKE_LINECAP="stroke-linecap",
//				STROKE_MITERLIMIT="stroke-miterlimit",
//				STROKE_OPACITY="stroke-opacity",
//				STROKE_WIDTH="stroke-width",
//				TEXT="text",
//				TEXT_ANCHOR="text-anchor",
//				TITLE="title",
//				TRANSFORM="transform",
//				WIDTH="width",
//				X="x",
//				Y="y"
				
	}catch (Exception e) {
		// TODO: handle exception
	}
}
/**
 * parses a css attribute presentation code like
 * <pre>stroke: green; stroke-width: 1px</pre>
 * (without the {})
 * @param cssSrc
 * @return a javascript object that is a map of name->values (String->String)
 */
public static Map<String, String> parseCss(String cssSrc) {
	Map<String, String> m = new HashMap<String, String>();
	String[] a = cssSrc.split(";");
	for (int i = 0; i < a.length; i++) {
		String[] b = a[i].split(":");
		if(b!=null&&b.length==2)
			m.put(b[0].trim(), b[1].trim());
	}
	return m;
}
}
