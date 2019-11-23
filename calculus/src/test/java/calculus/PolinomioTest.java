package calculus;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PolinomioTest {

//Test constructor correcto
    @Test
    public void testPolinomio() throws NullPointerException{
        long[] poli = {2, 4, 8};
        Polinomio newPol = new Polinomio(poli);
        newPol.imprimir();        
        System.out.println();
    }

//Test array con valor null
    @Test (expected=NullPointerException.class)
    public void testNullPolinomio() throws NullPointerException{
        long[] poli = null;
        Polinomio newP = new Polinomio(poli);
        newP.imprimir();        
        System.out.println();
    }
//Test método clone
    @Test
    public void testClone(){
        long[] poli = {1, 3, 7};
        Polinomio P = new Polinomio(poli);
        Polinomio cloneP = P.clone();
        cloneP.imprimir();        
        System.out.println();
    }
 //Test de sumar polinomios
 @Test
 public void testPolinomioSuma() {
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
 public void testPolinomioMultiplicar() {



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
    polinomio3.imprimir();

    assertEquals(polinomio3, polinomio1.multiplicar(polinomio2));

     
 }

 
 //Test de convertir en array un polinomio
 @Test
 public void testPolinomioArray() {

     long [] coeficientes = new long [3];
     coeficientes[0] = 1L;
     coeficientes[1] = 3L;
     coeficientes[2] = 1L;

     Polinomio polinomio1 = new Polinomio(coeficientes);

     assertArrayEquals(coeficientes, polinomio1.aArray());

 }
}