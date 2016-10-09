package ua.com.function;

import ua.com.entity.Offer;
import ua.com.interfaces.OfferInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

/**
 * Created by devnull on 09.10.16.
 */
public class OfferFunction implements OfferInterface{

    private static EntityManagerFactory fac;
    private static EntityManager man;
    private final static String offerTable = " Offer ";
    private Scanner sc = new Scanner(System.in);

    static{
        fac = Persistence.createEntityManagerFactory("primary");
        man = fac.createEntityManager();
    }

    @Override
    public void createOffer(Offer offer){
        man.getTransaction().begin();
        man.persist(offer);
        man.getTransaction().commit();
    }

    @Override
    public List<Offer> showAllOffers(){
        return man.createQuery("select o from"+offerTable+"o").getResultList();
    }

    @Override
    public void deleteComplitedOffers(){
        List<Offer> complitedOffers = man.createQuery("select o from"+offerTable+"o where o.offer_status = 'Неотправлен'").getResultList();
        if(complitedOffers != null){
            man.remove(complitedOffers);
        }
    }

    @Override
    public List<Offer> findUncomplitedOffers(){
        return man.createQuery("select o from"+offerTable+"o where o.offer_status = 'Отправлен'").getResultList();
    }
}
