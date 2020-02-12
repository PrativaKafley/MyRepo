package TestPkg;

import java.util.*;

public class QAworkFlow {
public static void main(String avg[]) {
List<String> list1 = new ArrayList();
list1.add("MF1");
list1.add("MF2");
list1.add("MF3");

List<String> list2 = new ArrayList();
list2.add("MTAC1");
list2.add("MTAC2");
list2.add("MTAC3");
list2.add("MTAC4");
list2.add("MTAC5");

List<String> list3 = new ArrayList();
list3.add("I1");
list3.add("I2");
list3.add("I3");
list3.add("I4");

List<String> list4 = new ArrayList();
list4.add("DC1");
list4.add("DC2");

List<List<String>> lists = new ArrayList<List<String>>();
lists.add(list1);
lists.add(list2);
lists.add(list3);
lists.add(list4);

Set<List<String>> combs = getCombinations(lists);
int index1 = 0;
for(List<String> list : combs) {
    System.out.println(list.toString() + index1++);
    for(String e : list){
        System.out.println(e);//e.click then Next.click
    }
}
}

public static <T> Set<List<T>> getCombinations(List<List<T>> lists) {
    Set<List<T>> combinations = new HashSet<List<T>>();
    Set<List<T>> newCombinations;

    int index = 0;

    // extract each of the strings in the first list
    // and add each to ints as a new list
    for(T i: lists.get(0)) {
        List<T> newList = new ArrayList<T>();
        newList.add(i);
        combinations.add(newList);
    }
    index++;
    while(index < lists.size()) {
        List<T> nextList = lists.get(index);
        newCombinations = new HashSet<List<T>>();
        for(List<T> first: combinations) {
            for(T second: nextList) {
                List<T> newList = new ArrayList<T>();
                newList.addAll(first);
                newList.add(second);
                newCombinations.add(newList);
            }
        }
        combinations = newCombinations;

        index++;
    }

    return combinations;
}

}