package org.sgx.espinillo.client.impl1.tools;

import org.sgx.espinillo.client.model.Document;
import org.sgx.raphael4gwt.raphael.PathCmd;
import org.sgx.raphael4gwt.raphael.base.Point;

import com.google.gwt.user.client.Window;

/**
 * draw shapes using smoothQuadBezierCurveTo curves
 * @author sg
 *
 */
public class CurveTool extends AbstractPathTool1 {

	public CurveTool(Document doc) {
		super(doc, Toolbar1.TOOL_CURVE, Toolbar1.TOOL_CURVE_LABEL);
	}

	@Override
	public PathCmd doNextCommand(Point coords, PathCmd c) {
		return c.smoothQuadBezierCurveTo(coords);
	}

	@Override
	public PathCmd doCloseCommand(Point coords, PathCmd c) {
		return c.close();
	}

//	@Override
//	public PathCmd simulateNextCommand(Point coords, PathCmd c) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
