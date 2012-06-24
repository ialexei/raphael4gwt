package org.sgx.raphael4gwt.raphael.eve;

import org.sgx.raphael4gwt.raphael.Shape;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayMixed;

/**
 * static class for http://raphaeljs.com/reference.html#eve<br/>
 * 
 * instead eve() for triggering use Eve.trigger. The rest is the same, Eve.on(), etc<br/>
 * 
 * I have trouble passing java arrays from and to jsni. In eve one send the event name and the event params: 
 * eve(eventName, param1, param2...)
 * 
 * I defined an artifiial EveEvent interface that has getName() property and the user must implement, possible anon class, for adding as attributes the params desired to pass.
 * 
 * @author sg
 *
 */
public class Eve {
	

/**
 * Fires the given named event. put the params you want to send to listeners as fields on your EveEvent implementation. 
 * @param e the event to be fired.
 * @return array of returned values from the listeners
 */
public static native JsArrayMixed trigger(EveEvent e)/*-{
	//I pass the event name and the event objects as the only event parameter 	
	var jsa = e.@org.sgx.raphael4gwt.raphael.eve.EveEvent::getNativeParams()();	
	var args = [e.@org.sgx.raphael4gwt.raphael.eve.EveEvent::getName()(), 
		e.@org.sgx.raphael4gwt.raphael.eve.EveEvent::getShape()()].
		concat(jsa);
	return $wnd.eve.apply(null, args);	
}-*/;
//public static native void triggerAttrName(String attrName, Shape shape, String attrVal)/*-{
//	var evName ="raphael.attr."+attrName+"."+shape.id;
//	$wnd.eve.apply(null, [evName, shape, attrVal, attrName]); 
////	$wnd.eve(evName, shape, attrVal, attrName);
//}-*/;



/**
 * Binds given event handler with a given name. You can use wildcards "*" for the names: 
 * @param name name of the event, dot (.) or slash (/) separated, with optional wildcards
 * @param l
 * @param zIndex - represents z-index of the handler. It is an optional feature and only used when you need to ensure that some subset of handlers will be invoked in a given order, despite of the order of assignment. Example:
<pre>eve.on("mouse", eat)(2);
eve.on("mouse", scream);
eve.on("mouse", catch)(1);</pre>
This will ensure that catch function will be called before eat. If you want to put your handler before non-indexed handlers, specify a negative value.
 *
 *
 */
public static native void on(String name, EveListener l, int zIndex)/*-{
	var f = $entry(function(){
//		var s = "args: ";
//		for(var i = 0; i<arguments.length; i++) 
//			s+=", "+arguments[i];
//		$wnd.alert(s);

		return l.@org.sgx.raphael4gwt.raphael.eve.EveListener::callNative(Lcom/google/gwt/core/client/JsArrayMixed;Lcom/google/gwt/core/client/JavaScriptObject;)(arguments, this);
	});
	@org.sgx.raphael4gwt.raphael.event.EventHelper::putEveListener(Lorg/sgx/raphael4gwt/raphael/eve/EveListener;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(l,f);
	
	$wnd.eve.on(name, f)(zIndex);
}-*/;

/**
 * Binds given event handler with a given name. You can use wildcards "*" for the names: 
 * @param name name of the event, dot (.) or slash (/) separated, with optional wildcards
 * @param l
 */
public static void on(String name, EveListener l) {
	on(name, l, 0);
}


/**
 * alias for on()
 */
public static void bind(String name, EveListener l) {
	on(name, l);
}
/**
 * Binds given event handler with a given name to only run once then unbind itself. 
 * @param name name of the event you which to register for
 * @param l
 */
public static native void once(String name, EveListener l)/*-{
	var f = $entry(function(evt){
		//remember in trigger we always pass a single parameter, the event.
		return l.@org.sgx.raphael4gwt.raphael.eve.EveListener::call(Lorg/sgx/raphael4gwt/raphael/eve/EveEvent;)(evt);
	});
	$wnd.eve.once(name, f);
}-*/;
/**
 * Removes given listener from the list of event listeners assigned to given name. 
 * @param name -the event name you wish to remove
 * @param l - the listener object you wish to remove.
 */
public static native void off(String name, EveListener l)/*-{
	var f = @org.sgx.raphael4gwt.raphael.event.EventHelper::removeEveListener(Lorg/sgx/raphael4gwt/raphael/eve/EveListener;)(l);
	$wnd.eve.off(name, f);
}-*/;

/**
 * alias for off(). @see off
 */
public static void unbind(String name, EveListener l) {
	off(name, l);
}

/**
 * @return eve's version
 */
public static final native String getVersion()/*-{
	return eve.version;
}-*/;

/**
 * register a listener that will be notified when any attribute changes on any shape.
 * @param l
 */
public static void onAttributeChange(AttrChangeListener l, int zIndex) {
	onAttributeChange(null, null, l, false, zIndex);
}
/**
 * register a listener when given attribute changes on ANY shape.
 * @param attributeName
 */
public static void onAttributeChange(String attributeName, AttrChangeListener l, int zIndex) {
	onAttributeChange(null, attributeName, l, false, zIndex);
}
/**
 * register a listener when given attribute changes on given shape.
 * @param shape is null it will listen on changes on any shape
 * @param attributeName - if null it will listen on changes of any attribute
 * @param l the attribute listener.
 * @param once - if true it will use once() so listeners will be notified nly once.
 */
public static void onAttributeChange(Shape shape, String attributeName, 
		AttrChangeListener l, boolean once, int zIndex) {
	String id = "*", attrName = "*";
	if(shape!=null)
		id=shape.getId()+"";
	if(attributeName!=null)
		attrName=attributeName;
	on("raphael.attr."+attrName+"."+id, l);
}

//public static final native void onAttributeChange(Shape shape, String attributeName, 
//		AttrChangeListener l, boolean once, int zIndex)/*-{
//			
//}-*/;



//var f = $entry(function(evt){
//	//remember in trigger we always pass a single parameter, the event.
//	return l.@org.sgx.raphael4gwt.raphael.eve.EveListener::call(Lorg/sgx/raphael4gwt/raphael/eve/EveEvent;)(evt);
//});
//@org.sgx.raphael4gwt.raphael.event.EventHelper::putEveListener(Lorg/sgx/raphael4gwt/raphael/eve/EveListener;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(l,f);
//$wnd.eve.on(name, f)(zIndex);


}
