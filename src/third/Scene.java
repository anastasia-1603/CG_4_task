package third;

import draw.IDrawer;
import math.Vector3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Scene {
    private List<IModel> models = new ArrayList<>();

    public List<IModel> getModels() {
        return models;
    }

    public void drawWorld(ICamera camera, IDrawer d)
    {
        List<PolyLine3D> allLines = new LinkedList<>();
        for (IModel m : models)
        {
            for (PolyLine3D pl : m.getLines())
            {
                List<Vector3> newVectors = new LinkedList<>();
                for (Vector3 v : pl.getPoints())
                {
                    newVectors.add(camera.w2c(v));
                }
                allLines.add(new PolyLine3D(newVectors));
            }
        }

        d.draw(allLines);
    }
}
