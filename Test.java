package test;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
 
public class Test {
 
    public static void main(String args[]) {
 
        // Java 1.4 way of using Collection
        List even = new ArrayList();
        even.add(Integer.valueOf(2));
        even.add(Integer.valueOf(4));
        even.add(Integer.valueOf(6));
        even.add(Integer.valueOf(8));
 
        for(int i=0; i<even.size(); i++){
            Integer number = (Integer)even.get(i);
            int num = number.intValue();
            System.out.println("Double of even number : " + num*2);
        }
 
 
        // Java 5 way
        List<Integer> odd = new ArrayList(Arrays.asList(new Integer[]{3, 5, 7, 9, 11}));
 
        for(Integer num : odd){
            System.out.println("Doulbe of odd number : " + num*2);
        }
 
 
       // Iterate through a List and test each element
       Collection<String> collection = Arrays.asList("ArrayList","Vector",
                                             "LinkedList", "CopyOnWriteArrayList");
       int count = 0;
       for(String str : collection){
           if(str.endsWith("List")){
               count +=1;
           }
       }
       System.out.println("Number of List which ends with word list :" + count);
 
       
       // Java 8, using functional predicate as Java 7 way (anonymous class)
       Collection<String> lists = Arrays.asList("ArrayList","Vector",
                                           "LinkedList", "CopyOnWriteArrayList");
       long endsWithList = lists.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String element) {
                return element.endsWith("List");
            }
        }).count();
 
       System.out.println("Number of List implementation which ends with word list :" 
                                          + endsWithList);
 
 
       // Java 8 Clean code example using lambda exprssion
       Collection<String> myList = Arrays.asList("ArrayList","Vector",
                                              "LinkedList", "CopyOnWriteArrayList");
       long listEndsWithList = myList.stream()
                                     .filter(element -> element.endsWith("List"))
                                     .count();
       System.out.println("Number of List classes which ends with word list :" 
                                                   + listEndsWithList);
 
    }
 
}