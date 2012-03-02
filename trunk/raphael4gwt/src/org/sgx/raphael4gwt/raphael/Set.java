package org.sgx.raphael4gwt.raphael;

import java.util.Collection;

import org.sgx.raphael4gwt.raphael.event.ForEachCallback;

import com.google.gwt.core.client.JsArray;

public class Set extends Shape {
protected Set(){}

/**
 * Removes all elements from the set 
 */
public native final void clear()/*-{
	this.clear();
}-*/;

/**
 * Removes given element from the set
 * @param s shape to be removed from the set
 * @return true if object was found & removed from the set
 */
public native final boolean excludes(Shape s)/*-{
	return this.excludes(s);
}-*/;

/**
 * Executes given ForEachCallback for each element in the set. If ForEachCallback returns false it will stop loop running.
 * <br/>Internal note: 
 * <pre>
 *  setproto.forEach = function (callback, thisArg) {
        for (var i = 0, ii = this.items.length; i < ii; i++) {
            if (callback.call(thisArg, this.items[i], i) === false) {
                return this;
            }
        }
        return this;
    };

 * </pre> 
 */
public native final Set forEach(ForEachCallback c)/*-{
	var f = $entry(function(shape, index){
		c.@org.sgx.raphael4gwt.raphael.event.ForEachCallback::call(Lorg/sgx/raphael4gwt/raphael/Shape;I)(shape, index);
	});
	return this.forEach(f, null);
//	return this.forEach(
//		function(shape, index){
//			c.@org.sgx.raphael4gwt.raphael.event.ForEachCallback::call(Lorg/sgx/raphael4gwt/raphael/Shape;I)(shape, index);
//		}, null
//	);
}-*/;
/**
 * Removes last element and returns it
 * @return the removed shape
 */
public native final Shape pop()/*-{
	return this.pop();
}-*/;

/**
 * add shape "on top" of this set
 */
public native final Set push(Shape s)/*-{
	return this.push(s);
}-*/;

/**
 * add shapes "on top" of this set
 */
public native final Set push(JsArray<Shape> shapes)/*-{
	return this.push(shapes);
}-*/;

/**
 * @return the number of items
 */
public native final int size()/*-{
	return this.length;
}-*/;
/**
 * @return the array of shapes that constitute this set.
 */
public native final JsArray<Shape> items()/*-{
	return this.items;
}-*/;
/**
 * @return the array of shapes that constitute this set.
 */
public native final Shape item(int i)/*-{
	return this.items[i];
}-*/;

///**
// * add shapes "on top" of this set
// */
//public native final Set push(Collection<Shape> c)/*-{
//	var arr = [];
//	var it = c.@java.util.Collection::iterator()();
//	while(it.@java.util.Iterator::hasNext()()) {
//		arr.push(it.@java.util.Iterator::next()());
//	}
//	return this.push(arr);
//}-*/;
}
