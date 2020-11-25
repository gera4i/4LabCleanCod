package plane;

import model.MilitaryTypes;

import java.util.Objects;

public class MilitaryPlane extends Plane{

    private MilitaryTypes militaryType;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryTypes type) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryType = type;
    }

    public MilitaryTypes getType() {
        return militaryType;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder(super.toString());
        stringBuilder.replace(stringBuilder.indexOf("}"),stringBuilder.indexOf("}")+1,", type=" + militaryType + '}');
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryType);
    }

    @Override
    public boolean equals(Object o) {
        return this==o || (o instanceof MilitaryPlane) || super.equals(o) ||
                militaryType==((MilitaryPlane) o).militaryType;
    }
}
