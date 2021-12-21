package lazutkina_a_a.CG2021.third;

import lazutkina_a_a.CG2021.draw.IDrawer;
import lazutkina_a_a.CG2021.math.Vector3;
import lazutkina_a_a.CG2021.models.Line3D;

import java.util.*;
import java.util.List;

/**
 * Описывает трёхмерную со всеми объектами на ней
 * @author Alexey
 */
public class Scene {
    private List<IModel> models = new ArrayList<>();

    public List<IModel> getModelsList() {
        return models;
    }

    private int backgroundColor;

    /**
     * Создаём сцену с заданным фоном
     * @param backgroundColorRGB цвет фона.
     */
    public Scene(int backgroundColorRGB) {
        this.backgroundColor = backgroundColorRGB;
        this.showAxes = false;
    }

    private boolean showAxes;

    public boolean isShowAxes() {
        return showAxes;
    }

    public void setShowAxes(boolean showAxis) {
        this.showAxes = showAxis;
    }

    public void showAxes() {
        this.showAxes = true;
    }

    public void hideAxes() {
        this.showAxes = false;
    }

    private static final List<Line3D> axes = Arrays.asList(
            new Line3D(new Vector3(0, 0, 0), new Vector3(1, 0, 0)),
            new Line3D(new Vector3(0, 0, 0), new Vector3(0, 1, 0)),
            new Line3D(new Vector3(0, 0, 0), new Vector3(0, 0, 1))
    );

    /**
     * Рисуем сцену со всеми моделями
     * @param drawer то, с помощью чего будем рисовать
     * @param cam камера для преобразования координат
     * @param world мир с двухточечной проекцией
     */
    public void drawScene(IDrawer drawer, ICamera cam, World world) {
        List<PolyLine3D> lines = new LinkedList<>();
        LinkedList<Collection<? extends IModel>> allModels = new LinkedList<>();
        allModels.add(models);
        if (isShowAxes())
            allModels.add(axes);
        for (Collection<? extends IModel> mc : allModels)
            for (IModel m : mc) {
                for (PolyLine3D pl : m.getLines()) {
                    List<Vector3> points = new LinkedList<>();
                    for (Vector3 v : pl.getPoints()) {
                        points.add(cam.w2c(world.objectToWorld(v)));
                    }
                    lines.add(new PolyLine3D(points, pl.isClosed()));
                }
            }
        drawer.clear(backgroundColor);
        drawer.draw(lines);
    }
}
