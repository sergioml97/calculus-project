package calculus;
    public class Polinomio
    {
       private long coeficientes[];
     
       public Polinomio(){}
       
////////////////////////////////////////////// POLINOMIO CON ARRAYS //////////////////////////////////////////////


       public Polinomio(long[] coef, int grado){
    	    if (grado < 0) {
    	      coeficientes = new long[1];
    	      coeficientes[0] = 0;
    	      grado = 0;
    	    } else {
    	      coeficientes = new long[grado + 1];
    	      for(int i = 0; i <= grado; i++){
    	        coeficientes[i] = coef[i];
    	      }
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
     
////////////////////////////////////////////////// SUMA //////////////////////////////////////////////////

       Polinomio sumar(Polinomio otro)
       {
          int grado = Math.max( grado(), otro.grado() );
          Polinomio resultado = new Polinomio(grado);
          for ( int i = 0; i <= grado; ++i )
             resultado.coeficientes[i] = coeficiente(i) + otro.coeficiente(i);
     
          return resultado;
       }
     
////////////////////////////////////////////////// RESTA //////////////////////////////////////////////////

       Polinomio restar(Polinomio otro)
       {
          int grado = Math.max( grado(), otro.grado() );
          Polinomio resultado = new Polinomio(grado);
          for ( int i = 0; i <= grado; ++i )
             resultado.coeficientes[i] = coeficiente(i) - otro.coeficiente(i);
     
          return resultado;
       }

//////////////////////////////////////// MULTIPLICACIÓN DE POLINOMIOS //////////////////////////////////////////

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
     
       public static void main(String args[])
       {
          int grado = 2;
          long [] coeficientes = new long [grado+1];
          coeficientes[0] = (long) 1.00;
          coeficientes[1] = (long) 3.00;
          coeficientes[2] = (long) 1.00;

          Polinomio polinomio1 = new Polinomio(coeficientes, grado);
          System.out.println("Polinomio 1");

          polinomio1.imprimir();
          System.out.println("");
          System.out.println("El coeficiente 1 es: " + polinomio1.coeficiente(1));
          System.out.println("El grado es: " +polinomio1.grado());

     
          System.out.println("\n\nPolinomio 2");
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
     
      
    }
