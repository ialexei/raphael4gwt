package org.sgx.raphael4gwt.gtest.gallery.tests;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface TestResources extends ClientBundle {
	  public static final TestResources INSTANCE =  GWT.create(TestResources.class);
	  
	  @Source("PieChartTest1.java")
	  public TextResource PieChartTest1();
	  
	  @Source("BarChartTest1.java")
	  public TextResource BarChartTest1();
	  
	  @Source("DotChartTest1.java")
	  public TextResource DotChartTest1();
	  
	  @Source("BarChartTest2.java")
	  public TextResource BarChartTest2();
	  
	  @Source("BarChartTest3.java")
	  public TextResource BarChartTest3();
	  
	  @Source("TooltipTest1.java")
	  public TextResource TooltipTest1();
	  
	  @Source("LineChartTest1.java")
	  public TextResource LineChartTest1();
	  
	  @Source("BarChartColumnTest1.java")
	  public TextResource BarChartColumnTest1();
	  
	  @Source("BarChartDynamicUpdate.java")
	  public TextResource BarChartDynamicUpdate();
	  
	  @Source("SunBurstTest1.java")
	  public TextResource SunBurstTest1();
	  
	  @Source("RadarTest1.java")
	  public TextResource RadarTest1();
	  
	  @Source("RadarTest2.java")
	  public TextResource RadarTest2();
	  
	  @Source("RaphalyticsTest1.java")
	  public TextResource RaphalyticsTest1();
	  
	  @Source("DonutChartTest1.java")
	  public TextResource DonutChartTest1();
	  
	  
}
