package org.sgx.raphael4gwt.test.gallery;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.resources.client.ImageResource.ImageOptions;

public interface GalleryResources extends ClientBundle {
  GalleryResources INSTANCE = GWT.create(GalleryResources.class);

  @ImageOptions(preventInlining=true)
  @Source("res/images/smallLion.png")
  ImageResource smallLion();
  
  @ImageOptions(preventInlining=true)
  @Source("res/images/edit16.png")
  ImageResource edit16();
  
  @ImageOptions(preventInlining=true)
  @Source("res/images/preferences.gif")
  ImageResource preferences();
  

	@Source("res/fonts/Anchor_Steam_NF_400.font.js")
	ExternalTextResource FontAnchorSteam();
	
	@Source("res/fonts/Phorssa_400.font.js")
	ExternalTextResource FontPhorssa();
}
