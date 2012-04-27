package org.sgx.espinillo.client.impl1.tools;

import org.sgx.espinillo.client.model.Document;
import org.sgx.raphael4gwt.raphael.PathCmd;
import org.sgx.raphael4gwt.raphael.base.Point;

import com.google.gwt.user.client.Window;

/**
 * supports both clicking and maquee like selection tool (drag rectangle)
 * @author sg
 *
 */
public class LineTool extends AbstractPathTool1 {

	public LineTool(Document doc) {
		super(doc);
	}

	@Override
	public PathCmd doNextCommand(Point coords, PathCmd c) {
//		Window.alert("linetool donext");
		return c.lineto(coords);
	}

	@Override
	public PathCmd doCloseCommand(Point coords, PathCmd c) {
		return c.close();
	}
	
}
