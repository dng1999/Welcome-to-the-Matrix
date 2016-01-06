/*
  Dorothy Ng
  APCS1 pd5
  HW54 -- Red vs Blue
  2015-01-05
*/

/*====================================
  class Matrix -- models a square matrix

  TASK: Implement methods below.
  Categorize runtime of each. 
  Test in your main method.
  ====================================*/ 

public class Matrix {

    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] matrix;


    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix() {
	Object[][]temp=new Object[DEFAULT_SIZE][DEFAULT_SIZE];
	matrix=temp;
    }


    //constructor intializes an a*a matrix
    public Matrix( int a ) {
	Object[][]temp=new Object[a][a];
	matrix=temp;
    }


    //return size of this matrix, where size is 1 dimension
    private int size() {
	return matrix.length;
    }


    //return the item at the specified row & column   
    private Object get( int r, int c ) {
	return matrix[r][c];
    }


    //return true if this matrix is empty, false otherwise
    private boolean isEmpty() {
	for (int r=0;r<matrix.length;r++){
	    for (int c=0;c<matrix.length;c++){
		if (matrix[r][c]!=null){return false;}
	    }
	}
	return true;
    }

    //return true if this matrix is full, false otherwise
    private boolean isFull(){
	for (int r=0;r<matrix.length;r++){
	    for (int c=0;c<matrix.length;c++){
		if (matrix[r][c]==null){return false;}
	    }
	}
	return true;
    }


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
	Object temp = matrix[r][c];
	matrix[r][c]=newVal;
	return temp;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
	for (int i=0;i<matrix.length;i++){
	    for (int pos=0;pos<matrix[i].length;pos++){
		System.out.print(matrix[i][pos]+"\t");
	    }
	    System.out.println();
	}
	return "";
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object[][] rightSide ) {
	for (int i=0;i<matrix.length;i++){
	    for (int pos=0;pos<matrix[i].length;pos++){
		if (this.get(i,pos)!=rightSide[i][pos]){return false;}
	    }
	}
	return true;
    }


    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) {
	Object temp1;
	Object temp2;
	for (int i=0;i<matrix[0].length;i++){
	    temp1=matrix[i][c1];
	    temp2=matrix[i][c2];
	    matrix[i][c2]=temp1;
	    matrix[i][c1]=temp2;
	}
    }


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) {
        Object[] temp1;
	Object[] temp2;
	temp1=matrix[r1];
	temp2=matrix[r2];
	matrix[r2]=temp1;
	matrix[r1]=temp2;
    }


    //main method for testing
    public static void main( String[] args ) {
	Matrix sein = new Matrix();
	System.out.println("empty sein: "+sein.isEmpty());
	sein.set(0,0,"K");
	sein.set(0,1,"A");
	sein.set(1,0,"Z");
	sein.set(1,1,"U");
	System.out.println(sein);
	sein.swapColumns(0,1);
	System.out.println(sein);
	sein.swapRows(0,1);
	System.out.println(sein);
	Matrix elf = new Matrix();
	System.out.println("sein == elf: "+sein.equals(elf));
    }

}//end class Matrix