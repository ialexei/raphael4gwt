package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Path;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.base.Animation;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Font;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.dom.client.NativeEvent;

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
		 * We must include that script in our application so one way of doing this is:
		 * 
		 * 2) create if not exists a directory called "public" at the same level 
		 * of your project's *.gwt.xml file and put the font javascript file there, 
		 * like public/TimeNewRoman500.js
		 * 
		 * 3) include that script in your *.gwt.xml file like this:
		 * <script src="Anchor_Steam_NF_400.font.js"></script>
		 * 
		 * and now we are ready to use the font in our paper.
		 */

		Font font = paper.getFont("Anchor Steam NF");
		text1 = paper.print(150,200,"clickme please !!!", font, 84);
		text1.hide();
		
		text2 = paper.print(150,200,"thanks for my life", font, 84);
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
	}

	
	//test stuff
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
