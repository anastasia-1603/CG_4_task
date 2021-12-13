package lazutkina_a_a.CG2021.third;

import lazutkina_a_a.CG2021.math.Matrix4;
import lazutkina_a_a.CG2021.math.Vector3;
import lazutkina_a_a.CG2021.math.Vector4;

/**
 * Описывает класс камеры, который хранит матрицы преобразования
 * мировой системы координат в систему координат камеры.
 */
public class Camera implements ICamera {
    private Matrix4 translate, rotate, scale, projection;

    /**
     * Создаёт простую камеру
     */
    public Camera() {
        translate = Matrix4.one();
        rotate = Matrix4.one();
        scale = Matrix4.one();
        projection = Matrix4.one();
    }

    /**
     * Метод, преобразуюший точку из мировой системы координат в систему координат камеры.
     * Сначала к вектору применяется масштаб(S), далее поворот(R), потом перенос(T) и в конце - проекция(P).
     * r = P * T * R * S * v
     * @param v вектор, который надо перевести
     * @return новый вектор
     */
    @Override
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
