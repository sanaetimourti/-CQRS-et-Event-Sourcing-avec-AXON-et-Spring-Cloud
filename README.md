# Banking CQRS & Event Sourcing

**Projet académique — Gestion des comptes bancaires**

**Repository :** atiqaessayouti/banking-cqrs-event-sourcing-axon

**Encadré par :** Pr. Mohamed YOUSSFI

## Objectif

Mise en pratique des architectures CQRS et Event Sourcing à l'aide de Spring Boot, Axon Framework et Axon Server.

## Technologies utilisées

- Java 21 et Spring Boot
- Axon Framework et Axon Server
- PostgreSQL et Spring Data JPA
- Docker Compose et PgAdmin
- Swagger UI
- Project Reactor et Server-Sent Events (SSE)

## Fonctionnalités

- Création et activation de comptes bancaires
- Opérations de crédit et débit
- Modification du statut des comptes
- Consultation des comptes et relevés bancaires
- Historique des événements
- Suivi en temps réel des opérations

## Architecture

L'application sépare les opérations d'écriture (Command Side) et les opérations de lecture (Query Side). Les changements d'état sont enregistrés sous forme d'événements, puis projetés dans une base relationnelle.

## Auteur

**GitHub :** [@atiqaessayouti](https://github.com/atiqaessayouti)

## Référence pédagogique

Projet adapté à partir du code source et des démonstrations du Pr. Mohamed YOUSSFI.

**Code source original :** https://github.com/mohamedYoussfi/event-sourcing-cqrs-spring-axon-app