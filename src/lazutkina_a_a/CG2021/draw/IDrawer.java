package lazutkina_a_a.CG2021.draw;

import lazutkina_a_a.CG2021.third.PolyLine3D;

import java.awt.*;
import java.util.Collection;
import java.util.List;

/**
 * Интерфейс, описывающий в общем виде процесс рисования полилинии
 *
 */
public interface IDrawer {
    /**
     * Очищает область заданным цветом
     * @param color цвет
     */
    public void clear(int color);

    /**
     * Рисует все полилинии
     * @param polyline набор рисуемых полилиний.
     */

    public void draw(Collection<PolyLine3D> polyline);
}
