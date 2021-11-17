/*************************************************************************
 *  Compilation:  javac RURottenTomatoes.java
 *  Execution:    java RURottenTomatoes
 *
 *  @author:Udayan Rai, ur41@scarletmail.rutgers.edu, ur41
 *
 * RURottenTomatoes creates a 2 dimensional array of movie ratings 
 * from the command line arguments and displays the index of the movie 
 * that has the highest sum of ratings.
 *
 *  java RURottenTomatoes 3 2 5 2 3 3 4 1
 *  0
 *************************************************************************/

public class RURottenTomatoes {

    public static void main(String[] args) {

		// WRITE YOUR CODE HERE
		int row= Integer.parseInt(args[0]);
		int col=Integer.parseInt(args[1]);
		int[][] ratings= new int[row][col];

		int index=2;
		while(index<args.length){
			for(int r=0; r<row;r++){
				for(int c=0; c<col; c++){
					ratings[r][c]=Integer.parseInt(args[index]);
					index++;
				}
			}
		}
		int[] sums= new int[col];
		for(int c=0;c<col;c++){
			for(int r=0;r<row;r++){
				sums[c]+=ratings[r][c];
			}
		}
		int greatest=sums[0];
		int greatestI=0;
		for(int i=0; i<sums.length; i++){
			if(sums[i]>greatest){
				greatest=sums[i];
				greatestI=i;
			}
		}
		System.out.println(greatestI);
	}
}
