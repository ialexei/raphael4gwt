package org.sgx.espinillo.client.impl1.tools;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.sgx.espinillo.client.impl1.ui.VEditorWidget;
import org.sgx.espinillo.client.impl1.ui.i18in.Messages;
import org.sgx.espinillo.client.model.Document;
import org.sgx.espinillo.client.model.tool.Tool;
import org.sgx.espinillo.client.model.tool.Toolbar;
/**
 * 
 * @author sg
 *
 */
public class Toolbar1 implements Toolbar {
	public static final String 
		TOOL_ELLIPSE="ellipse", 
		TOOL_CIRCLE="circle", 
		TOOL_RECT="rect", TOOL_LINE="line", TOOL_CURVE="curve",
		TOOL_SELECTION="selection", TOOL_TEXT="text", TOOL_FT="free transform";

	public static final String[] TOOLS = new String[]{
		TOOL_ELLIPSE, TOOL_CIRCLE, TOOL_RECT, TOOL_LINE, 
		TOOL_CURVE, TOOL_TEXT, TOOL_SELECTION, TOOL_FT
	};
	
	public static final String 
		TOOL_ELLIPSE_LABEL = Messages.INSTANCE.ellipse(),
		TOOL_CIRCLE_LABEL = Messages.INSTANCE.circle(),
		TOOL_RECT_LABEL = Messages.INSTANCE.rect(),
		TOOL_LINE_LABEL = Messages.INSTANCE.line(),
		TOOL_CURVE_LABEL = Messages.INSTANCE.curve(),
		TOOL_TEXT_LABEL = Messages.INSTANCE.text(),						
		TOOL_SELECTION_LABEL = Messages.INSTANCE.selection(),
		TOOL_FT_LABEL = Messages.INSTANCE.freeTransform();
	
	public static final String[] TOOL_LABELS = new String[]{
		TOOL_ELLIPSE_LABEL, TOOL_CIRCLE_LABEL, TOOL_RECT_LABEL, TOOL_LINE_LABEL, 
		TOOL_CURVE_LABEL, TOOL_TEXT_LABEL, TOOL_SELECTION_LABEL, TOOL_FT_LABEL
	};
	
	Map<Document, Tool> currentTool;
	
	public Toolbar1() {
		currentTool=new HashMap<Document, Tool>();		
	}

	@Override
	public String[] getAllToolNames() {
		return TOOLS;
	}
	public String[] getAllToolLabels() {
		return TOOL_LABELS;
	}

	//current tool for each document knower: 
	public Tool getCurrentTool(Document d) {
		return currentTool.get(d);
	}
	public void setCurrentTool(Document d, Tool t) {
		if(currentTool.get(d)!=null)
			currentTool.get(d).uninstall();
		currentTool.put(d, t);
		t.install();
	}
	
	@Override
	public Tool newTool(String name, Document d) {
		if(name.equals(TOOL_ELLIPSE))
			return new EllipseTool(d);
		if(name.equals(TOOL_CIRCLE))
			return new CircleTool(d);
		if(name.equals(TOOL_RECT))
			return new RectangleTool(d);
		if(name.equals(TOOL_SELECTION))
			return new SelectionTool(d);
		if(name.equals(TOOL_LINE))
			return new LineTool(d);
		if(name.equals(TOOL_CURVE))
			return new CurveTool(d);
		if(name.equals(TOOL_TEXT))
			return new TextTool(d);
		if(name.equals(TOOL_FT))
			return new FTTool(d);
		
		return null;
	}

//	@Override
//	public String getStatusText() {
//		return VEditorWidget.getInstance().getStatus().getText(); 
//	}
//
//	@Override
//	public void setStatusText(String s) {
//		VEditorWidget.getInstance().getStatus().setText(s); 
//	}

	
}
