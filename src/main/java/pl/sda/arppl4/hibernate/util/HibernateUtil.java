package pl.sda.arppl4.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//Wzorzec projektowy Singleton
//
// Rozwiazuje problem:
//  - jak stworzyc obiekt aby istnial tylko jeden na caly projekt
//  - jak sprawic by ten obiekt ladowal sie TYLKO RAZ
//  - jak sprawic by był ogolnodostepny

public class HibernateUtil {
    public static final HibernateUtil INSTANCE = new HibernateUtil();
    public SessionFactory sessionFactory;

    private HibernateUtil() {
        loadConfiguration();
    }

    private void loadConfiguration() {
        //Załadowanie "Registry" jako kolekcji parametrów konfiguracyjnych do rejestru
        //Stworzenie obieku zawierajacego zestaw ustawień.
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        // Stworzenie obiektu metadata - dane opisujace polaczenie z baza danych
        Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();

        // Wykorzystujemy metadane do skonfigurowania/parametryzacji fabryki. Tworzymy fabrykę.
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
