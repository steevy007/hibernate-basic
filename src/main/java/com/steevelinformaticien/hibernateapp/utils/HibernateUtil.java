/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.hibernateapp.utils;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author PEPECELL
 */
public class HibernateUtil {

    public static SessionFactory factory;
//to disallow creating objects by other classes.

    private HibernateUtil() {
    }
//maling the Hibernate SessionFactory object as singleton

    public static synchronized SessionFactory getSessionFactory() {
        File f = new File("src/hibernate.cfg.xml");
        if (factory == null) {
            factory = new Configuration().configure(f).buildSessionFactory();
        }
        return factory;
    }
}
