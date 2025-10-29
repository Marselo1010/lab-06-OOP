package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int MIN = 1000;
    private static final int MAX = 2000;
    private static final int FIRST_ELEM = 0;
    private static final int ELEMS = 100_000;
   
    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

         ArrayList<Integer> myArray = new ArrayList<>(); 
         
       
        for( Integer i = MIN ; i<=MAX;i++ ){
            myArray.add(i);
         }



        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer>myList = new LinkedList<>(myArray);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        Integer tmp = myArray.getFirst();;
        myArray.set(FIRST_ELEM, myArray.getLast());
        myArray.set(myArray.size() - 1, tmp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer iter : myArray) {
            System.out.println(iter);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            myArray.addFirst(i);
        }
        time = System.nanoTime() - time;
        System.out.println("adding 100 000 elements to array list -> time: " + time);


        time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            myList.addFirst(i);
        }
        time = System.nanoTime() - time;
        System.out.println("adding 100 000 elements to linked list -> time: " + time);


        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();

        for (int i = 1; i <= 1000; i++) {
            myArray.get( myArray.size() / 2 );
        } 
        time = System.nanoTime() - time;
       System.out.println("reading 1000 elements to array list -> time: " + time);


        time = System.nanoTime();

        for (int i = 1; i <= 1000; i++) {
            myList.get( myList.size() / 2 );
        } 
        time = System.nanoTime() - time;
        System.out.println("reading 1000 elements to linked list -> time: " + time);




        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */


         
        HashMap<String, Long> continentPopulation = new HashMap<>();

        
        continentPopulation.put("Africa", 1_110_635_000L);
        continentPopulation.put("Americas", 972_005_000L);
        continentPopulation.put("Antarctica", 0L);
        continentPopulation.put("Asia", 4_298_723_000L);
        continentPopulation.put("Europe", 742_452_000L); 
        continentPopulation.put("Oceania", 38_304_000L);

       
        /*
         * 8) Compute the population of the world
         */
        Long sum=0L;
        for (final Long  i : continentPopulation.values()) {
            sum += i;
        }
         System.out.println("sum of the world's population : " + sum);
    }
}