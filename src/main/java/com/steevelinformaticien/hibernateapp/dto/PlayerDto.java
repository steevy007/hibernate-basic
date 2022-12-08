/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.hibernateapp.dto;

import com.steevelinformaticien.hibernateapp.bean.Player;
import com.steevelinformaticien.hibernateapp.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author PEPECELL
 */
public class PlayerDto {

    public PlayerDto() {}
    
    public void createPlayer(Player player){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        session.persist(player);
        
    }
    
    public List<Player> listPlayer(){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        List<Player> p= session.createQuery("SELECT p FROM Player p",Player.class).getResultList();
        return p;
    }
    
    public Player getPlayerById(int id){
         Session session=HibernateUtil.getSessionFactory().getCurrentSession();
         Player p=session.find(Player.class, id);
         return p;
    }
    
    public void updatePlayerName(int id, String name){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Player p=session.find(Player.class, id);
        p.setLastname(name);
        session.persist(p);
        
    }
    
    public void deletePlayer(int id){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Player p=session.find(Player.class, id);
        session.remove(p);
        
    }
    
}
