package com.qube.menus;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JPopupMenu;

import com.qube.ToolBar;

import static com.qube.menus.Utils.*;

public class ViewMenu extends JPopupMenu {
    

    public ViewMenu() {
        addMenuItem(this, "Command Palette...", ev -> { });
            addMenuItem(this, "Open View...", ev -> { });
            this.addSeparator();

            addSubMenuItem(this, "Appearance", new JComponent[]{
                checkBoxMenuItem("Fullscreen", ToolBar.fullScreen, ev -> {
                    JCheckBoxMenuItem src = (JCheckBoxMenuItem) ev.getSource();
                    ToolBar.fullScreen = src.isSelected();
                }),
                checkBoxMenuItem("Zen Mode", ToolBar.zenMode, ev -> {
                    JCheckBoxMenuItem src = (JCheckBoxMenuItem) ev.getSource();
                    ToolBar.zenMode = src.isSelected();
                }),
                checkBoxMenuItem("Centered Layout", ToolBar.centeredLayout, ev -> {
                    JCheckBoxMenuItem src = (JCheckBoxMenuItem) ev.getSource();
                    ToolBar.centeredLayout = src.isSelected();
                }),
                separator(),
                checkBoxMenuItem("Menu Bar", ToolBar.menuBar, ev -> {
                    JCheckBoxMenuItem src = (JCheckBoxMenuItem) ev.getSource();
                    ToolBar.menuBar = src.isSelected();
                }),
                checkBoxMenuItem("Primary Side Bar", ToolBar.primarySideBar, ev -> {
                    JCheckBoxMenuItem src = (JCheckBoxMenuItem) ev.getSource();
                    ToolBar.primarySideBar = src.isSelected();
                }),
                checkBoxMenuItem("Secondary Side Bar", ToolBar.secondarySideBar, ev -> {
                    JCheckBoxMenuItem src = (JCheckBoxMenuItem) ev.getSource();
                    ToolBar.secondarySideBar = src.isSelected();
                }),
                checkBoxMenuItem("Status Bar", ToolBar.statusBar, ev -> {
                    JCheckBoxMenuItem src = (JCheckBoxMenuItem) ev.getSource();
                    ToolBar.statusBar = src.isSelected();
                }),
                checkBoxMenuItem("Panel", ToolBar.panel, ev -> {
                    JCheckBoxMenuItem src = (JCheckBoxMenuItem) ev.getSource();
                    ToolBar.panel = src.isSelected();
                }),
                separator(),
                menuItem("Move Primary Side Bar Left", null),
                subMenuItem("Activity Bar Position", new JComponent[]{
                    menuItem("Default", null),
                    menuItem("Bottom", null),
                    menuItem("Top", null),
                    menuItem("Hidden", null),
                }),
                subMenuItem("Panel Position", new JComponent[]{
                    menuItem("Top", null),
                    menuItem("Left", null),
                    menuItem("Right", null),
                    menuItem("Bottom", null),
                }),
                subMenuItem("Align Panel", new JComponent[]{
                    menuItem("Center", null),
                    menuItem("Justify", null),
                    menuItem("Left", null),
                    menuItem("Right", null),
                }),
                subMenuItem("Tab Bar", new JComponent[]{
                    menuItem("Multiple Tabs", null),
                    menuItem("Single Tab", null),
                    menuItem("Hidden", null),
                }),
                subMenuItem("Editor Actions Position", new JComponent[]{
                    menuItem("Tab Bar", null),
                    menuItem("Title Bar", null),
                    menuItem("Hidden", null),
                }),
                separator(),

            });
            addSubMenuItem(this, "Editor Layout", new JComponent[]{
                menuItem("Split Up", null),
                menuItem("Split Down", null),
                menuItem("Split Left", null),
                menuItem("Split Right", null),
                separator(),
                menuItem("Split in Group", null),
                separator(),
                menuItem("Move Editor into New Window", null),
                menuItem("Copy Editor into New Window", null),
                separator(),
                menuItem("Single", null),
                menuItem("Two Columns", null),
                menuItem("Three Colums", null),
                menuItem("Two Rows", null),
                menuItem("Three Rows", null),
                menuItem("Grid (2x2)", null),
                menuItem("Two Rows Right", null),
                menuItem("Two Columns Bottom", null),
                separator(),
                menuItem("Flip Layout", null)
            });
            this.addSeparator();

            addMenuItem(this, "Explorer", ev -> { });
            addMenuItem(this, "Search", ev -> { });
            addMenuItem(this, "Source Control", ev -> { });
            addMenuItem(this, "Run", ev -> { });
            addMenuItem(this, "Extensions", ev -> { });
            addMenuItem(this, "Testing", ev -> { });
            this.addSeparator();

            addMenuItem(this, "Chat", ev -> { });
            this.addSeparator();

            addMenuItem(this, "Problems", ev -> { });
            addMenuItem(this, "Output", ev -> { });
            addMenuItem(this, "Debug Console", ev -> { });
            addMenuItem(this, "Terminal", ev -> { });
            this.addSeparator();

            addMenuItem(this, "Word Wrap", ev -> { });
    }
}
