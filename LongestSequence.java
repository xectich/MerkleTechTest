
public class LongestSequence {
    /**
     * Functions takes a string and calculates the longest consecutive 
     * occurence of a character
     * @param input the input string to verify
     * @return A tuple with the character and the count of it
     */
    public static Tuple<Character,Integer> longestSequnece(String input){
        Tuple<Character,Integer> result = new Tuple<Character,Integer>(null, 0);
        int count = 0;
        for (int i = 0; i < input.length(); i++){
            // Update count if current character matches with next 
            if (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)){
                count++; 
            } 
            // If doesn't match, update result tuple and reset count 
            else
            { 
                if (count > result.y) 
                { 
                    result.y = count;
                    result.x = input.charAt(i); 
                } 
                count = 1; 
            } 
        } 
        
        return result;
    }

    
    
    /**
     * Custom tuple class for generic types
     * @param <X> first type in pair
     * @param <Y> second type in pair
     */
    private static class Tuple<X, Y> { 
        public X x; 
        public Y y; 
        public Tuple(X x, Y y) { 
          this.x = x; 
          this.y = y; 
        } 
    } 

    public static void main(String[] args){
        Tuple<Character,Integer> t1= longestSequnece("dghhhmhmx");
        System.out.println(t1.x + "," + t1.y);
        Tuple<Character,Integer> t2 = longestSequnece("dhkkhhKKKt");
        System.out.println(t2.x + "," + t2.y);
        Tuple<Character,Integer> t3 = longestSequnece("aBbBadddadd");
        System.out.println(t3.x + "," + t3.y);

    }

}



