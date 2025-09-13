Proyecto Android - Gestión de Reglas y Entidades
Descripción

Este proyecto es una aplicación Android desarrollada en Java que implementa un CRUD completo para varias entidades como Reglas, Clientes, Productos, Tiendas, Beneficios, Visitas y Canjes, utilizando Room Database para persistencia local.

Incluye un Menú Administrativo que permite gestionar las entidades mediante Fragments y un RecyclerView para visualización dinámica de listas.

Tecnologías y Librerías

Lenguaje: Java

IDE: Android Studio

Base de datos: Room (SQLite)

UI: RecyclerView, ConstraintLayout, ScrollView, Buttons, EditText

Arquitectura: Controladores para encapsular la lógica de negocio y DAOs para el acceso a datos

Otros: LiveData para actualizar automáticamente el RecyclerView

Estructura del Proyecto
com.example.proyectoandroid
│
├── controller/        # Controladores para lógica de negocio (ReglaController, ClienteController, etc.)
├── dao/               # Interfaces DAO para CRUD con Room
├── database/          # AppDatabase y TypeConverters
├── modelo/            # Clases modelo / entidades de Room
├── Adaptadores/       # Adaptadores para RecyclerView
├── Vista/             # Activities y Fragments de la UI
└── res/               # Layouts, drawables, colores, strings

Funcionalidades

CRUD de Reglas

Crear, leer, actualizar y eliminar reglas.

Selección de items en RecyclerView para edición.

Persistencia automática en Room Database.

Menú Administrativo

Navegación entre fragments de entidades (Reglas, Clientes, Productos, Tiendas, Beneficios).

Botones para agregar, modificar, eliminar y volver al menú.

RecyclerView Dinámico

Muestra listas actualizadas automáticamente usando LiveData.

Cada item del RecyclerView es clickeable para seleccionar y editar.

Instalación

Clonar el repositorio:

Abrir el proyecto en Android Studio.

Sincronizar Gradle para descargar las dependencias.

Ejecutar en un emulador o dispositivo físico con Android SDK >= 26.

Uso

Iniciar la app y acceder al Menú Administrativo.

Seleccionar una sección (ej. Reglas) para ver la lista.

Agregar nuevas reglas, seleccionarlas para editar o eliminar.

Los cambios se guardan automáticamente en Room Database y se reflejan en la UI.

Buenas Prácticas

Uso de LiveData para actualizar RecyclerView automáticamente.

Controladores para encapsular la lógica de negocio.

Separación clara de capas: Modelo → DAO → Controller → Vista.

Evita operaciones en el hilo principal usando ExecutorService.
