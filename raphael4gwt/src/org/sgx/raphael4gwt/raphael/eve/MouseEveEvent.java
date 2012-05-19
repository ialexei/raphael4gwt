package org.sgx.raphael4gwt.raphael.eve;

import org.sgx.raphael4gwt.raphael.Shape;

import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.dom.client.NativeEvent;

public class MouseEveEvent implements EveEvent {

	public final String TYPE_CLICK="click", 
		TYPE_DBLCLICK="dblclick", 
		TYPE_MOUSEUP="mouseup";
	
	String eventType;	
	int x, y;
	NativeEvent event;
	Shape shape;
	
	public MouseEveEvent(String eventType, int x, int y, NativeEvent event, Shape s) {
		super();
		this.eventType = eventType;
		this.x = x;
		this.y = y;
		this.event = event;
		this.shape=s;
	}

	@Override
	public String getName() {
		return "raphael.event."+eventType;
	}
	
	@Override
	public void fromJsArray(JsArrayMixed jsa) {
//		eve("raphael.event." + type + "." + element.id, element, type, x, y, e, element);
		if(jsa.length()==5) {
			eventType=jsa.getString(0);
			x=(int) jsa.getNumber(1);
			y=(int) jsa.getNumber(2);
			event = jsa.getObject(3);
			shape = jsa.getObject(4);
		}
	}

	@Override
	public JsArrayMixed toJsArray() {
		JsArrayMixed jsa = JsArrayMixed.createArray().<JsArrayMixed>cast();
		jsa.push(eventType);
		jsa.push(x);
		jsa.push(y);
		jsa.push(event);
		jsa.push(shape);
		return jsa;
	}

	@Override
	public Shape getShape() {
		return shape;
	}

}
