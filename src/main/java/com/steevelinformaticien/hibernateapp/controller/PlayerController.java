/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.hibernateapp.controller;

import com.steevelinformaticien.hibernateapp.bean.Player;
import com.steevelinformaticien.hibernateapp.service.PlayerService;
import java.util.Scanner;

/**
 *
 * @author PEPECELL
 */
public class PlayerController {

    private PlayerService service;

    public PlayerController() {
        this.service = new PlayerService();
    }

    public void creer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom :");
        String nom = sc.nextLine();
        System.out.println("Veuillez saisir le prenom :");
        String prenom = sc.nextLine();

        Player p = new Player();
        p.setFirstname(prenom);
        p.setLastname(nom);

        this.service.create(p);
        
        System.out.println("Player creer");
    }

    public void afficherListePlayer() {
        for (Player p : this.service.listPlayer()) {
            System.out.println("Nom => " + p.getLastname() + " Prenom => " + p.getFirstname());
        }
    }

    public void afficherPlayerById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir id du player");
        int id = sc.nextInt();
        Player p = (Player) this.service.getById(id);

        System.out.println("Le player selectionner est : " + p.getFirstname());
    }

    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir id du player");
        int id = sc.nextInt();
        this.service.delete(id);
        System.out.println("Player delete");
    }
    
    public void updateName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir id du player");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("veuillez saisir le nouveau nom");
        String name=sc.nextLine();
        this.service.updateName(id, name);
        System.out.println("Player update");
    }
}
