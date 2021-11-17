/*************************************************************************
 *  Compilation:  javac RunLengthEncoding.java
 *  Execution:    java RunLengthEncoding
 *
 *  @author:Udayan Rai, ur41, ur41@scarletmail.rutgers.edu
 *
 *************************************************************************/

public class RunLengthEncoding {

    /* 
     * Encode the original string by finding sequences in the string
     * where the same character repeats. Replace each such sequence
     * by a token consisting of: the number of characters in the sequence
     * followed by the repeating character.
     * Return the encoded string.
     */
    public static String encode (String original)  {
    String word="";
	// WRITE YOUR CODE HERE
    for(int i=0;i<original.length();i++){
        int count=1;
        while(i<original.length()-1 && original.charAt(i)==original.charAt(i+1)){
            count++;
            i++;
        }
        if(count>1)
            word=word+count+original.charAt(i);
        else
            word=word+original.charAt(i);
    }
    return word;
    }

    /*
     * Decodes the original string encoded with the encode method.
     * Returns the decoded string.
     *
     * YOUR decode METHOD MUST BE RECURSIVE, do not use while, do/while, 
     * or for loops
     */
    public static String decode (String original)  {
	
	// WRITE YOUR RECURSIVE CODE HERE
    char a= original.charAt(0);
    if(original.length()<=1){
        return original;
    }
    else{
        if(a=='2'|| a=='3'||a=='4'||a=='5'||a=='6'||a=='7'||a=='8'||a=='9'){
                char c=a;
                c--;
                original=c+original.substring(1);
                return original.substring(1,2)+decode(original);   
        }
        else if(a=='1'){
            return decode(original.substring(1));
        }
        else{
            return a+decode(original.substring(1));
        }
    }
    }

    public static void main (String[] args) {

	// WRITE YOUR TEST CASES HERE to test your methods
    String out= encode("hhhhhheLLoooooooWooorlllddd");
    StdOut.println(out);
    String expand= decode(out);
    StdOut.println(expand);
    }
}
