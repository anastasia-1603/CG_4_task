package lazutkina_a_a.CG2021.math;

/**
 * Данный класс описывает точку в трехмерном пространстве
 */
public class Vector3
{
    private float[] values;

    /**
     * Конструктор трехмерной точки по трем составляющим
     * @param x
     * @param y
     * @param z
     */
    public Vector3(float x, float y, float z)
    {
        this.values = new float[] {x, y, z};
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

    public float at(int index)
    {
        return values[index];
    }

    private static final float EPSILON = 1e-10f;
    /**
     * Метод, возвращающий длину вектора
     * @return длина вектора
     */
    public float length() {
        float lenSqr = values[0] * values[0] + values[1] * values[1] + values[2] * values[2];
        if (lenSqr < EPSILON)
            return 0;
        return (float)Math.sqrt(lenSqr);
    }
}
