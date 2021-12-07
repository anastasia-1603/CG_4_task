import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JDialog
{
    private JPanel contentPane;
    private DrawPanel drawPanel;

    public MainFrame()
    {
        contentPane = new JPanel();
        setContentPane(contentPane);
        setModal(true);
        drawPanel = new DrawPanel();
        drawPanel.setPreferredSize(new Dimension(800, 600));
        contentPane.add(drawPanel);
    }

    public static void main(String[] args)
    {
        MainFrame dialog = new MainFrame();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
