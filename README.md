# Sistema de Préstamos de Equipos para Estudiantes

![Java](https://img.shields.io/badge/Java-17%2B-blue)
![GitHub last commit](https://img.shields.io/github/last-commit/cristiancallep/sistema-prestamos-equipos)

Sistema de gestión para préstamos de equipos tecnológicos (computadores portátiles y tabletas gráficas) a estudiantes de ingeniería y diseño.

## Características Principales

- Registro de estudiantes (ingeniería y diseño)
- Gestión de equipos (computadores portátiles y tabletas gráficas)
- Búsqueda y modificación de préstamos
- Inventario completo
- Persistencia en archivos planos
- Interfaz basada en JOptionPane

## Estructura del Proyecto

```plaintext
src/
├── main/
│   ├── java/
│   │   ├── estudiantes/
│   │   │   ├── Estudiante.java
│   │   │   ├── EstudianteIngenieria.java
│   │   │   └── EstudianteDiseno.java
│   │   ├── equipos/
│   │   │   ├── ComputadorPortatil.java
│   │   │   └── TabletaGrafica.java
│   │   ├── validaciones/
│   │   │   └── Validaciones.java
│   │   ├── persistencia/
│   │   │   ├── CargadorDatos.java
│   │   │   ├── Gestor Equipos.java
│   │   │   └── Persistencia.java
│   │   ├── menus/
│   │   │   ├── MenuPrincipal.java
│   │   │   ├── MenuIngenieria.java
│   │   │   ├── MenuDiseno.java
│   │   │   ├── MenuPortatiles.java
│   │   │   └── MenuTabletas.java
│   │   └── Main.java
```

## Requisitos

- Java JDK 17 o superior
- Maven (opcional, para gestión de dependencias)

## Configuración

1. Clona el repositorio:
```bash
git clone https://github.com/cristiancallep/sistema-prestamos-equipos.git
```
2. Compila el proyecto:
```bash
javac src/main/java/Main.java -d bin/
```
3. Ejecuta la aplicación:
```bash
   java -cp bin Main
```
## Archivos de Datos
El sistema utiliza los siguientes archivos para persistencia:

- ingenieros.txt - Estudiantes de ingeniería

- disenadores.txt - Estudiantes de diseño

- portatiles.txt - Computadores portátiles

- tabletas.txt - Tabletas gráficas

- inventario_total.txt - Inventario completo

## Flujo de Desarrollo
1. Crea una rama para tu nueva característica:
```bash
   git checkout -b feature/nombre-caracteristica
```
2. Haz commits atómicos:
```bash
   git add .
   git commit -m "feat: añade funcionalidad X"
```
3. Sube tus cambios:
```bash
git push origin feature/nombre-caracteristica
```
4. Crea un Pull Request en GitHub para revisión
##   Contribuciones
   Las contribuciones son bienvenidas. 
   Por favor abre un issue para discutir los cambios que te gustaría hacer.

## Contacto
Cristian Calle Perez - cristiancallepp@gmail.com

Enlace del proyecto: https://github.com/cristiancallep/sistema-prestamos-equipos