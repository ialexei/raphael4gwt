package org.sgx.raphael4gwt.raphael.eve;

import org.sgx.raphael4gwt.raphael.Shape;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;

/**
 * contain the native js array of event attributes as a java attribute. 
 * @author sg
 *
 */
public abstract class AbstractEveEvent implements EveEvent {
	
JsArrayMixed params; 
JavaScriptObject context;

public AbstractEveEvent() {
	params=JavaScriptObject.createArray().cast();
}

public JsArrayMixed getData() {
	return params;
} 

@Override
public void load(JsArrayMixed params, JavaScriptObject context) {
	this.params=params;
	this.context=context;
}

@Override
public JsArrayMixed getNativeParams() {
	return this.params==null ? 
		JsArrayMixed.createArray().<JsArrayMixed>cast() :
		this.params;
}
public JavaScriptObject getNativeContext() {
	return this.context; 			
}
@Override
public abstract String getName();


@Override
public abstract Shape getShape();

}
