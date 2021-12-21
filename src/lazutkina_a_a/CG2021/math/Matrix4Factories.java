package lazutkina_a_a.CG2021.math;

/**
 * Класс, хранящий методы создания особых матриц.
 */
public final class Matrix4Factories {
    /**
     * Продублированный метод создания нулевой матрицы
     *
     * @return нулевая матрица
     */
    public static Matrix4 zero() {
        return Matrix4.zero();
    }

    /**
     * Продублированный метод создания единичной матрицы
     *
     * @return единичная матрица
     */
    public static Matrix4 one() {
        return Matrix4.one();
    }

    /**
     * Создаёт матрицу поворота вокруг одной из осей,
     * заданной с помощью индекса на указанный угол в радианах.
     * Индексы осей: X=0, Y=1, Z=2.
     * В случае некорректного индекса, возваращается единичная матрица.
     *
     * @param alpha     угол поворота
     * @param axisIndex индекс оси
     * @return Матрица поворота или единичная матрица.
     */
    public static Matrix4 rotationXYZ(double alpha, int axisIndex) throws Exception {
        Matrix4 m = one();
        if (axisIndex < 0 || axisIndex > 2) {
            throw new Exception("Wrong axis index");
        }

        int a1 = (axisIndex + 1) % 3;
        int a2 = (axisIndex + 2) % 3;

        m.setAt(a1, a1, (float) Math.cos(alpha));
        m.setAt(a1, a2, (float) Math.sin(alpha));
        m.setAt(a2, a1, -(float) Math.sin(alpha));
        m.setAt(a2, a2, (float) Math.cos(alpha));

        return m;
    }

    public static enum Axis {X, Y, Z}

    ;

    /**
     * Создаёт матрицу поворота вокруго одной из осей на заданный угол в радианах
     *
     * @param alpha угол в радианах
     * @param axis  название оси, вокруг которой происходит вращение
     * @return матрица поворота
     */
    public static Matrix4 rotationXYZ(double alpha, Axis axis) {
        try {
            return rotationXYZ(alpha, axis == Axis.X ? 0 : axis == Axis.Y ? 1 : 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Создаёт новую матрицу переноса по заданным параметрам
     *
     * @param x X-составялющая смещения
     * @param y Y-составляющая смещения
     * @param z Z-составляющая смещения
     * @return матрица переноса
     */
    public static Matrix4 translation(float x, float y, float z) {
        Matrix4 m = one();
        m.setAt(0, 3, x);
        m.setAt(1, 3, y);
        m.setAt(2, 3, z);
        return m;
    }

    /**
     * Создаёт новую матрицу переноса на указанный вектор
     *
     * @param v вектор, на который производится перенос
     * @return матрица переноса
     */
    public static Matrix4 translation(Vector3 v) {
        return translation(v.getX(), v.getY(), v.getZ());
    }

    /**
     * Создаёт матрицу масштабирования по заданным параметрам
     *
     * @param factorX масштабирование вдоль оси X
     * @param factorY масштабирование вдоль оси Y
     * @param factorZ масштабирование вдоль оси Z
     * @return матрица масштабирования
     */
    public static Matrix4 scale(float factorX, float factorY, float factorZ) {
        Matrix4 m = one();
        m.setAt(0, 0, factorX);
        m.setAt(1, 1, factorY);
        m.setAt(2, 2, factorZ);
        return m;
    }

    /**
     * Создаёт матрицу масштабирования с одинаковыми коэффициентами по всем осям.
     *
     * @param factor коэффициент масштабирования
     * @return матрица масштабирования
     */
    public static Matrix4 scale(float factor) {
        return scale(factor, factor, factor);
    }

    /**
     * Создаёт матрицу центральной проекции вдоль выбранной оси
     *
     * @param point     точка схода на этой оси
     * @param axisIndex номер оси (X=0, Y=1, Z=2)
     * @return Матрица проекции
     */
    public static Matrix4 centralProjection(float point, int axisIndex) {
        Matrix4 m = one();
        if (axisIndex < 0 || axisIndex > 2)
            return m;
        m.setAt(3, axisIndex, 1 / point);
        return m;
    }

    /**
     * Создаёт матрицу двухточечной проекции на заданных 2-х осях
     *
     * @param point1     первая точка схода на этой оси
     * @param point2     вторая точка схода
     * @param axisIndex1 номер оси для первой точки(X=0, Y=1, Z=2)
     * @param axisIndex2 номер оси для второй точки(X=0, Y=1, Z=2)
     * @return Матрица проекции
     */
    public static Matrix4 twoPointProjection(float point1, float point2, int axisIndex1, int axisIndex2) {
        Matrix4 m = one();
        if (axisIndex1 < 0 || axisIndex1 > 2 || axisIndex2 < 0 || axisIndex2 > 2)
            return m;
        m.setAt(3, axisIndex1, 1 / point1);
        m.setAt(3, axisIndex2, 1 / point2);
        return m;
    }

    /**
     * Создаёт матрицу двухточечной проекции вдоль выбранных осей
     *
     * @return Матрица проекции
     */
    public static Matrix4 twoPointProjection(float point1, float point2, Axis axis1, Axis axis2) {
        return twoPointProjection(point1, point2,
                axis1 == Axis.X ? 0 : axis1 == Axis.Y ? 1 : 2,
                axis2 == Axis.X ? 0 : axis2 == Axis.Y ? 1 : 2
        );
    }

    public static Matrix4 allProjection(float point1, float point2, float point3, int axisIndex1, int axisIndex2, int axisIndex3) {
        Matrix4 m = one();
        if (axisIndex1 < 0 || axisIndex1 > 2 || axisIndex2 < 0 || axisIndex2 > 2)
            return m;
        m.setAt(3, axisIndex1, point1 == 0 ? 0 : (1 / point1));
        m.setAt(3, axisIndex2, point2 == 0 ? 0 : (1 / point2));
        m.setAt(3, axisIndex3, point3 == 0 ? 0 : (1 / point3));
        return m;
    }


    public static Matrix4 allProjection(float point1, float point2, float point3, Axis axis1, Axis axis2, Axis axis3) {
        return allProjection(point1, point2, point3,
                axis1 == Axis.X ? 0 : axis1 == Axis.Y ? 1 : 2,
                axis2 == Axis.X ? 0 : axis2 == Axis.Y ? 1 : 2,
                axis3 == Axis.X ? 0 : axis3 == Axis.Y ? 1 : 2
        );
    }
    /**
     * Создаёт матрицу центральной проекции вдоль выбранной оси
     *
     * @param point точка схода на этой оси
     * @param axis  название оси
     * @return Матрица проекции
     */
    public static Matrix4 centralProjection(float point, Axis axis) {
        return centralProjection(point, axis == Axis.X ? 0 : axis == Axis.Y ? 1 : 2);
    }
}
