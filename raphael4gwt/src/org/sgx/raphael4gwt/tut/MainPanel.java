//package org.sgx.raphael4gwt.tut;
//
//import com.google.gwt.user.client.ui.DockPanel;
//import com.google.gwt.user.client.ui.HTML;
//import com.google.gwt.user.client.ui.TabPanel;
//import com.google.gwt.user.client.ui.MenuBar;
//import com.google.gwt.user.client.ui.MenuItem;
//import com.google.gwt.user.client.Command;
//import com.google.gwt.user.client.ui.FlexTable;
//import com.google.gwt.user.client.ui.SimplePanel;
//
//public class MainPanel extends DockPanel {
//	public MainPanel() {
//		setSize("100%","100%"); 
//		TabPanel tabPanel = new TabPanel();
//		add(tabPanel, DockPanel.WEST);
//		
//		MenuBar menuBar = new MenuBar(false);
//		add(menuBar, DockPanel.NORTH);
//		MenuBar menuBar_1 = new MenuBar(true);
//		
//		MenuItem mntmNewMenu = new MenuItem("New menu", false, menuBar_1);
//		
//		MenuItem mntmNewItem_1 = new MenuItem("New item", false, (Command) null);
//		menuBar_1.addItem(mntmNewItem_1);
//		menuBar.addItem(mntmNewMenu);
//		MenuBar menuBar_2 = new MenuBar(true);
//		
//		MenuItem mntmNewMenu_1 = new MenuItem("New menu", false, menuBar_2);
//		
//		MenuItem mntmNewItem = new MenuItem("New item", false, (Command) null);
//		menuBar_2.addItem(mntmNewItem);
//		menuBar.addItem(mntmNewMenu_1);
//		
//		FlexTable flexTable = new FlexTable();
//		add(flexTable, DockPanel.SOUTH);
//		
//		HTML content = new HTML("<iframe style=\"width: 100%; height: 100%\" src=\"org.sgx.raphael4gwt.Raphael4GwtTutorial/tut/index.html\"></iframe>");
////		content.setSize("100%", "100%");
//		add(content, DockPanel.CENTER);
//	}
//
//
//}
