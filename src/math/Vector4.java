package math;

/**
 * Описывает трехмерную точку в виде вектора из четырех компонент для матричной алгебры
 */
public class Vector4 {
    private float[] values;
    public static final int SIZE = 4;

    /**
     * Конструктор трехмерной точки по 4-м составляющим
     *
     * @param x
     * @param y
     * @param z
     * @param w
     */
    public Vector4(float x, float y, float z, float w) {
        this.values = new float[]{x, y, z, w};
    }

    /**
     * Конструктор трехмерной точки по 3-м составляющим
     *
     * @param x
     * @param y
     * @param z
     */
    public Vector4(float x, float y, float z) {
        this.values = new float[]{x, y, z, 0};
    }

    /**
     * Конструктор трехмерной точки по 4-м составляющим
     *
     * @param vector {@link Vector3}
     * @param w
     */
    public Vector4(Vector3 vector, float w) {
        this.values = new float[]{vector.getX(), vector.getY(), vector.getZ(), w};
    }

    /**
     * Конструктор трехмерной точки по 3-м составляющим
     *
     * @param vector {@link Vector3}
     */
    public Vector4(Vector3 vector) {
        this.values = new float[]{vector.getX(), vector.getY(), vector.getZ(), 0};
    }

    public Vector4(float[] values) {
        this.values = values;
    }

    private static final float EPS = 1e-12f;

    public Vector4 normalized() {
        if (Math.abs(getW()) < EPS) {
            return new Vector4(getX(), getY(), getZ(), 0);
        }
        return new Vector4(getX() / getW(), getY() / getW(), getZ() / getW(), 1f);
    }

    public Vector4 multiply(float number) {
        float[] result = new float[SIZE];
        for (int i = 0; i < SIZE; i++)
        {
            result[i] = this.at(i) * number;
        }
        return new Vector4(result);
    }

    public Vector4 add(Vector4 other) {
        float[] result = new float[SIZE];
        for (int i = 0; i < SIZE; i++)
        {
            result[i] = this.at(i) + other.at(i);
        }
        return new Vector4(result);
    }

    public static Vector4 zero() {
        return new Vector4(new float[SIZE]);
    }

    public float getX() {
        return values[0];
    }

    public float getY() {
        return values[1];
    }

    public float getZ() {
        return values[2];
    }

    public float getW() {
        return values[3];
    }

    /**
     * Возвращает значение компоненты по индексу
     *
     * @param index
     * @return
     */
    public float at(int index) {
        return values[index];
    }
}
