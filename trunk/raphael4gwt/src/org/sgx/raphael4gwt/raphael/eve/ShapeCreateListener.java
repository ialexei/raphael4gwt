package org.sgx.raphael4gwt.raphael.eve;

/**
 * @author sg
 */
public abstract class ShapeCreateListener extends EveListener<ShapeCreateEvent> {

	@Override
	public EveEventInstantiator<ShapeCreateEvent> getEventInstantiator() {
		return new EveEventInstantiator<ShapeCreateEvent>() {			
			@Override
			public EveEvent instantiate() {
				return new ShapeCreateEvent();
			}
		};
	}
}
