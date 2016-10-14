package ua.com.function;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.entity.Offer;
import ua.com.interfaces.OfferInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Scanner;

/**
 * Created by devnull on 09.10.16.
 */
@Repository
public class OfferFunction implements OfferInterface{
    @PersistenceContext(name="primary")
    private EntityManager man;
    private final static String offerTable = " Offer ";
    @Transactional
    public void createOffer(Offer offer){
        man.persist(offer);
    }

    @Transactional
    public List<Offer> showAllOffers(){
        return man.createQuery("from"+offerTable+"o").getResultList();
    }

    @Transactional
    public void deleteComplitedOffers(){
        List<Offer> complitedOffers = man.createQuery("select o from"+offerTable+"o where o.offer_status = 'Отправлено'").getResultList();
        if(complitedOffers != null){
            for(Offer offer: complitedOffers){
                man.remove(offer);
            }
        }
    }

    @Transactional
    public List<Offer> findUncomplitedOffers(){
        return man.createQuery("select o from"+offerTable+"o where o.offer_status = 'Неотправлено'").getResultList();
    }
}
