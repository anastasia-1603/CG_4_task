package lazutkina_a_a.CG2021;

import lazutkina_a_a.CG2021.draw.IDrawer;

import lazutkina_a_a.CG2021.draw.SimpleEdgeDrawer;
import lazutkina_a_a.CG2021.math.Vector3;
import lazutkina_a_a.CG2021.models.Parallelepiped;
import lazutkina_a_a.CG2021.screen.ScreenConverter;
import lazutkina_a_a.CG2021.third.Camera;
import lazutkina_a_a.CG2021.third.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements CameraController.RepaintListener
{
        private Scene scene;
        private ScreenConverter sc;
        private Camera camera;
        private CameraController cameraController;

        public DrawPanel() {
            super();
            sc = new ScreenConverter(-1, 1, 2, 2, 1, 1);
            camera = new Camera();
            cameraController = new CameraController(camera, sc);
            scene = new Scene(Color.WHITE.getRGB());
            scene.showAxes();

            scene.getModelsList().add(new Parallelepiped(
                    new Vector3(-0.4f, -0.4f, -0.4f),
                    new Vector3(0.4f, 0.4f, 0.4f)
            ));

            cameraController.addRepaintListener(this);
            addMouseListener(cameraController);
            addMouseMotionListener(cameraController);
            addMouseWheelListener(cameraController);
        }

        @Override
        public void paint(Graphics g) {
            sc.setScreenSize(getWidth(), getHeight());
            BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = (Graphics2D)bi.getGraphics();
            IDrawer dr = new SimpleEdgeDrawer(sc, graphics);
            scene.drawScene(dr, camera);
            g.drawImage(bi, 0, 0, null);
            graphics.dispose();
        }

        @Override
        public void shouldRepaint() {
            repaint();
        }
}

