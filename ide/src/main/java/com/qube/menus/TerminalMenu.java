package com.qube.menus;

import javax.swing.JPopupMenu;

import static com.qube.menus.Utils.*;

public class TerminalMenu extends JPopupMenu {
    

    public TerminalMenu() {
        addMenuItem(this, "New Terminal", ev -> { });
        addMenuItem(this, "Split Terminal", ev -> { });
        addMenuItem(this, "New Terminal Window", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Run Task...", ev -> { });
        addMenuItem(this, "Run Build Task...", ev -> { });
        addMenuItem(this, "Run Active File", ev -> { });
        addMenuItem(this, "Run Selected File", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Show Running Tasks...", ev -> { });
        addMenuItem(this, "Restart Running Tasks...", ev -> { });
        addMenuItem(this, "Terminate Tasks...", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Configure Tasks...", ev -> { });
        addMenuItem(this, "Configure Default Build Tasks...", ev -> { });
    }
}
