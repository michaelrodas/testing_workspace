package com.internal.experimental.amazontest;

import java.util.*;
import java.util.stream.Collectors;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    /*
        Find shortest distances for the number of deliveries requested
     */

    List<List<Integer>> closestXdestinations(int numDestinations,
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


    private double getDistanceToLocation(List<Integer> coordinate){
        return Math.pow(coordinate.get(0),2) + Math.pow(coordinate.get(1),2);
    }


    public static void main(String[] args){
        Solution mySolution = new Solution();
        List<Integer> values = Arrays.asList(1,2);
        List<Integer> values2 = Arrays.asList(3,4);
        List<Integer> values3 = Arrays.asList(1,-1);
        List<List<Integer>> coords = Arrays.asList(values,values2,values3);
        List<List<Integer>> result = mySolution.closestXdestinations(3, coords,2);
        System.out.println("Case 1:");
        result.forEach(System.out::println);

        List<Integer> cvalues = Arrays.asList(3,6);
        List<Integer> cvalues2 = Arrays.asList(2,4);
        List<Integer> cvalues3 = Arrays.asList(5,3);
        List<Integer> cvalues4 = Arrays.asList(2,7);
        List<Integer> cvalues5 = Arrays.asList(1,8);
        List<Integer> cvalues6 = Arrays.asList(7,9);
        List<List<Integer>> coords2 = Arrays.asList(cvalues,cvalues2,cvalues3,cvalues4,cvalues5,cvalues6);
        List<List<Integer>> result2 = mySolution.closestXdestinations(6, coords2,3);
        System.out.println("Case 2:");
        result2.forEach(System.out::println);
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

