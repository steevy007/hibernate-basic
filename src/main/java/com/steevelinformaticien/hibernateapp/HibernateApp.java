/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.steevelinformaticien.hibernateapp;

import com.steevelinformaticien.hibernateapp.bean.Player;
import com.steevelinformaticien.hibernateapp.controller.PlayerController;
import com.steevelinformaticien.hibernateapp.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author PEPECELL
 */
public class HibernateApp {

    public static void main(String[] args) {
        //creation player
        PlayerController servicec = new PlayerController();
        servicec.creer();
        //getbyid
        servicec.afficherPlayerById();
        //update
        servicec.updateName();
        //delete
        servicec.delete();
        //lister all player
        servicec.afficherListePlayer();

    }
}
