import java.util.Arrays;

//Author Tatek Ahmed
public class CountingCharacter {
    public static void main(String[] args) {
        String mystr = "ahabcjahbdcjbjj";
        System.out.println ("Input: "+ mystr);
        System.out.println ("Output: "+ countCharacters (mystr));
    }
    private static String countCharacters(String myStr){
        StringBuffer sb = new StringBuffer ();
        char []ch = myStr.toCharArray ();
        Arrays.sort (ch);
        String str = new String (ch);
        //at this point this is the input aaabbbccdhhjjjj
        Integer count = 1;Integer shift = 0;
        for (int i = 0; i < str.length (); i++) {
            //this loop is only counting occurrence
            for (int j = i+1; j < str.length (); j++) {
                if (str.charAt (i+shift) == str.charAt (j))
                    count++;
                if (str.charAt (i) != str.charAt (j))
                    //when character differ exit the inner loop
                    break;
            }
            //this will merge the counted character and number
            if (!(sb.toString ().contains (str.substring (i,i+1))))
                sb.append (str.charAt (i));//collecting new character
            if (count >1)
                sb.append (count);
            i+=(count -1);//shift the index to the next uncounted character
            count = 1;//resetting counter
        }
        return sb.toString ();
    }
}
