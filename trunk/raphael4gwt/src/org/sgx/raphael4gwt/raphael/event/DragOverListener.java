package org.sgx.raphael4gwt.raphael.event;

import org.sgx.raphael4gwt.raphael.Shape;

public interface DragOverListener {
	/**
	 * 
	 * @param src the element is being dragged over this.
	 */
	void dragOver(Shape src);
}
