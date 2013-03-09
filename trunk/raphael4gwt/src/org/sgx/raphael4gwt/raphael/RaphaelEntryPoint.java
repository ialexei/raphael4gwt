package org.sgx.raphael4gwt.raphael;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public class RaphaelEntryPoint implements EntryPoint {

	/*
	 * raphael javascript loading using a TextResource and ScriptInjector.fromString(), not using the unsuported <script> in gwt.xml
	 */

	public interface RaphaelScripts extends ClientBundle {

		public static RaphaelScripts instance = GWT.create(RaphaelScripts.class);

		@Source("scripts/raphael4gwt-all-min.js")
		TextResource raphael4gwtallminjs();

	}

	public static void loadRaphaelJs() {
		String text = 
//				RaphaelScripts.instance.raphaelminjs().getText() + ";"+ 
				RaphaelScripts.instance.raphael4gwtallminjs().getText();
		ScriptInjector.fromString(text).setWindow(ScriptInjector.TOP_WINDOW).inject();
	}

	@Override
	public void onModuleLoad() {
		loadRaphaelJs();
	}

}
