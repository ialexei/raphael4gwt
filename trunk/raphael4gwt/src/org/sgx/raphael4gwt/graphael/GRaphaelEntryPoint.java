package org.sgx.raphael4gwt.graphael;

import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.Window;

public class GRaphaelEntryPoint implements EntryPoint {

	/*
	 * graphael javascript loading using a TextResource and ScriptInjector.fromString(), not using the unsuported <script> in gwt.xml
	 */

	public interface RaphaelScripts extends ClientBundle {

		public static RaphaelScripts instance = GWT.create(RaphaelScripts.class);

		@Source("scripts/g.raphael.all-min.js")
		TextResource graphaelallminjs();
	}

	public static void loadGRaphaelJs() {
		String text = RaphaelScripts.instance.graphaelallminjs().getText();
		ScriptInjector.fromString(text).setWindow(JsUtil.window().cast()).inject();
	}

	@Override
	public void onModuleLoad() {
		loadGRaphaelJs();
	}

}
