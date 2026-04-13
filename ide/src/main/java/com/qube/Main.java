package com.qube;

// import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.util.SystemInfo;
import com.qube.panels.MainPanel;

import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

public class Main {
    public static int width = 960;
    public static int height = 540;

    public static MainPanel mainPanel;
    public static ToolBar toolBar;
    public static JFrame frame;

    public static void main(String[] args) {
        // FlatDarkLaf.setup();
        FlatLightLaf.setup();
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame = new JFrame("Qube IDE");
                frame.getRootPane().putClientProperty( "JRootPane.titleBarShowTitle", false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(960, 540);
                // frame.pack();
                toolBar = new ToolBar();
                frame.setJMenuBar(toolBar);
                mainPanel = new MainPanel();
                frame.add(mainPanel);

                try {
                    Image image = ImageIO.read(new File("ide/src/main/resources/logo.png"));

                    frame.setIconImage(image);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                frame.addComponentListener(new ComponentListener() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        width = e.getComponent().getWidth();
                        height = e.getComponent().getHeight();
                        if (ToolBar.sideBarRightVisible) {
                            ((JSplitPane) mainPanel.tabSplitPane).setDividerLocation(Main.width * 107 / 128 );
                        }
                        else {
                            ((JSplitPane) mainPanel.tabSplitPane).setDividerLocation(Main.width);
                        }

                        if (ToolBar.fileButton != null) {
                            ToolBar.searchOffset = (Main.width) - (ToolBar.fileButton.getPreferredSize().width + ToolBar.editButton.getPreferredSize().width + ToolBar.selectionButton.getPreferredSize().width + ToolBar.viewButton.getPreferredSize().width + ToolBar.goButton.getPreferredSize().width + ToolBar.runButton.getPreferredSize().width + ToolBar.terminalButton.getPreferredSize().width + ToolBar.helpButton.getPreferredSize().width);
                            ToolBar.box.setSize(ToolBar.searchOffset, ToolBar.box.getHeight());
                            System.out.println(ToolBar.searchOffset);
                        }

                        frame.revalidate();
                        frame.repaint();
                    }

                    @Override
                    public void componentMoved(ComponentEvent e) {
                    }

                    @Override
                    public void componentShown(ComponentEvent e) {
                    }

                    @Override
                    public void componentHidden(ComponentEvent e) {
                    }
                    
                });

                frame.setLocation(0,0);
                frame.setVisible(true);
            }
        });

        if( SystemInfo.isLinux ) {
            // enable custom window decorations
            JFrame.setDefaultLookAndFeelDecorated( true );
            JDialog.setDefaultLookAndFeelDecorated( true );
        }
    }
}