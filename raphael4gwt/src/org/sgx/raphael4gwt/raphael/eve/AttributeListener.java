package org.sgx.raphael4gwt.raphael.eve;

import com.google.gwt.core.client.JsArrayMixed;
/**
 * @author sg
 */
public abstract class AttributeListener extends EveListener<AttributeChangeEvent> {

//	@Override
//	public Object callNative(JsArrayMixed jsa) {
//		AttributeChangeEvent e = new AttributeChangeEvent("");
//		e.fromJsArray(jsa);
//		return call(e);
//	}
	
	@Override
	public EveEventInstantiator<AttributeChangeEvent> getEventInstantiator() {
		return new EveEventInstantiator<AttributeChangeEvent>() {			
			@Override
			public EveEvent instantiate() {
				return new AttributeChangeEvent();
			}
		};
	}
}
