package org.sgx.raphael4gwt.test.font;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.TextResource;

public interface TestImageResources extends ClientBundle {
  TestImageResources INSTANCE = GWT.create(TestImageResources.class);

  @Source("Anchor_Steam_NF_400.font.js")
  TextResource AnchorSteamNF400();
}
