package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Path;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Animation;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Font;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;
import org.sgx.raphael4gwt.raphael.util.FontUtil;
import org.sgx.raphael4gwt.test.gallery.GalleryResources;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.core.client.Callback;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;

public class FontTest1 extends Test {

	private Path text1;
	private Path text2;
	private Animation animation1;

	@Override
	public void test() {
		/*
		 * for this example to work,one must first:
		 * 
		 * 1) go to http://cufon.shoqolate.com/generate/ and generate a javascript 
		 * file from true type font compatible with raphaeljs.
		 * 
		 * 2) you must load this script in your document. In this case we add the script
		 * as a GWT Resource, in this case a ExternalTextResource, so it will be loaded 
		 * when required. You can also use a normal TextResource so the font will be 
		 * embbeded in your app, or just include the script in gwt.xml or in the html 
		 * document itself. 
		 * 
		 */
		try {
			FontUtil.loadFont(GalleryResources.INSTANCE.FontAnchorSteam(), new ResourceCallback<TextResource>() {
				
				@Override
				public void onSuccess(TextResource resource) {
//					System.out.println("font loaded ok");
					performTest(); 
				}
				
				@Override
				public void onError(ResourceException e) {
					System.out.println("font failed to load 1");
				}
			});
			
		} catch (ResourceException e) {
//			System.out.println("font failed to load 2");
			e.printStackTrace();
		} 
			
	}

	
	private void performTest() {
//		System.out.println("test started");
		Font font = paper.getFont("Anchor Steam NF");
		text1 = paper.print(150,150,"clickme please !!!", font, 84);
		text1.hide();
		
		text2 = paper.print(150,150,"thanks for my life", font, 84);
		text2.hide();
		
		Attrs future1 = (Attrs) JsUtil.obj(
			"path", text2.getAttribute("path")
		);
		
		animation1 = Raphael.animation(future1, 5000, Raphael.EASING_EASEOUT);
		
		text1.show();
		text1.click(new MouseEventListener() {
			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				text1.animate(animation1);
			}
		});	
		
		//now download a font from a url
		final String fontUrl = "http://cancerbero.vacau.com/testFiles/Elvish_Ring_NFI_100.font.js", 
				fontFamily = "Elvish Ring NFI"; 
		FontUtil.loadFont(fontUrl, new Callback<Void, Exception>() {			
			@Override
			public void onSuccess(Void result) {
				Font font2 = paper.getFont(fontFamily);
				Shape text3 = paper.print(50,100,"some elvish style !!!", font2, 44).attr(Attrs.create().fill("red"));				
			}			
			@Override
			public void onFailure(Exception reason) {
			}
		}); 
		
	}


	//test stuff
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_FONT};
	}
	
	public FontTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="fonts&anim1";
		this.description="simple test using cufon fonts and animating a text to other";		
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.FontTest1().getText();
	}

}
