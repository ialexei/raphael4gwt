package org.sgx.raphael4gwt.test.image;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;

public interface TestImageResources extends ClientBundle {
  TestImageResources INSTANCE = GWT.create(TestImageResources.class);

  @ImageOptions(preventInlining=true)
  @Source("smallLion.png")
  ImageResource smallLion();
  
  @ImageOptions(preventInlining=true)
  @Source("edit16.png")
  ImageResource edit16();
  
  @ImageOptions(preventInlining=true)
  @Source("preferences.gif")
  ImageResource preferences();
}
