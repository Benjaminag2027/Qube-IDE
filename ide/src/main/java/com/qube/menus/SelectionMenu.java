package com.qube.menus;

import javax.swing.JPopupMenu;

import static com.qube.menus.Utils.*;

public class SelectionMenu extends JPopupMenu {
    public SelectionMenu() {
        addMenuItem(this, "Select All", ev -> { });
            addMenuItem(this, "Expand Selection", ev -> { });
            addMenuItem(this, "Shrink Selection", ev -> { });
            this.addSeparator();

            addMenuItem(this, "Copy Line Up", ev -> { });
            addMenuItem(this, "Copy Line Down", ev -> { });
            addMenuItem(this, "Move Line Up", ev -> { });
            addMenuItem(this, "Move Line Down", ev -> { });
            addMenuItem(this, "Duplicate Selection", ev -> { });
            this.addSeparator();

            addMenuItem(this, "Add Cursor Above", ev -> { });
            addMenuItem(this, "Add Cursor Below", ev -> { });
            addMenuItem(this, "Add Cursors to Line Ends", ev -> { });
            addMenuItem(this, "Add Next Occurence", ev -> { });
            addMenuItem(this, "Add Previous Occurence", ev -> { });
            addMenuItem(this, "Select All Occurences", ev -> { });
            this.addSeparator();

            addMenuItem(this, "Switch to Ctrl+Click for Multi-Cursor", ev -> { });
            addMenuItem(this, "Column Selection Mode", ev -> { });
    }
}
