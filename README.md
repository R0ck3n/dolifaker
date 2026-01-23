# Dolifaker

Dolifaker est une application desktop Java permettant de générer automatiquement des données fictives (tiers, produits, etc.) et de les créer via l’API REST de Dolibarr.

## 🎯 Objectif

L’objectif de Dolifaker est de faciliter :
- le remplissage de données de test dans Dolibarr
- les phases de développement et de recette
- la génération massive d’objets via l’API Dolibarr

L’application propose une interface graphique simple permettant de :
- configurer la connexion à un Dolibarr (URL, clé API)
- choisir les types d’objets à générer
- définir le volume de données
- envoyer automatiquement les données générées vers Dolibarr

## 🧱 Stack technique

- **Java 21**
- **Spring Boot 3.5.10**
- **JavaFX** (interface graphique desktop)
- **Datafaker** (génération de données fictives)
- **API REST Dolibarr**
- **Maven**

## 📦 Architecture du projet

Le projet est organisé selon une séparation claire des responsabilités :

- `javafx` : interface utilisateur (JavaFX)
- `dolibarr` : communication avec l’API Dolibarr
- `faker` : génération de données fictives
- `config` : configuration applicative

Spring Boot est utilisé comme moteur applicatif embarqué dans l’application desktop.

## 🚀 État du projet

- [x] Initialisation du projet
- [x] Configuration Spring Boot / JavaFX
- [ ] Interface de connexion Dolibarr
- [ ] Appels API Dolibarr
- [ ] Génération de données (tiers, produits, etc.)
- [ ] Packaging Windows (EXE)

## 🛠️ Lancement (développement)

```bash
mvn spring-boot:run
