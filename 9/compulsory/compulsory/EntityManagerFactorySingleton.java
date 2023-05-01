package compulsory;

import jakarta.persistence.*;

/**
 * Class EntityManagerFactorySingleton - responsible with management
 */

public class EntityManagerFactorySingleton {

    private static EntityManagerFactory emf;

    private EntityManagerFactorySingleton() {
    }


    public static synchronized EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("default");
        }
        return emf;
    }
}