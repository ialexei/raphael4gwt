package org.sgx.raphael4gwt.raphy.test.tests;

import java.util.HashMap;
import java.util.Map;

import org.sgx.raphael4gwt.raphy.client.Charts;
import org.sgx.raphael4gwt.raphy.client.line.Line;
import org.sgx.raphael4gwt.raphy.client.line.LineChart;
import org.sgx.raphael4gwt.raphy.client.line.LineChartOpts;
import org.sgx.raphael4gwt.raphy.client.line.LineOpts;
import org.sgx.raphael4gwt.raphy.client.line.Point;
import org.sgx.raphael4gwt.raphy.client.pathmenu.PathMenu;
import org.sgx.raphael4gwt.raphy.client.pathmenu.PathMenuItem;
import org.sgx.raphael4gwt.raphy.client.pathmenu.PathMenuOpts;
import org.sgx.raphael4gwt.raphy.test.app.AbstractRaphyTest;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.user.client.Window;

public class PathMenuTest1 extends AbstractRaphyTest {

	@Override
	public void test(Element parent) {

		// create a div for the first chart and set dimensions
		DivElement e = Document.get().createDivElement();
		parent.appendChild(e);
		e.getStyle().setProperty("width", "400px");
		e.getStyle().setProperty("height", "300px");
		
//		Window.alert("running"); 

		PathMenu menu = Charts.PathMenu(e, PathMenuOpts.create());
		
		menu.add(PathMenuItem.create().label("alkjsd").value(2.3).children(
				new PathMenuItem[]{
				PathMenuItem.create().label("alkjsd12").value(2.3), 
				PathMenuItem.create().label("alkjsd").value(2.3)				
		})); 
		menu.add(PathMenuItem.create().label("alkjs3d22").value(2.3).children(
				new PathMenuItem[]{
				PathMenuItem.create().label("alkjsd").value(2.3), 
				PathMenuItem.create().label("alkjsd").value(2.3)				
		})); 
		menu.add(PathMenuItem.create().label("alkjsddd").value(2.3).children(		
				new PathMenuItem[]{})); 
		
		menu.draw();

	}

	// test related information:
	public PathMenuTest1() {
		super("PathMenuTest1", "PathMenuTest1");
	}

	public Map<String, ExternalTextResource> getResources() {
		Map<String, ExternalTextResource> m = new HashMap<String, ExternalTextResource>();
		m.put("PathMenuTest1.java", RaphyTestResources.INSTANCE.PathMenuTest1());
		return m;
	}
}
