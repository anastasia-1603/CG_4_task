package lazutkina_a_a.CG2021.math;

public class Matrix4 {
    private float matrix[];
    public static final int SIZE = 4;

    public Matrix4(float[][] m) {
        matrix = new float[16];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i * SIZE + j] = m[i][j];
            }
        }
    }

    /**
     * Возвращает значение матрицы по заданным индексам
     *
     * @param row номер строки
     * @param col номер столбца
     * @return
     */
    public float getAt(int row, int col) {
        return matrix[row * SIZE + col];
    }

    /**
     * Задает значение матрицы по заданным индексам
     *
     * @param row   номер строки
     * @param col   номер столбца
     * @param value новое значение
     * @return
     */
    public void setAt(int row, int col, float value) {
        matrix[row * SIZE + col] = value;
    }

    private Matrix4(float[] arr) {
        matrix = arr;
    }


    /**
     * Создает новую матрицу, заполненную нулями
     *
     * @return нулевая матрица
     */
    public static Matrix4 zero() {
        return new Matrix4(new float[16]);
    }

    /**
     * Создает единичную матрицу
     *
     * @return единичная матрица
     */
    public static Matrix4 one() {
        Matrix4 m = zero();
        for (int i = 0; i < SIZE; i++) {
            m.setAt(i, i, 1);
        }
        return m;
    }



    public Matrix4 multiply(float number)
    {
        Matrix4 m = zero();
        for (int i = 0; i < this.matrix.length; i++)
        {
            m.matrix[i] = this.matrix[i] * number;
        }
        return m;
    }

    public Vector4 multiply(Vector4 vector)
    {
        float[] result = new float[4];
        for (int i = 0; i < SIZE; i++)
        {
            float sum = 0;
            for (int j = 0; j < SIZE; j++)
            {
                sum += this.getAt(i, j) * vector.at(j);
            }
            result[i] = sum;
        }
        return new Vector4(result);
    }

    public Matrix4 multiply(Matrix4 other)
    {
        Matrix4 result = zero();
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                float sum = 0;
                for (int k = 0; k < SIZE; k++)
                {
                    sum += this.getAt(i, k) * other.getAt(k, j);
                }
                result.setAt(i, j, sum);
            }
        }
        return result;
    }

    public Matrix4 add(Matrix4 other)
    {
        Matrix4 result = Matrix4.zero();
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                result.setAt(i, j, this.getAt(i, j) + other.getAt(i, j));
            }
        }
        return result;
    }
}
