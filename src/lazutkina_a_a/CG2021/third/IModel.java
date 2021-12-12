package lazutkina_a_a.CG2021.third;

import java.util.List;

/**
 *Описывает трехмерную модель в общем виде
 */
public interface IModel
{
    /**
     * Возвращает список линий, описывающих контуры граней трехмерного объекта
     * @return
     */
    List<PolyLine3D> getLines();
}
