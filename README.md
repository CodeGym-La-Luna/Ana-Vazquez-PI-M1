   <h1 align="center"> Cifrado Cesar-Java </h1>  

------------
#### El cifrado César es uno de las técnicas para codificar o decodificar un texto utilizando el método de cifrado de César. En este métoo de cifrado, cada letra es sustituida por otra letra que se encuentra N posiciones adelante en el alfabeto. Se considera que el alfabeto es circular, es decir, la letra siguiente a la ‘z’ es la ‘a’.
------------
## Funcionamiento del programa:

Este programa implementa el cifrado y descifrado de texto utilizando el Cifrado César. Los usuarios pueden interactuar con un menú para cifrar un archivo de texto con una clave, descifrarlo con una clave conocida, o descifrar utilizando fuerza bruta. El programa maneja archivos de entrada y salida y valida las rutas de los archivos y las claves de cifrado proporcionadas.

------------

## Clases Principales 

1.	**Main**: Punto de entrada del programa. Inicializa y ejecuta el menú interactivo.
2.	**MenuCifradoCesar**: Implementa la lógica del menú permitiendo al usuario seleccionar entre las diversas operaciones de cifrado/descifrado.
3.	**Cifrado**: Implementa el cifrado y descifrado de texto utilizando el Cifrado César.
4.	**BruteForce**: Ejecuta el descifrado por fuerza bruta, probando todas las posibles claves y mostrando las combinaciones resultantes.
5.	**FileManager**: Maneja la lectura y escritura de archivos utilizando la clase FileChannel de Java NIO.
6.	**Validador**: Valida las claves de cifrado y la existencia de archivos en el sistema de archivos.
------
## Funcionalidad de Clases:

### 1. Clase principal Main:
#### Descripción: Esta clase inicia el programa llamando a la clase MenuCifradoCesar que se encarga de la interacción con el usuario.


### 2. Clase MenuCifradoCesar:
#### Descripcion: Esta clase contiene el menú principal del programa y la lógica para manejar las opciones del usuario.
#### Funcionalidad principal:
*	Muestra un menú con 4 opciones: cifrar texto, descifrar con clave, descifrar con fuerza bruta y salir.
* Valida las entradas del usuario (números enteros y rutas de archivo válidas) para asegurar que los valores ingresados sean correctos.
* Llama a las funciones correspondientes para cifrar, descifrar o usar fuerza bruta.
#### Métodos:
•	menuiniciar(): Controla el ciclo de interacción del usuario con el menú.

##### Opciones:

![image](https://github.com/user-attachments/assets/e5287dc7-1e37-4b8e-b99a-c28e0b5fe64a)


1.	***Cifrar texto***: El usuario proporciona una ruta de archivo, una ruta de salida y una clave de cifrado. Se lee el archivo, se cifra su contenido y se guarda en un nuevo archivo.
2.	***Descifrar texto con clave***: Similar a la opción de cifrado, pero descifra el archivo con una clave proporcionada.
3.	***Descifrar texto con brute force***: Prueba todas las posibles claves y genera las diferentes combinaciones descifradas.
4.	***Salir***: Termina el programa.

### 3. Clase Cifrado:
Descripción: Implementa el cifrado y descifrado de texto utilizando el alfabeto personalizado.
#### Funcionalidad principal:
*	Cifrado: Desplaza cada carácter del texto de entrada una cantidad de posiciones determinada por la clave.
* Descifrado: Realiza el desplazamiento inverso para recuperar el texto original.
#### Métodos:
•	encrypt(): Cifra el texto dado un desplazamiento positivo.
•	decrypt(): Descifra el texto dado un desplazamiento negativo.
•	desplazarTexto(): Realiza el desplazamiento de caracteres dentro del alfabeto.
•	findIndex(): Encuentra el índice de un carácter en el alfabeto personalizado.

### 4. Clase BruteForce:
Descripción: Realiza un descifrado por fuerza bruta, probando todas las posibles claves de cifrado.
Funcionalidad principal:
*	decryptByBruteForce(): Prueba todas las posibles claves de cifrado, generando las distintas combinaciones de texto descifrado y las devuelve como resultado.
  
### 5. Clase FileManager:
Descripción: Encargada de la lectura y escritura de archivos utilizando FileChannel.
#### Funcionalidad principal:
*	Lectura de archivo: Lee un archivo desde una ruta especificada y devuelve su contenido como texto.
*	Escritura de archivo: Escribe un texto en un archivo en una ruta especificada.
#### Métodos: •	leerArchivo(): Lee un archivo y devuelve su contenido como una cadena de texto.
•	escribirArchivoChannel(): Escribe una cadena de texto en un archivo.

### 6.Clase Validador:
Descripción: Valida las claves de cifrado y las rutas de los archivos.
#### Funcionalidad principal:
*	Validación de clave: Verifica que la clave esté dentro de los límites del alfabeto.
*	Validación de existencia de archivo: Verifica que un archivo exista en la ruta especificada.
#### Métodos:
•	isValidKey(): Verifica que la clave esté dentro del rango permitido por el alfabeto.
•	isFileExists(): Verifica si un archivo existe en la ruta especificada.


-------------------------------------------------------------------------------------------------------


**Autor: Ana Vázquez.**
