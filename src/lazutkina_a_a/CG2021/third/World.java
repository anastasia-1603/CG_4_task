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

    public Matrix4 getProjection() {
        return projection;
    }

    public void setProjection(Matrix4 projection) {
        this.projection = projection;
    }

    public void modifyRotate(Matrix4 dp) {
        this.rotate = dp.multiply(this.rotate);
    }

    public Matrix4 getRotate() {
        return rotate;
    }

    public void setRotate(Matrix4 rotate) {
        this.rotate = rotate;
    }

    public void modifyScale(Matrix4 dp) {
        this.scale = dp.multiply(this.scale);
    }

    public Matrix4 getScale() {
        return scale;
    }

    public void setScale(Matrix4 scale) {
        this.scale = scale;
    }

    public void modifyTranslate(Matrix4 dp) {
        this.translate = dp.multiply(this.translate);
    }

    public Matrix4 getTranslate() {
        return translate;
    }

    public void setTranslate(Matrix4 translate) {
        this.translate = translate;
    }
}
