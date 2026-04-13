package com.qube.menus;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class Utils {
    public static void addMenuButton(JComponent parent, String name, ActionListener l) {
        JButton button = new JButton(name);
        button.addActionListener(l);
        button.putClientProperty("JButton.buttonType", "toolBarButton");
        button.setFocusable(false);
        parent.add(button);
    }

    public static void addMenuItem(JComponent parent, String name, ActionListener l) {
        JMenuItem item = new JMenuItem(name);
        item.addActionListener(l);
        parent.add(item);
    }

    public static JComponent menuItem(String name, ActionListener l) {
        JMenuItem item = new JMenuItem(name);
        item.addActionListener(l);
        return item;
    }

    public static void addCheckBoxMenuItem(JComponent parent, String name, Boolean defaultState, ActionListener l) {
        JCheckBoxMenuItem item = new JCheckBoxMenuItem(name);
        item.setSelected(defaultState);
        item.addActionListener(l);
        parent.add(item);
    }

    public static JComponent checkBoxMenuItem(String name, Boolean defaultState, ActionListener l) {
        JCheckBoxMenuItem item = new JCheckBoxMenuItem(name);
        item.setSelected(defaultState);
        item.addActionListener(l);
        return item;
    }

    public static void addSubMenuItem(JComponent parent, String name, JComponent[] comps) {
        JMenu menu = new JMenu(name);
        
        for (JComponent comp : comps) {
            menu.add(comp);
        }

        parent.add(menu);
    }

    public static JComponent subMenuItem(String name, JComponent[] comps) {
        JMenu menu = new JMenu(name);
        
        for (JComponent comp : comps) {
            menu.add(comp);
        }

        return menu;
    }

    public static JComponent separator() {
        return new JPopupMenu.Separator();
    }
}
