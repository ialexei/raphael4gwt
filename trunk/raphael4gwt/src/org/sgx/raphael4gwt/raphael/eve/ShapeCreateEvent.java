package org.sgx.raphael4gwt.raphael.eve;

import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
/**
 * eve event raphael.elementCreate.type.id - arguments [shapeType, shapeAttrs]
 * 
 * TODO: method getShapeId() using eve.th() for guessing the .id from event name.
 *  
 * @author sg
 *
 */
public class ShapeCreateEvent extends AbstractEveEvent {

	public String getShapeType() {
		return params.getString(0);
	}
	
	public Attrs getShapeAttributes() {
		return params.getObject(1).cast();
	}
	
	@Override
	public String getName() {
		return "raphael.elementCreate."+getShapeType();
	}

	@Override
	public Shape getShape() {
		return getNativeContext().cast();
	}

}
