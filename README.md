# Banking CQRS & Event Sourcing with Axon

**Projet académique – Gestion des comptes bancaires**

[![Java](https://img.shields.io/badge/Java-21-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)](https://spring.io/projects/spring-boot)
[![Axon Framework](https://img.shields.io/badge/Axon-Framework-blue)](https://www.axoniq.io/)
[![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL-blue)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/Docker-Compose-blue)](https://www.docker.com/)

## Présentation du projet

Ce projet consiste à concevoir et développer une application de gestion des comptes bancaires en mettant en pratique deux patterns architecturaux :

- **CQRS (Command Query Responsibility Segregation)** : séparation des opérations de lecture et d'écriture.
- **Event Sourcing** : conservation des changements d'état sous forme d'événements afin de reconstruire l'historique des comptes.

L'application est développée avec Spring Boot et Axon Framework, avec Axon Server pour la gestion des événements et des commandes.

## Objectifs

- Comprendre et appliquer l'architecture CQRS.
- Implémenter le pattern Event Sourcing.
- Gérer le cycle de vie des comptes bancaires.
- Séparer les modèles de lecture et d'écriture.
- Assurer la traçabilité des opérations bancaires.
- Suivre les transactions en temps réel.

## Technologies utilisées

| Technologie | Utilisation |
|---|---|
| Java 21 | Langage de programmation |
| Spring Boot | Développement backend |
| Axon Framework | CQRS et Event Sourcing |
| Axon Server | Gestion des commandes et événements |
| PostgreSQL | Stockage des données de lecture |
| Spring Data JPA | Accès aux données |
| Docker Compose | Conteneurisation des services |
| PgAdmin | Administration de la base de données |
| Swagger UI | Documentation et test des API REST |
| Project Reactor | Programmation réactive |
| Server-Sent Events (SSE) | Suivi des opérations en temps réel |

## Fonctionnalités principales

### Gestion des comptes
- Création de comptes bancaires.
- Activation des comptes.
- Modification du statut des comptes.

### Opérations bancaires
- Créditer un compte.
- Débiter un compte.
- Enregistrer les opérations bancaires.

### Consultation et suivi
- Consulter les comptes bancaires.
- Consulter les relevés et historiques des opérations.
- Consulter l'historique des événements.
- Suivre les transactions en temps réel grâce aux SSE.

## Architecture

L'application repose sur une séparation entre deux parties complémentaires :

**1. Command Side (écriture)**

Cette partie reçoit les commandes, applique les règles métier et génère les événements correspondants.

**2. Query Side (lecture)**

Cette partie traite les requêtes de consultation à partir de projections alimentées par les événements.

**3. Event Store**

Les événements représentent les changements successifs de l'état des comptes et permettent de retracer leur évolution.

### Flux de fonctionnement

```text
Client
  |
  v
REST API
  |
  +----------------------+
  |                      |
  v                      v
Command Side          Query Side
  |                      ^
  v                      |
Axon Framework            |
  |                      |
  v                      |
Axon Server               |
  |                      |
  v                      |
Domain Events ------------+
  |
  v
PostgreSQL Projections
```

## Installation et exécution

### Prérequis

- Java 21
- Docker Desktop
- Git
- Maven (ou Maven Wrapper fourni avec le projet)

### 1. Cloner le dépôt

```bash
git clone https://github.com/sanaetimourti/-CQRS-et-Event-Sourcing-avec-AXON-et-Spring-Cloud.git
```

### 2. Accéder au projet

```bash
cd -CQRS-et-Event-Sourcing-avec-AXON-et-Spring-Cloud
```

### 3. Lancer les services Docker

```bash
docker compose up -d
```

### 4. Compiler et lancer l'application

Sous Windows :

```powershell
.\mvnw.cmd clean install
```

Puis :

```powershell
.\mvnw.cmd spring-boot:run
```

*Remarque : vérifier les ports, les services et les paramètres de connexion définis dans les fichiers de configuration avant le lancement.*

## Tests et documentation API

Swagger UI permet de consulter et tester les endpoints REST de l'application.

L'historique des opérations peut également être consulté à travers les fonctionnalités de lecture et le suivi en temps réel.

## Structure du projet

```text
banking-cqrs-event-sourcing-axon/
│
├── .mvn/
├── accounts-front/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
│
├── .gitattributes
├── .gitignore
├── compose.yaml
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Auteur

**Réalisé par : Sanae Timourti**

- GitHub : [@sanaetimourti](https://github.com/sanaetimourti)
- Repository : [Banking CQRS & Event Sourcing with Axon](https://github.com/sanaetimourti/-CQRS-et-Event-Sourcing-avec-AXON-et-Spring-Cloud)

## Encadrement et références pédagogiques

**Encadrant : Pr. Mohamed YOUSSFI**

Projet académique adapté à partir du code source et des démonstrations pédagogiques du professeur Mohamed YOUSSFI.

**Projet de référence :**  
https://github.com/mohamedYoussfi/event-sourcing-cqrs-spring-axon-app

---

*Projet réalisé dans un cadre académique dans le but de mettre en pratique les architectures CQRS et Event Sourcing avec Spring Boot et Axon Framework.*
