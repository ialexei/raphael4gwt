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
	
}
