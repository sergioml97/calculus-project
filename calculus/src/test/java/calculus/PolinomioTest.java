package calculus;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PolinomioTest {

//Test constructor correcto
    @Test
    public void testPolinomio() throws Exception,NullPointerException{
        long[] poli = {2, 4, 6, 9};
        Polinomio newPol = new Polinomio(poli);
        newPol.toString();        
        System.out.println(newPol);
    }





//Test array con valor null
    @Test (expected=NullPointerException.class)
    public void testNullPolinomio() throws Exception,NullPointerException{
        long[] poli = null;
        Polinomio newP = new Polinomio(poli);
        newP.toString();        
        System.out.println();
    }

//Test método clone
    @Test
    public void testClone()throws Exception{
        long[] poli = {1, 3, 7};
        Polinomio P = new Polinomio(poli);
        Polinomio cloneP = P.getClone();
        cloneP.toString();       
        assertEquals(P, cloneP); 
        //System.out.println();
    }


//Test derivada

@Test
public void testDerivada()throws Exception{
    long[] poli = {1, 3, 7, 8};
    Polinomio P = new Polinomio(poli);
    Polinomio derivP = P.getDerivada();
    derivP.toString(); 
    System.out.println(derivP);       
}


 //Test de sumar polinomios
 @Test
 public void testPolinomioSuma() throws Exception,NullPointerException {
     long [] coeficientes = new long [3];
     coeficientes[0] = 1L;
     coeficientes[1] = 3L;
     coeficientes[2] = 1L;

     Polinomio polinomio1 = new Polinomio(coeficientes);

     Polinomio polinomio2 = new Polinomio(coeficientes);

     polinomio1.sumar(polinomio2);

     coeficientes[0] = 2L;
     coeficientes[1] = 6L;
     coeficientes[2] = 2L;

     Polinomio polinomio3 = new Polinomio(coeficientes);

     assertEquals(polinomio3, polinomio1.sumar(polinomio2));

 }

 //Test de multiplicar polinomios
 @Test
 public void testPolinomioMultiplicar() throws Exception,NullPointerException{



     long [] coeficientes = new long [3];
     coeficientes[0] = 1L;
     coeficientes[1] = 3L;
     coeficientes[2] = 1L;

     Polinomio polinomio1 = new Polinomio(coeficientes);

     Polinomio polinomio2 = new Polinomio(coeficientes);

    // polinomio1.imprimir();
    polinomio1.imprimirOperacion( polinomio1, polinomio2, "*", polinomio1.multiplicar(polinomio2) );

    long [] prueba = new long [5];
    prueba[0] = 1L;
    prueba[1] = 6L;
    prueba[2] = 11L;
    prueba[3] = 6L;
    prueba[4] = 1L;

    Polinomio polinomio3 = new Polinomio(prueba);
    polinomio3.toString();

    assertEquals(polinomio3, polinomio1.multiplicar(polinomio2));

     
 }

 
 //Test de convertir en array un polinomio
 @Test
 public void testPolinomioArray() throws Exception,NullPointerException{

     long [] coeficientes = new long [3];
     coeficientes[0] = 1L;
     coeficientes[1] = 3L;
     coeficientes[2] = 1L;

     Polinomio polinomio1 = new Polinomio(coeficientes);

     assertArrayEquals(coeficientes, polinomio1.toArray());

 }
}