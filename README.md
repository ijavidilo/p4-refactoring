# P4: Refactoring - Javier Diaz Lopez (Parte 6: TDD práctica TicTacToe)
  * ## Anotaciones alumno: 
  > Aplicamos TDD a la version de la práctica "modelViewPresenter - presentationModel" de TicTacToe añadiendo poco a poco la funcionalidad necesaria hasta llegar a la version "withComposite". No se ha llegado hasta el final, pero se a aplicado TDD a varias funcionalidades (Estados, doble despacho/inversion de dependencias en controladores/tests)
### Instrucciones de entrega

Entrega de un proyecto público en git varias ramas:

* **master**, con:
    * Modelo del dominio.
    * Requisitos: Puedes encontrar los requisitos en la carpeta /Damas de este mismo repositorio.
    * Código inicial: https://github.com/ijavidilo/p3-damas/tree/unitTestWithMockito/solution.Java
* **nullObjectPattern**, con:
    * solución en Java o similar (fuertemente tipado) basada en el capitulo de Diseño y el proyecto de las damas
        * Modelo del Dominio: https://github.com/ijavidilo/p4-refactoring/tree/master#modelo-del-dominio
        * Implementación: https://github.com/ijavidilo/p4-refactoring/tree/nullObjectPattern/solution.Java/src/main/java/usantatecla/draughts
        * Test unitarios: https://github.com/ijavidilo/p4-refactoring/tree/nullObjectPattern/solution.Java/src/test/java/usantatecla/draughts  
* **genericCoordinate**, con:
    * solución en Java o similar (fuertemente tipado) basada en el capitulo de Diseño y el proyecto de las damas
        * Modelo del Dominio: https://github.com/ijavidilo/p4-refactoring/tree/master#modelo-del-dominio
        * Implementación: https://github.com/ijavidilo/p4-refactoring/tree/genericCoordinate/solution.Java/src/main/java/usantatecla/draughts
        * Test unitarios: https://github.com/ijavidilo/p4-refactoring/tree/genericCoordinate/solution.Java/src/test/java/usantatecla/draughts 
* **onlyOneView**, con:
    * solución en Java o similar (fuertemente tipado) basada en el capitulo de Diseño y el proyecto de las damas
        * Modelo del Dominio: https://github.com/ijavidilo/p4-refactoring/tree/master#modelo-del-dominio
        * Implementación: https://github.com/ijavidilo/p4-refactoring/tree/onlyOneView/solution.Java/src/main/java/usantatecla/draughts
        * Test unitarios: https://github.com/ijavidilo/p4-refactoring/tree/onlyOneView/solution.Java/src/test/java/usantatecla/draughts 
* **mvp.pv**, con:
    * solución en Java o similar (fuertemente tipado) basada en el capitulo de Diseño y el proyecto de las damas
        * Modelo del Dominio: https://github.com/ijavidilo/p4-refactoring/tree/master#modelo-del-dominio
        * Implementación: https://github.com/ijavidilo/p4-refactoring/tree/mvp.pv/solution.Java/src/main/java/usantatecla/draughts
        * Test unitarios: https://github.com/ijavidilo/p4-refactoring/tree/mvp.pv/solution.Java/src/test/java/usantatecla/draughts
* **intervals**, con:
    * solución en Java o similar (fuertemente tipado)
        * Código de partida: https://github.com/USantaTecla/intervals
        * Implementación: https://github.com/ijavidilo/p4-refactoring/tree/intervals/solution.Java/src/main/java/usantatecla
        * Test unitarios: https://github.com/ijavidilo/p4-refactoring/tree/intervals/solution.Java/src/test/java/usantatecla
>* **tictactoe.tdd**, con:
>    * solución en Java o similar (fuertemente tipado) basada en el capitulo de Diseño y el proyecto ticTacToe
>        * Código de partida: https://github.com/SantaTecla-ticTacToe/solution.java.swing.socket.sql/tree/master/modelViewPresenter/presentationModel/basic
>        * Código al que tenemos que llegar aplicando TDD: https://github.com/SantaTecla-ticTacToe/solution.java.swing.socket.sql/tree/master/modelViewPresenter/presentationModel/withComposite
>        * Implementación: https://github.com/ijavidilo/p4-refactoring/tree/tictactoe.tdd/solution.Java/src/main/java/usantatecla
>        * Test unitarios: https://github.com/ijavidilo/p4-refactoring/tree/tictactoe.tdd/solution.Java/src/test/java/usantatecla

Master Cloud Apps curso 2020/21 [MasterCloudApps](https://www.codeurjc.es/mastercloudapps/).