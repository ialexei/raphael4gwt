package org.sgx.raphael4gwt.raphael.eve;

/**
 * @author sg
 */
public abstract class MouseEveListener extends EveListener<MouseEveEvent> {

	@Override
	public EveEventInstantiator<MouseEveEvent> getEventInstantiator() {
		return new EveEventInstantiator<MouseEveEvent>() {			
			@Override
			public EveEvent instantiate() {
				return new MouseEveEvent();
			}
		};
	}
}
