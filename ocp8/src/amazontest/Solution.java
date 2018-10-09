package amazontest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
    {
        TreeSet<ComplexLocation> sortedStoresByDistance = allLocations.parallelStream()
                .map(location -> new ComplexLocation(getDistanceToLocation(location), location))
                .collect(Collectors.toCollection(
                        ()->new TreeSet<>(Comparator.comparingDouble(ComplexLocation::getDistanceToLocation))));
        List<ComplexLocation> tempResult = sortedStoresByDistance.stream().limit(numDeliveries).collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();
        tempResult.forEach( coordinate -> result.add(coordinate.getCoordinate()));
        return result;
    }
    // METHOD SIGNATURE ENDS

    double getDistanceToLocation(List<Integer> coordinate){
        return Math.pow(coordinate.get(0),2) + Math.pow(coordinate.get(1),2);
    }


    public static void main(String[] args){
        //find shortest distances for the number of deliveries
        Solution mySolution = new Solution();
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        List<Integer> values2 = new ArrayList<>();
        values2.add(3);
        values2.add(4);
        List<Integer> values3 = new ArrayList<>();
        values3.add(1);
        values3.add(-1);
        List<List<Integer>> coords = new ArrayList<>();
        coords.add(values);
        coords.add(values2);
        coords.add(values3);
        List<List<Integer>> result = mySolution.ClosestXdestinations(3, coords,2);
        result.forEach(System.out::println);

        /*
        6,
        [[3,6],[2,4],[5,3],[2,7],[1,8],[7,9]]
        3
        result:
        2 4
        3 6
        5 3
         */
    }
}

class ComplexLocation {

    private double distanceToLocation;

    private List<Integer> coordinate;

    public ComplexLocation(double distanceToLocation, List<Integer> coordinate) {
        this.distanceToLocation = distanceToLocation;
        this.coordinate = coordinate;
    }

    public double getDistanceToLocation() {
        return distanceToLocation;
    }

    public void setDistanceToLocation(double distanceToLocation) {
        this.distanceToLocation = distanceToLocation;
    }

    public List<Integer> getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(List<Integer> coordinate) {
        this.coordinate = coordinate;
    }
}

