# Vuelo - Aplicación de Gestión de Vuelos ✈️

La aplicación Vuelo es un sistema que proporciona funcionalidades para la gestión de vuelos, aerolíneas y ubicaciones. Permite realizar búsquedas de vuelos según diversos criterios.

## Ejecución de la Aplicación ▶️

Para ejecutar la aplicación Vuelo, sigue estos pasos:

1. **Clonar el Repositorio 📦**: Clona el repositorio de GitHub en tu máquina local.

   ```bash
   git clone https://github.com/tu_usuario/vuelo.git

2. **Importar Proyecto 📁**: Abre el proyecto en tu IDE como un proyecto de Maven.

3. **Configurar Dependencias 📚:**: Asegúrate de que todas las dependencias definidas en el archivo `pom.xml` se descarguen correctamente.

4. **Ejecutar la Aplicación ▶️**: Ejecuta la clase principal `VueloApplication.java` como una aplicación Spring Boot.

5. **Acceder a la Aplicación 🌐**: Una vez que la aplicación esté en funcionamiento, puedes acceder a ella en tu navegador web preferido ingresando la URL: `http://localhost:8080`.

## Endpoints Disponibles 🚀

La aplicación proporciona los siguientes endpoints para interactuar con la API:

- **Búsqueda de Vuelos 🔍**: `/flights/searchFlights` - Permite buscar vuelos según diferentes criterios como aerolínea, origen, destino, fecha de salida, precio, etc.
  
- **Obtener Todas las Aerolíneas 🛫**: `/airlines/getAllAirlines` - Devuelve una lista de todas las aerolíneas disponibles.
  
- **Obtener Todas las Ubicaciones 📍**: `/locations/getAllLocations` - Devuelve una lista de todas las ubicaciones disponibles.

## Requisitos del Sistema 📋
- Java JDK 11 o superior ☕.
- Apache Maven 📦.
- IDE compatible con Spring Boot (por ejemplo, IntelliJ IDEA, Eclipse) 🖥️.
- Conexión a Internet para descargar dependencias 🌐.
