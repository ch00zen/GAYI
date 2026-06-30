package com.gestion.utilisateurs;

import com.gestion.utilisateurs.model.User;
import com.gestion.utilisateurs.service.UserService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService = new UserService();

    public static void main(String[] args) {
        System.out.println("=== Gestion des utilisateurs ===");
        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> createUser();
                case "2" -> listUsers();
                case "3" -> updateUser();
                case "4" -> deleteUser();
                case "5" -> {
                    System.out.println("Au revoir !");
                    return;
                }
                default -> System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. Ajouter un utilisateur");
        System.out.println("2. Afficher tous les utilisateurs");
        System.out.println("3. Modifier un utilisateur");
        System.out.println("4. Supprimer un utilisateur");
        System.out.println("5. Quitter");
        System.out.print("Sélectionnez une option: ");
    }

    private static void createUser() {
        System.out.println("--- Création d'un utilisateur ---");
        String firstName = prompt("Prénom: ");
        String lastName = prompt("Nom: ");
        String email = prompt("Email: ");
        String password = promptPassword();

        User user = new User(firstName, lastName, email, password);
        userService.addUser(user);
        System.out.println("Utilisateur créé : " + user);
    }

    private static void listUsers() {
        System.out.println("--- Liste des utilisateurs ---");
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("Aucun utilisateur trouvé.");
            return;
        }
        users.forEach(System.out::println);
    }

    private static void updateUser() {
        System.out.println("--- Modification d'un utilisateur ---");
        int id = promptInt("ID de l'utilisateur: ");
        User user = userService.getUser(id);
        if (user == null) {
            System.out.println("Utilisateur introuvable.");
            return;
        }

        String firstName = prompt("Nouveau prénom (laisser vide pour garder '" + user.getFirstName() + "'): ");
        String lastName = prompt("Nouveau nom (laisser vide pour garder '" + user.getLastName() + "'): ");
        String email = prompt("Nouvel email (laisser vide pour garder '" + user.getEmail() + "'): ");
        String password = prompt("Nouveau mot de passe (laisser vide pour garder l'ancien): ");

        if (!firstName.isBlank()) {
            user.setFirstName(firstName);
        }
        if (!lastName.isBlank()) {
            user.setLastName(lastName);
        }
        if (!email.isBlank()) {
            user.setEmail(email);
        }
        if (!password.isBlank()) {
            user.setPassword(password);
        }

        userService.updateUser(user);
        System.out.println("Utilisateur mis à jour : " + user);
    }

    private static void deleteUser() {
        System.out.println("--- Suppression d'un utilisateur ---");
        int id = promptInt("ID de l'utilisateur: ");
        userService.deleteUser(id);
        System.out.println("Utilisateur supprimé si existant.");
    }

    private static String prompt(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    private static String promptPassword() {
        String password;
        do {
            password = prompt("Mot de passe: ");
            if (password.isBlank()) {
                System.out.println("Le mot de passe ne peut pas être vide.");
            }
        } while (password.isBlank());
        return password;
    }

    private static int promptInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }
    }
}
