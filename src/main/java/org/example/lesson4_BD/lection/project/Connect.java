package org.example.lesson4_BD.lection.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Connect {

    final StandardServiceRegistry registry;
    SessionFactory sessionFactory;


    public Connect() {
        registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
