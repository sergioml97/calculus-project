package calculus;

    public class Polinomio
    {
       private long coeficientes[];
     
       public Polinomio(){}
       
       public Polinomio(final long[] coef) throws Exception,NullPointerException {
          
         try{

          coeficientes = new long[coef.length];
    	    for (int i = 0; i < coef.length; i++){
              coeficientes[i] = coef[i];
           }
         }catch  (final NullPointerException e){
            System.out.println("Array null");
            throw e;
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


//////////////////////////////////////////////////////CLONAR///////////////////////////////////////////////////////

       public Polinomio getClone() throws Exception{
         return new Polinomio(coeficientes);
     }


//////////////////////////////////////////////////////COEFICIENTES///////////////////////////////////////////////////////



       public long coeficiente(final int i)
       {
          return i < coeficientes.length ? coeficientes[i] : 0;
       }



//////////////////////////////////////////////////IMPRIMIR///////////////////////////////////////////////////////////

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
       


//////////////////////////////////////////////////CONVERTIR A STRING///////////////////////////////////////////////////////////

       public String toString() {
         String p = new String();
         for (int i = coeficientes.length - 1; i >= 0 ; i--) {
            if ( coeficientes[i] != 0 )
            {
               if ( i == 0) p += coeficientes[i];            
               if( i == 1 ) p += coeficientes[i] + "x + ";
               if ( i >= 2 ) p += coeficientes[i] + "x^" + i + " + ";
             
            }
         }
         return p;
     }



//////////////////////////////////////////////////////DERIVAR///////////////////////////////////////////////////////

Polinomio getDerivada(){
   int grado = grado()-1;
   Polinomio derivada = new Polinomio(grado);
   for (int i = grado(); i > 0; --i ) {
      derivada.coeficientes[i-1] = coeficientes[i] * i ;
   }
   return derivada;
 }


/////////////////////////////////////////////////COMPARACIÓN////////////////////////////////////////////////////////////
       
       @Override
       public boolean equals(final Object p){
 
           if (!(p instanceof Polinomio)){
              return false;
           }
           if (p == null){
              return false;
           }

           final Polinomio pp1 = (Polinomio) this;
           final Polinomio pp2 = (Polinomio) p;

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

/*
       String aString() {

         String resultado1;
         resultado1= toString();
         return resultado1;
       }
*/


//////////////////////////////////////////////////CONVERTIR A ARRAY///////////////////////////////////////////////////////////

       long[] toArray(){

         long [] resultado = new long[coeficientes.length];
         resultado= coeficientes;
          return resultado;


       }
     

/////////////////////////////////////////////////////SUMAR////////////////////////////////////////////////////////

       Polinomio sumar(final Polinomio otro)
       {
          final int grado = Math.max( grado(), otro.grado() );
          final Polinomio resultado = new Polinomio(grado);
          for ( int i = 0; i <= grado; ++i )
             resultado.coeficientes[i] = coeficiente(i) + otro.coeficiente(i);
     
          return resultado;
       }


///////////////////////////////////////////////////////RESTAR//////////////////////////////////////////////////////

     
       Polinomio restar(final Polinomio otro)
       {
          final int grado = Math.max( grado(), otro.grado() );
          final Polinomio resultado = new Polinomio(grado);
          for ( int i = 0; i <= grado; ++i )
             resultado.coeficientes[i] = coeficiente(i) - otro.coeficiente(i);
     
          return resultado;
       }
     


//////////////////////////////////////////////////////////MULTIPLICAR///////////////////////////////////////////////////

       Polinomio multiplicar(final Polinomio otro)
       {
          final int grado = grado() + otro.grado();
          final Polinomio resultado = new Polinomio(grado);
          for ( int i = 0; i <= grado(); ++i )
             for ( int j = 0; j <= otro.grado(); ++j )
                resultado.coeficientes[i + j] += coeficiente(i) * otro.coeficiente(j);
     
          return resultado;
       }


//////////////////////////////////////////////////////IMPRIMIR OPERACIÓN///////////////////////////////////////////////////////

       
       public static void imprimirOperacion(final Polinomio a, final Polinomio b, final String op, final Polinomio resultado)
       {
          System.out.print("\n(");
          a.imprimir();
          System.out.print(") " + op + " (");
          b.imprimir();
          System.out.print(") = ");
          resultado.imprimir();
          System.out.println();
       }
     
       /*
       public static void main(String args[]) throws Exception
       {
          int grado = 2;
          long [] coeficientes = new long [grado+1];
          coeficientes[0] = (long) 1.00;
          coeficientes[1] = (long) 3.00;
          coeficientes[2] = (long) 1.00;

          Polinomio polinomio1 = new Polinomio(coeficientes);
          System.out.println("Polinomio 1");

          //polinomio1.clone();

          polinomio1.imprimir();
          //System.out.println("");
          //System.out.println("El coeficiente 1 es: " + polinomio1.coeficiente(1));
          //System.out.println("El grado es: " +polinomio1.grado());

     
          //System.out.println("\n\nPolinomio 2");
          coeficientes[0] = (long) 5.00;
          Polinomio polinomio2 = new Polinomio(coeficientes);
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
