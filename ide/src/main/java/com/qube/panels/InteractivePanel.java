package com.qube.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.qube.Main;

public class InteractivePanel extends JPanel {
    
    private Image originalImage;
    private double scaleFactor = 1.0;
    private JLabel imageLabel;

    public InteractivePanel() {
        // setLayout(new BorderLayout());
        
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Qube IDE");
        title.putClientProperty( "FlatLaf.styleClass", "h00");
        titlePanel.add(title);
        JLabel subtitle = new JLabel("Coding Experience");
        subtitle.putClientProperty( "FlatLaf.styleClass", "h2");
        titlePanel.add(subtitle);

        JPanel StartPanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        JLabel start = new JLabel("Start");
        start.putClientProperty( "FlatLaf.styleClass", "h2");
        titlePanel.add(start);

        add(titlePanel);
        add(StartPanel);
    }

    public InteractivePanel(File file) {
        setLayout(new BorderLayout());
        String path = file.getAbsolutePath();
        String name = file.getName().toLowerCase();
        
        Main.mainPanel.tabsPane.startButton.setVisible(false);
        Main.mainPanel.tabsPane.goToFileButton.setVisible(false);
        if (isImage(name)) {
            if (name.endsWith(".svg")) {
                Main.mainPanel.tabsPane.goToFileButton.setVisible(true);
                addSVGImageViewer(path);
            }
            else {
                addImageViewer(path);
            }
        } else {
            Main.mainPanel.tabsPane.startButton.setVisible(true);
            addTextArea(path);
        }
    }

    private boolean isImage(String name) {
        return name.endsWith(".png") || name.endsWith(".jpg") || 
               name.endsWith(".jpeg") || name.endsWith(".gif") || name.endsWith(".svg");
    }

    public void addTextArea(String filePath) {
        try {
            RSyntaxTextArea textArea = new RSyntaxTextArea(Files.readString(Paths.get(filePath)));
            textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
            textArea.setCodeFoldingEnabled(true);
            add(new RTextScrollPane(textArea), BorderLayout.CENTER);
        } catch (IOException e) {
            add(new JLabel("Could not load text file: " + e.getMessage()));
        }
    }

    public void addImageViewer(String filePath) {
        ImageIcon rawIcon = new ImageIcon(filePath);
        originalImage = rawIcon.getImage();
        imageLabel = new JLabel(rawIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        // Add the click-to-zoom listener
        imageLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.isControlDown()) {
                    scaleFactor = Math.max(0.1, scaleFactor - 0.2); 
                } else {
                    scaleFactor += 0.2;
                }
                updateImageScale();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        JScrollPane scrollPane = new JScrollPane(imageLabel);
        scrollPane.getViewport().setBackground(new Color(127, 127, 127));
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void addSVGImageViewer(String filePath) {
        File svgFile = new File(filePath);
        FlatSVGIcon baseIcon = new FlatSVGIcon(svgFile);
        // Initialize the label with the original icon
        imageLabel = new JLabel(baseIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        // Using MouseAdapter is cleaner than MouseListener (no empty methods needed)
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    if (e.isControlDown()) {
                        // Ctrl + Click = Zoom Out
                        scaleFactor = Math.max(0.1, scaleFactor - 0.2); 
                    } else {
                        // Click = Zoom In
                        scaleFactor += 0.2;
                    }
                    updateImageScale();
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(imageLabel);
        scrollPane.getViewport().setBackground(new Color(127, 127, 127));
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void updateImageScale() {
        int newWidth = (int) (originalImage.getWidth(null) * scaleFactor);
        int newHeight = (int) (originalImage.getHeight(null) * scaleFactor);

        Image scaledResized = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledResized));
        
        imageLabel.revalidate();
        imageLabel.repaint();
    }
}