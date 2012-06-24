package org.sgx.raphael4gwt.raphael.eve;

/**
 * @author sg
 */
public abstract class AttrChangeListener extends EveListener<AttrChangeEvent> {

	@Override
	public EveEventInstantiator<AttrChangeEvent> getEventInstantiator() {
		return new EveEventInstantiator<AttrChangeEvent>() {			
			@Override
			public EveEvent instantiate() {
				return new AttrChangeEvent();
			}
		};
	}
}
