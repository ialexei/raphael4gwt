package org.sgx.raphael4gwt.raphael.eve;

import org.sgx.raphael4gwt.raphael.Shape;

import com.google.gwt.core.client.JsArrayMixed;

public abstract class AbstractEvent implements EveEvent {
	
//String name;

public AbstractEvent() {
//	this.name=name;
}
@Override
public abstract String getName();

@Override
public abstract void fromJsArray(JsArrayMixed jsa);

@Override
public JsArrayMixed toJsArray() {
	return JsArrayMixed.createArray().<JsArrayMixed>cast();
}

@Override

public Shape getShape() {
	return null;
}

}
