package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.base.Font;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PrintLettersOnPath extends Test {

	@Override
	public void test() {
		Font font = paper.getFont("Anchor Steam NF");
		String pathstr = "M 50 100 C 100 50 150 0 200 50" +
			    " C 250 100 300 150 350 100" +
			    " C 400 50 450 50 450 50";
		paper.printLetters(50,100,"how about letters on a path", font, 44,15, 12, pathstr);
	}

	
	//test stuff
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_PATH, GalleryUtil.TAG_FONT,
				GalleryUtil.TAG_EXTENSION};
	}
	public PrintLettersOnPath(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="printLettersOnPath";
		this.description="print letters on a path using printLetters plugin";		
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.PrintLettersOnPath().getText();
	}

}
