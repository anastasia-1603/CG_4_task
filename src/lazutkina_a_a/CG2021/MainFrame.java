package lazutkina_a_a.CG2021;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private DrawPanel drawPanel;
    private JTextField projectionNumX;
    private JTextField projectionNumY;
    private JTextField projectionNumZ;
    private JButton done;

    private JPanel panelFields;
    private JPanel panelMain;

    public MainFrame()
    {
        drawPanel = new DrawPanel();
        done = new JButton("применить");
        initProjectionFields();
        addListener();
        panelFields = new JPanel();
        panelFields.add(done);
        panelMain = new JPanel();
        initPanelFields();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
       // panelMain.setSize(this.getWidth(), this.getHeight());
        panelMain.add(panelFields);
        panelMain.add(drawPanel);
        this.add(panelMain);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initProjectionFields()
    {
        projectionNumX = new JTextField("0.0");
        projectionNumY = new JTextField("0.0");
        projectionNumZ = new JTextField("0.0");/*
        projectionNumX.setSize(this.getWidth() / 3, 50);
        projectionNumY.setSize(this.getWidth() / 3, 50);
        projectionNumZ.setSize(this.getWidth() / 3, 50);*/
    }

    private void initPanelFields()
    {
       // panelFields.setLayout(new BoxLayout(panelFields, BoxLayout.X_AXIS));

        //panelFields.setSize(this.getWidth(), 40);
        panelFields.setPreferredSize(new Dimension(this.getWidth(), 100));

        panelFields.add(projectionNumX);
        panelFields.add(projectionNumY);
        panelFields.add(projectionNumZ);

    }


    private void addListener()
    {
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modify();
            }
        });
    }


    public void modify()
    {
        drawPanel.modifyProjection(
                Float.parseFloat(projectionNumX.getText()),
                Float.parseFloat(projectionNumY.getText()),
                Float.parseFloat(projectionNumZ.getText())
        );
    }
}
