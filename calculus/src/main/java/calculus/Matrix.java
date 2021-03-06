package calculus;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;

/**
 * Hello world!
 */
public class Matrix {

  private int M;             // number of rows
  private int N;             // number of columns
  private double[][] data;   // M-by-N array



  public Matrix() throws Exception{
    this(new double[0][0]);
  }
//-----------------------------------------------------------------------------
//Constructor de matriz
 public Matrix(int M, int N) throws Exception {
      // Lanzar exceptión si N o M < 0
      if (M < 0 || N < 0) throw new Exception();
      this.M = M;
      this.N = N;
      data = new double[M][N];

  }
//-----------------------------------------------------------------------------
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
//-----------------------------------------------------------------------------
//Metodo para pasar matriz a array
 public double[][] toArray() {
  double[][] array = new double[M][N];
  for (int i = 0; i < M; i++)
      for (int j = 0; j < N; j++)
          array[i][j] = this.data[i][j];
return array;
}

//-----------------------------------------------------------------------------
//metodo para imprimir la matriz
public void print() {
      for (int i = 0; i < M; i++) {
          for (int j = 0; j < N; j++) 
              System.out.printf("%9.4f ", data[i][j]);
          System.out.println();
      }
  }

//-----------------------------------------------------------------------------
//metodo de matriz toString
@Override
public String toString() {
    String s = new String();
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            s +="\t" + data[i][j];
        }
        s += "\n";
    }
    return s;
}

//-----------------------------------------------------------------------------
//metodo para clonar matriz 
public Matrix getClone() throws Exception, NullPointerException{
  return new Matrix(data);
}

//-----------------------------------------------------------------------------
//metodo quitar fila
  public static Matrix quitarFila (Matrix m  , int n) throws Exception{ 
    
    Matrix res  = null; 
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

//-----------------------------------------------------------------------------
//metodo para quitar columna
  public static Matrix quitarColumna (Matrix m  , int n) throws Exception{ 
    
    Matrix res  = null;    
    try{
      if (n >= m.data.length  ||  n<0) throw new Exception();

     res  = new Matrix(m.data.length,m.data[0].length-1);

      for(int  i = 0; i <  res.data.length;i++){      
        for(int   j =  0; j < res.data[i].length;j++) {  
              if  (i <  n){            
                  res.data[i][j]  =  m.data[i][j];            
                          }                   
              else if  (j >=n && j+1 <  m.data[i].length){   
                          res.data[i][j] = m.data[i][j+1];            
                                                  }                     
                }                
         }     
     }catch(Exception e2){
          System.out.println("No existe la columna");
          throw e2;
        }   
      finally{
        return res;
      }       
    }

//-----------------------------------------------------------------------------
//método obtener Fila
    public static double[] obtenerFila(Matrix m, int n) throws Exception {
      Matrix res = new Matrix(0, 0);
      double[] row = new double[0];

    try {
      if (n >= m.data[0].length || n < 0)
          throw new Exception();
        res = new Matrix(m.data.length - 1, m.data[0].length);
        row = new double[n];

        for (int i = 0; i < res.data.length; i++) {
          for (int j = 0; j < res.data[i].length; j++) {
            if (i == n) {
              res.data[n][j] = row[i];
                        }
                                                        }
                                                  }
    } catch (Exception e3) {
      System.out.println("No existe la Fila");
      throw e3;
                            } finally {
                              return row;
                                      }
                                                                           }

//-----------------------------------------------------------------------------
// método obtener Columna
    public static double[] obtenerColumna(Matrix m, int c) throws Exception {
      Matrix res = new Matrix(0, 0);
      double[] column = new double[0];
  
      try {
            if (c >= m.data[0].length || c < 0)
            throw new Exception();
          res = new Matrix(m.data.length - 1, m.data[0].length);
          column = new double[c];
    
          for (int i = 0; i < res.data.length; i++) {
            for (int j = 0; j < res.data[i].length; j++) {
              if (j == c) {
                res.data[i][c] = column[i];
                          }   
                                                        }
                                                      }
      } catch (Exception e4) {
        System.out.println("No existe la Columna");
        throw e4;
                            } finally {
                              return column;
                            }
                                                                              }

//----------------------------------------------------------------------------
// método obtener traspuesta
public Matrix getTraspuesta()throws Exception, NullPointerException {
  Matrix tr = new Matrix(this.data);
  for (int i = 0; i < tr.data.length; i++){
    for (int j = 0; j < tr.data[i].length; j++){
      tr.data[i][j] = this.data[j][i];
    }
  }
  return tr;
}    
//----------------------------------------------------------------------------
  // metodo para comparar las matrices
  @Override
  public boolean equals(Object m) {

    if (!(m instanceof Matrix)) {
      return false;
    }
    if (m == null) {
      return false;
    }

    Matrix mm1 = (Matrix) this;
    Matrix mm2 = (Matrix) m;

    if (mm1 == mm2) {
      return true;
    }

    if (mm1.data.length != mm2.data.length) {
      return false;
    }

    if (mm1.data[0].length != mm2.data[0].length)
      return false;

    for (int i = 0; i < mm1.data.length; i++)
      for (int j = 0; j < mm1.data[0].length; j++)
        if (mm1.data[i][j] != mm2.data[i][j])
          return false;

    return true;
  }
//-----------------------------------------------------------------------------
// MAIN PARA MOSTRAR RESULTADOS
  public static void main(String[] args) throws Exception {
    double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3 } };
    Matrix D = new Matrix(d);
    System.out.println("Matriz D:");
    D.print();
    System.out.println();

    int fila = 1;
    Matrix F = quitarFila(D, fila);
    System.out.println("Matriz F sin fila " + fila);
    F.print();
    System.out.println();

      int columna = 1;
      Matrix FF = quitarColumna(D, columna);
      System.out.println("Matriz FF sin columna " + columna);
      FF.print();        
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