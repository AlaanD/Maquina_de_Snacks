# Maquina de Snacks

Este proyecto es una práctica en **Java** diseñada para trabajar con la manipulación de archivos.
Su objetivo principal es simular el funcionamiento de una máquina expendedora de snacks,
permitiendo al usuario interactuar con el sistema y registrar la información de los productos mediante archivos.

## Características

- Lectura y escritura de datos en archivos de texto (`snacks.txt`).
- Simulación del proceso de compra de snacks.
- Registro y actualización del inventario de productos en la máquina.
- Uso de principios básicos de programación orientada a objetos en Java.
- Implementación en dos versiones con diferentes estructuras y niveles de mantenimiento.

## Requisitos Previos

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) instalado en tu sistema.
- Entorno de desarrollo integrado (IDE) como **IntelliJ IDEA**, **Eclipse** o **NetBeans**.


## Enfoques del Proyecto
El proyecto está organizado en dos paquetes principales, cada una con un enfoque diferente para cumplir los mismos objetivos:

maquina_snacks:
- Contiene una versión simple del proyecto con código centralizado y no manipula archivos.
- Ideal para aprender la funcionalidad básica sin una división estricta de responsabilidades.

maquina_snacks_archivo_multicapa:
- Divide el código en capas (domino, presentacion y servicio) para mejorar el mantenimiento y la escalabilidad.
- Ofrece dos implementaciones para el servicio que gestiona los snacks:
- Servicio basado en listas: Maneja los datos directamente en memoria utilizando listas.
- Servicio basado en archivos: Realiza operaciones de lectura y escritura en archivos para manejar los datos.
- Ambas implementaciones utilizan la interfaz IServicioSnacks para garantizar consistencia y flexibilidad.

## Estructura del Proyecto

- **Maquina_de_Snacks/**
  - **maquina_snacks/**  
    - Archivos principales de esta versión.
  - **maquina_snacks_archivo_multicapa/**  
    - **dominio/**  
    - **presentacion/**  
    - **servicios/**  
      - `ServicioSnacksLista.java`: Implementación basada en listas.  
      - `ServicioSnacksArchivos.java`: Implementación basada en archivos.  
      - `IServicioSnacks.java`: Interfaz de servicios.  
    - Otros archivos de esta versión.
  - `snacks.txt`: Archivo de datos para la máquina de snacks.
  - `.gitattributes`: Configuración de Git.
  - `.gitignore`: Archivos y carpetas ignorados por Git.
  - `Maquina_de_Snacks.iml`: Archivo de proyecto para el IDE.


## Cómo Usar

1. Clona este repositorio:
    ```
    git clone https://github.com/AlaanD/Maquina_de_Snacks.git
    ```

2. Abre el proyecto en tu IDE favorito.

3. Elige la carpeta correspondiente al enfoque que quieras utilizar:
- maquina_snacks: Para la versión básica.
- maquina_snacks_archivo_multicapa: Para la versión dividida en capas.

4. Si seleccionaste maquina_snacks_archivo_multicapa, edita el archivo principal que contiene el método main.
- Deberás comentar y descomentar las líneas según la implementación de servicio que desees utilizar:
- Para usar la implementación basada en listas, asegura que la línea sea como sigue:
- //Creamos el objeto para obtener el servicio de snacks (lista)
- IServicioSnacks servicioSnacks = new ServicioSnacksLista();
- Para usar la implementación basada en archivos, asegúrate de que esta línea esté activa:
- //Creamos el objeto para obtener el servicio de snacks (Archivo)
- IServicioSnacks servicioSnacks = new ServicioSnacksArchivos();
- Asegúrate de comentar/descomentar estas líneas correctamente antes de ejecutar el programa.

5. Ejecuta el archivo principal (main) y sigue las instrucciones en la consola para interactuar con la máquina de snacks.


## Autor

- **Alán D.**  

