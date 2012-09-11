package org.sgx.espinillo.client.impl1.eds;

import org.sgx.gwteditors.client.impl1.basetypes.Color;
import org.sgx.gwteditors.client.impl1.basetypes.SelectionList;
import org.sgx.gwteditors.client.impl1.edbean.EditableBean;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;

public abstract class ShapeBean implements EditableBean {
	
public ShapeBean(){
	
	strokeDashArray=new SelectionList<String>(
		new String[]{"", ".", "-", "- ." }, 
			new String[]{""});
	
	fillColor=new Color("ffffff");
	strokeColor=new Color("000000");
	fillImage = "";
	fillGradient="";
//	arrowEnd=GWT.create(ArrowEndBean.class);
}

Color fillColor, strokeColor; 
String fillImage, fillGradient, transform, clipRect, path;
SelectionList<String> strokeDashArray;
Integer strokeWidth=2;
Double opacity=1.0;
String text="", fontFamily="";
Integer fontSize=14;
//ArrowEndBean arrowEnd;
public Attrs getNativeAttrs() {
	Attrs a = Attrs.create().fill(getFill()).stroke(getStroke()).transform(getTransform()).
		clipRect(getClipRect()).text(getText()).fontFamily(getFontFamily()).
		fontSize(getFontSize()).strokeWidth(getStrokeWidth()); 
	return a; 
}

public Color getFillColor() {
	return fillColor;
}
public void setFillColor(Color fillColor) {
	this.fillColor = fillColor;
}
public Color getStrokeColor() {
	return strokeColor;
}
public void setStrokeColor(Color strokeColor) {
	this.strokeColor = strokeColor;
}
public String getFill() {
	if(fillColor!=null)
		return "#"+fillColor.getHex(); 
	else return "#ffffff";
}
public String getStroke() {
	if(strokeColor!=null)
		return "#"+strokeColor.getHex(); 
	else return "#000000";
}
public String getFillImage() {
	return fillImage;
}
public void setFillImage(String fillImage) {
	this.fillImage = fillImage;
}
public String getFillGradient() {
	return fillGradient;
}
public void setFillGradient(String fillGradient) {
	this.fillGradient = fillGradient;
}
public SelectionList<String> getStrokeDashArray() {
	return strokeDashArray;
}
public void setStrokeDashArray(SelectionList<String> strokeDashArray) {
	this.strokeDashArray = strokeDashArray;
}
public void setStrokeDashArraySelection(String val) {
	this.strokeDashArray.getSelection().clear();
	this.strokeDashArray.getSelection().add(val);
}
public Integer getStrokeWidth() {
	return strokeWidth;
}
public void setStrokeWidth(Integer strokeWidth) {
	this.strokeWidth = strokeWidth;
}
public String getTransform() {
	return transform;
}
public void setTransform(String transform) {
	this.transform = transform;
}
public String getClipRect() {
	return clipRect;
}
public void setClipRect(String clipRect) {
	this.clipRect = clipRect;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public Double getOpacity() {
	return opacity;
}
public void setOpacity(Double opacity) {
	this.opacity = opacity;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getFontFamily() {
	return fontFamily;
}
public void setFontFamily(String fontFamily) {
	this.fontFamily = fontFamily;
}
public Integer getFontSize() {
	return fontSize;
}
public void setFontSize(Integer fontSize) {
	this.fontSize = fontSize;
}


//public ArrowEndBean getArrowEnd() {
//	return arrowEnd;
//}
//public void setArrowEnd(ArrowEndBean arrowEnd) {
//	this.arrowEnd = arrowEnd;
//}

}
