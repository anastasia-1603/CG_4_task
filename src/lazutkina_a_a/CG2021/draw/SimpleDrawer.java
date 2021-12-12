package lazutkina_a_a.CG2021.draw;

import lazutkina_a_a.CG2021.math.Vector3;
import lazutkina_a_a.CG2021.screen.ScreenConverter;
import lazutkina_a_a.CG2021.screen.ScreenCoordinates;
import lazutkina_a_a.CG2021.screen.ScreenPoint;
import lazutkina_a_a.CG2021.third.PolyLine3D;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class SimpleDrawer implements IDrawer{

    private Graphics g;
    private ScreenConverter sc;

    public SimpleDrawer(Graphics g, ScreenConverter sc) {
        this.g = g;
        this.sc = sc;
    }

    public Graphics getGraphics() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    public ScreenConverter getScreenConverter() {
        return sc;
    }

    public void setSc(ScreenConverter sc) {
        this.sc = sc;
    }

    @Override
    public void draw(List<PolyLine3D> lines) {
        Color prev = getGraphics().getColor();
        getGraphics().setColor(Color.BLACK);
        for (PolyLine3D l : lines)
        {
            List<ScreenPoint> points = new LinkedList<>();
            for (Vector3 v : l.getPoints())
            {
                points.add(getScreenConverter().realToScreen(v));
            }
            if (points.size() == 1)
            {
                getGraphics().fillRect(points.get(0).getX(), points.get(0).getY(), 1, 1);
            }
            else if (points.size() == 2)
            {
                getGraphics().drawLine(points.get(0).getX(), points.get(0).getY(),
                        points.get(1).getX(), points.get(1).getY());
            }
            else if (points.size() > 2)
            {
                ScreenCoordinates coordinates = new ScreenCoordinates(points);
                getGraphics().drawPolyline(coordinates.getXx(), coordinates.getYy(),
                        coordinates.getLength());
            }
        }
        getGraphics().setColor(prev);
    }

    @Override
    public void clear(Color c) {
        Color prev = getGraphics().getColor();
        getGraphics().setColor(c);
        getGraphics().fillRect(0, 0, getScreenConverter().getScreenWidth(),
                getScreenConverter().getScreenHeight());
        getGraphics().setColor(prev);
    }
}
