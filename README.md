# calculus-project
A project designed in DevOps subject - MUITE (ETSIT)

	POLINOMIOS -> Funcionalidad/Servicio + Observaciones
	
-Construir un Polinomio P(x) de coeficientes enteros a partir de un array de enteros.
	El índice de cada elemento se corresponde con el coeficiente de la potencia de x correspondiente. Por ejemplo, para
	2x3 - 6x + 1, x[3] = 2, x[2] = 0, x[1] = -6, x[0] = 1
	Lanza excepción si el array es null.

-Construir un Polinomio de coeficientes enteros a partir de su representación en JSON.
	Lanza excepción si el objeto JSON es null o no se corresponde con un polinomio.

-Clonar un Polinomio.
	Devuelve una copia del polinomio

-Obtener el grado del polinomio.
	Devuelve el mayor exponente existente en el polinomio

-Convertir en array.
	Devuelve un array de enteros correspondiente al polinomio

-Convertir en String.
	Devuelve un String que representa al polinomio, para ser escrito en una consola de texto.

-Convertir a JSON.
	Devuelve un objeto JSON que representa al polinomio

-Obtener el valor del polinomio para un xi dado.
	Valor del polinomio en P(xi)

-Obtener la derivada del polinomio P(x).
	Devolver otro polinomio que sea la derivada del primero P’(x)

-Escalar el polinomio.
	Devuelve otro polinomio resultado de escalar el actual por un factor k estrictamente mayor que cero

-Reflejar el polinomio.
	Devuelve otro polinomio P(-x). Cambia signo de los coeficientes de potencias impares.

-Sumar dos polinomios.
	Devuelve al polinomio resultante de sumar otros dos.

-Multiplicar dos polinomios.
	Devuelve al polinomio resultante de multiplicar otros dos.

-División.
	Devuelve dos polinomios: cociente y resto.

-División de Ruffini.
	Devuelve dos polinomios: cociente y resto.


	MATRICES -> Funcionalidad/Servicio + Observaciones

-Construir una Matriz partir de un array bidimensional de reales.
	Lanza excepción si el array es null, contiene nulls o no representa a una matriz.

-Construir una Matriz de enteros a partir de su representación en JSON.
	Lanza excepción si el objeto JSON es null o no se corresponde con una matriz.

-Clonar una Matriz.
	Devuelve una copia de la matriz

-Convertir en array bidimensional.
	Devuelve el array bidimensional de enteros correspondiente a la matriz

-Convertir en String.
	Devuelve un String que representa a la matriz, para ser escrita en una consola de texto.

-Convertir a JSON.
	Devuelve un objeto JSON que representa a la matriz

-Obtener traspuesta.
	Devuelve OTRA matriz, que es la traspuesta de la original.

-Obtener la fila iésima.
	Se devuelve como un array de enteros. Si la fila no existe lanza excepción

-Obtener columna iésima.
	Se devuelve como un array de enteros. Si la columna no existe lanza excepción

-Quitar fila.
	Devuelve OTRA matriz sin esa fila. Si la fila no existe lanza excepción

-Quitar columna.
	Devuelve OTRA matriz sin esa columna. Si la columna no existe lanza excepción

-Obtener el menor complementario.
	Dado un determinante de orden n, se llama menor complementario del elemento aij, al determinante de orden n-1 que resulta de suprimir en el determinante dado la fila i-ésima y la columna j-ésima.

-Obtener el determinante de la matriz.
	Devuelve el determinante de la matriz. Sólo tiene sentido si la matriz es cuadrada. Es conveniente aplicar la regla de Chio (se simplifica mucho la implementación).

-Obtener la matriz adjunta.
	Se llama matriz adjunta de una matriz cuadrada (aij) a la matriz (Aij) cuyos elementos son los adjuntos de los elementos aij.
	Se llama adjunto del elemento aij al menor complementario de dicho elemento con signo positivo si (i+j) es par y negativo si (i+j) es impar.

-Obtener la matriz inversa.
	Calcula la matriz inversa de una dada, que debe ser cuadrada.