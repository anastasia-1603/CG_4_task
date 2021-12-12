package lazutkina_a_a.CG2021.third;

import lazutkina_a_a.CG2021.math.Vector3;

public class Camera implements ICamera{
    @Override
    public Vector3 w2c(Vector3 point) {
        return new Vector3(point.getX(), point.getY(), point.getZ());
    }
}
