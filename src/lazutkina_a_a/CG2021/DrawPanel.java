package lazutkina_a_a.CG2021;

import lazutkina_a_a.CG2021.draw.IDrawer;
import lazutkina_a_a.CG2021.draw.SimpleDrawer;
import lazutkina_a_a.CG2021.math.Vector3;
import lazutkina_a_a.CG2021.models.Line3D;
import lazutkina_a_a.CG2021.screen.ScreenConverter;
import lazutkina_a_a.CG2021.third.Camera;
import lazutkina_a_a.CG2021.third.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel
{
    private ScreenConverter sc = new ScreenConverter(-1, 1, 2, 2, 800, 600);
    private Scene scene;
    private Camera camera;

    public DrawPanel() {

        camera = new Camera();
        scene = new Scene(Color.WHITE);
        scene.getModels().add(new Line3D(
                new Vector3(0, 0, 0),
                new Vector3(1, 0, 0)
        ));
        scene.getModels().add(new Line3D(
                new Vector3(0, 0, 0),
                new Vector3(0, 1, 0)
        ));
        scene.getModels().add(new Line3D(
                new Vector3(0, 0, 0),
                new Vector3(0, 0, 1)
        ));
    }

    @Override
    public void paint(Graphics origG) {
        sc.setScreenHeight(getHeight());
        sc.setScreenWidth(getWidth());
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        /*g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(2));*/
        IDrawer d = new SimpleDrawer(g, sc);
        scene.drawWorld(camera, d);
        g.dispose();
        origG.drawImage(bi, 0, 0, null);
    }
}
