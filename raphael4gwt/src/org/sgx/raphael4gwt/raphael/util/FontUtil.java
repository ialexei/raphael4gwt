package org.sgx.raphael4gwt.raphael.util;

import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;

public class FontUtil {
	public static void loadFont(String fontJsUrl, Callback<Void, Exception> c) {
		ScriptInjector.fromUrl(fontJsUrl).setWindow(JsUtil.window()).setCallback(c).inject();
	}

	public static void loadFont(TextResource fontJs) {
		String text = fontJs.getText(); 
		System.out.println("loadFont "+text.length());
		ScriptInjector.fromString(text).setWindow(JsUtil.window()).inject();
	}

	public static void loadFont(ExternalTextResource fontJs, final ResourceCallback<TextResource> callback)
			throws ResourceException {
		fontJs.getText(new ResourceCallback<TextResource>() {

			@Override
			public void onSuccess(TextResource resource) {
				loadFont(resource);
				if (callback != null)
					callback.onSuccess(resource);
			}

			@Override
			public void onError(ResourceException e) {
				if (callback != null)
					callback.onError(e);
			}
		});
	}

}
