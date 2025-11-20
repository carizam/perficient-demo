# Perficient Demo - BDD Automation Tests

Este proyecto contiene pruebas automatizadas BDD (Behavior-Driven Development) para el sitio web de Perficient utilizando Java, Maven, Cucumber y TestNG.

## Tecnologías Utilizadas

- **Java 11**
- **Maven** - Gestión de dependencias y construcción del proyecto
- **Cucumber** - Framework BDD para escribir pruebas en lenguaje natural
- **TestNG** - Framework de pruebas
- **Selenium WebDriver** - Automatización del navegador
- **WebDriverManager** - Gestión automática de drivers del navegador

## Estructura del Proyecto

```
perficient-demo/
├── src/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── perficient/
│       │           ├── hooks/          # Hooks de Cucumber (Before/After)
│       │           ├── pages/          # Page Object Model
│       │           ├── runners/        # Test Runner de Cucumber
│       │           ├── stepdefinitions/# Step Definitions
│       │           └── utils/          # Utilidades (DriverManager, ConfigReader)
│       └── resources/
│           ├── features/               # Archivos .feature de Cucumber
│           ├── application.properties  # Configuración de la aplicación
│           └── cucumber.properties    # Configuración de Cucumber
├── pom.xml                            # Configuración de Maven
├── testng.xml                         # Configuración de TestNG
└── README.md
```

## Requisitos Previos

- Java JDK 11 o superior
- Maven 3.6 o superior
- Navegador Chrome, Firefox o Edge instalado

## Configuración

1. Clonar o descargar el proyecto
2. Asegurarse de tener Java y Maven instalados
3. Configurar las propiedades en `src/test/resources/application.properties`:
   - `base.url`: URL base del sitio web
   - `browser`: Navegador a utilizar (chrome, firefox, edge)
   - `headless`: Ejecutar en modo headless (true/false)
   - `implicit.wait`: Tiempo de espera implícito en segundos

## Ejecución de Pruebas

### Ejecutar todas las pruebas
```bash
mvn clean test
```

### Ejecutar pruebas con un tag específico
Editar `testng.xml` o modificar el tag en `@CucumberOptions` en `TestRunner.java`:
```java
tags = "@smoke"  // Solo pruebas con tag @smoke
```

### Ejecutar una feature específica
```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

## Tags Disponibles

- `@smoke` - Pruebas críticas de humo
- `@regression` - Pruebas de regresión completas

## Reportes

Después de la ejecución, los reportes se generan en:
- **HTML**: `target/cucumber-reports/index.html`
- **JSON**: `target/cucumber-reports/Cucumber.json`
- **XML**: `target/cucumber-reports/Cucumber.xml`

## Escribir Nuevas Pruebas

1. Crear un archivo `.feature` en `src/test/resources/features/`
2. Escribir los escenarios en lenguaje Gherkin
3. Implementar los step definitions en `src/test/java/com/perficient/stepdefinitions/`
4. Crear o actualizar Page Objects en `src/test/java/com/perficient/pages/` si es necesario

## Ejemplo de Feature

```gherkin
@smoke
Feature: Página Principal
  Scenario: Verificar carga de página
    Given que el usuario navega a la página principal de Perficient
    When la página se carga completamente
    Then el usuario debería ver el encabezado principal "AI-First"
```

## Notas

- El proyecto utiliza WebDriverManager para gestionar automáticamente los drivers del navegador
- Las capturas de pantalla se toman automáticamente cuando un escenario falla
- El proyecto está configurado para ejecutar pruebas en paralelo (configurable en testng.xml)

## Autor

Proyecto creado para demostración de automatización BDD con Cucumber y TestNG.

