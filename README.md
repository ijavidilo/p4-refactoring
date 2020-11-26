# P4: Refactoring - Javier Diaz Lopez (Parte 4: Arquitectura MVC con Vista Pasiva)
  * ## Anotaciones alumno: 
  > En esta parte se va a cambiar el estilo arquitectónico de la práctica para que el controlador conozca a la vista (y no al revés). Arquitectura MVC con Vista Pasiva.

## Modelo del Dominio
Como jugar: https://www.youtube.com/watch?v=yFrAN-LFZRU

![This is a alt text.](./Damas/images/draughts.jpg "Damas.")

![This is a alt text.](./Damas/images/draughtsModeloDominio.svg "Damas.")

### Instrucciones de entrega

Entrega de un proyecto público en git varias ramas:

* **master**, con:
    * Modelo del dominio.
    * Requisitos: Puedes encontrar los requisitos en la carpeta /Damas de este mismo repositorio.
    * Código inicial: https://github.com/ijavidilo/p3-damas/tree/unitTestWithMockito/solution.Java
* **nullObjectPattern**, con:
    * solución en Java o similar (fuertemente tipado) basada en el capitulo de Diseño y el proyecto ticTacToe
        * Modelo del Dominio: https://github.com/ijavidilo/p4-refactoring/tree/master#modelo-del-dominio
        * Implementación: https://github.com/ijavidilo/p4-refactoring/tree/nullObjectPattern/solution.Java/src/main/java/usantatecla/draughts
        * Test unitarios: https://github.com/ijavidilo/p4-refactoring/tree/nullObjectPattern/solution.Java/src/test/java/usantatecla/draughts  
* **genericCoordinate**, con:
    * solución en Java o similar (fuertemente tipado) basada en el capitulo de Diseño y el proyecto ticTacToe
        * Modelo del Dominio: https://github.com/ijavidilo/p4-refactoring/tree/master#modelo-del-dominio
        * Implementación: https://github.com/ijavidilo/p4-refactoring/tree/genericCoordinate/solution.Java/src/main/java/usantatecla/draughts
        * Test unitarios: https://github.com/ijavidilo/p4-refactoring/tree/genericCoordinate/solution.Java/src/test/java/usantatecla/draughts 
* **onlyOneView**, con:
    * solución en Java o similar (fuertemente tipado) basada en el capitulo de Diseño y el proyecto ticTacToe
        * Modelo del Dominio: https://github.com/ijavidilo/p4-refactoring/tree/master#modelo-del-dominio
        * Implementación: https://github.com/ijavidilo/p4-refactoring/tree/onlyOneView/solution.Java/src/main/java/usantatecla/draughts
        * Test unitarios: https://github.com/ijavidilo/p4-refactoring/tree/onlyOneView/solution.Java/src/test/java/usantatecla/draughts 
>* **mvp.pv**, con:
>    * solución en Java o similar (fuertemente tipado) basada en el capitulo de Diseño y el proyecto ticTacToe
>        * Modelo del Dominio: https://github.com/ijavidilo/p4-refactoring/tree/master#modelo-del-dominio
>        * Implementación: https://github.com/ijavidilo/p4-refactoring/tree/mvp.pv/solution.Java/src/main/java/usantatecla/draughts
>        * Test unitarios: https://github.com/ijavidilo/p4-refactoring/tree/mvp.pv/solution.Java/src/test/java/usantatecla/draughts

Master Cloud Apps curso 2020/21 [MasterCloudApps](https://www.codeurjc.es/mastercloudapps/).