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
	  
//	  @Source("PathSimpleTest1.java")
//	  public TextResource PathSimpleTest1();
	  
	  @Source("ImageSimpleTest.java")
	  public TextResource ImageSimpleTest();
	  
	  @Source("AllPathIcons.java")
	  public TextResource AllPathIcons();
	  
	  @Source("AnimTransformAndPathTest1.java")
	  public TextResource AnimTransformAndPathTest1();
	  
	  @Source("SetSimpleTest1.java")
	  public TextResource SetSimpleTest1();
	  
	  @Source("FillTest1.java")
	  public TextResource FillTest1();
	  
	  @Source("GradientTest1.java")
	  public TextResource GradientTest1();
	  
	  @Source("FontTest1.java")
	  public TextResource FontTest1();
	  	  
	  @Source("GradientMouseTest1.java")
	  public TextResource GradientMouseTest1();
	  
	  @Source("MouseRelativeCoordsTest.java")
	  public TextResource MouseRelativeCoordsTest();
	  
	  @Source("DragTest1.java")
	  public TextResource DragTest1();
	  
	  @Source("FreeTransformTest1.java")
	  public TextResource FreeTransformTest1();
	  
	  @Source("AllMouseEvents.java")
	  public TextResource AllMouseEvents();
	  
	  @Source("PathEditorTest1.java")
	  public TextResource PathEditorTest1();
	  
	  @Source("PrintLettersOnPath.java")
	  public TextResource PrintLettersOnPath();
	  
	  @Source("BlurAndEmbossTest1.java")
	  public TextResource BlurAndEmbossTest1();
	  
	  @Source("ImageTransforms1.java")
	  public TextResource ImageTransforms1();
	  
	  @Source("MouseCoordsOnHoverTest.java")
	  public TextResource MouseCoordsOnHoverTest();
	  
	  @Source("DrawAndClick.java")
	  public TextResource DrawAndClick();
	  
	  @Source("ShapeEditor1.java")
	  public TextResource ShapeEditor1();
	  
	  @Source("AttrChangeListenerTest1.java")
	  public TextResource AttrChangeListenerTest1();
	  
	  @Source("SetTest2.java")
	  public TextResource SetTest2();
	  
	  @Source("ShapeUnitTest1.java")
	  public TextResource ShapeUnitTest1();
	  
	  @Source("PathCmdsTest1.java")
	  public TextResource PathCmdsTest1();
	  
	  @Source("LivePathTest.java")
	  public TextResource LivePathTest();
}
