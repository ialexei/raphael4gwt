package org.sgx.raphael4gwt.raphael.pathobj;

public class VerticalLineToPathCommand extends PathCmd {
protected VerticalLineToPathCommand(){}
public static final native VerticalLineToPathCommand createAbs(double y)/*-{
	return ["V", y]; 
}-*/;
public static final native VerticalLineToPathCommand createRel(double y)/*-{
	return ["v", y]; 
}-*/;
}
