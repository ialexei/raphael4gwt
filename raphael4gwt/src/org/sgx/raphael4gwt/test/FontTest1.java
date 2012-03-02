package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Font;
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;

import com.google.gwt.user.client.Window;

public class FontTest1 extends Test {

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
		Set text1 = paper.print(200,200,"Hello New Font", font, 54);
		
		/* yes, the text is a set, the array of letter-shapes can be obtained 
		 * with text1.items(), here we use forEach for iterating the letters */
		Window.alert("the text is formed by "+text1.size()+" letters. ");
		
		text1.forEach(new ForEachCallback() {			
			@Override
			public boolean call(Shape shape, int index) {
				shape.attr(Attrs.create().stroke(randomColor()));
				shape.attr(Attrs.create().fill(randomColor()));
				return false;
			}
		});
	}

	//test stuff

	public FontTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="font1";
		this.description="simple test using cufon fonts";		
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.FontTest1().getText();
	}

}
