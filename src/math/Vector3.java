package math;

/**
 * Данный класс описывает точку в трехмерном пространстве
 */
public class Vector3
{
    private float[] values;

    /**
     * Конструктор трехмерной точки
     * @param values
     */
    public Vector3(float[] values)
    {
        this.values = values;
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

}
