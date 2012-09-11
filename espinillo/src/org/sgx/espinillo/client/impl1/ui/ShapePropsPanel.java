package org.sgx.espinillo.client.impl1.ui;

import org.sgx.espinillo.client.impl1.commands.ChangeShapeAttrsCmd;
import org.sgx.espinillo.client.impl1.eds.ShapeBeanUtil;
import org.sgx.espinillo.client.impl1.eds.ShapeBean;
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
	}

	public void notifyEspinilloSelectionChange(Set selection) {
		ShapeBeanUtil.copyShapeBean(currentSelectionShapeBean, selection);
//		Window.alert(currentSelectionShapeBean.getFill()); 
		getSelectedShapeEditor().load(currentSelectionShapeBean);
	}
	

	public Editor<ShapeBean> getSelectedShapeEditor() {
		return shapeEditor;
	}
}
