package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.DDListener;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.gallery.GalleryResources;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.resources.client.ImageResource;
/**
 * simple test showing a complete raphael.image usage, using GWT ClientBundle and 
 * ImageResource for referencing the images in the gwt project.<br/>
 * 
 * Important: for creating an raphael image, raphaeljs internally 
 * needs a "normal url" (not an inline image params: url). So, if working with
 * GWT ClientBundle, make sure to use <pre>@ImageOptions(preventInlining=true)</pre>
 *  in your resources definitions like:
 * 
 * 
 * <pre>
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;

public interface TestFontResources extends ClientBundle {
  TestFontResources INSTANCE = GWT.create(TestFontResources.class);

  @ImageOptions(preventInlining=true)
  @Source("smallLion.png")
  ImageResource smallLion();
  
}
</pre>  
	  
 * @author sg
 *
 */
public class ImageSimpleTest extends Test {
	
	@Override
	public void test() {
		/* get the GWT image resources */
		ImageResource img1Res = GalleryResources.INSTANCE.smallLion();	
		
		//draw a raphael image using the gwt resource and add a click listener that rotates it.
		final Shape img1 = paper.image(img1Res, 10, 10, 120, 120).rotate(20);
		img1.click(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				img1.rotate(25);
			}
		});
		paper.text(200,200, "click the lion");
		
		
		
			
		
		
	}

	
	//test information:
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_SHAPE};
	}
	public ImageSimpleTest(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="Image simple test";
		this.description="Image simple test using GWT Client Bundle and ImageResource. click the image for rotating.";		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.ImageSimpleTest().getText();
	}

}
