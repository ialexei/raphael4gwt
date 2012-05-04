package org.sgx.raphael4gwt.raphael.base;

import org.sgx.raphael4gwt.raphael.event.Callback;

import com.google.gwt.core.client.JavaScriptObject;
/**
 * animation keyframes support. natively: 
 * <pre>
 * el.animate({
    "20%": {cy: 200, easing: ">"},
    "40%": {cy: 100},
    "60%": {cy: 200},
    "80%": {cy: 300, callback: function () {}},
    "100%": {cy: 200}
}, 5000);</pre>
 * @author sg
 *
 */
public final class AnimKeyFrames extends JavaScriptObject {
	protected AnimKeyFrames(){}
public static native AnimKeyFrames create()/*-{
	return {};
}-*/;
/**Use it like <pre>
 * 
 * AnimKeyFrames kf = AnimKeyFrames.create().
 * 	put("20%" ,Attrs.create().fill("yellow")).
 *  put("100%", Attrs.create().fill("blue")); 
 *  </pre>
 *  String percent - a string like "20%"
 * @param attrs - attributes to reach at frame
 * @param easing - easing to use to reach frame
 * @param callback - callback to call when this anim's frame finish
 * @return this
 */
public native AnimKeyFrames put(String percent, Attrs attrs, String easing, Callback callback)/*-{
	attrs["easing"]=easing;
	attrs["callback"]=$entry(function(){
		callback.@org.sgx.raphael4gwt.raphael.event.Callback::call(Lorg/sgx/raphael4gwt/raphael/Shape;)(this);
	});
	this[percent]=attrs;
	return this;
}-*/;
/**Use it like <pre>
 * 
 * AnimKeyFrames kf = AnimKeyFrames.create().
 * 	put("20%" ,Attrs.create().fill("yellow")).
 *  put("100%", Attrs.create().fill("blue")); 
 *  </pre>
 *  String percent - a string like "20%"
 * @param attrs - attributes to reach at frame
 * @param easing - easing to use to reach frame
 * @return this
 */
public native AnimKeyFrames put(String percent, Attrs attrs, String easing)/*-{
	attrs["easing"]=easing;	
	this[percent]=attrs;
	return this;
}-*/;
/**Use it like <pre>
 * 
 * AnimKeyFrames kf = AnimKeyFrames.create().
 * 	put("20%" ,Attrs.create().fill("yellow")).
 *  put("100%", Attrs.create().fill("blue")); 
 *  </pre>
 *  String percent - a string like "20%"
 * @param attrs - attributes to reach at frame
 * @param callback - callback to call when this anim's frame finish
 * @return this
 */
public native AnimKeyFrames put(String percent, Attrs attrs)/*-{
	this[percent]=attrs;
	return this;
}-*/;
/**
 * removes passed keyframe 
 * @param percent
 * @return this
 */
public native AnimKeyFrames remove(String percent)/*-{	
	delete this[percent];
	return this;
}-*/;


}
