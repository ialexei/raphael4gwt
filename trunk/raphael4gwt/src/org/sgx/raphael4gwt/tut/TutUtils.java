package org.sgx.raphael4gwt.tut;

import org.sgx.raphael4gwt.raphael.Paper;

public class TutUtils {

	public static void runExample(Paper p, String testName) {
		
	}
	
	public static final native void registerTutorialNatives()/*-{
		$wnd.r4gtutGWT = {
			runExample : function(paper, exName) {
				@org.sgx.raphael4gwt.tut.TutUtils::runExample(Lorg/sgx/raphael4gwt/raphael/Paper;Ljava/lang/String;)(paper, exName); 
			}, 
			sayHello : function(){
				$wnd.alert("helloooooo");
			}				
		}; 
	}-*/;

}
