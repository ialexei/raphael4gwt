package org.sgx.raphael4gwt.raphael.pathobj;

public class MovePathCommand extends PathCmd {
protected MovePathCommand(){}
public static final native MovePathCommand createAbs(double x, double y)/*-{
	return ["M", x, y]; 
}-*/;
public static final native MovePathCommand createRel(double x, double y)/*-{
	return ["m", x, y]; 
}-*/;

public final native boolean isAbsolute()/*-{
	return this[0]=="M"; 
}-*/;
}
