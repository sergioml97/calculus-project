package calculus;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class MatrixTest {
    /**
     * Rigorous Test.
     */
    //Test de constructor matrix
    @Test
    public void testMatrix() throws Exception,NullPointerException{
        double[][] d = { { 2, 3, 4 }, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
        D.toString();        
        System.out.println();
    }

    //Test de constructor matrix con tamaños negativos
    @Test (expected=Exception.class)
    public void testMatrixNegativeSize() throws Exception{
        Matrix D = new Matrix(-1,-1);
    }

    //Test de constructor matrix con array nulo
    @Test (expected=NullPointerException.class)
    public void testMatrixArrayIsNull() throws Exception,NullPointerException{
        double[][] d = null;
        Matrix D = new Matrix(d);
    }

    //Test de constructor matrix con datos nulos
    @Test (expected=NullPointerException.class)
    public void testMatrixContainsNull() throws Exception,NullPointerException{
        double[][] d = { null, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
    }

    //Test de constructor matrix diferente tamaño de filas (1)
    @Test (expected=Exception.class)
    public void testMatrixDiferentSize() throws Exception{
        double[][] d = { { 2, 3, 4, 5 }, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
    }

    //Test de constructor matrix diferente tamaño de filas (2)
    @Test (expected=Exception.class)
    public void testMatrixDiferentSize2() throws Exception{
        double[][] d = { { 2, 3 }, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
    }
//--------------------------------------------------------------------------------
    //Test de quitar fila
    @Test 
    public void testMatrixQuitarFila() throws Exception{
        double[][] d = { { 2, 3, 4 }, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
        Matrix F = Matrix.quitarFila(D, 1);  
        F.toString();
        System.out.println();
    }
//--------------------------------------------------------------------------------
    //Test de quitar fila que no existe
    @Test (expected=Exception.class)
    public void testMatrixQuitarFilaException() throws Exception{
        double[][] d = { { 2, 3, 4 }, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
        Matrix F = Matrix.quitarFila(D, -1);  
        F.toString();
        System.out.println();
    }
//--------------------------------------------------------------------------------
    //Test de quitar columna
    @Test 
    public void testMatrixQuitarColumna() throws Exception{
        double[][] d = { { 2, 3, 4 }, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
        Matrix F = Matrix.quitarColumna(D, 1);  
        F.toString();
        System.out.println();
    }
//--------------------------------------------------------------------------------
    //Test de quitar columna que no existe
    @Test (expected=Exception.class)
    public void testMatrixQuitarColumnaException() throws Exception{
        double[][] d = { { 2, 3, 4 }, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
        Matrix F = Matrix.quitarColumna(D, -1);  
        F.toString();
        System.out.println();
    }
//--------------------------------------------------------------------------------
    // Test de obtener fila
    @Test 
    public void testMatrixobtenerFila() throws Exception{
        double[][] d = { { 2, 3, 4 }, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
        double [] F = Matrix.obtenerFila(D, 1);  
        F.toString();
        System.out.println();
    }

//--------------------------------------------------------------------------------
    // Test de obtener columna
    @Test 
    public void testMatrixobtenerColumna() throws Exception{
        double[][] d = { { 2, 3, 4 }, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
        double [] C = Matrix.obtenerColumna(D, 1);  
        C.toString();
        System.out.println();
    }
//--------------------------------------------------------------------------------
    //Test de clonar matriz
    @Test
    public void testGetClone()throws Exception{
        double[][] d = { { 2, 3, 4 }, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
        Matrix D2 = D.getClone();
        assertEquals(D, D2);
    }
    
    @Test
    public void testMatrixtoArray() throws Exception{
        //Creamos una matriz
        double[][] d = { { 2, 3, 4 }, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
        assertArrayEquals(d, D.toArray());
        //Otra forma sería volver a convertir en matriz
        Matrix A = new Matrix(D.toArray());
        //Y comprobamos la matriz con la original
        assertEquals(D, A);
    }

    @Test
    public void testGetTraspuesta() throws Exception{
        //Creamos una matriz y su traspuesta
        double[][] d = { { 2, 3, 4 }, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix D = new Matrix(d);
        double[][] tr = { { 2, 4, 9 }, { 3, 5, 1 }, { 4, 6, 3} };
        Matrix TR = new Matrix(tr);
        Matrix TR2 = D.getTraspuesta();
        assertEquals(TR, TR2);
    } 
}
