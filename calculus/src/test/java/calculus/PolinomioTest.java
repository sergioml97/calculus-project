package calculus;

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
        Polinomio newPol = new Polinomio(poli);
        newPol.imprimir();        
        System.out.println();
    }

}