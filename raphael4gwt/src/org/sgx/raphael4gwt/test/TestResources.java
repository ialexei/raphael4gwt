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
	  
	  @Source("PathSimpleTest1.java")
	  public TextResource PathSimpleTest1();
	  
	  @Source("ImageSimpleTest.java")
	  public TextResource ImageSimpleTest();
	  
	  @Source("AllPathIcons.java")
	  public TextResource AllPathIcons();
	  
	  @Source("AnimTransformAndPathTest1.java")
	  public TextResource AnimTransformAndPathTest1();
	  
	  @Source("SetSimpleTest1.java")
	  public TextResource SetSimpleTest1();
}
