package calculus;

/**
 * Hello world!
 */
public final class Matrix {

  private final int M;             // number of rows
  private final int N;             // number of columns
  private final double[][] data;   // M-by-N array


  public Matrix() throws Exception{
    this(new double[0][0]);
  }

 //Constructor de matriz
 public Matrix(int M, int N) {

      // Lanzar exceptión si N o M < 0
      this.M = M;
      this.N = N;
      data = new double[M][N];
  }

 //Constructor de matriz con array bidimensional
 public Matrix(double[][] data) throws Exception, NullPointerException {
  M = data.length;
  N = data[0].length;
  this.data = new double[M][N];

  int aux = N;
  try{

    for (int i = 0; i < M; i++){
        if(aux != data[i].length) throw new Exception();
        aux = data[i].length;
    }

  for (int i = 0; i < M; i++)
      for (int j = 0; j < N; j++)
              this.data[i][j] = data[i][j];

} catch  (NullPointerException e1){
    System.out.println("Contiene nulos");
    throw e1;
} catch  (Exception e2){
  System.out.println("Filas de diferente tamaño");
  throw e2;
}

}

 //Constructor de matriz con array bidimensional
 public double[][] toArray() {
  double[][] array = new double[M][N];
  for (int i = 0; i < M; i++)
      for (int j = 0; j < N; j++)
          array[i][j] = this.data[i][j];
return array;
}

//imprimir matriz
public void to_string() {
      for (int i = 0; i < M; i++) {
          for (int j = 0; j < N; j++) 
              System.out.printf("%9.4f ", data[i][j]);
          System.out.println();
      }
  }

      
//metodo quitar fila
  public static Matrix quitarFila (Matrix m  , int n) throws Exception{ 
    
    Matrix res  = null;
      // if(!esMatriz(m)){   
      //                    return null;  }     
    try{
      if (n >= m.data.length  ||  n<0) throw new Exception();

     res  = new Matrix(m.data.length-1,m.data[0].length);

      for(int  i = 0;i <  res.data.length;i++){      
        for(int   j =  0; j < res.data[i].length;j++) {  
              if  (i <  n){            
                  res.data[i][j]  =  m.data[i][j];            
                          }                   
              else if  (i >=n && i+1 <  m.data.length){   
                          res.data[i][j] = m.data[i+1][j];            
                                                  }                     
                }                
         }     

     }catch(Exception e1){
          System.out.println("No existe la fila");
          throw e1;
        }   
      finally{
        return res;
      }                    
              
    }    
                                                              

    //MAIN PARA MOSTRAR RESULTADOS
    public static void main(String[] args) throws Exception{
      double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3} };
      Matrix D = new Matrix(d);
      System.out.println("Matriz D:");
      D.to_string();        
      System.out.println();
      int fila = -1;
      Matrix F = quitarFila(D, fila);
      System.out.println("Matriz D sin fila " + fila);
      F.to_string();        
      System.out.println();
      double [][] array = F.toArray();
      System.out.println("Imprimos array");
      for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[0].length; j++) 
            System.out.printf("%9.4f ", array[i][j]);
      System.out.println();
  }


}




}