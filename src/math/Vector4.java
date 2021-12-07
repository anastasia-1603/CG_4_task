package math;

/**
 * Описывает трехмерную точку в виде вектора из четырех компонент для матричной алгебры
 */
public class Vector4
{
    private float[] values;

    /**
     * Конструктор трехмерной точки по 4-м составляющим
     * @param x
     * @param y
     * @param z
     * @param w
     */
    public Vector4(float x, float y, float z, float w)
    {
        this.values = new float[]{x, y, z, w};
    }

    /**
     * Конструктор трехмерной точки по 3-м составляющим
     * @param x
     * @param y
     * @param z
     */
    public Vector4(float x, float y, float z)
    {
        this.values = new float[]{x, y, z, 0};
    }

    /**
     * Конструктор трехмерной точки по 4-м составляющим
     * @param vector {@link Vector3}
     * @param w
     */
    public Vector4(Vector3 vector, float w)
    {
        this.values = new float[]{vector.getX(), vector.getY(), vector.getZ(), w};
    }

    /**
     * Конструктор трехмерной точки по 3-м составляющим
     * @param vector {@link Vector3}
     */
    public Vector4(Vector3 vector)
    {
        this.values = new float[]{vector.getX(), vector.getY(), vector.getZ(), 0};
    }

    private static final float EPS = 1e-12f;
    public Vector4 normalized()
    {
        if (Math.abs(getW()) < EPS)
        {
            return new Vector4(getX(), getY(), getZ(), 0);
        }
        return new Vector4(getX()/getW(), getY()/getW(), getZ()/getW(), 1f);
    }

    public float getX()
    {
        return values[0];
    }

    public float getY()
    {
        return values[1];
    }

    public float getZ()
    {
        return values[2];
    }

    public float getW()
    {
        return values[3];
    }

    /**
     * Возвращает значение компоненты по индексу
     * @param index
     * @return
     */
    public float at(int index)
    {
        return values[index];
    }
}
