package org.sgx.raphael4gwt.test.gallery;

import java.util.HashSet;
import java.util.Set;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.test.AllPathIcons;
import org.sgx.raphael4gwt.test.CircleGlowingAndDraggin;
import org.sgx.raphael4gwt.test.DragAndSnap;
import org.sgx.raphael4gwt.test.EventRegisterAndUnregister;
import org.sgx.raphael4gwt.test.ImageSimpleTest;
import org.sgx.raphael4gwt.test.Test;
import org.sgx.raphael4gwt.test.util.GUIUtil;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;

public class GalleryUtil {
	
private static GalleryUtil instance;
protected Test currentTest;

private GalleryUtil() {
//	tests=new HashSet<Test>();
//	testClasses=new Class[] {
//		CircleGlowingAndDraggin.class, 
//		EventRegisterAndUnregister.class
//	};
}

public static GalleryUtil getInstance() {
	if (null == instance) {
		instance = new GalleryUtil();
	}
	return instance;
}
//Set<Test> tests;
//Class<Test> [] testClasses;
public void loadAllTest(Paper paper, int paperWidth, int paperHeight) {
//	tests.clear();
//	tests.add(new EventRegisterAndUnregister(paper, paperWidth, paperHeight));
//	tests.add(new CircleGlowingAndDraggin(paper, paperWidth, paperHeight));
}
	public Button createButtonFor(final Test t) {
		Button b = new Button(t.getName(), new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				currentTest=t;
				t.getPaper().clear();
				t.test();
			}
		});
		return b;
	}
	
	public void doShowJavaSource(Test t) {
		ShowSourceDialog d = new ShowSourceDialog(t.getJavaClassSource());
		GUIUtil.createDialogBox("Java test class sources", d);
	}

	public Test getCurrentTest() {
		return currentTest;
	}

	public void doAddAllGeneralTests(Paper paper, FlowPanel parentPanel, int w, int h) {
		Button button = createButtonFor(new CircleGlowingAndDraggin(paper, w, h));
		parentPanel.add(button);
		
		button = createButtonFor(new EventRegisterAndUnregister(paper, w, h));
		parentPanel.add(button);
			
		button = createButtonFor(new DragAndSnap(paper, w, h));
		parentPanel.add(button);
		
		button = createButtonFor(new ImageSimpleTest(paper, w, h));
		parentPanel.add(button);
		
		button = createButtonFor(new AllPathIcons(paper, w, h));
		parentPanel.add(button);
	}

}
