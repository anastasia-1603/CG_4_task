import javax.swing.*;
import java.awt.*;

public class MainWindow extends JDialog
{
    private JPanel contentPane;
    private DrawPanel drawPanel;

    public MainWindow()
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
        MainWindow dialog = new MainWindow();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
