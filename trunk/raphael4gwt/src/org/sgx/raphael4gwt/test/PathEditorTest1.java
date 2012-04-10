package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Font;
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PathEditorTest1 extends Test {

	@Override
	public void test() {
		Panel buttonPanel = getButtonPanel();
		
		Button moveToButton = new Button("moveto", new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		moveToButton.setTitle("1 click to the point to move to");
		buttonPanel.add(moveToButton);
	}

	private Panel getButtonPanel() {
		VerticalPanel vp = GalleryUtil.getInstance().getTestPanel();
		vp.clear();
		FlowPanel fp = new FlowPanel();
		vp.add(fp);
		return fp;
	}

	
	
	//test stuff

	public PathEditorTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="pathEditor1";
		this.description="a test app that try to bring a path editor";		
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.PathEditorTest1().getText();
	}

}
