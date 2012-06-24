package org.sgx.raphael4gwt.raphael.wrap;

import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;

import com.google.gwt.core.client.JsArray;
/**
 * "real" java set wrapper . @see ShapeWrapper
 * @author sg
 *
 */
public class SetWrapper extends ShapeWrapper {

	public SetWrapper(Shape shape) {
		super(shape);
	}
	
	public Set getSet() {
		return (Set) getShape();
	}

/* following code is generated automatically using eclipse's 
 * Source -> generate Delegate Methods for shape. -modification will be 
 * overrided probably, please edit this class above this.(non-Javadoc)
 * @see java.lang.Object#clone()
 */

	public final void clear() {
		getSet().clear();
	}

	public final boolean exclude(Shape s) {
		return getSet().exclude(s);
	}

	public final Set forEach(ForEachCallback c) {
		return getSet().forEach(c);
	}

	public final Shape pop() {
		return getSet().pop();
	}

	public final Set push(Shape s) {
		return getSet().push(s);
	}

	public final Set push(JsArray<Shape> shapes) {
		return getSet().push(shapes);
	}

	public final int size() {
		return getSet().size();
	}

	public final Set splice(int index, int count) {
		return getSet().splice(index, count);
	}

	public final Set splice(int index, int count, Set s2) {
		return getSet().splice(index, count, s2);
	}

	public final String print() {
		return getSet().print();
	}

	public final Set intersect(Set other) {
		return getSet().intersect(other);
	}

	public final boolean contains(Shape s) {
		return getSet().contains(s);
	}

	public final boolean containsAll(Set other) {
		return getSet().containsAll(other);
	}

	public final Set add(Set other) {
		return getSet().add(other);
	}

	public final Set substract(Set other) {
		return getSet().substract(other);
	}

	public final Set filter(ForEachCallback c) {
		return getSet().filter(c);
	}

	public final Shape firstShape() {
		return getSet().firstShape();
	}

	public final Shape item(int index) {
		return getSet().item(index);
	}

	public String toSource() {
		return getSet().toSource();
	}
	
	
}
