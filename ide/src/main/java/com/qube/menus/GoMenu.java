package com.qube.menus;

import javax.swing.JPopupMenu;

import static com.qube.menus.Utils.*;

public class GoMenu extends JPopupMenu {
    

    public GoMenu() {
        addMenuItem(this, "Start Debugging", ev -> { });
        addMenuItem(this, "Run Without Debugging", ev -> { });
        addMenuItem(this, "Stop Debugging", ev -> { });
        addMenuItem(this, "Restart Debugging", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Open Configurations", ev -> { });
        addMenuItem(this, "Add Configurations...", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Step Over", ev -> { });
        addMenuItem(this, "Step Into", ev -> { });
        addMenuItem(this, "Step Out", ev -> { });
        addMenuItem(this, "Continue", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Toggle Breakpoint", ev -> { });
        addMenuItem(this, "New Breakpoint", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Enable All Breakpoints", ev -> { });
        addMenuItem(this, "Disable All Breakpoints", ev -> { });
        addMenuItem(this, "Remove All Breakpoints", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Install Additional Debuggers...", ev -> { });
    }
}
