package org.sgx.raphael4gwt.raphael.wrap;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.AnimKeyFrames;
import org.sgx.raphael4gwt.raphael.base.AnimStatus;
import org.sgx.raphael4gwt.raphael.base.Animation;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Glow;
import org.sgx.raphael4gwt.raphael.base.Rectangle;
import org.sgx.raphael4gwt.raphael.event.Callback;
import org.sgx.raphael4gwt.raphael.event.DDListener;
import org.sgx.raphael4gwt.raphael.event.DragOverListener;
import org.sgx.raphael4gwt.raphael.event.HoverListener;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;

/**
 * "real" java wrapper for shapes. 
 * Use this class for safely inherith a raphael Shape and be able of override its methods. 
 * Caution: this is a real wrappers, not GWT overly types so it has little overhead to use. 
 * @author sg
 *
 */
public class ShapeWrapper {
	
Shape shape;

public ShapeWrapper(Shape shape) {
	super();
	this.shape = shape;
}

public Shape getShape() {
	return shape;
}

public void setShape(Shape shape) {
	this.shape = shape;
}



/* following code is generated automatically using eclipse's 
 * Source -> generate Delegate Methods for shape. -modification will be 
 * overrided probably, please edit this class above this.(non-Javadoc)
 * @see java.lang.Object#clone()
 */

public final Shape clone() {
	return shape.clone();
}

public final Rectangle getBBox(boolean isWithoutTransform) {
	return shape.getBBox(isWithoutTransform);
}

public final Rectangle getBBox() {
	return shape.getBBox();
}

public final String getType() {
	return shape.getType();
}

public final Shape rotate(double deg, int cx, int cy) {
	return shape.rotate(deg, cx, cy);
}

public final Shape rotate(double deg) {
	return shape.rotate(deg);
}

public final Shape scale(double sx, double sy, int cx, int cy) {
	return shape.scale(sx, sy, cx, cy);
}

public final Shape scale(double sx, double sy) {
	return shape.scale(sx, sy);
}

public final Shape translate(double dx, double dy) {
	return shape.translate(dx, dy);
}

public final Shape hide() {
	return shape.hide();
}

public final Shape show() {
	return shape.show();
}

public final String getTransform() {
	return shape.getTransform();
}

public final Shape setTransform(String transfStr) {
	return shape.setTransform(transfStr);
}

//public final <T extends JavaScriptObject> T cast() {
//	return shape.cast();
//}

//@SuppressWarnings("unchecked")
//public final <T extends JavaScriptObject> T cast() {
//  return shape.cast(); //(T) this;
//}

public final boolean equals(Object other) {
	return shape.equals(other);
}

public final int hashCode() {
	return shape.hashCode();
}

public String toSource() {
	return shape.toSource();
}

public final String toString() {
	return shape.toString();
}

public final Shape mouseDown(MouseEventListener l) {
	return shape.mouseDown(l);
}

public final Shape unmouseDown(MouseEventListener l) {
	return shape.unmouseDown(l);
}

public final Shape mouseMove(MouseEventListener l) {
	return shape.mouseMove(l);
}

public final Shape mouseMove(MouseEventListener l, int throttle) {
	return shape.mouseMove(l, throttle);
}

public final Shape unmouseMove(MouseEventListener l) {
	return shape.unmouseMove(l);
}

public final Shape click(MouseEventListener l) {
	return shape.click(l);
}

public final Shape unclick(MouseEventListener l) {
	return shape.unclick(l);
}

public final Shape dblclick(MouseEventListener l) {
	return shape.dblclick(l);
}

public final Shape undblclick(MouseEventListener l) {
	return shape.undblclick(l);
}

public final Shape drag(DDListener l) {
	return shape.drag(l);
}

public final Shape drag(DDListener l, int throttle) {
	return shape.drag(l, throttle);
}

public final void undrag() {
	shape.undrag();
}

public final Shape hover(HoverListener l) {
	return shape.hover(l);
}

public final Shape unhover(HoverListener l) {
	return shape.unhover(l);
}

public final void onDragOver(DragOverListener l) {
	shape.onDragOver(l);
}

public final Shape touchCancel(MouseEventListener l) {
	return shape.touchCancel(l);
}

public final Shape unTouchCancel(MouseEventListener l) {
	return shape.unTouchCancel(l);
}

public final Shape touchEnd(MouseEventListener l) {
	return shape.touchEnd(l);
}

public final Shape unTouchEnd(MouseEventListener l) {
	return shape.unTouchEnd(l);
}

public final Shape touchMove(MouseEventListener l) {
	return shape.touchMove(l);
}

public final Shape unTouchMove(MouseEventListener l) {
	return shape.unTouchMove(l);
}

public final Shape touchStart(MouseEventListener l) {
	return shape.touchStart(l);
}

public final Shape unTouchStart(MouseEventListener l) {
	return shape.unTouchStart(l);
}

public final Shape next() {
	return shape.next();
}

public final Shape prev() {
	return shape.prev();
}

public final void remove() {
	shape.remove();
}

public final Element node() {
	return shape.node();
}

public final Paper paper() {
	return shape.paper();
}

public final Shape toBack() {
	return shape.toBack();
}

public final Shape toFront() {
	return shape.toFront();
}

public final Shape insertAfter(Shape s) {
	return shape.insertAfter(s);
}

public final Shape insertBefore(Shape s) {
	return shape.insertBefore(s);
}

public final boolean isPointInside(double x, double y) {
	return shape.isPointInside(x, y);
}

public final Shape setAttribute(String name, int value) {
	return shape.setAttribute(name, value);
}

public final Shape setAttribute(String name, String value) {
	return shape.setAttribute(name, value);
}

public final Shape setAttribute(String name, double value) {
	return shape.setAttribute(name, value);
}

public final String getAttribute(String name) {
	return shape.getAttribute(name);
}

public final Shape attr(Attrs attrs) {
	return shape.attr(attrs);
}

public final Shape attr(String name, String val) {
	return shape.attr(name, val);
}

public final Shape attr(String name, double val) {
	return shape.attr(name, val);
}

public final String attr(String name) {
	return shape.attr(name);
}

public final Attrs attr() {
	return shape.attr();
}

public final Shape animate(Animation a) {
	return shape.animate(a);
}

public final Shape animate(Attrs attrs, int ms, String easing) {
	return shape.animate(attrs, ms, easing);
}

public final Shape animate(Attrs attrs, int ms) {
	return shape.animate(attrs, ms);
}

public final Shape animate(Attrs attrs, int ms, String easing, Callback callback) {
	return shape.animate(attrs, ms, easing, callback);
}

public final Shape animate(AnimKeyFrames kf, int ms) {
	return shape.animate(kf, ms);
}

public final Shape animateWith(Shape el, Animation anim, Animation animation) {
	return shape.animateWith(el, anim, animation);
}

public final Shape pause() {
	return shape.pause();
}

public final Shape pause(Animation a) {
	return shape.pause(a);
}

public final Shape stop() {
	return shape.stop();
}

public final Shape stop(Animation a) {
	return shape.stop(a);
}

public final Shape resume() {
	return shape.resume();
}

public final Shape resume(Animation a) {
	return shape.resume(a);
}

public final Shape setAnimStatus(Animation anim, double val) {
	return shape.setAnimStatus(anim, val);
}

public final double getAnimStatus(Animation anim) {
	return shape.getAnimStatus(anim);
}

public final JsArray<AnimStatus> getAnimStatus() {
	return shape.getAnimStatus();
}

public final Set glow(Glow glow) {
	return shape.glow(glow);
}

public final void setData(String key, Object value) {
	shape.setData(key, value);
}

public final Object getData(String key) {
	return shape.getData(key);
}

public final int getId() {
	return shape.getId();
}

public final void setId(String id) {
	shape.setId(id);
}

public final Shape removeData() {
	return shape.removeData();
}

public final Shape removeData(String key) {
	return shape.removeData(key);
}

//public final Shape blur(double blurSize) {
//	return shape.blur(blurSize);
//}
//
//public final Shape emboss(double bias) {
//	return shape.emboss(bias);
//}
//
//public final Shape convolve(String convolutionName, int kernelXSize,
//		double[] kernel, double divisor, double bias) {
//	return shape.convolve(convolutionName, kernelXSize, kernel, divisor, bias);
//}
//
//public final Shape convolveClear(String convolutionName) {
//	return shape.convolveClear(convolutionName);
//}
//
//public final Shape convolveClearAll() {
//	return shape.convolveClearAll();
//}
//
//public final Shape emboss2(double factor, String orientation, double divisor,
//		double bias) {
//	return shape.emboss2(factor, orientation, divisor, bias);
//}
//
//public final Shape emboss2(double factor, String orientation) {
//	return shape.emboss2(factor, orientation);
//}
//
//public final Shape convolveSobel(double size, double multiplier,
//		double divisor, double bias) {
//	return shape.convolveSobel(size, multiplier, divisor, bias);
//}
//
//public final Shape convolveSobel(double size, double multiplier) {
//	return shape.convolveSobel(size, multiplier);
//}

public final JsArray<Attrs> writeToObject() {
	return shape.writeToObject();
}

public final String writeToString() {
	return shape.writeToString();
}

public final Set asSet() {
	return shape.asSet();
}

public final boolean isRemoved() {
	return shape.isRemoved();
}



}
