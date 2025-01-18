# Conversor de Monedas - README
## Descripción del Proyecto
El **Conversor de Monedas** es una aplicación Java que permite realizar conversiones entre diferentes monedas, obteniendo las tasas de cambio desde una API externa. Además, puede guardar un historial de conversiones realizadas y exportar esta información a archivos para un análisis posterior.
Este proyecto también permite buscar códigos de monedas soportados y gestionar tanto las tasas de cambio como los datos procesados en formato JSON.
## Características
- Consulta y muestra los códigos de monedas soportados.
- Realiza conversiones entre monedas basándose en tasas de cambio actualizadas desde una API.
- Exporta las tasas de conversión y los resultados de las conversiones a archivos en formato JSON o texto.
- Permite mantener un historial de conversiones con registro de fecha y hora.
- Opciones intuitivas dentro de un menú interactivo por consola.
- Soporte para filtrar y ordenar los datos según las necesidades del usuario.

## Requisitos del Sistema
- **Java 17 o superior**: El proyecto usa características modernas del lenguaje, como los `record`s.
- **Maven**: Gestión de dependencias y construcción del proyecto.
- **Conexión a Internet**: Para consultar datos en tiempo real desde la API de Exchange Rate.

## Instalación
1. **Clona el repositorio**:
git clone <https://github.com/IbtFerGomez/AluraConversorMonedasChallenge.git>
   cd AluraConversorMonedasChallenge
2. **Compila el proyecto utilizando Maven**:
 mvn clean package

3. **Ejecuta la aplicación desde la carpeta `target`**:

## Configuración
### Dependencias
El proyecto utiliza la biblioteca **Gson** para manipular datos JSON. La dependencia ya está incluida en el archivo `pom.xml`:

### API Key
El proyecto utiliza [ExchangeRate-API]() para obtener datos en tiempo real. La clave de API `API_KEY (No mostrada por seguridad)` está hardcodeada en la clase `ConsultaMoneda`, pero se recomienda reemplazarla con tu propia clave para evitar problemas de acceso

## Uso
1. **Inicia el programa**: Ejecuta la aplicación desde consola.
2. **Menú principal**:
    - Selecciona `1` para realizar una conversión de moneda.
    - Selecciona `2` para salir del programa (guarda automáticamente el historial en un archivo).
    - Selecciona `3` para visualizar el historial de conversiones realizadas.

3. Ingresa los datos solicitados como códigos de monedas, monto y confirma la operación.
4. Los resultados serán mostrados en pantalla, y las conversiones serán registradas en el historial.

## Clases Principales
### `Principal`
El punto de entrada principal para el programa. Contiene el menú interactivo para los usuarios y gestiona los flujos principales del programa.
### `ConsultaMoneda`
Realiza las solicitudes HTTP a la API para obtener los códigos de moneda y las tasas de conversión.
### `ConversorDeMonedas`
Contiene la lógica necesaria para calcular las conversiones monetarias según la tasa de cambio.
### `HistorialDeConversiones`
Administra el historial de conversiones realizadas y permite exportarlo a un archivo de texto.
### `GeneradorDeArchivo`
Guarda los datos del proyecto, como las tasas de conversión y los códigos de monedas soportados, en archivos JSON estructurados.
### `TasaDeConversion` y `CodigosMoneda`
Son clases `record` que encapsulan los datos devueltos por la API, como las tasas de cambio y los códigos soportados.

## Licencia
Este proyecto ha sido desarrollado como parte de un desafío educativo y se encuentra bajo la licencia MIT. Puedes modificar y distribuir el código siguiendo los términos de la misma