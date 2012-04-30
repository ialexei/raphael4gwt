package org.sgx.raphael4gwt.test.gallery;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.util.GUIUtil;
import org.sgx.raphael4gwt.raphael.util.Util;
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
import org.sgx.raphael4gwt.test.LivePathTest;
import org.sgx.raphael4gwt.test.MouseCoordsOnHoverTest;
import org.sgx.raphael4gwt.test.MouseRelativeCoordsTest;
import org.sgx.raphael4gwt.test.PaperLoadAndSave;
import org.sgx.raphael4gwt.test.PaperLoadAndSaveUnit1;
import org.sgx.raphael4gwt.test.PathCmdsTest1;
import org.sgx.raphael4gwt.test.PathEditorTest1;
import org.sgx.raphael4gwt.test.PrintLettersOnPath;
import org.sgx.raphael4gwt.test.SetSimpleTest1;
import org.sgx.raphael4gwt.test.SetTest2;
import org.sgx.raphael4gwt.test.ShapeEditor1;
import org.sgx.raphael4gwt.test.ShapeUnitTest1;
import org.sgx.raphael4gwt.test.Test;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class GalleryUtil {

	public static final String 
		TAG_PATH="path", TAG_ANIM="animation", 
		TAG_GRADIENT="gradient", TAG_EVENT="event",
		TAG_EXTENSION = "extensions",TAG_FONT="fonts",TAG_FT="free transform",
		TAG_SHAPE="shapes", TAG_SET="sets",
		TAG_ALLCATEGORY="all tests";
						
	private static final String [] TAG_ALL = 
		{TAG_PATH, TAG_ANIM, TAG_GRADIENT, TAG_EVENT, TAG_SHAPE, TAG_EXTENSION,
		TAG_FONT,TAG_FT};

	
	
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
				setCurrentTest(t);
			}
		});
		return b;
	}

	protected void setCurrentTest(Test t) {
		currentTest = t;
		t.getPaper().clear();
		getTestPanel().clear();
		t.test();
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

	
	/**
	 * put tests in categories by tag - using only tags defined in TAG_ constants.
	 */
	public void doAddAllGeneralTestsCategorized(
			DecoratedStackPanel parentPanel) {
		
		if (tests.keySet().isEmpty()) {
			GUIUtil.showErrorMessage(
				"Error - no tests defined. this is a bug",
				"Error - no tests defined. this is a bug - " +
				"call GalleryUtil::loadAlltest first ");
		}
		
		Map<String, Widget> tagPanels = new HashMap<String, Widget>();
		for (int i = 0; i < TAG_ALL.length; i++) {
			String tag = TAG_ALL[i];
			FlowPanel panel = new FlowPanel();
			tagPanels.put(tag, panel);
			for (String testName : tests.keySet()) {
				Test t = tests.get(testName);
				if(t!=null&&Util.contains(t.getTags(), tag)) {
					panel.add(createButtonFor(t));
				}				
			}
		}
		
		//add a "all" category
		FlowPanel panel = new FlowPanel();
		tagPanels.put(TAG_ALLCATEGORY, panel);
		for (String testName : tests.keySet()) {
			Test t = tests.get(testName);
			panel.add(createButtonFor(t));
		}
		Object[] names = (Object[]) tagPanels.keySet().toArray();
		Arrays.sort(names);
		for(Object tag : names) {
			parentPanel.add(tagPanels.get(tag+""), tag+"", false);
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

		t = new PathCmdsTest1(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new LivePathTest(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new PaperLoadAndSave(paper, w, h);
		tests.put(t.getName(), t);
		
		t = new PaperLoadAndSaveUnit1(paper, w, h);
		tests.put(t.getName(), t);
		
		
	}

	Map<String, List<Test>> getTestsByTag() {
		return null;

	}

	/**
	 * check for a test=testName paraemter passed in the url
	 * and show that test if that is the case.
	 */
	public void checkUrl() {
		Map<String, String> urlParams = Util.parseUrlParams(Util.getCurrentAddressUrl());
		if(urlParams.containsKey("test")) {
			Test t = tests.get(urlParams.get("test"));
			if(t!=null) {
				setCurrentTest(t);
			}
		}
	}



}
