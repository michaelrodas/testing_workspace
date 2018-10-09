package amazontest;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2 {
    /*
        Find optimal memory usage by combining foreground app with background app
        if memory usage is equal than capacity, it's optimal, otherwise like for closest ones
     */

    List<List<Integer>> optimalUtilization(
            int deviceCapacity,
            List<List<Integer>> foregroundAppList,
            List<List<Integer>> backgroundAppList)
    {
        List<TreeSet<ComplexCapacity>> orderedFoundCapacities = new ArrayList<>();
        foregroundAppList.forEach(forApp -> orderedFoundCapacities.add(getMemUsage(forApp, backgroundAppList)));
        List<List<Integer>> exactCapacity = new ArrayList<>();
        List<List<Integer>> closeCapacity = new ArrayList<>();
        //get values and select the ones inferior to deviceCapacity
        orderedFoundCapacities.forEach(set -> exactCapacity.addAll(set.parallelStream().filter(e -> e.getMemoryUsage() == deviceCapacity)
                .map(ComplexCapacity::getCoordinate).collect(Collectors.toList())));
        if(exactCapacity.isEmpty()){
            orderedFoundCapacities.forEach(set -> closeCapacity.addAll(set.parallelStream().filter(e -> (e.getMemoryUsage() <= deviceCapacity)
                    && e.getMemoryUsage() >= ((deviceCapacity+e.getMemoryUsage())/2))
                    .map(ComplexCapacity::getCoordinate).collect(Collectors.toList())));
            return closeCapacity;
        } else {
            return exactCapacity;
        }
    }

    TreeSet<ComplexCapacity> getMemUsage(List<Integer> forApp, List<List<Integer>> backgroundAppList){
       return backgroundAppList.parallelStream().map(backApp ->
                new ComplexCapacity(forApp.get(1)+backApp.get(1),
                        Arrays.asList(forApp.get(0),backApp.get(0)))).
                        collect(Collectors.toCollection(
                ()->new TreeSet<>(Comparator.comparingInt(ComplexCapacity::getMemoryUsage))));
    }

    public static void main(String[] args){
        Solution2 mySolution = new Solution2();
        List<Integer> values = Arrays.asList(1,2);
        List<Integer> values2 = Arrays.asList(2,4);
        List<Integer> values3 = Arrays.asList(3,6);
        List<Integer> values4 = Arrays.asList(1,2);
        List<List<Integer>> forApp = Arrays.asList(values,values2,values3);
        List<List<Integer>> backApp = Arrays.asList(values4);
        List<List<Integer>> result = mySolution.optimalUtilization(7, forApp,backApp);
        System.out.println("Case 1:");
        result.forEach(System.out::println);

        List<Integer> forValues = Arrays.asList(1,3);
        List<Integer> forValues2 = Arrays.asList(2,5);
        List<Integer> forValues3 = Arrays.asList(3,7);
        List<Integer> forValues4 = Arrays.asList(4,10);
        List<List<Integer>> forApp2 = Arrays.asList(forValues,forValues2,forValues3,forValues4);
        List<Integer> backValues = Arrays.asList(1,2);
        List<Integer> backValues2 = Arrays.asList(2,3);
        List<Integer> backValues3 = Arrays.asList(3,4);
        List<Integer> backValues4 = Arrays.asList(4,5);
        List<List<Integer>> backApp2 = Arrays.asList(backValues,backValues2,backValues3,backValues4);
        List<List<Integer>> result2 = mySolution.optimalUtilization(10, forApp2,backApp2);
        System.out.println("Case 2:");
        result2.forEach(System.out::println);
    }
}
/*
input:
device capacity
foregroundAppList
backgroundAppList
Case 1:
7,
[[1,2],[2,4],[3,6]]
[[1,2]]
result:
[[2,1]]

Case 2:
10,
[[1,3],[2,5],[3,7],[4,10]]
[[1,2],[2,3],[3,4],[4,5]]
result:
[[2,4],[3,2]]
 */
class ComplexCapacity {

    private int memoryUsage;

    private List<Integer> coordinate;

    public ComplexCapacity(int memoryUsage, List<Integer> coordinate) {
        this.memoryUsage = memoryUsage;
        this.coordinate = coordinate;
    }

    public int getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(int memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public List<Integer> getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(List<Integer> coordinate) {
        this.coordinate = coordinate;
    }
}