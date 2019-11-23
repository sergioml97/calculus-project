package calculus;

    public class Polinomio
    {
       private long coeficientes[];
     
       public Polinomio(){}
       
       public Polinomio(long[] coef) throws NullPointerException {
          
         try{

          coeficientes = new long[coef.length];
    	    for (int i = 0; i < coef.length; i++){
              coeficientes[i] = coef[i];
           }
         }catch  (NullPointerException e){
            System.out.println("Array null");
        } 
      }
       
       public Polinomio(int grado)
       {
          if ( grado <= 0 ) grado = 0;
          coeficientes = new long[grado + 1];
       }
     
       public int grado()
       {
          return coeficientes.length - 1;
       }

       public Polinomio clone() {
         return new Polinomio(coeficientes);
     }


       public long coeficiente(int i)
       {
          return i < coeficientes.length ? coeficientes[i] : 0;
       }

       public void imprimir()
       {
          for ( int i = grado(); i >= 0; --i )
          {
             if ( coeficientes[i] != 0 )
             {
                if ( i != grado() ) System.out.print(" + ");
                if ( coeficientes[i] != 1 || i == 0 ) System.out.print(coeficientes[i]);
                if ( i > 0 ) System.out.print("x");
                if ( i > 1 ) System.out.print("^" + i);
             }
          }
       }

       
       @Override
       public boolean equals(Object p){
 
           if (!(p instanceof Polinomio)){
              return false;
           }
           if (p == null){
              return false;
           }

           Polinomio pp1 = (Polinomio) this;
           Polinomio pp2 = (Polinomio) p;

           if (pp1 == pp2 ){
              return true;
           }

           if ( pp1.coeficientes.length != pp2.coeficientes.length){
              return false;
           }

           for (int i = 0; i < pp1.coeficientes.length; i++){
              if (pp1.coeficientes[i] != pp2.coeficientes[i]){
                 return false;
              }
           }
           

           return true;
       }

       String aString() {

         String resultado1;
         resultado1= toString();
         return resultado1;
       }

       long[] aArray(){

         long [] resultado = new long[coeficientes.length];
         resultado= coeficientes;
          return resultado;


       }
     
       Polinomio sumar(Polinomio otro)
       {
          int grado = Math.max( grado(), otro.grado() );
          Polinomio resultado = new Polinomio(grado);
          for ( int i = 0; i <= grado; ++i )
             resultado.coeficientes[i] = coeficiente(i) + otro.coeficiente(i);
     
          return resultado;
       }
     
       Polinomio restar(Polinomio otro)
       {
          int grado = Math.max( grado(), otro.grado() );
          Polinomio resultado = new Polinomio(grado);
          for ( int i = 0; i <= grado; ++i )
             resultado.coeficientes[i] = coeficiente(i) - otro.coeficiente(i);
     
          return resultado;
       }
     
       Polinomio multiplicar(Polinomio otro)
       {
          int grado = grado() + otro.grado();
          Polinomio resultado = new Polinomio(grado);
          for ( int i = 0; i <= grado(); ++i )
             for ( int j = 0; j <= otro.grado(); ++j )
                resultado.coeficientes[i + j] += coeficiente(i) * otro.coeficiente(j);
     
          return resultado;
       }
       
       public static void imprimirOperacion(Polinomio a, Polinomio b, String op, Polinomio resultado)
       {
          System.out.print("\n(");
          a.imprimir();
          System.out.print(") " + op + " (");
          b.imprimir();
          System.out.print(") = ");
          resultado.imprimir();
          System.out.println();
       }
     
       /**
       public static void main(String args[])
       {
          int grado = 2;
          long [] coeficientes = new long [grado+1];
          coeficientes[0] = (long) 1.00;
          coeficientes[1] = (long) 3.00;
          coeficientes[2] = (long) 1.00;

          Polinomio polinomio1 = new Polinomio(coeficientes, grado);
          System.out.println("Polinomio 1");

          polinomio1.clone();

          polinomio1.imprimir();
          //System.out.println("");
          //System.out.println("El coeficiente 1 es: " + polinomio1.coeficiente(1));
          //System.out.println("El grado es: " +polinomio1.grado());

     
          //System.out.println("\n\nPolinomio 2");
          coeficientes[0] = (long) 5.00;
          Polinomio polinomio2 = new Polinomio(coeficientes, grado);
          //polinomio2.leer();
          polinomio2.imprimir();
     
          System.out.println();
          imprimirOperacion( polinomio1, polinomio2, "+", polinomio1.sumar(polinomio2) );
          imprimirOperacion( polinomio1, polinomio2, "-", polinomio1.restar(polinomio2) );
          imprimirOperacion( polinomio2, polinomio1, "-", polinomio2.restar(polinomio1) );
          imprimirOperacion( polinomio1, polinomio2, "*", polinomio1.multiplicar(polinomio2) );
       }
       */
      
    }
