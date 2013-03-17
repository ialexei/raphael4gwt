package org.sgx.raphael4gwt.raphy.test.tests;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface RaphyTestResources extends ClientBundle {
	public static final RaphyTestResources INSTANCE = GWT.create(RaphyTestResources.class);

	@Source("LineChartTest1.java")
	public ExternalTextResource LineChartTest1();

	@Source("PathMenuTest1.java")
	public ExternalTextResource PathMenuTest1();

	@Source("BarChartTest1.java")
	public ExternalTextResource BarChartTest1();

	@Source("IndexChartTest1.java")
	public ExternalTextResource IndexChartTest1();
	
	@Source("CircleProgressChartTest1.java")
	public ExternalTextResource CircleProgressChartTest1();
	
	
	//g.raphael
	@Source("../../../gtest/gallery/tests/PieChartTest2.java")
	public ExternalTextResource GRPieChartTest2();
	
	@Source("../../../gtest/gallery/tests/BarChartTest2.java")
	public ExternalTextResource GRBarChartTest2();
	
	@Source("../../../gtest/gallery/tests/DonutChartTest1.java")
	public ExternalTextResource GRDonutChartTest1();
	
	@Source("../../../gtest/gallery/tests/CoxCombTest2.java")
	public ExternalTextResource GRCoxCombTest2();
	
	@Source("../../../gtest/gallery/tests/DotChartTest1.java")
	public ExternalTextResource GRDotChartTest1();
	
	@Source("../../../gtest/gallery/tests/LineChartTest1.java")
	public ExternalTextResource GRLineChartTest1();
	
	@Source("../../../gtest/gallery/tests/RadarTest2.java")
	public ExternalTextResource GRRadarTest2();
	
	@Source("../../../gtest/gallery/tests/RaphalyticsTest1.java")
	public ExternalTextResource GRRaphalyticsTest1();
	
	@Source("../../../gtest/gallery/tests/SunBurstTest1.java")
	public ExternalTextResource GRSunBurstTest1();
	
}
