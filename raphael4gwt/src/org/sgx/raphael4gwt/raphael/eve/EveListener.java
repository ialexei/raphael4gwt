package org.sgx.raphael4gwt.raphael.eve;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;
/**
 * mediator class between even native event and EveEvent java object - 
 * the java event all params is the native argument array with no 
 * conversion for less overhead.
 * 
 * @author sg
 *
 * @param <T>
 */
public abstract class EveListener<T extends EveEvent> {
public abstract Object call(T e);
/**
 * this method must instantiate an event object, call evt.fromArray() for poblating with values from native array, and call call(evt), like this:
 * <pre>
MyEveEvent1 e = new MyEveEvent1();
e.fromJsArray(jsa);
return call(e);
 * </pre>
 * this method is calle directly from native code
 */
public Object callNative(JsArrayMixed params, JavaScriptObject context) {
	EveEvent ev = getEventInstantiator().instantiate();
	ev.load(params, context);
	return call((T) ev);
}
public abstract EveEventInstantiator<T> getEventInstantiator();

}
