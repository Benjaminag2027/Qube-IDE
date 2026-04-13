package com.qube.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.qube.Main;

public class PrimarySidePanel extends JTabbedPane {

    private static JTree fileStruct;
    
    public PrimarySidePanel() {
        // setTabPlacement(JTabbedPane.RIGHT);
        
        JPanel explorerTab = createExplorerTab();
        
        addTab(null, new FlatSVGIcon("icons/files.svg", 18, 18), explorerTab);
        
        addTab(null, new FlatSVGIcon("icons/search.svg", 18, 18), new JPanel());

        addTab(null, new FlatSVGIcon("icons/debug-alt-small.svg"), new JPanel());
    }

    private JPanel createExplorerTab() {
        JPanel panel = new JPanel(new BorderLayout());

        // 1. Header Area
        JPanel header = new JPanel(new BorderLayout());
        JLabel title = new JLabel(" EXPLORER");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 11f));
        title.setPreferredSize(new Dimension(100, 30));
        
        header.add(title, BorderLayout.WEST);
        
        // Add a separator line at the bottom of the header
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, UIManager.getColor("Separator.foreground")));
        
        panel.add(header, BorderLayout.NORTH);

        // 2. Tree Area (Inside a ScrollPane)
        String rootPath = "C:\\Users\\BenjaminAG.2027\\OneDrive - Meridian Technical Charter High School\\MTCHS\\junior\\Computer Science 1B\\Portfolio\\JAVA\\IDE";
        fileStruct = new JTree(new DefaultTreeModel(createTree(new File(rootPath))));
        
        fileStruct.setCellRenderer(new FileTreeRenderer());
        fileStruct.setRowHeight(22);
        
        fileStruct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    handleFileSelection(fileStruct);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(fileStruct);
        scrollPane.setBorder(null);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private void handleFileSelection(JTree tree) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (node == null || !node.isLeaf()) return;

        if (node.getUserObject() instanceof File file) {
            String tabTitle = file.getName();
            JTabbedPane tabs = Main.mainPanel.tabsPane;

            for (int i = 0; i < tabs.getTabCount(); i++) {
                if (tabs.getTitleAt(i).equals(tabTitle)) {
                    tabs.setSelectedIndex(i);
                    return;
                }
            }

            InteractivePanel content = new InteractivePanel(file);
            tabs.addTab(tabTitle, content);
            tabs.setSelectedIndex(tabs.getTabCount() - 1);
        }
    }

    public DefaultMutableTreeNode createTree(File file) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(file);
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File child : children) {
                    node.add(createTree(child));
                }
            }
        }
        return node;
    }

    private static class FileTreeRenderer extends DefaultTreeCellRenderer {
        @Override
        public java.awt.Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean exp, boolean leaf, int row, boolean focus) {
            super.getTreeCellRendererComponent(tree, value, sel, exp, leaf, row, focus);
            if (value instanceof DefaultMutableTreeNode node && node.getUserObject() instanceof File file) {
                setText(file.getName());

                TreePath path = new TreePath(node.getPath());

                if (file.isDirectory()) {
                    if (fileStruct.isExpanded(path)) {
                        setIcon(new FlatSVGIcon("icons/folder-opened.svg"));
                    }
                    else {
                        setIcon(new FlatSVGIcon("icons/folder.svg"));
                    }
                    // setIcon(exp ? UIManager.getIcon("Tree.openIcon") : UIManager.getIcon("Tree.closedIcon"));
                }
                else {
                    setIcon(new FlatSVGIcon("icons/file.svg"));
                }
            }
            return this;
        }
    }
}