package com.qube;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;
import javax.swing.JToolTip;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.qube.menus.*;

public class ToolBar extends JMenuBar {
    // File
    public static Boolean autoSave = true;

    // View
    public static Boolean fullScreen = false;
    public static Boolean zenMode = false;
    public static Boolean centeredLayout = false;
    public static Boolean menuBar = true;
    public static Boolean primarySideBar = true;
    public static Boolean secondarySideBar = false;
    public static Boolean statusBar = true;
    public static Boolean panel = false;

    // Quick Access
    public static boolean sideBarLeftVisible = false;
    public static boolean panelVisible = false;
    public static boolean sideBarRightVisible = true;

    // Stuff
    public static JButton fileButton;
    public static JButton editButton;
    public static JButton selectionButton;
    public static JButton viewButton;
    public static JButton goButton;
    public static JButton runButton;
    public static JButton terminalButton;
    public static JButton helpButton;
    public static JButton search;
    public static int searchOffset;
    public static Component box;

    public ToolBar() {
        
        fileButton = addMenuButton("File", e -> {
            JPopupMenu menu = new FileMenu();
            // menu.setPopupSize(256, menu.getPreferredSize().height);
            menu.show((JButton) e.getSource(), 0, ((JButton) e.getSource()).getHeight());
        }, null);

        editButton = addMenuButton("Edit", e -> {
            JPopupMenu menu = new EditMenu();
            // menu.setPopupSize(256, menu.getPreferredSize().height);
            menu.show((JButton) e.getSource(), 0, ((JButton) e.getSource()).getHeight());
        }, null);
    
        selectionButton = addMenuButton("Selection", e -> {
            JPopupMenu menu = new SelectionMenu();            
            // menu.setPopupSize(256, menu.getPreferredSize().height);
            menu.show((JButton) e.getSource(), 0, ((JButton) e.getSource()).getHeight());
        }, null);
    
        viewButton = addMenuButton("View", e -> {
            JPopupMenu menu = new ViewMenu();            
            // menu.setPopupSize(256, menu.getPreferredSize().height);
            menu.show((JButton) e.getSource(), 0, ((JButton) e.getSource()).getHeight());
        }, null);
    
        goButton = addMenuButton("Go", e -> {
            JPopupMenu menu = new GoMenu();
            // menu.setPopupSize(256, menu.getPreferredSize().height);
            menu.show((JButton) e.getSource(), 0, ((JButton) e.getSource()).getHeight());
        }, null);
    
        runButton = addMenuButton("Run", e -> {
            JPopupMenu menu = new RunMenu();            
            // menu.setPopupSize(256, menu.getPreferredSize().height);
            menu.show((JButton) e.getSource(), 0, ((JButton) e.getSource()).getHeight());
        }, null);
    
        terminalButton = addMenuButton("Terminal", e -> {
            JPopupMenu menu = new TerminalMenu();            
            // menu.setPopupSize(256, menu.getPreferredSize().height);
            menu.show((JButton) e.getSource(), 0, ((JButton) e.getSource()).getHeight());
        }, null);
    
        helpButton = addMenuButton("Help", e -> {
            JPopupMenu menu = new HelpMenu();            
            // menu.setPopupSize(256, menu.getPreferredSize().height);
            menu.show((JButton) e.getSource(), 0, ((JButton) e.getSource()).getHeight());
        }, null);

        
        search = new JButton("Search") {
            @Override
            public Dimension getMaximumSize() {
                Dimension max = super.getMaximumSize();
                max.width = 300;
                return max;
            }
        };
        search.setIcon(new FlatSVGIcon("icons/search.svg"));

        searchOffset = (Main.width/2) - (fileButton.getPreferredSize().width + editButton.getPreferredSize().width + selectionButton.getPreferredSize().width + viewButton.getPreferredSize().width + goButton.getPreferredSize().width + runButton.getPreferredSize().width + terminalButton.getPreferredSize().width + helpButton.getPreferredSize().width + (search.getPreferredSize().width / 2));
        box = Box.createHorizontalStrut(searchOffset);

        add(box);
        add(search);
        add(Box.createHorizontalGlue());

        addMenuButton(new FlatSVGIcon("icons/layout.svg"), e -> {}, "Customize Layout.");

        addMenuButton(new FlatSVGIcon("icons/layout-sidebar-left" + (sideBarLeftVisible ? "" : "-off") + ".svg"), e -> {
            sideBarLeftVisible = !sideBarLeftVisible;
            ((JButton) e.getSource()).setIcon(new FlatSVGIcon("icons/layout-sidebar-left" + (sideBarLeftVisible ? "" : "-off") + ".svg"));
        }, "Toggle Secondary Side Bar (Ctrl + Alt + B)");

        addMenuButton(new FlatSVGIcon("icons/layout-panel" + (panelVisible ? "" : "-off") + ".svg"), e -> {
            panelVisible = !panelVisible;
            ((JButton) e.getSource()).setIcon(new FlatSVGIcon("icons/layout-panel" + (panelVisible ? "" : "-off") + ".svg"));
        }, "Toggle Panel (Ctrl + J)");

        addMenuButton(new FlatSVGIcon("icons/layout-sidebar-right" + (sideBarRightVisible ? "" : "-off") + ".svg"), e -> {
            sideBarRightVisible = !sideBarRightVisible;
            ((JButton) e.getSource()).setIcon(new FlatSVGIcon("icons/layout-sidebar-right" + (sideBarRightVisible ? "" : "-off") + ".svg"));

            Main.mainPanel.tabSplitPane.setEnabled(sideBarRightVisible);
            if (ToolBar.sideBarRightVisible) {
                ((JSplitPane) Main.mainPanel.tabSplitPane).setDividerLocation(Main.width * 107 / 128 );
            }
            else {
                ((JSplitPane) Main.mainPanel.tabSplitPane).setDividerLocation(Main.width);
            }
            revalidate();
        }, "Toggle Primary Side Bar (Ctrl + B)");

        addMenuButton(new FlatSVGIcon("icons/account.svg"), e -> {}, "Accounts");

        addMenuButton(new FlatSVGIcon("icons/gear.svg"), e -> {}, "Manage");
    }

    private JButton addMenuButton(String name, ActionListener l, String context) {
        JButton button = new JButton(name) {
            @Override
            public Point getToolTipLocation(MouseEvent event) {
                JToolTip tmp = createToolTip();
                tmp.setTipText(context);
                int tooltipWidth = tmp.getPreferredSize().width;
                int buttonWidth = getWidth();
                
                return new Point((buttonWidth - tooltipWidth) / 2, getHeight());
            }
        };
        button.addActionListener(l);

        button.setToolTipText(context);

        button.putClientProperty("JButton.buttonType", "toolBarButton");
        button.setFocusable(false);
        add(button);

        return button;
    }

    private void addMenuButton(FlatSVGIcon icon, ActionListener l, String context) {
        JButton button = new JButton(icon) {
            @Override
            public Point getToolTipLocation(MouseEvent event) {
                JToolTip tmp = createToolTip();
                tmp.setTipText(context);

                return new Point(-((int) (tmp.getPreferredSize().getWidth() - getWidth()) / 2), getHeight());
            }
        };
        button.addActionListener(l);

        button.setToolTipText(context);

        button.putClientProperty("JButton.buttonType", "toolBarButton");
        button.setFocusable(false);
        add(button);
    }
}
