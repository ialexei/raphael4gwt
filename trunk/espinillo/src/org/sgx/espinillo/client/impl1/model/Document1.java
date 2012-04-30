package org.sgx.espinillo.client.impl1.model;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.sgx.espinillo.client.impl1.commands.ChangeShapeAttrsCmd;
import org.sgx.espinillo.client.impl1.util.SelectionUtil;
import org.sgx.espinillo.client.model.AbstractDocument;
import org.sgx.espinillo.client.model.Command;
import org.sgx.espinillo.client.model.CommandListener;
import org.sgx.espinillo.client.model.VEditor;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Set;

import com.google.gwt.user.client.Window;

public class Document1 extends AbstractDocument {

	static Logger logger = Logger.getLogger("Document1");
	private Set selFeedbacks=null;
	private CommandListener shapeChangeAttrListener;

	public Document1(VEditor ved, Paper paper, String name) {
		super(ved, paper, name);
		selFeedbacks=null;
		
		init();
	}
	
	private void init() {
		shapeChangeAttrListener = new CommandListener() {			
			@Override
			public void onCommandExec(Command c) {
				if(c instanceof ChangeShapeAttrsCmd) {
					if(getSelection().contains(((ChangeShapeAttrsCmd)c).getShape())) {
						SelectionUtil.getInstance().updateSelectionFeedbacks(getPaper(), getSelection());
					}					
				}
			}			
			@Override
			public boolean beforeCommandExec(Command c) {
				return true;
			}
		};
		addCommandListener(ChangeShapeAttrsCmd.class, shapeChangeAttrListener);
	}

	@Override
	public void setSelection(Set selection) {
		super.setSelection(selection);
		
		if(selFeedbacks!=null)
			SelectionUtil.getInstance().hideSelectionFeedbacks(selFeedbacks);
		//selFeedbacks.remove();
		
		selFeedbacks = SelectionUtil.getInstance().
				getSelectionFeedbacks(getPaper(), selection);
		
		logger.log(Level.INFO, "setSelection :"+selection.print()+" - feedbacks : "+selFeedbacks.print());
		
		selFeedbacks.show();
		
		notifySelectionChange();
		
		
		
	}

}
