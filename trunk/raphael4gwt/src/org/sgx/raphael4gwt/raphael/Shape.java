package org.sgx.raphael4gwt.raphael;

import org.sgx.raphael4gwt.raphael.base.AnimStatus;
import org.sgx.raphael4gwt.raphael.base.Animation;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Glow;
import org.sgx.raphael4gwt.raphael.base.Rectangle;
import org.sgx.raphael4gwt.raphael.event.DDListener;
import org.sgx.raphael4gwt.raphael.event.DragOverListener;
import org.sgx.raphael4gwt.raphael.event.HoverListener;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;
/**
 * this correspond to Element object in raphaeljs ref.
 * @author sg
 *
 */
public class Shape extends JavaScriptObject {
	
	protected Shape(){}
	
	public final native Shape clone()/*-{ 
		return this.clone();
	}-*/;
	
	/**
	 * Return bounding box for a given element 
	 * @param isWithoutTransform - flag, true if you want to have bounding box before transformations. Default is false.
	 * @return
	 */
	public final native Rectangle getBBox(boolean isWithoutTransform)/*-{ 
		return this.getBBox(isWithoutTransform); 
	}-*/;
	/**
	 * @return bounding box for a given element 
	 */
	public final native Rectangle getBBox()/*-{ 
		return this.getBBox(); 
	}-*/;
	
	
	
	/* *** TRANSFORMATIONS *** */
	
	/**
	 * Adds rotation by given angle around given point to the list of transformations of the element. 
	 * @param deg angle in degrees
	 * @return
	 */
	public final native Shape rotate(double deg, int cx, int cy)/*-{
		return this.rotate(deg, cx, cy);
	}-*/;
	/**
	 * centre of the shape is used as a point of rotation. 
	 * @param deg angle in degrees
	 * @return
	 */
	public final native Shape rotate(double deg)/*-{
		return this.rotate(deg);
	}-*/;
	/**
	 * Adds scale by given amount relative to given point to the list of transformations of the element. 
	 * @param sx horizontal scale amount
	 * @param sy vertical scale amount
	 * @param cx x coordinate of the centre of scale
	 * @param cy xy coordinate of the centre of scale
	 * @return
	 */
	public final native Shape scale(double sx, double sy, int cx, int cy)/*-{
		return this.scale(sx, sy, cx, cy);
	}-*/;
	/**
	 * Adds scale by given amount relative to given point to the list of transformations of the element using centre of the shape
	 * @param sx horizontal scale amount
	 * @param sy vertical scale amount
	 * @return
	 */
	public final native Shape scale(double sx, double sy)/*-{
		return this.scale(sx, sy);
	}-*/;
	public final native Shape translate(double dx, double dy)/*-{
		return this.translate(dx, dy);
	}-*/;
	public final native Shape hide()/*-{
		return this.hide();
	}-*/;
	public final native Shape show()/*-{
		return this.show();
	}-*/;
	/**
	 * 
	 * @return  current transformation string. @see setTransform()
	 */
	public final native String getTransform()/*-{
		return this.transform()+"";
	}-*/;
	/**
	 * Adds transformation to the element which is separate to other attributes, i.e. translation doesn’t change x or y of the rectange. The format of transformation string is similar to the path string syntax:<br/>

"t100,100r30,100,100s2,2,100,100r45s1.5"<br/>

Each letter is a command. There are four commands: t is for translate, r is for rotate, s is for scale and m is for matrix.<br/>

There are also alternative “absolute” translation, rotation and scale: T, R and S. They will not take previous transformation into account. 
For example, ...T100,0 will always move element 100 px horisontally, while ...t100,0 could move it vertically if there is r90 before. 
Just compare results of r90t100,0 and r90T100,0.<br/>

So, the example line above could be read like “translate by 100, 100; rotate 30° around 100, 100; scale twice around 100, 100; rotate 45° 
around centre; scale 1.5 times relative to centre”. As you can see rotate and scale commands have origin coordinates as optional parameters, 
the default is the centre point of the element. Matrix accepts six parameters.<br/>

Usage<br/>
<pre>
var el = paper.rect(10, 20, 300, 200);
// translate 100, 100, rotate 45°, translate -100, 0
el.transform("t100,100r45t-100,0");
// if you want you can append or prepend transformations
el.transform("...t50,50");
el.transform("s2...");
// or even wrap
el.transform("t50,50...t-50-50");
// to reset transformation call method with empty string
el.transform("");
// to get current value call it without parameters
console.log(el.transform());
</pre>
	 * @return  current transformation string. @see setTransormationString()
	 */
	public final native Shape setTransform(String transfStr)/*-{
		return this.transform(transfStr);
	}-*/;
	
	
	
	
	
	
	
	/* *** EVENTS *** */
	/**
	 * Adds event handler for mousedown for the element.
	 * @param l
	 * @return
	 */
	public final native Shape mouseDown(MouseEventListener l)/*-{ 
		var f = $entry(function(e) {
			l.@org.sgx.raphael4gwt.raphael.event.MouseEventListener::notifyMouseEvent(Lcom/google/gwt/dom/client/NativeEvent;)(e);
		});
		@org.sgx.raphael4gwt.raphael.event.EventHelper::putMouseEventListener(Lorg/sgx/raphael4gwt/raphael/event/MouseEventListener;Lcom/google/gwt/core/client/JavaScriptObject;)(l,f);
		return this.mousedown(f);
	}-*/;
	/**
	 * Removes event handler for mousedown for the element. 
	 * @param l handler for the event
	 * @return
	 */
	public final native Shape unmouseDown(MouseEventListener l)/*-{		
		var f = @org.sgx.raphael4gwt.raphael.event.EventHelper::removeMouseEventListener(Lorg/sgx/raphael4gwt/raphael/event/MouseEventListener;)(l);
		return this.unmousedown(f);
	}-*/;
	/**
	 * Adds event handler for mousemove for the element.
	 * @param l
	 * @return
	 */
	public final native Shape mouseMove(MouseEventListener l)/*-{ 
		var f = $entry(function(e) {
			l.@org.sgx.raphael4gwt.raphael.event.MouseEventListener::notifyMouseEvent(Lcom/google/gwt/dom/client/NativeEvent;)(e);
		});
		@org.sgx.raphael4gwt.raphael.event.EventHelper::putMouseEventListener(Lorg/sgx/raphael4gwt/raphael/event/MouseEventListener;Lcom/google/gwt/core/client/JavaScriptObject;)(l,f);
		return this.mousemove(f);
	}-*/;
	/**
	 * Removes event handler for mousemove for the element. 
	 * @param l handler for the event
	 * @return
	 */
	public final native Shape unmouseMove(MouseEventListener l)/*-{		
		var f = @org.sgx.raphael4gwt.raphael.event.EventHelper::removeMouseEventListener(Lorg/sgx/raphael4gwt/raphael/event/MouseEventListener;)(l);
		return this.unmousemove(f);
	}-*/;
	/**
	 * Adds event handler for click for the element. 
	 * @param l
	 * @return
	 */
	public final native Shape click(MouseEventListener l)/*-{ 
		var f = $entry(function(e) {
			l.@org.sgx.raphael4gwt.raphael.event.MouseEventListener::notifyMouseEvent(Lcom/google/gwt/dom/client/NativeEvent;)(e);
		});
		@org.sgx.raphael4gwt.raphael.event.EventHelper::putMouseEventListener(Lorg/sgx/raphael4gwt/raphael/event/MouseEventListener;Lcom/google/gwt/core/client/JavaScriptObject;)(l,f);
		return this.click(f);
	}-*/;
	/**
	 * Removes event handler for click for the element. 
	 * @param l handler for the event
	 * @return
	 */
	public final native Shape unclick(MouseEventListener l)/*-{		
		var f = @org.sgx.raphael4gwt.raphael.event.EventHelper::removeMouseEventListener(Lorg/sgx/raphael4gwt/raphael/event/MouseEventListener;)(l);
		return this.unclick(f);
	}-*/;
	/**
	 * Adds event handler for double click for the element. 
	 * @param l
	 * @return
	 */
	public final native Shape dblclick(MouseEventListener l)/*-{ 
		return this.dblclick($entry(function(e) {
			l.@org.sgx.raphael4gwt.raphael.event.MouseEventListener::notifyMouseEvent(Lcom/google/gwt/dom/client/NativeEvent;)(e);
		}));
	}-*/;
	/**
	 * Removes event handler for double click for the element. 
	 * @param l
	 * @return
	 */
	public final native Shape undblclick(MouseEventListener l)/*-{ 
		var f = @org.sgx.raphael4gwt.raphael.event.EventHelper::removeMouseEventListener(Lorg/sgx/raphael4gwt/raphael/event/MouseEventListener;)(l);
		return this.undblclick(f);
	}-*/;
	/**
	 * Adds event handler for double click for the element. 
	 * @param l
	 * @return
	 */
	public final native Shape drag(DDListener l)/*-{ 
		var onstart = function(x, y, e) {
			$entry(l.@org.sgx.raphael4gwt.raphael.event.DDListener::onStart(IILcom/google/gwt/dom/client/NativeEvent;)(x, y, e));
		};
		var onend = function(e) {
			$entry(l.@org.sgx.raphael4gwt.raphael.event.DDListener::onEnd(Lcom/google/gwt/dom/client/NativeEvent;)(e));
		};
		var onmove = function(dx, dy, x, y, e) {
			$entry(l.@org.sgx.raphael4gwt.raphael.event.DDListener::onMove(IIIILcom/google/gwt/dom/client/NativeEvent;)(dx, dy, x, y, e));
		};
		return this.drag(onmove, onstart, onend);
	}-*/;
	/**
	 * Removes all drag event handlers from given element. 
	 */
	public final native void undrag()/*-{
		this.undrag();
	}-*/;

	public final native Shape hover(HoverListener l)/*-{
		var hoverIn = $entry(function(e) {
			l.@org.sgx.raphael4gwt.raphael.event.HoverListener::hoverIn(Lcom/google/gwt/dom/client/NativeEvent;)(e);
		}); 
		var hoverOut = $entry(function(e) {
			l.@org.sgx.raphael4gwt.raphael.event.HoverListener::hoverOut(Lcom/google/gwt/dom/client/NativeEvent;)(e);
		});  
		@org.sgx.raphael4gwt.raphael.event.EventHelper::putHoverListener(Lorg/sgx/raphael4gwt/raphael/event/HoverListener;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)(l, hoverIn, hoverOut);
		return this.hover(hoverIn, hoverOut);		
	}-*/;
	/**
	 * Removes event handlers for hover for the element. 
	 * @param l
	 * @return
	 */
	public final native Shape unhover(HoverListener l)/*-{
		var funcs = @org.sgx.raphael4gwt.raphael.event.EventHelper::removeHoverListener(Lorg/sgx/raphael4gwt/raphael/event/HoverListener;)(l);
		return this.unhover(funcs[0], funcs[1]);
	}-*/;

	/**
	 * Shortcut for assigning event handler for drag.over.<id> event, where id is id of the element (see Element.id). 
	 * @param l
	 * @return
	 */
	public final native void onDragOver(DragOverListener l)/*-{
		return this.onDragOver($entry(function(src){
			l.@org.sgx.raphael4gwt.raphael.event.DragOverListener::dragOver(Lorg/sgx/raphael4gwt/raphael/Shape;)(src);
		}));
	}-*/;
	/**
	 * Adds event handler for touchcancel for the element. 
	 * @param l
	 * @return
	 */
	public final native Shape touchCancel(MouseEventListener l)/*-{ 
		return this.touchcancel($entry(function(e) {
			l.@org.sgx.raphael4gwt.raphael.event.MouseEventListener::notifyMouseEvent(Lcom/google/gwt/dom/client/NativeEvent;)(e);
		}));
	}-*/;
	/**
	 * Removes event handler for touchcancel for the element. 
	 * @param l
	 * @return
	 */
	public final native Shape unTouchCancel(MouseEventListener l)/*-{ 
		var f = @org.sgx.raphael4gwt.raphael.event.EventHelper::removeMouseEventListener(Lorg/sgx/raphael4gwt/raphael/event/MouseEventListener;)(l);
		return this.untouchcancel(f);
	}-*/;
	/**
	 * Adds event handler for touchend for the element. 
	 * @param l
	 * @return
	 */
	public final native Shape touchEnd(MouseEventListener l)/*-{ 
		return this.touchend($entry(function(e) {
			l.@org.sgx.raphael4gwt.raphael.event.MouseEventListener::notifyMouseEvent(Lcom/google/gwt/dom/client/NativeEvent;)(e);
		}));
	}-*/;
	/**
	 * Removes event handler for touchend for the element. 
	 * @param l
	 * @return
	 */
	public final native Shape unTouchEnd(MouseEventListener l)/*-{ 
		var f = @org.sgx.raphael4gwt.raphael.event.EventHelper::removeMouseEventListener(Lorg/sgx/raphael4gwt/raphael/event/MouseEventListener;)(l);
		return this.untouchend(f);
	}-*/;
	/**
	 * Adds event handler for touchmove for the element. 
	 * @param l
	 * @return
	 */
	public final native Shape touchMove(MouseEventListener l)/*-{ 
		return this.touchmove($entry(function(e) {
			l.@org.sgx.raphael4gwt.raphael.event.MouseEventListener::notifyMouseEvent(Lcom/google/gwt/dom/client/NativeEvent;)(e);
		}));
	}-*/;
	/**
	 * Removes event handler for touchmove for the element. 
	 * @param l
	 * @return
	 */
	public final native Shape unTouchMove(MouseEventListener l)/*-{ 
		var f = @org.sgx.raphael4gwt.raphael.event.EventHelper::removeMouseEventListener(Lorg/sgx/raphael4gwt/raphael/event/MouseEventListener;)(l);
		return this.untouchmove(f);
	}-*/;
	/**
	 * Adds event handler for touchstart for the element. 
	 * @param l
	 * @return
	 */
	public final native Shape touchStart(MouseEventListener l)/*-{ 
		return this.touchstart($entry(function(e) {
			l.@org.sgx.raphael4gwt.raphael.event.MouseEventListener::notifyMouseEvent(Lcom/google/gwt/dom/client/NativeEvent;)(e);
		}));
	}-*/;
	/**
	 * Removes event handler for touchstart for the element. 
	 * @param l
	 * @return
	 */
	public final native Shape unTouchStart(MouseEventListener l)/*-{ 
		var f = @org.sgx.raphael4gwt.raphael.event.EventHelper::removeMouseEventListener(Lorg/sgx/raphael4gwt/raphael/event/MouseEventListener;)(l);
		return this.untouchstart(f);
	}-*/;
	
	
	
	
	
	/* *** HIERARCHIES *** */
	/**
	 * Reference to the next element in the hierarchy. 
	 * @return
	 */
	public final native Shape next()/*-{
		return this.next;
	}-*/;
	/**
	 * Reference to the previous element in the hierarchy.
	 */
	public final native Shape prev()/*-{
		return this.prev;
	}-*/;
//	public final native Raphael raphael()/*-{
//		return this.prev;
//	}-*/;
	/**
	 * Removes element form the paper. 
	 */
	public final native void remove()/*-{
		this.remove();
	}-*/;
	
	public final native Element node()/*-{
		return this.node;
	}-*/;	
	/**
	 * Internal reference to “paper” where object drawn. Mainly for use in plugins and element extensions. 
	 * @return
	 */
	public final native Paper paper()/*-{
		return this.paper;
	}-*/;
	/**Moves the element so it is the furthest from the viewer’s eyes, behind other elements. */
	public final native Shape toBack()/*-{
		return this.toBack();
	}-*/;
	/**Moves the element so it is the furthest from the viewer’s eyes, behind other elements. */
	public final native Shape toFront()/*-{
		return this.toFront();
	}-*/;
	
	
	
	
	
	/* *** ATRIBUTES *** */
	
	public final native void setAttribute(String name, String value)/*-{
		this.attr(name, value);
	}-*/;
	public final native void setAttribute(String name, int value)/*-{
		this.attr(name, value);
	}-*/;
	public final native void setAttribute(String name, double value)/*-{
		this.attr(name, value);
	}-*/;
//	public final native void setAttribute(String name, float value)/*-{
//		this.attr(name, value);
//	}-*/;
	public final native String getAttribute(String name)/*-{
		return this.attr(name)+"";
	}-*/;
	
//	public final native NativeAttrs getNativeAttrs()/*-{
//		return this.attr();
//	}-*/;
//	public final native void setNativeAttrs(NativeAttrs a)/*-{
//		this.attr(a);
//	}-*/;
	
	public final native Attrs attr()/*-{
		return this.attr();
		//return @org.sgx.raphael4gwt.raphael.base.Attrs::createFromNative(Lorg/sgx/raphael4gwt/raphael/base/NativeAttrs;)(this.attr());
	}-*/;
	public final native Shape attr(Attrs attrs)/*-{	
		//var a = attrs.@org.sgx.raphael4gwt.raphael.base.Attrs::getNativeAttrs()();
		this.attr(attrs);		
		return this;
	}-*/;
	

	public final native Shape attr(String name, String val)/*-{
		this.attr(name, val);
		return this;
	}-*/;
	
//	public Attrs getAttrs() {
//		Attrs attrs = new Attrs();
//		attrs.setNativeAttrs(getNativeAttrs());
//		return attrs;
//	}
	
	
	
	
	
	

	/* *** ANIMATION *** */
	
	/**
	 * animates this shape according to animation object. see Raphael.animation
	 * @return
	 */
	public final native Shape animate(Animation a)/*-{
		return this.animate(a);
	}-*/;
	/**
	 * Acts similar to animate, but ensure that given animation runs in sync with another given element. 
	 * @param el element to sync with
	 * @param anim animation to sync with
	 * @param animation animation object, see Raphael.animation
	 * @return
	 */
	public final native Shape animateWith(Shape el, Animation anim, Animation animation)/*-{
		return this.animate(a);
	}-*/;
	/**
	 * pauses all animations
	 * @return
	 */
	public final native Shape pause()/*-{
		return this.pause();
	}-*/;
	/**
	 * pauses animation
	 * @param a
	 * @return
	 */
	public final native Shape pause(Animation a)/*-{
		return this.pause(a);
	}-*/;
	/**
	 * stops all animations on this shape
	 * @return
	 */
	public final native Shape stop()/*-{
		return this.pause();
	}-*/;
	/**
	 * stops animation
	 * @param a - animation to stop.
	 * @return
	 */
	public final native Shape stop(Animation a)/*-{
		return this.pause(a);
	}-*/;

	/**Resumes animation if it was paused with Element.pause method. */
	public final native Shape resume()/*-{
		return this.resume();
	}-*/;
	/**Resumes animation if it was paused with Element.pause method. */
	public final native Shape resume(Animation a)/*-{
		return this.resume(a);
	}-*/;
//	public final native Annimation getAnimationStatus
	/**
	 * sets the status of animation of the element. 
	 * @param anim animation object
	 * @param val 0 – 1.  works like a setter and sets the status of a given animation to the value. This will cause animation to jump to the given position.
	 * @return
	 */
	public final native Shape setAnimStatus(Animation anim, double val)/*-{
		return this.status(anim, val);
	}-*/;
	/**
	 * get an animation status
	 * @param anim animation object
	 * @return the animation status
	 */
	public final native double getAnimStatus(Animation anim)/*-{
		return this.status(anim);
	}-*/;
	/**
	 * get all the animations status of this shape
	 */
	public final native JsArray<AnimStatus> getAnimStatus()/*-{
		return this.status();
	}-*/;
	
	
	
	
	
	/**
	 * Return set of elements that create glow-like effect around given element. See Paper.set.

Note: Glow is not connected to the element. If you change element attributes it won’t adjust itself. 
	 * @param glow
	 * @return
	 */
	public final native Set glow(Glow glow)/*-{
//		var dump = function(o) {
//			var s = "{";
//			for(var i in o) {
//				s+=i+"("+typeof(o[i])+"): "+o[i]+", ";
//			}
//			return s+"}";
//		};
		
		var g = glow.@org.sgx.raphael4gwt.raphael.base.Glow::getNative()();
//		$wnd.alert(dump(g));
		return this.glow(g);
		//return this.glow(glow);
	}-*/;


	

	
	
	
	/* *** DATA *** */
	
	/**
	 * Adds given value asociated with given key	
	 * @param key key to store data
	 * @param value value to store
	 */
	public final native void setData(String key, Object value)/*-{
		this.data(key, value);
	}-*/;
	
	/**
	 * retrieves given value asociated with given key	
	 * @param key
	 * @return
	 */
	public final native  Object getData(String key)/*-{
		return this.data(key);
	}-*/;
	
	/**
	 * Unique id of the element. Especially usesful when you want to listen to events of the element, because all events are fired in format <module>.<action>.<id>. Also useful for Paper.getById method. 
	 */
	public final native String getId()/*-{
		this.id;
	}-*/;
	/**Unique id of the element. Especially usesful when you want to listen to events of the element, because all events are fired in format <module>.<action>.<id>. Also useful for Paper.getById method. */
	public final native void setId(String id)/*-{
		this.id=id;
	}-*/;
	/**
	 *  removes all the data of the element. 
	 */
	public final native Shape removeData()/*-{
		return this.removeData();
	}-*/;
	
	/**Removes value associated with an element by given key.*/ 
	public final native Shape removeData(String key)/*-{
		return this.removeData(key);
	}-*/;
}
