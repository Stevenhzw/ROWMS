package sv.edu.udb.www.utils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class JpaUtil {
    private static final EntityManagerFactory emFactory;
    static {
        emFactory = Persistence.createEntityManagerFactory("default");
    }
    public static EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }
}
