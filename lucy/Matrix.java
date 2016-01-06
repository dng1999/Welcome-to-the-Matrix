/*
Lucy Tang
APCS1 pd5
HW54--Red vs Blue
2015-1-5
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
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }//n(1)

    
    //constructor intializes an a*a matrix
    public Matrix( int a ) {
	matrix = new Object[a][a];
    }//n(1)


    //return size of this matrix, where size is 1 dimension
    private int size() {
	return matrix.length; //# of rows
    }//n(1)


    //return the item at the specified row & column   
    private Object get( int r, int c ) {
	return matrix[r][c];
    }//n(1)

    
    //return true if this matrix is empty, false otherwise
    private boolean isEmpty( int r, int c ) {
	return matrix[r][c] == null;
    }//n(1)


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
	Object oldVal = matrix[r][c];
	matrix[r][c] = newVal;
	return oldVal;
    }//n(1)


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
	String retStr = "";
	for (int r = 0; r < this.size(); r++){
	    for (int c = 0; c < this.size(); c++){
		retStr += matrix[r][c] + "\t";
	    }
	    retStr += "\n";
	}
	return retStr;
    }
    //(n^2)

    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) {
	if (this.size() == ((Matrix)rightSide).size()){ //identical dimensions
	    for (int r = 0; r < this.size(); r++){ 
	        for (int c = 0; c < this.size(); c++){ 
		    if (matrix[r][c] != ((Matrix)rightSide).get(r,c))
			return false;
		}
	    }
	    return true;
	}
	return false;   
    }//n(^2)


    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) {
	for (int r = 0; r < this.size(); r++){
	    Object c1Val = matrix[r][c1];
	    matrix[r][c1] = matrix[r][c2];
	    matrix[r][c2] = c1Val;
	}
    }//(n)


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) {
	for (int c = 0; c < this.size(); c++){
	    Object r1Val = matrix[r1][c];
	    matrix[r1][c] = matrix[r2][c];
	    matrix[r2][c] = r1Val;
	}
    }//(n)

    public boolean isFull(){
	for (int r = 0; r < this.size(); r++){
	    for (int c = 0; c < this.size(); c++){
		if (matrix[r][c] == null) return false;
	    }
	}
	return true;
    }

    public Object[] getRow(int r){
	Object[] row = new Object[this.size()];
	for (int c = 0; c < this.size(); c++){
	    row[c] = this.get(r,c);
	}
	return row;
    }

    //returns ________
    public Object[] setRow(int r,Object[]newRow){
	//for (int c = 0; c < this.size(); c++){
	//matrix[r][c] = newRow[r][c];
	//}
	Object[] temp = matrix[r];
	matrix[r] = newRow;
	return temp;
    }

    public Object[] getCol(int c){
	Object[] col = new Object[this.size()];
	for (int r = 0; r < this.size(); r++){
	    col[r] = this.get(r,c);
	}
	return col;
    }

    //returns _________
    public Object[] setCol(int c,Object[]newCol){
	//for (int r = 0; r < this.size(); r++){
	//matrix[r][c] = newCOL[r][c];
	//}
	Object[] temp = matrix[c];
	matrix[c] = newCol;
	return temp;
    }
    
    public void transpose(){
	Object[][] newMatrix = new Object[this.size()][this.size()];
	//Matrix newMatrix = new Matrix(this.size());
	for (int c = 0; c < this.size(); c++){
	    //((Matrix)newMatrix).setRow(c,this.getCol(c));
	    newMatrix.setRow(c,this.getCol(c));
	}
	matrix = newMatrix;
    }
    
    //main method for testing
    public static void main( String[] args ) {
	Matrix first = new Matrix();
	System.out.println(first);
	System.out.println(first.size());
	first.set(1,1,5);
	System.out.println(first.get(1,1)); //5
	System.out.println(first.isEmpty(1,1)); //false
	System.out.println(first.isEmpty(0,0)); //true
	System.out.println();

	Matrix second = new Matrix(2);
	System.out.println(second);
	System.out.println(second.size());
	second.set(1,1,5);
	System.out.println(second.get(1,1)); //5
	System.out.println(second.isEmpty(1,1)); //false
	System.out.println(second.isEmpty(0,0)); //true
	System.out.println();

	System.out.println(first.equals(second)); //true

	first.swapColumns(0,1);
	System.out.println(first);
	first.swapRows(0,1);
	System.out.println(first);

    }

}//end class Matrix
