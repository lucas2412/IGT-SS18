package Controller;

import model.History;
import model.Item;
import tools.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ItemController {

    public void createItem(Item i) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(i);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();

    }

    public void updateItem(Item i) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Item itemold = entityManager.find(Item.class, i.getI_ID());
        itemold = i;
        entityManager.merge(itemold);

        entityManager.getTransaction().commit();


        entityManager.close();
        factory.close();

    }

    public void deleteItem(int I_ID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Item item = entityManager.find(Item.class, I_ID);

        entityManager.remove(item);
        entityManager.getTransaction().commit();



        entityManager.close();
        factory.close();

    }

    public Item getItem(int I_ID) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        Item item = null;

        entityManager.getTransaction().begin();

        item = entityManager.find(Item.class, I_ID);

        entityManager.close();
        factory.close();

        return item;


    }
}
