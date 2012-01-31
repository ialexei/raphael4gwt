package org.sgx.raphael4gwt.raphael.event;

import org.sgx.raphael4gwt.raphael.Shape;

public interface ForEachCallback {
	/**
	 * @param shape current shape in the set we are iterating on
	 * @param index - the index of current shape in the set (push/pop order)
	 * @return false in the case you want to stop the foreach loop. For keep looping return true;
	 */
	boolean call(Shape shape, int index);
}
