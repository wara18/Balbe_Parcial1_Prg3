# EcoRide Pro — Sistema de Alquiler de Vehículos Eléctricos - Parcial 2

Sistema desarrollado con Spring Boot 3, Java 21 y Maven.
Continuación del parcial 1

## Integrantes
- Martin Francisco -  EISI1534
- Avila Wara - EISI1510
- Peralta Lautaro - EISI1589
- Nuñez Castelli Santiago - EISI1587

## Cómo correr
Ejecutar "ParcialProg3Application.java" y acceder a `http://localhost:8080`

## Endpoints disponibles

| Método | URL | Descripción |
|--------|-----|-------------|
| GET | /api/alquileres/desbloquear/{idUsuario}/{patente}/{metodoPago} | Inicia un viaje |
| GET | /api/alquileres/finalizar/{idUsuario}/{patente} | Finaliza un viaje |
| GET | /api/vehiculos/prioridad-carga | Flota ordenada por batería |
| GET | /api/vehiculos/tarifa-descendente | Flota ordenada por tarifa |

## Decisiones técnicas

**Búsqueda de vehículos:** cambiamos la lista por un HashMap para que la búsqueda
por patente sea directa y no dependa de cuántos vehículos haya cargados.

**Deduplicación GPS:** usamos un HashSet que hace una sola pasada sobre los datos,
evitando comparar cada elemento contra todos los demás.

**Ordenamiento:** Vehiculo implementa Comparable para el criterio de batería.
Para ordenar por tarifa usamos un Comparator externo sin tocar la clase.