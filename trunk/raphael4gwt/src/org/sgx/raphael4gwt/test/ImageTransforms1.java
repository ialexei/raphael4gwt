package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Image;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Path;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.gallery.IconPaths;
import org.sgx.raphael4gwt.test.gallery.GalleryResources;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
/**
 * @author sg
 *
 */
public class ImageTransforms1 extends Test {
	
	private TextBox sobelText;
	private Image image1;
	@Override
	public void test() {
		
		FlowPanel sobelPanel = new FlowPanel();
		sobelText = new TextBox();
		sobelText.setText("1.5");
		sobelPanel.add(new Label("size: "));
		sobelPanel.add(sobelText);
		
		GalleryUtil.getInstance().getTestPanel().add(sobelPanel);
		
		paper.text(100,30,
			"all these images will be transformed\n" +
			"when you clicked according to the \n" +
			"configuration panels above. ");
				
		
		image1 = paper.image(GalleryResources.INSTANCE.smallLion(), 10, 10, 180, 180);
		image1.click(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
//				image1.convolveSobel(1, 1.5);
			}
		});
	}

	
	//test information:
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_EXTENSION};
	}
	public ImageTransforms1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="image transforms";
		this.description="applying varius svg transformation to an image";		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.ImageTransforms1().getText();
	}

}
