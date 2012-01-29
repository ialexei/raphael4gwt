package org.sgx.raphael4gwt.test;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface TestResources extends ClientBundle {
	  public static final TestResources INSTANCE =  GWT.create(TestResources.class);
	  
	  @Source("CircleGlowingAndDraggin.java")
	  public TextResource CircleGlowingAndDraggin();
	  
	  @Source("EventRegisterAndUnregister.java")
	  public TextResource EventRegisterAndUnregister();
	  
}
