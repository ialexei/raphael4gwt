package org.sgx.raphael4gwt.raphael.eve;

import org.sgx.raphael4gwt.raphael.Shape;

import com.google.gwt.core.client.JsArrayMixed;
/**eve attribute change event. all attributes are stored in a js array consistent 
 * with eve native api (js arrays). in this api tree length array 
 * [shape, attributeName, attributeValue] is spected. 
 * @author sg
 */
public class AttrChangeEvent extends AbstractEveEvent {

/**
 * @param attributeName
 * @param attrVal
 * @param shapeId - if -1 then it will raphael.attrVal.attrName.*
 */
public AttrChangeEvent(Shape shape, String attributeName, String attrVal) {
	super();
	params.push(shape); 
	params.push(attributeName); 
	params.push(attrVal);
}
public AttrChangeEvent() {
	this(null, null, null);
}
@Override
public String getName() {
	String aName = getAttributeName()==null?"*":getAttributeName();
	String sid = getShape()==null?"*":getShape().getId()+"";
	return "raphael.attr."+aName+"."+sid;
}
@Override
public Shape getShape() {
	return params.getObject(0).cast();
}
public String getAttributeName() {
	return params.getString(1);
}

public void setAttributeName(String attributeName) {
	params.set(1, attributeName); 
//	this.attributeName = attributeName;
}

public String getNewValue() {
	return params.getString(2);
}

public void setNewValue(String newValue) {
	params.set(2, newValue); 
}

@Override
public String toString() {
	return "AttrChangeEvent(shape: "+getShape().getId()+", attrName: "+getAttributeName()+
		", attrValue: "+getNewValue();
}
}
