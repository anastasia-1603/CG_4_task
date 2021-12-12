package lazutkina_a_a.CG2021.third;

import lazutkina_a_a.CG2021.math.Vector3;

import java.util.LinkedList;
import java.util.List;

public class PolyLine3D
{
    private List<Vector3> points;

    public PolyLine3D(List<Vector3> points)
    {
        this.points = new LinkedList<>();
        this.points.addAll(points);
    }

    public List<Vector3> getPoints()
    {
        return new LinkedList<>(points);
    }
}

