package org.sgx.raphael4gwt.raphy.test.app;

import com.google.gwt.dom.client.Element;


public abstract class AbstractRaphyTest implements RaphyTest {
String name, description;

protected AbstractRaphyTest(String name, String description) {
	super();
	this.name = name;
	this.description = description;
}
//protected void clear(Element root) {
//	while (root.hasChildNodes()) {
//	    root.removeChild(root.getLastChild());
//	}
//}


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}


}
