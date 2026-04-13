package com.qube.menus;

import javax.swing.JPopupMenu;

import static com.qube.menus.Utils.*;

public class EditMenu extends JPopupMenu {
    public EditMenu() {
        addMenuItem(this, "Undo", ev -> { });
            addMenuItem(this, "Redo", ev -> { });
            this.addSeparator();

            addMenuItem(this, "Cut", ev -> { });
            addMenuItem(this, "Copy", ev -> { });
            addMenuItem(this, "Paste", ev -> { });
            this.addSeparator();

            addMenuItem(this, "Find", ev -> { });
            addMenuItem(this, "Replace", ev -> { });
            this.addSeparator();

            addMenuItem(this, "Find in Files", ev -> { });
            addMenuItem(this, "Replace in Files", ev -> { });
            this.addSeparator();

            addMenuItem(this, "Toggle Line Comment", ev -> { });
            addMenuItem(this, "Toggle Block Comment", ev -> { });
            addMenuItem(this, "Emmet: Expand Abbreviation", ev -> { });
    }
}
