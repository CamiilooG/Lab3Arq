/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Camilo Gomez
 */
public class PersistenceManager {

    public static boolean DEBUG = true;
    private static PersistenceManager singleton = new PersistenceManager();
    protected EntityManagerFactory emf;

    public PersistenceManager() {
    }

    public static PersistenceManager getInstance() {
        return singleton;
    }
    public EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            createEntityManagerFactory();
        }
        return emf;
    }

    protected void createEntityManagerFactory() {
        this.emf = Persistence.createEntityManagerFactory("PU", System.getProperties());
        if (DEBUG) {
            System.out.println("Persistence started at " + new java.util.Date());
        }
    }

    public void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
            emf = null;
            if (DEBUG) {
                System.out.println("Persistencia finalizada el dia " + new java.util.Date());
            }

        }
    }
}
