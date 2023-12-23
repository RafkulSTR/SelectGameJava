package models;

import java.util.Comparator;

public class GameComparatorWeigth implements Comparator<Game>  {
    @Override
    public int compare(Game o1, Game o2) {
        return Double.compare(o1.getWeight(),o2.getWeight());
    }

}
