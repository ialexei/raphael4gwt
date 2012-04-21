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
public native final boolean exclude(Shape s)/*-{
	var b = this.exclude(s)
	if(b)return true;
	else return false; 
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
	var f = function(){
		var ret = $entry(function(shape, index){
			return c.@org.sgx.raphael4gwt.raphael.event.ForEachCallback::call(Lorg/sgx/raphael4gwt/raphael/Shape;I)(shape, index);
		}).apply(this, arguments);
		ret = $wnd.r4g._castToBoolean(ret);
		return ret;
	};
	return this.forEach(f);
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
///**
// * @return the array of shapes that constitute this set.
// */
//public native final JsArray<Shape> items()/*-{
//	return this.items;
//}-*/;
///**
// * @return the array of shapes that constitute this set.
// */
//public native final Shape item(int i)/*-{
//	return this.items[i];
//}-*/;

/**
 * Removes given element from the set 
 * @param index position of the deletion
 * @param count number of element to remove
 * @return set elements that were deleted
 */
public native final Set splice(int index, int count)/*-{
	return this.splice(index, count);
}-*/;
/**http://raphaeljs.com/reference.html#Set.splice
 * replaces given element from the set with s2
 * @param index position of the deletion
 * @param count number of element to remove
 * @return set elements that were deleted
 */
public native final Set splice(int index, int count, Set s2)/*-{ 
	var args = [index, count];
	for(var i = 0; i< s2.length; i++) {
		args.push(s2[i]);
	}
	return this.splice.apply(this, args);
}-*/;

//extensions

/**
 * @return the types of the shapes this set contains
 */
public native final String print()/*-{
	var s = "Set(";
	for(var i = 0; i<this.length; i++) {
		s+=(this[i].type?this[i].type:"undef")+", ";
	}
	return s+")";
}-*/;

public native final Set intersect(Set other)/*-{
	return this.intersect(other);
}-*/;
public native final boolean contains(Shape s)/*-{
	return this.contains(s);
}-*/;
public native final boolean containsAll(Set other)/*-{
	return this.containsAll(other);
}-*/;
public native final Set add(Set other)/*-{
	return this.add(other);
}-*/;

public native final Set substract(Set other)/*-{
	return this.add(other);
}-*/;

/**
 * @return this set with all elements for which f return true removed.
 */
public native final Set remove(ForEachCallback c)/*-{
	var f = function(){
		var ret = $entry(function(shape, index){
			return c.@org.sgx.raphael4gwt.raphael.event.ForEachCallback::call(Lorg/sgx/raphael4gwt/raphael/Shape;I)(shape, index);
		}).apply(this, arguments);
		ret = $wnd.r4g._castToBoolean(ret);
		return ret;
	};
	return this.remove(f);
}-*/;

}
