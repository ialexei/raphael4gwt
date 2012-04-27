package org.sgx.espinillo.client.impl1.eds;

import org.sgx.espinillo.client.impl1.util.ShapeUtil;
import org.sgx.espinillo.client.impl1.util.Util;
import org.sgx.gwteditors.client.impl1.basetypes.Color;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
/**
  * perform bean - raphel <--> shape   conversion 
 * @author sg
 *
 */
public class ShapeBeanUtil {

	public static void copyShapeBean(ShapeBean dest, Set shape) {
		Shape s = null;
		if(shape!=null && shape.size()==1) {
			s=ShapeUtil.getInstance().getFirst(shape);
		}
		else if(shape!=null && shape.size()>1){
			s=shape;
		}
		if(s!=null) {
			String val = s.getAttribute("fill");
			if(Util.notNull(val)) {
				String hex = val.substring(1, val.length());
				dest.setFillColor(new Color(hex));
			}
			val = s.getAttribute("stroke");
			if(Util.notNull(val)) {
				String hex = val.substring(1, val.length());
				dest.setStrokeColor(new Color(hex));
			}
			val = s.getAttribute("stroke-width");
			if(Util.notNull(val) && Util.isInteger(val)) {
				dest.setStrokeWidth(Integer.parseInt(val));
			}
			val = s.getAttribute("stroke-dasharray");
			if(Util.notNull(val)) {
				dest.setStrokeDashArraySelection(val);
			}
			val = s.getAttribute("clip-rect");
			if(Util.notNull(val)) {
				dest.setClipRect(val);
			}
			val = s.getAttribute("transform");
			if(Util.notNull(val)) {
				dest.setTransform(val);
			}
			val = s.getAttribute("path");
			if(Util.notNull(val)) {
				dest.setPath(val);
			}
			val = s.getAttribute("opacity");
			if(Util.notNull(val)&&Util.isDouble(val)) {
				dest.setOpacity(Util.parseDouble(val, 1));
			}
			val = s.getAttribute("text");
			if(Util.notNull(val)) {
				dest.setText(val);
			}
			val = s.getAttribute("font-family");
			if(Util.notNull(val)) {
				dest.setFontFamily(val);
			}
			val = s.getAttribute("font-size");
			if(Util.notNull(val)&&Util.isInteger(val)) {
				dest.setFontSize(Util.parseInt(val, 12));
			}
//			val = s.getAttribute("arrow-end");
//			if(Util.notNull(val)) {
//				String width="", length="", type="";
//				String[] a = val.split("-");
//				if(a.length==3) {
//					type=a[0];
//					width=a[1];
//					length=a[2];
//				}
//				if(a.length==2) {
//					type=a[0];
//					width=a[1];
//				}
//				if(a.length==1) {
//					type=a[0];
//				}
//				ArrowEndBean ab = GWT.create(ArrowEndBean.class);
//				ab.setSelectedType(type);
//				ab.setSelectedWidth(width); 
//				ab.setSelectedLength(length);
//				dest.setArrowEnd(ab);
//			}
		}
	}

	public static void beanToShape(ShapeBean sb, Set shape) {
		Shape s = shape;
		if(shape!=null&&shape.size()==1)
			s=ShapeUtil.getInstance().getFirst(shape);
		Attrs attrs = Attrs.create();
		if(Util.notNull(sb.getFillColor())) {
			attrs.fill("#"+sb.getFillColor().getHex());
		}
		if(Util.notNull(sb.getStrokeColor())) {
			attrs.stroke("#"+sb.getStrokeColor().getHex());
		}
		if(Util.notNull(sb.getStrokeDashArray())) {
			attrs.strokeDashArray(sb.getStrokeDashArray().getSelection().get(0));
		}
		if(true) {
			attrs.strokeWidth(sb.getStrokeWidth());
		}
		if(Util.notNull(sb.getClipRect())) {
			attrs.clipRect(sb.getClipRect());
		}
		if(Util.notNull(sb.getTransform())) {
			attrs.transform(sb.getTransform());
		}
		if(Util.notNull(sb.getPath())) {
			attrs.path(sb.getPath());
		}
		if(Util.notNull(sb.getText())) {
			attrs.text(sb.getText());
		}
		if(Util.notNull(sb.getFontFamily())) {
			attrs.fontFamily(sb.getFontFamily());
		}
		if(Util.notNull(sb.getFontSize())) {
			attrs.fontSize(sb.getFontSize());
		}
//		if(Util.notNull(sb.get())) {
			attrs.opacity(sb.getOpacity());
//		}
//		if(Util.notNull(sb.getArrowEnd())) {
//			ArrowEndBean ae = sb.getArrowEnd();
//			attrs.arrowEnd(ae.toRaphaelString());
//		}
		s.attr(attrs);
	}

}
