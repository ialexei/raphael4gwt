package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Text;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Font;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.raphael.util.FontUtil;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.core.client.Callback;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;

public class PrintLettersOnPath extends Test {

	private String fontUrl;
	private String fontFamily;
	private Text statusLabel;

	@Override
	public void test() {

//		Window.alert("printLettersOnAPath begin"); 
		// first load the font from url
		statusLabel = paper.text(100,100, "Loading font..."); 
		fontUrl = "http://cancerbero.vacau.com/testFiles/Kill_Switch_400.font.js";
		fontFamily = "Kill Switch";
		FontUtil.loadFont(fontUrl, new Callback<Void, Exception>() {
			@Override
			public void onSuccess(Void result) {
				// if loaded correctly, then perform the test
				performTest();
				statusLabel.hide(); 
			}

			@Override
			public void onFailure(Exception reason) {
				Window.alert("failure to load : "+fontUrl); 
			}
		});

	}

	protected void performTest() {
		Font font = paper.getFont(fontFamily);
		//the path to which alignt our text
		String pathstr = 
				"M 50 100 C 100 50 150 0 200 50" + 
				" C 250 100 300 150 350 100" + 
				" C 400 50 450 50 450 50";
		
		//printLetters : print text aligned to a path aligned 
		final Set lettersOnAPath = paper.printLetters(50, 200, "how about letters on a path", font, 44, 15, 22, pathstr);
		
		lettersOnAPath.click(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				lettersOnAPath.animate(Attrs.create().transform("...t-50,50"), 2000, "bounce");				
			}
		}); 
		
//		Window.alert("printLettersOnAPath end"); 
		 
	}

	// test stuff
	public String[] getTags() {
		return new String[] { GalleryUtil.TAG_PATH, GalleryUtil.TAG_FONT, GalleryUtil.TAG_EXTENSION };
	}

	public PrintLettersOnPath(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name = "printLettersOnPath";
		this.description = "print letters on a path using printLetters plugin";
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.PrintLettersOnPath().getText();
	}

}
