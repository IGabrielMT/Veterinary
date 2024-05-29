# REGISTRO VETERINARIA

Este proyecto es una aplicacion de escritorio que permite llevar un registro de las citas de una veterinaria, tomando en cuenta
los datos de los clientes y las vacunas y ademas de poder visualizar los datos de los clientes y las vacunas.


## Tabla de Contenidos

- Requisitos
- Uso
- Autor
- Mas Trabajos

## Requisitos

- Java 21 o superior.
- Sistema Operativo Windows.

## Uso

El proceso de ejecucion en el IDE es sencillo, variará segun el IDE que se utilice, en el caso de Visual Studio Code y IntellijIDEA se debe ejecutar el archivo `Main.java` que se encuentra en la carpeta `src/Main.java`.

## Uso en la Aplicacion

La aplicacion cuenta con un menu principal que permite al usuario elegir entre las opciones de registrar una cita y vacunas, ver las citas registradas y salir de la aplicacion.
La aplicación depende de la carpeta `files` que se encuentra en la raiz del proyecto, en esta carpeta se guardan los datos de las citas y las vacunas.

## Pequeños inconvenientes posibles
 
Los JDateChooser no se ven completos y es necesario escribir la fecha en el formato dd/MM/yyyy.
Los JComboBox no se ven completos y es necesario hacer uso de las flechas o del teclado para elegir una opcion
La tabla no se ve completa a menos que se organice manualmente.

## Librerias Usadas

Gson: Para la lectura y escritura de archivos JSON.
JDateChooser: Para la seleccion de fechas.
Lombok: Para la generacion de getters y setters.
ManagerProperties: Para la lectura de archivos de configuracion.

## Nota

Se encuentra en la carpeta `files` un archivo llamado `config.properties` que contiene la ruta de los archivos de citas y vacunas, si se desea cambiar la ruta de los archivos se debe modificar el archivo `config.properties` y cambiar la ruta de los archivos.
Para modificar la ruta de donde se encuentra el archivo `config.properties` se debe modificar el archivo `PresenterVet.java` en la linea 23.
En la carpeta `files` se encuentran los archivos json quemados, sin embargo no son necesarios para la ejecucion de programa

## Agradecimientos

Muchas gracias a los profesores de la Universidad Pedagogica y Tecnologica de Colombia por la enseñanza y la paciencia.

## Instalación

1. Clona el repositorio en tu máquina local usando `git clone https://github.com/username/repo.git`
2. Navega al directorio del proyecto usando `cd repo`
3. Si usas IntelliJ IDEA, puedes abrir el proyecto directamente. Para otros IDEs, puedes necesitar configurar el proyecto manualmente.
4. Asegúrate de tener Java 21 o superior instalado en tu máquina. Si no, puedes descargarlo [aquí](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
5. Ejecuta el archivo `Main.java` que se encuentra en la carpeta `src/Main.java`.

## Licencia

Este proyecto está licenciado bajo los términos de la licencia MIT. Consulta el archivo `LICENSE` para más detalles.
## Autor

Ian Gabriel Martinez Torres