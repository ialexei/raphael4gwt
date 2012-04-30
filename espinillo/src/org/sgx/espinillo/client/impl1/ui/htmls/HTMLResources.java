package org.sgx.espinillo.client.impl1.ui.htmls;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface HTMLResources extends ClientBundle {
	  public static final HTMLResources INSTANCE =  GWT.create(HTMLResources.class);
	  
	  @Source("aboutDialog.html")
	  public TextResource aboutDialog();	  
}
