# TiendaDisco

Este proyecto contiene diferentes requerimientos donde se emula el funcionamiento de una Tienda de Discos y que se podria dividir en 4 partes distintas:

1. En la primera parte se solicita crear 5 consultas según la base de datos entregada, dichas consultas se encuentran en un archivo txt de nombre consultas.
2. En la segunda parte se pide crear una interfaz de nombre CalcularDescuento y dos clases de nombre CalcularDescuentoImpl1 y CalcularDescuentoImpl2 que implementen dicha interfaz.
   Esta última tendrá en método de nombre obtenerDescuento() que recibirá un lista de la clase DetalleVenta que devolverá una variable de tipo double.
   Para comprobar el correcto funcionamiento de dichos métodos se hará mediante pruebas unitarias (@Test).
3. En la tercera parte se solicita crear una página web dinámica que despliegue una lista de elementos desde una base de datos,
   un cuadro de texto(buscador) que permita buscar por titulo(Disco) o nombre(Artista). Desplegar una lista de discos que incluyan (Titulo, Artista, Año de Lanzamiento, Número de Canciones)
   Y tener también un conjunto de botones(Ver,Editar,Eliminar) pero que no tengan ni hagan acción alguna.
4. En la última parte se solicita crear una ApiREST que realice operaciones CRUD(Crear, Leer, Actualizar, Eliminar) con los discos de la base de datos. También debe existir un servicio REST
   que permita filtrar como en el punto anterior.        
