package com.liquibase;

import jakarta.persistence.*;

public class Application {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        System.out.println("Hello World");
        EntityManager em = null;
        try {
            var item = new Item();
            item.setName("Home Appliance");
            var house = new House();
            house.setFullyPaid(true);
            house.setOwner("Julius Krah");
            setUp();
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(house);
            item.setHouse(em.getReference(House.class, house.getId()));
            em.persist(item);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null)
                em.getTransaction().rollback();
            System.err.println("The following error was observed " + e.getLocalizedMessage());
        } finally {
            if(em != null)
                em.close();
        }
    }

    protected static void setUp() throws Exception {
        emf = Persistence.createEntityManagerFactory("com.liquibase.hibernate.tutorial.jpa");
    }
}
