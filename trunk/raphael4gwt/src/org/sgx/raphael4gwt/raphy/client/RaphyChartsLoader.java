package org.sgx.raphael4gwt.raphy.client;

import org.sgx.raphael4gwt.raphael.RaphaelLoader;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.resources.client.ClientBundle.Source;

/**
 * an utility for loading raphaeljs async
 * 
 * @author sg
 * 
 */
public class RaphyChartsLoader {
	public static interface Listener {
		/**
		 * @param error
		 *            if not null then it is the cause of an error and means that probably raphael4gwt required script couln't be loaded
		 */
		void loaded(Exception error);
	}
	public static interface RaphyScripts extends ClientBundle {
		public static RaphyScripts instance = GWT.create(RaphyScripts.class);
		
		@Source("scripts/raphycharts-all-min.js")
		ExternalTextResource raphyCharts();
	}

	protected static boolean loaded = false;

	public static void loadRaphy(final Listener l) {
		if (loaded) {
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
						RaphyScripts.instance.raphyCharts().getText(new ResourceCallback<TextResource>() {
							@Override
							public void onSuccess(TextResource r) {
								ScriptInjector.fromString(r.getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
								loaded = true;
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
