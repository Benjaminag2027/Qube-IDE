package com.qube.menus;

import javax.swing.JPopupMenu;

import static com.qube.menus.Utils.*;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HelpMenu extends JPopupMenu {
    

    public HelpMenu() {
        addMenuItem(this, "Welcome", ev -> { });
        addMenuItem(this, "Show All Commands", ev -> { });
        addMenuItem(this, "Documentation", ev -> { });
        addMenuItem(this, "Editor Playground", ev -> { });
        addMenuItem(this, "Open Walkthrough...", ev -> { });
        addMenuItem(this, "Show Release Notes", ev -> { });
        addMenuItem(this, "Getting Started with Accessibility Features", ev -> { });
        addMenuItem(this, "Ask @qube", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Keyboard Shortcuts Reference", ev -> { });
        addMenuItem(this, "Video Tutorials", ev -> { });
        addMenuItem(this, "Tips and Tricks", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Join Us on YouTube", ev -> {
            try {
                // Open the URL in the user's default web browser
                Desktop.getDesktop().browse(new URI("https://www.youtube.com/@QubeInteractive"));
            } catch (IOException | URISyntaxException ex) {
                // Handle potential exceptions (e.g., network issues, invalid URI syntax)
                ex.printStackTrace();
            }
        });
        addMenuItem(this, "Search Feature Requests", ev -> { });
        addMenuItem(this, "Report Issue", ev -> { });
        this.addSeparator();

        addMenuItem(this, "View Licence", ev -> { });
        addMenuItem(this, "Privacy Statement", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Toggle Developer Tools", ev -> { });
        addMenuItem(this, "Open Processor Explorer", ev -> { });
        this.addSeparator();

        addMenuItem(this, "Restart to Update", ev -> { });
        this.addSeparator();

        addMenuItem(this, "About", ev -> { });
    }
}
