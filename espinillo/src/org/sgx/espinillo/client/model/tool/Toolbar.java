package org.sgx.espinillo.client.model.tool;

import java.util.List;
import java.util.Map;

import org.sgx.espinillo.client.model.Document;

/**
 * simple collection of tools.
 * TODO: categorize tools
 * @author sg
 *
 */
public interface Toolbar {
//	/**
//	 * tools by category
//	 * @return
//	 */
//Map<String,Tool> getTools();
	
	Tool newTool(String name, Document d);
	String[] getAllToolNames();
	
//	void changeTool(String toolName);
	public Tool getCurrentTool(Document d);
	public void setCurrentTool(Document d, Tool t);
}
