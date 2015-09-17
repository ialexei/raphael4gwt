# printing text with custom fonts in raphael4gwt #

# Introduction #

Raphaël let us work with any TrueType and other format fonts, so we can show our text using the exact desired system font. It uses [cufón](https://github.com/sorccu/cufon) for rendering any type of font.

# Use custom fonts for printing text in Raphaël #

In raphaeljs the steps for using some TrueType font are:

  1. Locate the .ttf file of the desired font.
  1. Go to [Cufón font generator](http://cufon.shoqolate.com/generate/) and upload the font there. Configure the generator according to your needs and make sure to customize the font to Raphael support (Raphael.registerFont()).
  1. If everything was fine, the cufón generator will give us a javascript file. We must include that .js file in our html document
  1. Use paper.getFont("Lucida XYZ") for retrieve the font object and pass it to paper.print for render some text iwht that font and font-size. paper.print will return a set of shapes, each on of them is a letter of given text.


# Use custom fonts for printing text in raphael4gwt #

For using custom fonts in a raphael4gwt application we take analogous steps. As above, we must get the javascript font file from .ttf file using [Cufón font generator](http://cufon.shoqolate.com/generate/).

Then we must include that script in our application so one way of doing this is:

  1. Create if not exists a directory called "public" at the same level of your project's .gwt.xml file and put the font javascript file there, like `public/Anchor_Steam_NF_400.font.js`.
  1. Include that script in your project's .gwt.xml file like this: ` <script src="Anchor_Steam_NF_400.font.js"></script>`.
  1. Now we are ready for using the font. In our example the font's name is "Anchor Steam NF", so in our java code we can print a text using that font, at 54 píxels of size, like this:

```

Font font = paper.getFont("Anchor Steam NF");
Set text1 = paper.print(200,200,"Hello New Font", font, 54);

```


# gwt.xml sample file #

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE module PUBLIC "-//Google Inc.//DTD Google Web Toolkit 2.4.0//EN" "http://google-web-toolkit.googlecode.com/svn/tags/2.4.0/distro-source/core/src/gwt-module.dtd">
<module>
	<inherits name="com.google.gwt.user.User" />

	<inherits name="com.google.gwt.resources.Resources" />
	<inherits name="org.sgx.raphael4gwt.Raphael4Gwt" />
	<inherits name='com.google.gwt.user.theme.clean.Clean' />

	<script src="Anchor_Steam_NF_400.font.js"></script>


	<entry-point class="org.sgx.raphael4gwt.test.Raphael4GwtTest" />
	<source path="test" />
</module>
```

# java test sample #
```

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
		this.name="font";
		this.description="simple test using cufon fonts";		
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.FontTest1().getText();
	}

}

```