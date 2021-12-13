package lazutkina_a_a.CG2021.models;


import lazutkina_a_a.CG2021.third.IModel;
import lazutkina_a_a.CG2021.third.PolyLine3D;

import java.util.ArrayList;
import java.util.List;

public class Model implements IModel {
    private ArrayList<PolyLine3D> lines;

    public Model(ArrayList<PolyLine3D> lines) {
        this.lines = lines;
    }

    @Override
    public List<PolyLine3D> getLines() {
        return lines;
    }
}
