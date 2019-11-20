package telemaquinas;

/**
 * Hello world!
 */
public final class Matrix {
    private Matrix() {


  public static double [][] quitarFila (double [][] m, int n) { 
  
      // if(!esMatriz(m)){   
      //                    return null;  }     

    if (n >= m.length  ||  n<0){  
          return  null;   
                              }   

    double [][] res  = new  double[m.length‐1][m[0].length];

      for(int  i = 0;i <  res.length;i++){      
        for(int   j =  0; j < res[i].length;j++) {  
              if  (i <  n){            
                  res[i][j]  =  m[i][j];            
                          }                   
              else if  (i >=n && i+1 <  m.length){   
                          res[i][j] = m[i+1][j];            
                                                  }                     
                                                  }                
                                          }                 
              return res;
                                                              }    
                                                              

    }



    

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }




}