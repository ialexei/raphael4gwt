package org.sgx.raphael4gwt.gtest.gallery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sgx.raphael4gwt.gtest.gallery.tests.BarChartColumnTest1;
import org.sgx.raphael4gwt.gtest.gallery.tests.BarChartTest1;
import org.sgx.raphael4gwt.gtest.gallery.tests.BarChartTest2;
import org.sgx.raphael4gwt.gtest.gallery.tests.BarChartTest3;
import org.sgx.raphael4gwt.gtest.gallery.tests.DotChartTest1;
import org.sgx.raphael4gwt.gtest.gallery.tests.LineChartTest1;
import org.sgx.raphael4gwt.gtest.gallery.tests.PieChartTest1;
import org.sgx.raphael4gwt.gtest.gallery.tests.TooltipTest1;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.util.GUIUtil;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GalleryUtil {

	private static GalleryUtil instance;
	protected Test currentTest;

	Map<String, Test> tests = null;

	private GalleryUtil() {
		tests = new HashMap<String, Test>();
	}

	public static GalleryUtil getInstance() {
		if (null == instance) {
			instance = new GalleryUtil();
		}
		return instance;
	}

	public Button createButtonFor(final Test t) {
		Button b = new Button(t.getName(), new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				currentTest = t;
				t.getPaper().clear();
				getTestPanel().clear();
				t.test();
			}
		});
		return b;
	}

	VerticalPanel testPanel;
	
	public VerticalPanel getTestPanel() {
		return testPanel;
	}

	public void setTestPanel(VerticalPanel testPanel) {
		this.testPanel = testPanel;
	}

	public void doShowJavaSource(Test t) {
		ShowSourceDialog d = new ShowSourceDialog(t.getJavaClassSource());
		GUIUtil.createDialogBox("Java test class sources", d);
	}

	public Test getCurrentTest() {
		return currentTest;
	}

	public void doAddAllGeneralTests(Panel parentPanel) {

		if (tests.keySet().isEmpty()) {
			GUIUtil.showErrorMessage(
					"Error - no tests defined. this is a bug",
					"Error - no tests defined. this is a bug - call GalleryUtil::loadAlltest first ");
		}
		Button button = null;
		for (String testName : tests.keySet()) {
			button = createButtonFor(tests.get(testName));
			parentPanel.add(button);
		}

	}

	/**
	 * all tests loading
	 * 
	 * @param paper
	 * @param w
	 * @param h
	 */
	public void loadAllTest(Paper paper, int w, int h) {

		Test t = null;
 
		t = new PieChartTest1(paper, w, h);
		tests.put(t.getName(), t);

		t = new BarChartTest1(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new BarChartTest2(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new BarChartTest3(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new TooltipTest1(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new LineChartTest1(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new DotChartTest1(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new BarChartColumnTest1(paper, w, h);
		tests.put(t.getName(), t);
	}

	Map<String, List<Test>> getTestsByTag() {
		return null;

	}



}
