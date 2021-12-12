package lazutkina_a_a.CG2021.draw;

import lazutkina_a_a.CG2021.third.PolyLine3D;

import java.awt.*;
import java.util.List;

public interface IDrawer {
    void draw(List<PolyLine3D> lines);
    void clear(Color c);
}
