package org.sgx.raphael4gwt.raphael;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;

/**
 * an utility for loading raphaeljs async
 * @author sg
 *
 */
public class RaphaelLoader {
	public static interface Listener {
		/**
		 * @param error if not null then it is the cause of an error and means that probably 
		 * raphael4gwt required script couln't be loaded
		 */
		void loaded(Exception error);
	}
	public static interface RaphaelScripts extends ClientBundle {
		public static RaphaelScripts instance = GWT.create(RaphaelScripts.class);

		@Source("scripts/raphael4gwt-all-min.js")
		ExternalTextResource raphael4gwtallminjs();
	}
	protected static boolean raphaelLoaded = false;

	public static void loadRaphael(final Listener l) {		
		try {
			RaphaelScripts.instance.raphael4gwtallminjs().getText(new ResourceCallback<TextResource>() {				
				@Override
				public void onSuccess(TextResource r) {
					ScriptInjector.fromString(r.getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
					l.loaded(null); 
					raphaelLoaded =true;
				}				
				@Override
				public void onError(ResourceException e) {
					l.loaded(e); 
				}
			});
		} catch (ResourceException e) {
			l.loaded(e); 
		} 
	}
	
	public static void loadGRaphael(final Listener l) {	
		loadRaphael(new Listener() {			
			@Override
			public void loaded(Exception error) {
				if(error!=null){
					l.loaded(error); 
				}
				try {
					RaphaelScripts.instance.raphael4gwtallminjs().getText(new ResourceCallback<TextResource>() {						
						@Override
						public void onSuccess(TextResource r) {
							ScriptInjector.fromString(r.getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
							l.loaded(null); 
						}						
						@Override
						public void onError(ResourceException e) {
							l.loaded(e); 
						}
					});
				} catch (ResourceException e) {
					l.loaded(e); 
				} 
			}
		});
	}

}
