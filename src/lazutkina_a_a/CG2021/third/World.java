package lazutkina_a_a.CG2021.third;

import lazutkina_a_a.CG2021.math.Matrix4;
import lazutkina_a_a.CG2021.math.Vector3;
import lazutkina_a_a.CG2021.math.Vector4;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class World {

    private Matrix4 translate, rotate, scale, projection;

    public World() {
        translate = Matrix4.one();
        rotate = Matrix4.one();
        scale = Matrix4.one();
        projection = Matrix4.one();
        projection.setAt(3, 1, 1);
        projection.setAt(3, 2, -1);
    }

    public Vector3 w2c(Vector3 v) {
        return projection.multiply(
                translate.multiply(
                        rotate.multiply(
                                scale.multiply(
                                        new Vector4(v, 1)
                                )
                        )
                )
        ).asVector3();
    }

    public void modifyProjection(Matrix4 dp) {
        this.projection = dp.multiply(this.projection);
    }

}
