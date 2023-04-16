# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2022/23)
Autor: David Basallote Braza   uvus:CQD5926

## Estructura de las carpetas del proyecto

* **/src**: Directorio con el código fuente.
  * **fp.moviles**: Paquete que contiene los tipos del proyecto.
  * **fp.moviles.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad.
  * **fp.common**:  Paquete que contiene propiedades de tipo auxiliar. 
* **/data**: Contiene el dataset del proyecto.
    * **Móviles.csv**: Archivo csv que contiene datos de diferentes móviles.
    
## Estructura del *dataset*

El dataset original se puede obtener de la URL [https://www.kaggle.com/datasets/ginelledsouza/mobilephone). Originalmente tiene 8 columnas y cada fila contiene datos sobre un móvil. El dataset usado en este proyecto tiene 10 columna, 6 se han tomado del dataset original, y cuatro, la fecha, la cantidad de vendidos, NFC y el precio, se han generado de forma aleatoria. A continuación se describen las 10 columnas del dataset:

* **Nombre**: de tipo Strign, indica el nombre del móvil
* **RAM**: de tipo cadena, indica la memoria RAM del dispositivo.
* **ROM**: de tipo cadena, indica la memoria ROM del dispositivo.
* **Calificaciones**: de tipo entero, indica el número de valoraciones que se han realizado.
* **Comentarios**: de tipo entero, indica el número de comentarios.
* **Estrellas**: de tipo doble, contiene la media de las valoraciones de 0 a 5.
* **Precio(€)**: de tipo entero, indica el precio del móvil en euros. 
* **NFC**: de tipo booleano, indica si el dispositivo tiene incorporado la tecnología NFC.
* **Fecha de salida**: de tipo fecha, indica la fecha de cuandó se empezó a vender el móvil.
* **Vendidos**: de tipo entero. Indica el número de dispositivos vendidos.

## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Movil
Representa un móvil en concreto.
**Propiedades**:

- _nombre_, de tipo _String_, consultable. Indica si las partidas han sido calificadas o no, es decir si son partidas amistosas o de tipo clasificatorio. 
- _calificaciones_, de tipo _Integer_, consultable. Número de calificaciones 
- _comentarios_, de tipo _Integer_, consultable. Indica el número de comentarios.
- _estrellas_, de tipo _Double_, consultable. Número de estrellas(valoración del móvil del 0 al 5).
- _precio_, de tipo _Integer_, consultable. Contiene el precio del móvil.
- _nfc_, de tipo _Boolean_, consultable. Si es false el dispositivo no tiene NFC y si es true contiene NFC.
- _fSalida_, de tipo _LocalDate_, consultable. Contiene la fecha de lanzamiento del dispositivo.
- _numVentas_, de tipo _Integer_, consultable. Cantidad de veces vendido.
- _memorias_, de tipo _Memorias_, consultable. Tipo auxiliar que contiene las dos memorias.
- _paisesMasVendidos_, de tipo _ List<String>_, consultable. Lista que contiene los países en los que más se ha vendido.

**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: Crea un objeto de tipo ```Movil``` a partir de los siguientes parámetros: ```String nombre, Integer precio, LocalDate fSalida```.

**Restricciones**:
 
- R1: El nombre del móvil no puede ser Null.
- R2: El precio debe ser mayor que cero.

***Criterio de igualdad**: Dos móviles son iguales si su nombre y la fecha de salida son iguales.

**Criterio de ordenación**: Por nombre y precio.

**Otras operaciones**:

- _String getGeneracion(LocalDate fSalida)_: Devuelve la generación en la cual fue lanzado el móvil.

#### Tipos auxiliares

- Generacion, enumerado. Puede tomar los valores PRIMERA, SEGUNDA, TERCERA, CUARTA, QUINTA.
- Memorias, record. tipo auxiliar que contiene las memorias del móvil.

### Factoria - FactoriaMoviles

Clase de factoría para construir objetos de tipo Moviles.

- _Moviles leerMoviles(String rutaFichero)_: Crea un objeto de tipo Moviles a partir de la información recogida en el archivo csv, cuya ruta se da como parámetro.

### Tipo Contenedor - MovilesImpl

Clase contenedora de los objetos de tipo Movil.

#### Propiedades:

- _moviles_, de tipo _List<Movil>_, consultable. Lista de moviles.
- _numero moviles_, de tipo _Integer_, consultable. Número de moviles del contenedor.

**Constructores**: 

- C1: Constructor por defecto. Creal un objeto de tipo Moviles sin ningun movil almacenado.
- C2: Constructor con un parámetro de tipo Collection<Movil>. Crea un objeto de tipo Moviles con los moviles incluidos en la colección dada como parámetro.
- C3: Constructor con un parámetro de tipo Stream<Movil>. Crea un objeto de tipo Moviles con los moviles incluidos en el Stream dado

**Criterio de igualdad**: Dos moviles son iguales si lo son sus propiedades.

**Otras operaciones**:

- _void añadirMovil(Movil m)_: Añade un movil al objeto.
- _void eliminarMovil(Movil m)_: Elimina un movil del objeto.
- _Boolean existeMovil(Integer anyo)_: Devuelve un _Boolean_ que indica si se encuentra en el objeto algún móvil que coincida su fecha de lanzamiento con dicho año.
- _Double mediaPrecioMoviles()_: Devuelve la media de los precios (tipo _Double_) de todos los móviles del objeto.
- _List<Movil> filtrarNFC(Boolean nfc)_: Devuelve una lista que contiene los móviles que cumplan la condición del parametro dado.
- _Map<Integer, List<String>> filtrarMovilesPorAnyo()_: Devuelve un Map en el que las claves son los años de la fecha de lanzamiento y los valores una lista con los móviles que hayan sido lanzados dicho año.
- _Map<Boolean, Integer> conteoSegunNFC()_: Devuelve un Map en el que las claves es un tipo _Boolean_ y los valores el número de móviles que cumplen la condición de la propiedad nfc.
