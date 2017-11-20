package dev.java.wordsearch;

public class WordSearch {
	private char[][]data;

    /**Initialize the grid to the size specified 
     *fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    public WordSearch(int rows,int cols){
    		this.data = new char[rows][cols];
    		clear();
    }

    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
    		for (int i = 0; i < data.length; i++) {
    			for (int k = 0; k < data.length; k++) {
    				data[i][k] = '_';
    			}
    		}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
    		String ans = "";
    		int l = data.length;
    		for (int i = 0; i < l; i++) {
			for (int k = 0; k < l; k++) {
				ans+= data[i][k];
				if (k != l-1) {
					ans+= " ";
				} 
			}
			ans+= "\n";
		}
    		return ans;
    }


    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned 
     * and the board is NOT modified.
     */
    public boolean addWordHorizontal(String word,int row, int col){
    		int l = word.length();
    		if (row >= data.length || col >= data.length) {
    			return false;
    		}
    		if (data.length >= col + l) {
    			for (int i = 0; i < l; i++) {
    				if (data[row][col+i] == '_') {
    					data[row][col+i] = word.charAt(i);
    				}
    				else {
    					if (data[row][col+i] != word.charAt(i)) {
    						return false;
    					}
    				}
    			}
    			return true;
    		}
    		else if (col - l >= -1) {
    			for (int i = 0; i < l; i++) {
    				if (data[row][col-i] == '_') {
    					data[row][col-i] = word.charAt(i);
    				}
    				else {
    					if (data[row][col-i] != word.charAt(i)) {
    						return false;
    					}
    				}
    			}
    			return true;
    		}
    		return false;
    }

   /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.
     */
    public boolean addWordVertical(String word,int row, int col){
    		int l = word.length();
    		if (row >= data.length || col >= data.length) {
    			return false;
    		}
		if (data.length >= row + l) {
			for (int i = 0; i < l; i++) {
				if (data[row+i][col] == '_') {
					data[row+i][col] = word.charAt(i);
				}
				else {
					if (data[row+i][col] != word.charAt(i)) {
						return false;
					}
				}
			}
			return true;
		}
		else if (col - l >= -1) {
			for (int i = 0; i < l; i++) {
				if (data[row-i][col] == '_') {
					data[row-i][col] = word.charAt(i);
				}
				else {
					if (data[row-i][col] != word.charAt(i)) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
    }
    public static void main(String[] args) {
    		WordSearch a = new WordSearch(4,4);
    		System.out.println(a);
    		a.addWordHorizontal("hi", 1, 1);
    		a.addWordVertical("hey", 1, 1);
    		System.out.println(a);
    }
}
