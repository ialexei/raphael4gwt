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
 * 
 * @author sg
 * 
 */
public class RaphaelLoader {
	public static interface Listener {
		/**
		 * @param error
		 *            if not null then it is the cause of an error and means that probably raphael4gwt required script couln't be loaded
		 */
		void loaded(Exception error);
	}

	public static interface RaphaelScripts extends ClientBundle {
		public static RaphaelScripts instance = GWT.create(RaphaelScripts.class);

		@Source("scripts/raphael4gwt-all-min.js")
		ExternalTextResource raphael4gwtallminjs();
		
		@Source("scripts/raphael4gwt-all.js")
		ExternalTextResource raphael4gwtalljs();

		// @Source("../graphael/scripts/g.raphael.all-min.js")
		// ExternalTextResource graphael4gwtallminjs();
	}

	protected static boolean raphaelLoaded = false;

	public static void loadRaphael(final Listener l) {
		loadRaphaelFrom(l, RaphaelScripts.instance.raphael4gwtallminjs());
//		loadRaphaelFrom(l, "raphael4gwt-all-min.js"); 
	}
	
	public static void loadRaphaelDebug(final Listener l) {
		loadRaphaelFrom(l, RaphaelScripts.instance.raphael4gwtalljs());		
//		loadRaphaelFrom(l, "raphael4gwt-all.js"); 
	}
	
	public static void loadRaphaelFrom(final Listener l, String url) {
		if (raphaelLoaded) {
			l.loaded(null);
		} else {
			ScriptInjector.fromUrl(url).setWindow(ScriptInjector.TOP_WINDOW)
			.setCallback(new com.google.gwt.core.client.Callback<Void, Exception>() {				
				@Override
				public void onSuccess(Void result) {
					l.loaded(null); 
				}				
				@Override
				public void onFailure(Exception reason) {
					l.loaded(reason); 
				}
			}).inject();
		}
	}
	
	public static void loadRaphaelFrom(final Listener l, ExternalTextResource res) {
		if (raphaelLoaded) {
			l.loaded(null);
		} else {
			try {
				res.getText(new ResourceCallback<TextResource>() {
					@Override
					public void onSuccess(TextResource r) {
						ScriptInjector.fromString(r.getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
						l.loaded(null);
						raphaelLoaded = true;
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
	}

	
}
