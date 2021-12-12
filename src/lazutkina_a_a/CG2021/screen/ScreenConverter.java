package lazutkina_a_a.CG2021.screen;

import lazutkina_a_a.CG2021.math.Vector3;

public class ScreenConverter {
    private double cornerX, cornerY, realWidth, realHeight;
    private int screenWidth, screenHeight;

    public ScreenConverter(double cornerX, double cornerY, double realWidth, double realHeight, int screenWidth, int screenHeight) {

        this.cornerX = cornerX;
        this.cornerY = cornerY;
        this.realWidth = realWidth;
        this.realHeight = realHeight;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    public ScreenPoint realToScreen(Vector3 v)
    {
        double x = (v.getX() - cornerX) * screenWidth / realWidth;
        double y = (cornerY - v.getY()) * screenHeight / realHeight;
        return new ScreenPoint((int) x, (int) y);
    }

    public double getCornerX() {
        return cornerX;
    }

    public void setCornerX(double cornerX) {
        this.cornerX = cornerX;
    }

    public double getCornerY() {
        return cornerY;
    }

    public void setCornerY(double cornerY) {
        this.cornerY = cornerY;
    }

    public double getRealWidth() {
        return realWidth;
    }

    public void setRealWidth(double realWidth) {
        this.realWidth = realWidth;
    }

    public double getRealHeight() {
        return realHeight;
    }

    public void setRealHeight(double realHeight) {
        this.realHeight = realHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }
}
