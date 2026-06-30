# Gestion des Utilisateurs

Application Java simple avec CRUD utilisateur et connexion MySQL.

## Structure du projet

- `src/main/java/com/gestion/utilisateurs/model` : classe `User`
- `src/main/java/com/gestion/utilisateurs/dao` : classe `UserDao`
- `src/main/java/com/gestion/utilisateurs/service` : classe `UserService`
- `src/main/java/com/gestion/utilisateurs/db` : classe `DatabaseConnection`
- `src/main/java/com/gestion/utilisateurs/Main.java` : point d'entrée de l'application

## Configuration MySQL

1. Démarrer XAMPP et activer MySQL.
2. Créer la base de données et la table :

```sql
CREATE DATABASE IF NOT EXISTS gestion_utilisateurs;
USE gestion_utilisateurs;

CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  email VARCHAR(150) NOT NULL
);
```

3. Modifier les paramètres de connexion dans `src/main/java/com/gestion/utilisateurs/db/DatabaseConnection.java` si nécessaire.

## Lancer l'application

```bash
cd C:\Users\tidia\ProjetJava\GestionUtilisateurs
mvn compile
mvn exec:java -Dexec.mainClass=com.gestion.utilisateurs.Main
```

> Si `mvn exec:java` n’est pas disponible, exécuter la classe `Main` depuis votre IDE.
