package org.sgx.raphael4gwt.raphy.client;

import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.Window;

public class RaphyChartsEntryPoint implements EntryPoint {

	/*
	 * graphael javascript loading using a TextResource and ScriptInjector.fromString(), not using the unsuported <script> in gwt.xml
	 */

	public interface RaphyChartsScripts extends ClientBundle {

		public static RaphyChartsScripts instance = GWT.create(RaphyChartsScripts.class);

		@Source("scripts/raphycharts-all-min.js")
		TextResource raphyCharts();
	}

	public static void loadRaphyChartsScripts() {
		String text = RaphyChartsScripts.instance.raphyCharts().getText();
		ScriptInjector.fromString(text).setWindow(JsUtil.window().cast()).inject();
	}

	@Override
	public void onModuleLoad() {
		loadRaphyChartsScripts();
	}

}
