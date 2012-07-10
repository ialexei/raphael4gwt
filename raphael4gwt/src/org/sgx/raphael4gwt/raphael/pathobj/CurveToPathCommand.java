package org.sgx.raphael4gwt.raphael.pathobj;

public class CurveToPathCommand extends PathCmd {
protected CurveToPathCommand(){}
public static final native CurveToPathCommand createAbs(double x, double y)/*-{
	return ["C", x, y]; 
}-*/;
public static final native CurveToPathCommand createRel(double x, double y)/*-{
	return ["C", x, y]; 
}-*/;

public final native boolean isAbsolute()/*-{
	return this[0]=="A"; 
}-*/;

}
