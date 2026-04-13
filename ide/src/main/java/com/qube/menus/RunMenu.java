package com.qube.menus;

import javax.swing.JPopupMenu;

import static com.qube.menus.Utils.*;

public class RunMenu extends JPopupMenu {
    

    public RunMenu() {
        addMenuItem(this, "Back", ev -> { });
        addMenuItem(this, "Forward", ev -> { });
        addMenuItem(this, "Last Edit Location", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Switch Editor", ev -> { });
        addMenuItem(this, "Switch Group", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Go to File", ev -> { });
        addMenuItem(this, "Go to Symbol in Workspace", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Go to Symbol in Editor...", ev -> { });
        addMenuItem(this, "Go to Definition", ev -> { });
        addMenuItem(this, "Go to Declaration", ev -> { });
        addMenuItem(this, "Go to Type Definition", ev -> { });
        addMenuItem(this, "Go to Implementations", ev -> { });
        addMenuItem(this, "Go to References", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Go to Line/Column...", ev -> { });
        addMenuItem(this, "Go to Bracket", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Next Problem", ev -> { });
        addMenuItem(this, "Previous Problem", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Next Change", ev -> { });
        addMenuItem(this, "Previous Change", ev -> { });
    }
}
