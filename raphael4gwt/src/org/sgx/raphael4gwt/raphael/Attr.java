package org.sgx.raphael4gwt.raphael;

import org.sgx.raphael4gwt.raphael.base.Arrow;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Gradient;
import org.sgx.raphael4gwt.raphael.pathobj.PathObject;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.resources.client.ImageResource;

/**
 * a Java helper for attributes so the user can use java syntax. 
 * thi has no overhead - only one more function callfor first time it is called 
 * because methods return the native object 
 * paper.rect(100,200,100,100,5).attr(new Attr().fill("red).stroke("blue"));
 * @author sg
 *
 */
public class Attr {
	private Attrs data;
	public Attr() {
		data = Attrs.create();
	}
	public Attrs getNativeAttrs() {
		return data;
	}
	
	//the following is generated automatically using eclipse's delegate methods refatctoring tool
//	public final <T extends JavaScriptObject> T cast() {
//		return data.cast();
//	}
	public final boolean equals(Object other) {
		return data.equals(other);
	}
	public final int hashCode() {
		return data.hashCode();
	}
	public String toSource() {
		return data.toSource();
	}
	public final String toString() {
		return data.toString();
	}
	public final String get(String attr) {
		return data.get(attr);
	}
	public final Attrs set(String attr, Object val) {
		return data.set(attr, val);
	}
	public final String getFill() {
		return data.getFill();
	}
	public final void setFill(String val) {
		data.setFill(val);
	}
	public final Attrs fill(String val) {
		return data.fill(val);
	}
	public final Attrs fill(ImageResource img) {
		return data.fill(img);
	}
	public final Attrs fill(Gradient g) {
		return data.fill(g);
	}
	public final double getFillOpacity() {
		return data.getFillOpacity();
	}
	public final void setFillOpacity(double val) {
		data.setFillOpacity(val);
	}
	public final Attrs fillOpacity(double val) {
		return data.fillOpacity(val);
	}
	public final String getStroke() {
		return data.getStroke();
	}
	public final void setStroke(String val) {
		data.setStroke(val);
	}
	public final Attrs stroke(String val) {
		return data.stroke(val);
	}
	public final int getStrokeWidth() {
		return data.getStrokeWidth();
	}
	public final void setStrokeWidth(int val) {
		data.setStrokeWidth(val);
	}
	public final Attrs strokeWidth(int val) {
		return data.strokeWidth(val);
	}
	public final Attrs strokeWidth(double val) {
		return data.strokeWidth(val);
	}
	public final String getStrokeDashArray() {
		return data.getStrokeDashArray();
	}
	public final void setStrokeDashArray(String val) {
		data.setStrokeDashArray(val);
	}
	public final Attrs strokeDashArray(String val) {
		return data.strokeDashArray(val);
	}
	public final String getStrokeLinecap() {
		return data.getStrokeLinecap();
	}
	public final void setStrokeLinecap(String val) {
		data.setStrokeLinecap(val);
	}
	public final Attrs strokeLinecap(String val) {
		return data.strokeLinecap(val);
	}
	public final int getStrokeMiterLimit() {
		return data.getStrokeMiterLimit();
	}
	public final void setStrokeMiterLimit(int val) {
		data.setStrokeMiterLimit(val);
	}
	public final Attrs strokeMiterLimit(int val) {
		return data.strokeMiterLimit(val);
	}
	public final double getStrokeOpacity() {
		return data.getStrokeOpacity();
	}
	public final void setStrokeOpacity(double val) {
		data.setStrokeOpacity(val);
	}
	public final Attrs strokeOpacity(double val) {
		return data.strokeOpacity(val);
	}
	public final String getTransform() {
		return data.getTransform();
	}
	public final void setTransform(String val) {
		data.setTransform(val);
	}
	public final Attrs transform(String val) {
		return data.transform(val);
	}
	public final String getArrowEnd() {
		return data.getArrowEnd();
	}
	public final void setArrowEnd(String val) {
		data.setArrowEnd(val);
	}
	public final Attrs setArrowEnd(Arrow a) {
		return data.setArrowEnd(a);
	}
	public final Attrs arrowEnd(String val) {
		return data.arrowEnd(val);
	}
	public final Attrs arrowEnd(Arrow a) {
		return data.arrowEnd(a);
	}
	public final String getClipRect() {
		return data.getClipRect();
	}
	public final void setClipRect(String val) {
		data.setClipRect(val);
	}
	public final Attrs clipRect(String val) {
		return data.clipRect(val);
	}
	public final String getCursor() {
		return data.getCursor();
	}
	public final void setCursor(String val) {
		data.setCursor(val);
	}
	public final Attrs cursor(String val) {
		return data.cursor(val);
	}
	public final int getCx() {
		return data.getCx();
	}
	public final void setCx(int val) {
		data.setCx(val);
	}
	public final Attrs cx(int val) {
		return data.cx(val);
	}
	public final Attrs cx(double val) {
		return data.cx(val);
	}
	public final int getCy() {
		return data.getCy();
	}
	public final void setCy(int val) {
		data.setCy(val);
	}
	public final Attrs cy(int val) {
		return data.cy(val);
	}
	public final Attrs cy(double val) {
		return data.cy(val);
	}
	public final int getWidth() {
		return data.getWidth();
	}
	public final void setWidth(int val) {
		data.setWidth(val);
	}
	public final Attrs width(int val) {
		return data.width(val);
	}
	public final Attrs width(double val) {
		return data.width(val);
	}
	public final int getHeight() {
		return data.getHeight();
	}
	public final void setHeight(int val) {
		data.setHeight(val);
	}
	public final Attrs height(int val) {
		return data.height(val);
	}
	public final Attrs height(double val) {
		return data.height(val);
	}
	public final int getX() {
		return data.getX();
	}
	public final void setX(int val) {
		data.setX(val);
	}
	public final Attrs x(int val) {
		return data.x(val);
	}
	public final Attrs x(double val) {
		return data.x(val);
	}
	public final int getY() {
		return data.getY();
	}
	public final void setY(int val) {
		data.setY(val);
	}
	public final Attrs y(int val) {
		return data.y(val);
	}
	public final Attrs y(double val) {
		return data.y(val);
	}
	public final String getFontFamily() {
		return data.getFontFamily();
	}
	public final void setFontFamily(String val) {
		data.setFontFamily(val);
	}
	public final Attrs fontFamily(String val) {
		return data.fontFamily(val);
	}
	public final String getFontWeight() {
		return data.getFontWeight();
	}
	public final void setFontWeight(String val) {
		data.setFontWeight(val);
	}
	public final Attrs fontWeight(String val) {
		return data.fontWeight(val);
	}
	public final Attrs fontWeight(double val) {
		return data.fontWeight(val);
	}
	public final int getFontSize() {
		return data.getFontSize();
	}
	public final void setFontSize(int val) {
		data.setFontSize(val);
	}
	public final Attrs fontSize(int val) {
		return data.fontSize(val);
	}
	public final Attrs fontSize(double val) {
		return data.fontSize(val);
	}
	public final String getFont() {
		return data.getFont();
	}
	public final void setFont(String val) {
		data.setFont(val);
	}
	public final Attrs font(String val) {
		return data.font(val);
	}
	public final String getFontStyle() {
		return data.getFontStyle();
	}
	public final void setFontStyle(String val) {
		data.setFontStyle(val);
	}
	public final Attrs fontStyle(String val) {
		return data.fontStyle(val);
	}
	public final String getText() {
		return data.getText();
	}
	public final void setText(String val) {
		data.setText(val);
	}
	public final Attrs text(String val) {
		return data.text(val);
	}
	public final String getTextAnchor() {
		return data.getTextAnchor();
	}
	public final void setTextAnchor(String val) {
		data.setTextAnchor(val);
	}
	public final Attrs textAnchor(String val) {
		return data.textAnchor(val);
	}
	public final String getTitle() {
		return data.getTitle();
	}
	public final void setTitle(String val) {
		data.setTitle(val);
	}
	public final Attrs title(String val) {
		return data.title(val);
	}
	public final String getHRef() {
		return data.getHRef();
	}
	public final void setHRef(String val) {
		data.setHRef(val);
	}
	public final Attrs href(String val) {
		return data.href(val);
	}
	public final double getOpacity() {
		return data.getOpacity();
	}
	public final void setOpacity(double val) {
		data.setOpacity(val);
	}
	public final Attrs opacity(double val) {
		return data.opacity(val);
	}
	public final String getPath() {
		return data.getPath();
	}
	public final void setPath(String val) {
		data.setPath(val);
	}
	public final Attrs path(String val) {
		return data.path(val);
	}
	public final Attrs path(PathObject val) {
		return data.path(val);
	}
	public final int getRadius() {
		return data.getRadius();
	}
	public final void setRadius(int val) {
		data.setRadius(val);
	}
	public final Attrs r(int val) {
		return data.r(val);
	}
	public final Attrs r(double val) {
		return data.r(val);
	}
	public final int getRadiusX() {
		return data.getRadiusX();
	}
	public final void setRadiusX(int val) {
		data.setRadiusX(val);
	}
	public final Attrs rx(int val) {
		return data.rx(val);
	}
	public final int getRadiusY() {
		return data.getRadiusY();
	}
	public final void setRadiusY(int val) {
		data.setRadiusY(val);
	}
	public final Attrs ry(int val) {
		return data.ry(val);
	}
	public final String print() {
		return data.print();
	}
	public final String getType() {
		return data.getType();
	}
	public final String type() {
		return data.type();
	}
	public final String type(String t) {
		return data.type(t);
	}
	
}
