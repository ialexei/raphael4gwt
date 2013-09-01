package org.sgx.espinillo.client.impl1.eds;

import org.sgx.gwteditors.client.impl1.edbean.EditableBean;

import com.google.gwt.core.shared.GWT;

public abstract class  TransformBean1 implements EditableBean {
	Double translateX, translateY, scaleX, scaleY; 
	Boolean absolute;
public static TransformBean1 create() {
	TransformBean1 b = GWT.create(TransformBean1.class); 
	b.setScaleX(0.5); 
	b.setScaleY(0.8); 
	b.setTranslateX(-10.1);
	b.setTranslateY(-10.1);
	b.setAbsolute(true); 
	return b;
}

public Boolean getAbsolute() {
	return absolute;
}

public void setAbsolute(Boolean absolute) {
	this.absolute = absolute;
}

public Double getTranslateX() {
	return translateX;
}
public void setTranslateX(Double translateX) {
	this.translateX = translateX;
}
public Double getTranslateY() {
	return translateY;
}
public void setTranslateY(Double translateY) {
	this.translateY = translateY;
}
public Double getScaleX() {
	return scaleX;
}
public void setScaleX(Double scaleX) {
	this.scaleX = scaleX;
}
public Double getScaleY() {
	return scaleY;
}
public void setScaleY(Double scaleY) {
	this.scaleY = scaleY;
}

}
