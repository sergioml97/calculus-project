package calculus;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

//import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class PolinomioTest {
    /**
     * Rigorous Test.
     */
    //Test de constructor matrix
    @Test
    public void testPolinomioSuma() {
        int grado = 2;
        long [] coeficientes = new long [grado+1];
        coeficientes[0] = 1L;
        coeficientes[1] = 3L;
        coeficientes[2] = 1L;

        Polinomio polinomio1 = new Polinomio(coeficientes, grado);
   
        Polinomio polinomio2 = new Polinomio(coeficientes, grado);

        polinomio1.sumar(polinomio2);

        coeficientes[0] = 2L;
        coeficientes[1] = 6L;
        coeficientes[2] = 2L;

        Polinomio polinomio3 = new Polinomio(coeficientes, grado);


        assertEquals(polinomio3, polinomio1.sumar(polinomio2));

    }

    //Test de constructor matrix con array nulo
    @Test (expected=NullPointerException.class)
    public void testMatrixArrayIsNull() throws Exception,NullPointerException{
        double[][] d = null;
        Matrix D = new Matrix(d);
        D.to_string();        
        System.out.println();
    }

    //Test de constructor matrix con datos nulos
    @Test (expected=NullPointerException.class)
    public void testMatrixContainsNull() throws Exception,NullPointerException{
        double[][] d = { null, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
        D.to_string();        
        System.out.println();
    }

    //Test de constructor matrix diferente tamaño de filas (1)
    @Test (expected=Exception.class)
    public void testMatrixDiferentSize() throws Exception{
        double[][] d = { { 2, 3, 4, 5 }, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
        //D.print();        
        //System.out.println("TERMINADO");
    }

    //Test de constructor matrix diferente tamaño de filas (2)
    @Test (expected=Exception.class)
    public void testMatrixDiferentSize2() throws Exception{
        double[][] d = { { 2, 3 }, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
        D.to_string();        
        System.out.println();
    }

    //Test de quitar fila
    @Test
    public void testMatrixQuitarFila() throws Exception{
        double[][] d = { { 2, 3, 4 }, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
        Matrix F = Matrix.quitarFila(D, 1);  
        F.to_string();
        System.out.println();
    }

    //Test de quitar fila que no existe
    @Test (expected=Exception.class)
    public void testMatrixQuitarFilaException() throws Exception{
        double[][] d = { { 2, 3, 4 }, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
        Matrix F = Matrix.quitarFila(D, -1);  
        F.to_string();
        System.out.println();
    }

    @Test
    public void testMatrixtoArray() throws Exception{
        double[][] d = { { 2, 3, 4 }, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
        D.toArray();  
        System.out.println();
    }
}
