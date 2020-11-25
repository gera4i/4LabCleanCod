// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

import plane.ExperimentalPlane;
import model.MilitaryTypes;
import plane.MilitaryPlane;
import plane.PassengerPlane;
import model.ClassificationLevels;
import plane.Plane;

import java.util.*;
import java.util.stream.Collectors;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        this.planes.stream().filter(plane->plane instanceof PassengerPlane).forEach(x->passengerPlanes.add((PassengerPlane)x));
        return passengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        this.planes.stream().filter(plane->plane instanceof MilitaryPlane).forEach(x->militaryPlanes.add((MilitaryPlane)x));
        return militaryPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        this.planes.stream().filter(plane->plane instanceof ExperimentalPlane).forEach(x->experimentalPlanes.add((ExperimentalPlane)x));
        return experimentalPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> experimentalPlanes = new ArrayList<>();
        getPassengerPlanes().stream().sorted(Comparator.comparingInt(PassengerPlane::getPassengersCapacity)).forEach(x->experimentalPlanes.add((PassengerPlane) x));
        return experimentalPlanes.get(0);
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        getMilitaryPlanes().stream().filter(plane->plane.getType()==MilitaryTypes.TRANSPORT).forEach(x->transportMilitaryPlanes.add((MilitaryPlane) x));
        return transportMilitaryPlanes;
    }
    public List<ExperimentalPlane> getUnclassifiedExperimentalPlanes() {
        return planes.stream().filter(p -> p instanceof ExperimentalPlane).map(p -> (ExperimentalPlane)p)
                .filter(p -> p.getClassificationLevel() == ClassificationLevels.UNCLASSIFIED).collect(Collectors.toList());
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        getMilitaryPlanes().stream().filter(plane->plane.getType()==MilitaryTypes.BOMBER).forEach(x->transportMilitaryPlanes.add((MilitaryPlane) x));
        return transportMilitaryPlanes;

    }

    public List<Plane> sortByMaxDistance() {
        return planes.stream().sorted(Comparator.comparingInt(Plane::getMaxFlightDistance)).collect(Collectors.toList());
    }

    public List<Plane> sortByMaxSpeed() {
        return planes.stream().sorted(Comparator.comparingInt(Plane::getMaxSpeed)).collect(Collectors.toList());
    }

    public List<Plane> sortByMaxLoadCapacity() {
        return planes.stream().sorted(Comparator.comparingInt(Plane::getMaxLoadCapacity)).collect(Collectors.toList());

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Airport{").append("Planes=").append(planes.toString()).append(+'}');
        return stringBuilder.toString();
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<? extends Plane> planes) {
        this.planes=planes;
    }
}
