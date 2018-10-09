package amazontest;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2 {
    List<List<Integer>> optimalUtilization(
            int deviceCapacity,
            List<List<Integer>> foregroundAppList,
            List<List<Integer>> backgroundAppList)
    {
        List<TreeSet<ComplexCapacity>> tempResult = new ArrayList<>();
        foregroundAppList.forEach(forApp -> tempResult.add(getMemUsage(forApp, backgroundAppList)));
        List<List<Integer>> result = new ArrayList<>();
        //get values and select the ones inferior to deviceCapacity
        Object[] objArray = tempResult.toArray();
        List<Object> array = Arrays.asList(objArray);
        List<Object> objectList = array.stream().filter(e -> ((ComplexCapacity) e).getMemoryUsage() <= deviceCapacity).collect(Collectors.toList());
        return result;
    }

    TreeSet<ComplexCapacity> getMemUsage(List<Integer> forApp, List<List<Integer>> backgroundAppList){
       return backgroundAppList.parallelStream().map(backApp ->
                new ComplexCapacity(forApp.get(1)+backApp.get(1),
                        Arrays.asList(new Integer[]{forApp.get(0),backApp.get(0)}))).
                        collect(Collectors.toCollection(
                ()->new TreeSet<>(Comparator.comparingInt(ComplexCapacity::getMemoryUsage))));
    }

    public static void main(String[] args){
        Solution2 mySolution = new Solution2();
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        List<Integer> values2 = new ArrayList<>();
        values2.add(2);
        values2.add(4);
        List<Integer> values3 = new ArrayList<>();
        values3.add(3);
        values3.add(6);
        List<Integer> values4 = new ArrayList<>();
        values4.add(1);
        values4.add(2);
        List<List<Integer>> forApp = new ArrayList<>();
        List<List<Integer>> backApp = new ArrayList<>();
        forApp.add(values);
        forApp.add(values2);
        forApp.add(values3);
        backApp.add(values4);
        List<List<Integer>> result = mySolution.optimalUtilization(7, forApp,backApp);
        result.forEach(System.out::println);
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