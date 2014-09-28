import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class LoadFile {

	// bad practice to set to public
	// but for simplicity its not :D
	public char[][] tdArray;	// Board Storage
	public char[][] wordList;
	public int grid_row;
	public int grid_columns;
	
	//private String [] tempwordList;
	
	public LoadFile(String file)
	{
		LoadfromFile(file);
	}
	
	/**
	 * 
	 * @param file
	 * @return
	 */
	public String LoadfromFile(String file)
	{
		try
		{	
			 Scanner st = new Scanner(new File(file));
			 st.useDelimiter("\r\n\r\n");
			 String [] grid = st.next().replace(" ", "").split("\r\n");
			 String wordStr = st.next();
			 st.close();
			 String[] twordList = wordStr.split("\\s"); // all separated words split
			 grid_row = grid.length;
			 grid_columns = grid[0].length();
			 tdArray = new char[grid_row][grid_columns];
			 copyArray(grid);
			 setFormat(twordList);
		}
		 
	     catch (IOException e) 
	     {
	         //System.out.println( e.getMessage());
	    	// System.out.println(Filename);
				return file +" (No such file or directory)";
	    	// e.printStackTrace();
	     }
		return ""; 
	}
	
	public char [][]getArray()
	{
		return tdArray;
	}
	
	public char [][]getList()
	{
		return wordList;
	}
	public void setArray()
	{
	  System.out.println("Not yet Implemented");
	}
	
	public void setFormat(String []list)
	{
		
		wordList = new char[list.length][]; 
		 for ( int i = 0 ; i < list.length;i++)
		 {		 
			 // erased toUppercase , 
			wordList[i] = list[i].trim().toCharArray(); 
			//System.out.println( wordList[i]);
		 }
		 
	}
	public void  copyArray (String[] grid1 )
	{

		for ( int row = 0 ; row < grid1.length; row++)
		{
			for ( int col = 0 ; col < grid1[0].length(); col++)
			{
				tdArray[row][col] =  grid1[row].charAt(col);
			}

		}
	}
	
	/**
	 * 
	 * @param board
	 */
    public  void print(char[][] board)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        //System.out.println();
    }
    
    public void print()
    {
        for(int i = 0; i < wordList.length; i++)
        {            
        	System.out.println(wordList[i]);
        }
    }
}
