import java.util.*;

public class SecondLowest {

    /**
     * Gets the lowest occurence of a number in a list
     * @param input the list
     * @return the second lowest occuring element
     */
    public static int secondLowest(List<Integer> input){
        Map<Integer,Integer> counts = new HashMap<>();

        //get the occurences of each character
        for (Integer item : input) {
            if(counts.containsKey(item)){
                counts.put(item,counts.get(item) + 1);
            }else{
                counts.put(item, 1);
            }
        }

        //keep track of the first lowest and second lowest counts and 
        //which elements they correspond to
        int first = counts.get(input.get(0)), second = counts.get(input.get(0));
        int firstLowest =input.get(0); int secondLowest = input.get(0);

        //loop map and do the check
        for(Integer key : counts.keySet()){
            if(counts.get(key) > first){
                second = first;
                secondLowest = firstLowest;
                first = counts.get(key);
                firstLowest = key;
            }else if(counts.get(key) > second && counts.get(key) != first){
                second = counts.get(key);
                secondLowest = key;
            }
        }
        if(first == second){
            return firstLowest > secondLowest ? firstLowest : secondLowest;
        }else{
            return secondLowest;
        }

        
    }

    public static void main(String[] args){
       //as the problem was not clearly defined, i also take into account 
       //occurences with count of 1 when producing the result
       //this example shows the second lowest with numbers having multiple 
       //occurences
       ArrayList<Integer> list = new ArrayList<>();
       list.add(3);
       list.add(3);
       list.add(3);
       list.add(1);
       list.add(1);
       list.add(2);
       list.add(2);
       list.add(2);
       list.add(2);
       System.out.println(secondLowest(list));

    }

}