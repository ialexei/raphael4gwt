package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Path;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.image.IconPaths;
import org.sgx.raphael4gwt.test.image.TestImageResources;

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
public class BlurAndEmbossTest1 extends Test {
	
	private TextBox blurText;
	private Shape blurPath;
	private Shape embossPath;
	private TextBox embossText;
	private Shape emboss2Path;
	@Override
	public void test() {
		
		FlowPanel blurPanel = new FlowPanel();
		blurText = new TextBox();
		blurText.setText("1");
		blurPanel.add(new Label("blur size: "));
		blurPanel.add(blurText);
		
		FlowPanel embossPanel = new FlowPanel();
		embossText = new TextBox();
		embossText.setText("0.7");
		embossPanel.add(new Label("emboss bias (ex 0.7): "));
		embossPanel.add(embossText);
		
		GalleryUtil.getInstance().getTestPanel().add(blurPanel);
		GalleryUtil.getInstance().getTestPanel().add(embossPanel);
		
		paper.text(100,30,
			"adjust blur and emboss\n" +
			"factors and then click the\n" +
			"following shapes for applying the effect");
		
		Shape normalPath = paper.path(IconPaths.question).attr( Attrs.create().
			fill(TestImageResources.INSTANCE.smallLion()).
			transform("s3.0t10,50")
		);				
		
		blurPath = paper.path(IconPaths.question).attr( Attrs.create().
			fill(TestImageResources.INSTANCE.smallLion()).
			transform("s3.0t70,50")
		);
		blurPath.click(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				blurPath.blur(0);
				blurPath.blur(Integer.parseInt(blurText.getText()));
			}
		});
		
		embossPath = paper.path(IconPaths.question).attr( Attrs.create().
			fill(TestImageResources.INSTANCE.smallLion()).
			transform("s3.0t140,50")
		);
		embossPath.click(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				embossPath.emboss(0);
				embossPath.emboss(Float.parseFloat(embossText.getText()));
			}
		});
		
		emboss2Path = paper.path(IconPaths.question).attr( Attrs.create().
			fill(TestImageResources.INSTANCE.smallLion()).
			transform("s3.0t10,100")
		);
		emboss2Path.click(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
//				Window.alert("hello");
//				emboss2Path.convolve("he", 3, new double[]{
//						0.5, 0, 0, 
//						0, 1, 0, 
//						0, 0, -0.5}, 1.0, 0.5);
				emboss2Path.emboss2(2.5, "south", 1.0, 1);
//				embossPath.emboss(Float.parseFloat(embossText.getText()));
			}
		});	
	}

	
	//test information:
	public BlurAndEmbossTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="blur&emboss";
		this.description="show usage of blur and emobss plugins";		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.BlurAndEmbossTest1().getText();
	}

}
