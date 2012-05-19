package org.sgx.raphael4gwt.raphael.eve;

import org.sgx.raphael4gwt.raphael.Shape;

import com.google.gwt.core.client.JsArrayMixed;

/**
 * I had
 * @author sg
 *
 */
public interface EveEvent {
/**
 * @return the complete event name of this event
 */
String getName();
void fromJsArray(JsArrayMixed jsa);
JsArrayMixed toJsArray();
//EveEvent getInstantiator();
/**
 * needed for sending the shape as a context object to jnative eve listeners when triggering events. 
 * @return the shape related to this event, 
 */
Shape getShape();
}
