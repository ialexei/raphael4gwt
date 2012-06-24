package org.sgx.raphael4gwt.raphael.eve;

import org.sgx.raphael4gwt.raphael.Shape;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;

/**
 * I 
 * @author sg
 *
 */
public interface EveEvent {
/**
 * @return the complete event name of this event
 */
String getName();
/**
 * loads this event from a native js array just as the native event handler "arguments" array. ,
 * builtin event types defines this array, custom eve events must implement these for defineing the "event content".
 * @see org.sgx.raphael4gwt.test.EveCustomEvents
 * @param jsa
 */
void load(JsArrayMixed jsa, JavaScriptObject context);
/**
 * builds a native array that must be exactly as the event handler spects.  
 *  builtin event types defines this array, custom eve events must implement these for defineing the "event content".
 *  @see org.sgx.raphael4gwt.test.EveCustomEvents
 * @return
 */
JsArrayMixed getNativeParams();
JavaScriptObject getNativeContext();
//EveEvent getInstantiator();
/**
 * needed for sending the shape as a context object to jnative eve listeners when triggering events. 
 * @return the shape related to this event, 
 */
Shape getShape();
}
