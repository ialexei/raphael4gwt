package org.sgx.espinillo.client.impl1.ui;

import org.sgx.espinillo.client.impl1.commands.ChangeShapeAttrsCmd;
import org.sgx.espinillo.client.impl1.eds.ShapeBeanUtil;
import org.sgx.espinillo.client.impl1.eds.ShapeBean;
import org.sgx.espinillo.client.impl1.model.VEditor1;
import org.sgx.espinillo.client.impl1.util.ShapeUtil;
import org.sgx.espinillo.client.model.Command;
import org.sgx.espinillo.client.model.CommandListener;
import org.sgx.espinillo.client.model.Document;
import org.sgx.gwteditors.client.editor.Editor;
import org.sgx.gwteditors.client.editor.event.EditorValueChangeEvent;
import org.sgx.gwteditors.client.editor.event.ValueChangeListener;
import org.sgx.gwteditors.client.impl1.complex.PropertyHaverEditor1;
import org.sgx.gwteditors.client.impl1.complex.PropertyHaverEditor2;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ShapePropsPanel extends VerticalPanel {
	
	private ShapeBean currentSelectionShapeBean;
	private PropertyHaverEditor2<ShapeBean> shapeEditor;

	public ShapePropsPanel() {
		super();
		setWidth("200px");
		getElement().addClassName("left-panel");
		add(new Label("Shape Properties"));
		
		currentSelectionShapeBean = GWT.create(ShapeBean.class);
				
		shapeEditor = new PropertyHaverEditor2<ShapeBean>();
		add(shapeEditor);
		shapeEditor.load(currentSelectionShapeBean);
		shapeEditor.addValueChangeListener(new ValueChangeListener<ShapeBean>() {
			
			@Override
			public void notifyValueChange(EditorValueChangeEvent<ShapeBean> evt) {
				ShapeBean sb = getSelectedShapeEditor().flush();
				
				Document curDoc = VEditorWidget.getInstance().getVeditor().getCurrentDocument(); 

				Attrs nattrs = sb.getNativeAttrs(); 
				ChangeShapeAttrsCmd cmd = new ChangeShapeAttrsCmd(curDoc, curDoc.getSelection().firstShape(), nattrs);

				curDoc.execute(cmd);
			}
		});
//		Document d = VEditorWidget.getInstance().getCurrentDocument(); 
//		VEditorWidget.getInstance().getCurrentDocument().addCommandListener(ChangeShapeAttrsCmd.class, new CommandListener() {
//			
//			@Override
//			public void onCommandExec(Command c) {
//				ChangeShapeAttrsCmd cc = (ChangeShapeAttrsCmd) c;
//				Set selection = VEditorWidget.getInstance().getCurrentDocument().getSelection();
//				
//				if(selection.contains(cc.getShape())) {
//					Shape s = null;
//					if(selection!=null && selection.size()==1) {
//						s=ShapeUtil.getInstance().getFirst(selection);
//					}
//					
//					ShapeBeanUtil.copyShapeBean(currentSelectionShapeBean, s);
////					Window.alert(currentSelectionShapeBean.getFill()); 
//					getSelectedShapeEditor().load(currentSelectionShapeBean);
//				}
//				
//			}
//			
//			@Override
//			public boolean beforeCommandExec(Command c) {
//				// TODO Auto-generated method stub
//				return true;
//			}
//		}); 
	}

	public void notifyEspinilloSelectionChange(Set selection) {

		Shape s = null;
		if(selection!=null && selection.size()==1) {
			s=ShapeUtil.getInstance().getFirst(selection);
		}
//		currentSelection=s;
//		else if(selection!=null && selection.size()>1){
//			s=selection;
//		}
		ShapeBeanUtil.copyShapeBean(currentSelectionShapeBean, s);
//		Window.alert(currentSelectionShapeBean.getFill()); 
		getSelectedShapeEditor().load(currentSelectionShapeBean);
	}
	

	public Editor<ShapeBean> getSelectedShapeEditor() {
		return shapeEditor;
	}
//	ChangeShapeAttrsCmd cc = (ChangeShapeAttrsCmd) c;
//	Set selection = VEditorWidget.getInstance().getCurrentDocument().getSelection();
//	
//	if(selection.contains(cc.getShape())) {
//		Shape s = null;
//		if(selection!=null && selection.size()==1) {
//			s=ShapeUtil.getInstance().getFirst(selection);
//		}
//		
//		ShapeBeanUtil.copyShapeBean(currentSelectionShapeBean, s);
////		Window.alert(currentSelectionShapeBean.getFill()); 
//		getSelectedShapeEditor().load(currentSelectionShapeBean);
//	}
	
	public void doShapeChange(Command c) {
		ChangeShapeAttrsCmd cc = (ChangeShapeAttrsCmd) c;
		Set selection = VEditorWidget.getInstance().getCurrentDocument().getSelection();
		
		if(selection.contains(cc.getShape())) {
			Shape s = null;
			if(selection!=null && selection.size()==1) {
				s=ShapeUtil.getInstance().getFirst(selection);
			}
			
			ShapeBeanUtil.copyShapeBean(currentSelectionShapeBean, s);
//			Window.alert(currentSelectionShapeBean.getFill()); 
			getSelectedShapeEditor().load(currentSelectionShapeBean);
		}
	}
}
