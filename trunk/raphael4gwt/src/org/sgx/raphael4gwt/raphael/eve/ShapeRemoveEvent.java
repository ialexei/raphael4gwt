package org.sgx.raphael4gwt.raphael.eve;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
/**
 * eve event raphael.elementRemove.type.id - arguments [paper, removedShapeId]
 *  
 * @author sg
 *
 */
public class ShapeRemoveEvent extends AbstractEveEvent {

	public String getShapeId() {
		return params.getString(1);
	}
	
	public Paper getPaper() {
		return params.getObject(0).cast();
	}
	
	@Override
	public String getName() {
		return "raphael.elementRemove."+getShapeType();
	}

	public String getShapeType() {
		return params.getString(1);
	}

	@Override
	public Shape getShape() {
		return getNativeContext().cast();
	}

}
