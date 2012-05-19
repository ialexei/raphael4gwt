package org.sgx.raphael4gwt.raphael.eve;

import org.sgx.raphael4gwt.raphael.Shape;

import com.google.gwt.core.client.JsArrayMixed;
/**
 * @author sg
 */
public class AttributeChangeEvent implements EveEvent {
	
String attributeName;
Shape shape;
String newValue;
public AttributeChangeEvent(String attributeName) {
	this(attributeName, null, null);
}
//@Override
//public EveEvent instantiate() {
//	return new AttributeChangeEvent("");
//}
/**
 * @param attributeName
 * @param attrVal
 * @param shapeId - if -1 then it will raphael.attrVal.attrName.*
 */
public AttributeChangeEvent(String attributeName, String attrVal, Shape shape) {
	super();
	this.attributeName = attributeName;
	this.newValue=attrVal;
	this.shape=shape;
}
public AttributeChangeEvent() {
	this(null, null, null);
}
@Override
public String getName() {
	String aName = attributeName==null?"*":attributeName;
	String sid = shape==null?"*":shape.getId()+"";
	return "raphael.attr."+aName+"."+sid;
}
@Override
public Shape getShape() {
	return shape;
}
public String getAttributeName() {
	return attributeName;
}

public void setAttributeName(String attributeName) {
	this.attributeName = attributeName;
}

public String getNewValue() {
	return newValue;
}

public void setNewValue(String newValue) {
	this.newValue = newValue;
}

@Override
public void fromJsArray(JsArrayMixed jsa) {	
	setNewValue(jsa.getString(0));
	setAttributeName(jsa.getString(1));
}

@Override
public JsArrayMixed toJsArray() {
	JsArrayMixed jsa = JsArrayMixed.createArray().<JsArrayMixed>cast();
//	if(newValue instanceof String)
	jsa.push(newValue+"");
//	else if (newValue instanceof Integer || newValue instanceof Double ||newValue instanceof Float)
//		jsa.push((Double)newValue);
	jsa.push(getAttributeName());
	return jsa;
}

}
