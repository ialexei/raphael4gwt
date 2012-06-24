package org.sgx.raphael4gwt.raphael.eve;

import org.sgx.raphael4gwt.raphael.Shape;

import com.google.gwt.dom.client.NativeEvent;
/**
 * context: the sape - params []
 * @author sebastian
 *
 */
public class MouseEveEvent extends AbstractEveEvent {

	public final String CLICK="click", 
		DBLCLICK="dblclick", 
		MOUSEUP="mouseup", 
		MOUSEDOWN="mousedown";	

	@Override
	public String getName() {
		return "raphael.event."+getEventType()+"."+getShape().getId();
	}
	
	public String getEventType() {
		return getNativeParams().getString(0);
	}
	public void setEvenType(String et) {
		getNativeParams().set(0, et); 
	}
	
	public double getX() {
		return getNativeParams().getNumber(1);
	}
	public void setX(double x) {
		getNativeParams().set(1, x); 
	}
	public double getY() {
		return getNativeParams().getNumber(2);
	}
	public NativeEvent getEvent() {
		return getNativeParams().getObject(3).cast();
	}
	@Override
	public Shape getShape() {
		return getNativeContext().cast();
	}
}
