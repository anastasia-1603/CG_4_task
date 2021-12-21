package lazutkina_a_a.CG2021.third;

import lazutkina_a_a.CG2021.math.Matrix4;
import lazutkina_a_a.CG2021.math.Vector3;
import lazutkina_a_a.CG2021.math.Vector4;

public class World {

    private Matrix4 translate, rotate, scale, projection;

    public World() {
        translate = Matrix4.one();
        rotate = Matrix4.one();
        scale = Matrix4.one();
        projection = Matrix4.one();
    }

    public Vector3 objectToWorld(Vector3 v) {
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
        this.projection = dp.multiply(this.projection); }

}
