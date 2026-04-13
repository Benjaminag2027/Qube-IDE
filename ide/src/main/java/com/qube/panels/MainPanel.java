package com.qube.panels;
import java.awt.BorderLayout;
import java.awt.Dimension;

// import javax.swing.ActionMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import com.qube.Main;

public class MainPanel extends JPanel {

    public JComponent tabSplitPane;

    public TabsPane tabsPane = new TabsPane();
    public PrimarySidePanel explorerPanel = new PrimarySidePanel();

    public MainPanel() {
        setPreferredSize(new Dimension(Main.width,Main.height));
        setLayout(new BorderLayout());

        tabSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tabsPane, new JScrollPane(explorerPanel));

        add(tabSplitPane);
    }
}
