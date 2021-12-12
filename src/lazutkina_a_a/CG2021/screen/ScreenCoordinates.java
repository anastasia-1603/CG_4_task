package lazutkina_a_a.CG2021.screen;

import java.util.List;

public class ScreenCoordinates {
    private int[] xx, yy;

    public ScreenCoordinates(List<ScreenPoint> points)
    {
        xx = new int[points.size()];
        yy = new int[points.size()];
        int i = 0;
        for (ScreenPoint p : points)
        {
            xx[i] = p.getX();
            yy[i] = p.getY();
            i++;
        }
    }

    public int[] getXx() {
        return xx;
    }

    public void setXx(int[] xx) {
        this.xx = xx;
    }

    public int[] getYy() {
        return yy;
    }

    public void setYy(int[] yy) {
        this.yy = yy;
    }

    public int getLength()
    {
        return xx.length;
    }
}
