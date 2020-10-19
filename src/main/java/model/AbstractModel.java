package model;

public class AbstractModel implements Comparable {

    protected int id;

    @Override
    public boolean equals(Object obj) {
        if ((obj.getClass() != this.getClass()) ) {
            return false;
        }

        AbstractModel castedObject = (AbstractModel) obj;

        return castedObject.getId() == this.getId();
    }

    public int getId() {
        return this.id;
    }

    @Override
    public int compareTo(Object o) {
        AbstractModel convertedObject = (AbstractModel) o;
        return this.getId() - convertedObject.getId();
    }
}
