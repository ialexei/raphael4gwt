package org.sgx.raphael4gwt.graphael;

import org.sgx.raphael4gwt.raphael.RaphaelLoader;

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
public class GRaphaelLoader {
	// public static interface Listener {
	// /**
	// * @param error if not null then it is the cause of an error and means that probably
	// * raphael4gwt required script couln't be loaded
	// */
	// void loaded(Exception error);
	// }
	public static interface RaphaelScripts extends ClientBundle {
		public static RaphaelScripts instance = GWT.create(RaphaelScripts.class);

		@Source("scripts/g.raphael.all-min.js")
		ExternalTextResource graphael4gwtallminjs();
	}

	protected static boolean graphaelLoaded = false;

	public static void loadGRaphael(final RaphaelLoader.Listener l) {
		if (graphaelLoaded) {
			l.loaded(null);
		}
		RaphaelLoader.loadRaphael(new RaphaelLoader.Listener() {
			@Override
			public void loaded(Exception error) {
				if (error != null) {
					l.loaded(error);
				} 
				else {
					try {
						RaphaelScripts.instance.graphael4gwtallminjs().getText(new ResourceCallback<TextResource>() {
							@Override
							public void onSuccess(TextResource r) {
								ScriptInjector.fromString(r.getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
								graphaelLoaded = true;
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
			}
		});
	}

}
