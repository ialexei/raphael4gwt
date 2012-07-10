package org.sgx.raphael4gwt.raphael.pathobj;

public class HorizontalLineToPathCommand extends PathCmd {
protected HorizontalLineToPathCommand(){}
public static final native HorizontalLineToPathCommand createAbs(double x)/*-{
	return ["H", x]; 
}-*/;
public static final native HorizontalLineToPathCommand createRel(double x)/*-{
	return ["H", x]; 
}-*/;

public final native boolean isAbsolute()/*-{
	return this[0]=="H"; 
}-*/;
}
