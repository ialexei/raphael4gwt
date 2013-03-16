package org.sgx.raphael4gwt.raphy.test.app;

import java.util.Map;

import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ExternalTextResource;

public interface RaphyTest {
	void test(Element parent);

	String getName();

	String getDescription();

	Map<String, ExternalTextResource> getResources();
}
