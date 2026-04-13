package com.qube.panels;

import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.function.BiConsumer;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolTip;

import org.w3c.dom.events.MouseEvent;

import com.formdev.flatlaf.extras.FlatSVGIcon;

public class TabsPane extends JTabbedPane {

    public JButton startButton;
    public JButton goToFileButton;
    public JButton previewButton;
    public JButton moreActionsButton;

    public TabsPane() {

        setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        putClientProperty("TabbedPane.scrollButtonsPolicy", "never");
        putClientProperty("TabbedPane.scrollButtonsPlacement", "both");
        putClientProperty("JTabbedPane.tabClosable", true);
        putClientProperty("TabbedPane.tabType", "card");
        putClientProperty("TabbedPane.tabsPopupPolicy", "never");

        putClientProperty("JTabbedPane.tabCloseCallback", (BiConsumer<JTabbedPane, Integer>) (tabPane, index) -> {
            tabPane.remove(index);
        });

        addTab("Welcome", new InteractivePanel());

        JPanel comps = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        startButton = addMenuButton(comps, new FlatSVGIcon("icons/debug-start.svg"), null, "Run");
        startButton.setVisible(false);
        goToFileButton = addMenuButton(comps, new FlatSVGIcon("icons/go-to-file.svg"), null, "Reopen as source text");
        goToFileButton.setVisible(false);
        previewButton = addMenuButton(comps, new FlatSVGIcon("icons/preview.svg"), null, "Reopen as image preview");
        previewButton.setVisible(false);
        moreActionsButton = addMenuButton(comps, new FlatSVGIcon("icons/ellipsis.svg"), null, "More Actions...");

        putClientProperty("JTabbedPane.trailingComponent", comps);
    }

    private JButton addMenuButton(JComponent parent, FlatSVGIcon icon, ActionListener l, String context) {

        JButton button = new JButton(icon) {
            public Point getToolTipLocation(MouseEvent event) {
                JToolTip tmp = createToolTip();
                tmp.setTipText(context);

                return new Point(-((int) (tmp.getPreferredSize().getWidth() - getWidth()) / 2), getHeight());
            }
        };
        button.addActionListener(l);

        button.setToolTipText(context);

        button.putClientProperty("JButton.buttonType", "toolBarButton");
        button.setFocusable(false);

        parent.add(button);

        return button;
    }
}