package org.sgx.raphael4gwt.test.gallery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.test.AllMouseEvents;
import org.sgx.raphael4gwt.test.AllPathIcons;
import org.sgx.raphael4gwt.test.AnimTransformAndPathTest1;
import org.sgx.raphael4gwt.test.AttrChangeListenerTest1;
import org.sgx.raphael4gwt.test.BlurAndEmbossTest1;
import org.sgx.raphael4gwt.test.CircleGlowingAndDraggin;
import org.sgx.raphael4gwt.test.DragAndSnap;
import org.sgx.raphael4gwt.test.DragTest1;
import org.sgx.raphael4gwt.test.DrawAndClick;
import org.sgx.raphael4gwt.test.EventRegisterAndUnregister;
import org.sgx.raphael4gwt.test.FillTest1;
import org.sgx.raphael4gwt.test.FontTest1;
import org.sgx.raphael4gwt.test.FreeTransformTest1;
import org.sgx.raphael4gwt.test.GradientMouseTest1;
import org.sgx.raphael4gwt.test.GradientTest1;
import org.sgx.raphael4gwt.test.ImageSimpleTest;
import org.sgx.raphael4gwt.test.ImageTransforms1;
import org.sgx.raphael4gwt.test.MouseCoordsOnHoverTest;
import org.sgx.raphael4gwt.test.MouseRelativeCoordsTest;
import org.sgx.raphael4gwt.test.PathEditorTest1;
import org.sgx.raphael4gwt.test.PrintLettersOnPath;
import org.sgx.raphael4gwt.test.SetSimpleTest1;
import org.sgx.raphael4gwt.test.SetTest2;
import org.sgx.raphael4gwt.test.ShapeEditor1;
import org.sgx.raphael4gwt.test.ShapeUnitTest1;
import org.sgx.raphael4gwt.test.Test;
import org.sgx.raphael4gwt.test.util.GUIUtil;

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

		t = new CircleGlowingAndDraggin(paper, w, h);
		tests.put(t.getName(), t);

		t = new EventRegisterAndUnregister(paper, w, h);
		tests.put(t.getName(), t);

		t = new DragAndSnap(paper, w, h);
		tests.put(t.getName(), t);

		t = new ImageSimpleTest(paper, w, h);
		tests.put(t.getName(), t);

		t = new AllPathIcons(paper, w, h);
		tests.put(t.getName(), t);

		t = new AnimTransformAndPathTest1(paper, w, h);
		tests.put(t.getName(), t);

		t = new SetSimpleTest1(paper, w, h);
		tests.put(t.getName(), t);

		t = new FillTest1(paper, w, h);
		tests.put(t.getName(), t);

		t = new GradientTest1(paper, w, h);
		tests.put(t.getName(), t);

		t = new GradientMouseTest1(paper, w, h);
		tests.put(t.getName(), t);

		t = new MouseRelativeCoordsTest(paper, w, h);
		tests.put(t.getName(), t);

		t = new DragTest1(paper, w, h);
		tests.put(t.getName(), t);

		t = new FontTest1(paper, w, h);
		tests.put(t.getName(), t);
		
//		t = new FontTextOnPath(paper, w, h);
//		tests.put(t.getName(), t);
		
		t = new FreeTransformTest1(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new AllMouseEvents(paper, w, h);
		tests.put(t.getName(), t);		

		t = new PathEditorTest1(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new PrintLettersOnPath(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new BlurAndEmbossTest1(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new ImageTransforms1(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new MouseCoordsOnHoverTest(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new DrawAndClick(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new ShapeEditor1(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new AttrChangeListenerTest1(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new SetTest2(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new ShapeUnitTest1(paper, w, h);
		tests.put(t.getName(), t);
		
	}

	Map<String, List<Test>> getTestsByTag() {
		return null;

	}



}
