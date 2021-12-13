package lazutkina_a_a.CG2021.models;

import lazutkina_a_a.CG2021.math.Vector3;
import lazutkina_a_a.CG2021.third.IModel;
import lazutkina_a_a.CG2021.third.PolyLine3D;

import java.util.Arrays;
import java.util.List;

public class Line3D implements IModel {
    private Vector3 p1, p2;

    public Line3D(Vector3 p1, Vector3 p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public List<PolyLine3D> getLines() {
        return Arrays.asList(new PolyLine3D(
                Arrays.asList(p1, p2), false));
    }
}
