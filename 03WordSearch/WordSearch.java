package dev.java.wordsearch;

import java.util.*;

import javax.xml.crypto.Data;

import java.io.*;



public class WordSearch {
	private char[][]data;
	private char[][]solution;
	private Random randgen;
	private ArrayList<String>wordsToAdd;
	private ArrayList<String>wordsAdded;
	private int seed;

    
    public WordSearch(int rows,int cols){
    		
    		randgen = new Random();
		wordsToAdd = new ArrayList<String>();
		wordsAdded = new ArrayList<String>();
    		this.data = new char[rows][cols];
    		clear();
    }
    	
    public WordSearch(int rows, int cols, String fileName) {
    		
    		this(rows,cols);
		
    		clear();
    		
    		try{
    		      File f = new File(fileName);//can combine
    		      Scanner in = new Scanner(f);//into one line
    		      
    		        //NOW read the file here...
    		      while(in.hasNext()){
    		          String line = in.nextLine();
    		          wordsToAdd.add(line.toUpperCase());
    		}

    		}catch(FileNotFoundException e){
    		      System.out.println("File not found: " + fileName);
    		      //e.printStackTrace();
    		      System.exit(1);
    		}
    		
    		seed = randgen.nextInt();
    		randgen = new Random(seed);
    		
    		addAllWords();
    		
    		setSolution();
    		
    		fillEmpty();
    		
    }
    
    public WordSearch( int rows, int cols, String fileName, int randSeed) {
    		this(rows,cols);
    		
    		clear();
    		
    		try{
  		      File f = new File(fileName);//can combine
  		      Scanner in = new Scanner(f);//into one line
  		      
  		        //NOW read the file here...
  		      while(in.hasNext()){
  		          String line = in.nextLine();
  		          wordsToAdd.add(line);
  		}

  		}catch(FileNotFoundException e){
  		      System.out.println("File not found: " + fileName);
  		      //e.printStackTrace();
  		      System.exit(1);
  		}
    		
    		seed = randSeed;
    		randgen = new Random(seed);
    		
    		addAllWords();
    		
    		setSolution();
    		
    		fillEmpty();
    		
    }
    
    public void setSolution() {
    		solution = new char[data.length][data.length];
    		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < data.length; k++) {
				solution[i][k] = data[i][k];
			}
		}
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
    public String toString(char[][] data){
    		String ans = "";
    		int l = data.length;
    		if (l == 0) {
    			return "[]";
    		}
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

    private boolean addWord(int row, int col, String word, int rInc, int cInc) {
    		int l = word.length();
		if (row > data.length || col > data.length) {
			return false;
		}
		if (col + l*rInc >= 0 && row + l * cInc >= 0) {
			if (data.length >= col + l*rInc && data.length >= row + l*cInc)  {
				for (int i = 0; i < l; i++) {
					if (data[row+i*cInc][col+i*rInc] == '_') {
						data[row+i*cInc][col+i*rInc] = word.charAt(i);
					}
					else {
						if (data[row+i*cInc][col+i*rInc] != word.charAt(i)) {
							return false;
						}
					}
				}
				wordsAdded.add(word);
				wordsToAdd.remove(word);
				return true;
			}
		}
		return false;
    }
    
    public boolean addAllWords() {
    		int a;
    		int z = 0;
    		int x,y;
    		int r,c;
    		if (data.length != 0) {	
    			while (wordsToAdd.size() != 0 && z < 1000) {
    				a = randgen.nextInt(wordsToAdd.size());
    				x = randgen.nextInt(data.length);
    				y = randgen.nextInt(data.length);
    				
    				r = randgen.nextInt()%2;
    				c = randgen.nextInt()%2;
    				
    				while (r==0 && c ==0) {
    					r = randgen.nextInt()%2;
    					c = randgen.nextInt()%2;
    				}
    			
    				addWord(x,y,wordsToAdd.get(wordsToAdd.size()-a-1), r, c);
    				z++;
    			}
    		}
    		return true;
    }
    
    public String getData() {
		return this.toString(data);
	}

	public String getSolution() {
		return this.toString(solution);
	}

	public ArrayList<String> getWordsAdded() {
		return wordsAdded;
	}

	public int getSeed() {
		return seed;
	}

	private void fillEmpty() {
    		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < data.length; k++) {
				if (data[i][k] == '_') {
					data[i][k] = (char) (randgen.nextInt(26) + 65);
				}
			}
		}
    }
    public static void main(String[] args) {
    		if (args.length == 5) {
    			try {
    				int x = Integer.parseInt(args[0]);
    				int y = Integer.parseInt(args[1]);
    				String f = args[2];
    				int s = Integer.parseInt(args[3]);
    				String k = args[4];
    				
    				WordSearch a = new WordSearch(x,y,f,s);
    	    			System.out.println(a.getData());
    	    			System.out.println(a.getWordsAdded());
    	    			if (k.equals("key")) {
    	    				System.out.println(a.getSolution());	
    	    			}
    			}
    			catch (IllegalArgumentException e) {
    				System.out.print("Try removing all terminal arguments to see the instruction");
    			}
    		}
    		else if (args.length == 4) {
    			try {
    				int x = Integer.parseInt(args[0]);
    				int y = Integer.parseInt(args[1]);
    				String f = args[2];
    				int s = Integer.parseInt(args[3]);
    				
    				WordSearch a = new WordSearch(x,y,f,s);
    	    			System.out.println(a.getData());
    	    			System.out.println(a.getWordsAdded());
    	    			
    			}
    			catch (IllegalArgumentException e) {
    				System.out.print("Try removing all terminal arguments to see the instruction");
    			}
    		}
    		else if (args.length == 3) {
    			try {
    				int x = Integer.parseInt(args[0]);
    				int y = Integer.parseInt(args[1]);
    				String f = args[2];
    				
    				WordSearch a = new WordSearch(x,y,f);
    	    			System.out.println(a.getData());
    	    			System.out.println(a.getWordsAdded());
    	    			System.out.println("The seed for this puzzle is :" + a.getSeed());
    	    			
    			}
    			catch (IllegalArgumentException e) {
    				System.out.print("Try removing all terminal arguments to see the instruction");
    			}
    		}
    		else if (args.length == 0) {
    			String instruction = "To initilize a wordSearch, insert parameters following the format: row cols filename randSeed answers";
    			System.out.println(instruction);
    		}
    		else {
    			System.out.println("Please do something sensible");
    		}
    }
}
