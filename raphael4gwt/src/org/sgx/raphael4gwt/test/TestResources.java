package org.sgx.raphael4gwt.test;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.ui.ValueBoxBase;

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
	  
	  @Source("FreeTransformTest2.java")
	  public TextResource FreeTransformTest2();
	  
	  
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
	  
	  @Source("EveAttrChangeTest1.java")
	  public TextResource AttrChangeListenerTest1();
	  
	  @Source("SetTest2.java")
	  public TextResource SetTest2();
	  
	  @Source("ShapeUnitTest1.java")
	  public TextResource ShapeUnitTest1();
	  
	  @Source("PathCmdsTest1.java")
	  public TextResource PathCmdsTest1();
	  
	  @Source("LivePathTest.java")
	  public TextResource LivePathTest();
	  
	  @Source("PaperLoadAndSave.java")
	  public TextResource PaperLoadAndSave();
	  
	  @Source("PaperLoadAndSaveUnit1.java")
	  public TextResource PaperLoadAndSaveUnit1();
	  
	  @Source("CustomAttributesTest1.java")
	  public TextResource CustomAttributesTest1();
	  
	  @Source("AnimKeyframesTest1.java")
	  public TextResource AnimKeyframesTest1();
	  
	  @Source("EveCustomEvents.java")
	  public TextResource EveTest1();

	  @Source("TextSelectionPreventTest.java")
	  public TextResource TextSelectionPreventTest();
	  
	  @Source("PaperViewBoxTest1.java")
	  public TextResource PaperViewportTest1();

	  @Source("SVGImportTest1.java")
	  public TextResource SVGImportTest1();
	  
	  @Source("SVGExportTest1.java")
	  public TextResource SVGExportTest1();
	  
	  @Source("AttributesTest1.java")
	  public TextResource AttributesTest1();
	  
	  @Source("EveEventsTest1.java")
	  public TextResource EveEventsTest1();

	  @Source("EveShapeCreateRemoveTest1.java")
	  public TextResource EveShapeCreateRemoveTest1();
	  
	  @Source("ComponentTransferLinearTest1.java")
	  public TextResource ComponentTransferLinearTest1();

	  @Source("PathObjectTest1.java")
	  public TextResource PathObjectTest1();

	  @Source("SvgFiltersTest1.java")
	  public TextResource SvgFiltersTest1();
	  
	  @Source("SvgFiltersTest2.java")
	  public TextResource SvgFiltersTest2();	  
	  
	  @Source("CSSTest1.java")
	  public TextResource CSSTest1();
	  
	  @Source("SetGlowing1.java")
	  public TextResource SetGlowing1();
}
