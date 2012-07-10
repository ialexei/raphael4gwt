package org.sgx.raphael4gwt.raphael.pathobj;

import com.google.gwt.core.client.JsArrayMixed;
/**
 * a path is composed of a command name and one or more ArcPathCmdData, for example
 * the path command ["l", 20, 0, 0, 20, 50, 5] is a path command moveto with 3 
 * pathcmddata (20, 0) , (0, 20) and (50,5) 
 * 
 * @author sebastian
 *
 */
public class PathCmd extends JsArrayMixed {
protected PathCmd(){}


public final native String getName()/*-{
	return this[0]; 
}-*/;

//public final native PathCmd
////abstract methods - overrided by subclasses. 
//public final native boolean isAbsolute()/*-{
//	return true; 
//}-*/;
}
