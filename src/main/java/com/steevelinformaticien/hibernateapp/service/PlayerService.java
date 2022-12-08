/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.steevelinformaticien.hibernateapp.service;

import com.steevelinformaticien.hibernateapp.bean.Player;
import com.steevelinformaticien.hibernateapp.dto.PlayerDto;
import com.steevelinformaticien.hibernateapp.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author PEPECELL
 */
public class PlayerService {

    private PlayerDto dto;

    public PlayerService() {
        this.dto = new PlayerDto();
    }

    public void create(Player player) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            this.dto.createPlayer(player);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.commit();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Player> listPlayer() {
        Session session = null;
        Transaction tx = null;
        List <Player> p=new ArrayList();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            for(Player pl:this.dto.listPlayer()){
                p.add(pl);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.commit();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        return p;
    }
    
    
    public Player getById(int id){
        Session session = null;
        Transaction tx = null;
        Player p=null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            p=(Player)this.dto.getPlayerById(id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.commit();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return p;
    }
    
    public void updateName(int id,String name){
        Session session = null;
        Transaction tx = null;
        Player p=null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            this.dto.updatePlayerName(id, name);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.commit();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
     public void delete(int id){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            this.dto.deletePlayer(id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.commit();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
