package org.sgx.raphael4gwt.test.graphael.gallery.tests;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface TestResources extends ClientBundle {
	  public static final TestResources INSTANCE =  GWT.create(TestResources.class);
	  
	  @Source("PieChartTest1.java")
	  public TextResource PieChartTest1();
	  
}
