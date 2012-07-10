package org.sgx.raphael4gwt.raphael.pathobj;

public class LineToPathCommand extends PathCmd {
protected LineToPathCommand(){}
public static final native LineToPathCommand createAbs(double x, double y)/*-{
	return ["L", x, y]; 
}-*/;
public static final native LineToPathCommand createRel(double x, double y)/*-{
	return ["l", x, y]; 
}-*/;

public final native boolean isAbsolute()/*-{
	return this[0]=="L"; 
}-*/;

}
