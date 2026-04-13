package com.qube.menus;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JPopupMenu;

import com.qube.ToolBar;

import static com.qube.menus.Utils.*;

public class FileMenu extends JPopupMenu {
    public FileMenu() {
        addMenuItem(this, "New Text File", ev -> { });
        addMenuItem(this, "New File...", ev -> { });
        addMenuItem(this, "New Window", ev -> { });
        addSubMenuItem(this, "New Window with Profile", new JComponent[]{
            menuItem("New Profile...", null)
        });
        this.addSeparator();
        addMenuItem(this, "Open File...", ev -> { });
        addMenuItem(this, "Open Folder...", ev -> { });
        addMenuItem(this, "Open Workspace with File...", ev -> { });
        addSubMenuItem(this, "Open Recent", new JComponent[]{
            menuItem("Reopen Closed Editor", null),
            separator(),
            separator(),
            menuItem("More...", null),
            separator(),
            menuItem("Clear Recently Opened...", null)
        });
        this.addSeparator();

        addMenuItem(this, "Add Folder to Workspace...", ev -> { });
        addMenuItem(this, "Save Workspace As...", ev -> { });
        addMenuItem(this, "Duplicate Workspace", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Save", ev -> { });
        addMenuItem(this, "Save As...", ev -> { });
        addMenuItem(this, "Save All", ev -> { });
        this.addSeparator();

        addSubMenuItem(this, "Share", new JComponent[]{
            menuItem("Export Profile (Default)...", null)
        });
        this.addSeparator();

        addCheckBoxMenuItem(this, "Auto Save", ToolBar.autoSave, ev -> {
            JCheckBoxMenuItem src = (JCheckBoxMenuItem) ev.getSource();
            ToolBar.autoSave = src.isSelected();
        });
        addSubMenuItem(this, "Preferences", new JComponent[]{
            menuItem("Profiles", null),
            menuItem("Settings", null),
            menuItem("Extensions", null),
            menuItem("Keyboard Shortcuts", null),
            menuItem("Configure Snippets", null),
            menuItem("Tasks", null),
            subMenuItem("Themes", new JComponent[]{
                menuItem("Color Theme", null),
                menuItem("File Icon Theme", null),
                menuItem("Product Icon Theme", null)
            }),
            separator(),
            menuItem("Backup and Sync Settings...", null),
            separator(),
            menuItem("Online Service Settings", null)
        });
        this.addSeparator();

        addMenuItem(this, "Revert File", ev -> { });
        addMenuItem(this, "Close Editor", ev -> { });
        addMenuItem(this, "Close Folder", ev -> { });
        addMenuItem(this, "Close Window", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Exit", ev -> {
            System.exit(0);
        });
    }
}
