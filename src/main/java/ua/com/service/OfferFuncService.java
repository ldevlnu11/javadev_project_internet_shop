package ua.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.abstractservice.OfferService;
import ua.com.entity.Offer;
import ua.com.interfaces.OfferInterface;

import java.util.List;

/**
 * Created by devnull on 11.10.16.
 */
@Service("OfferService")
public class OfferFuncService implements OfferService{

    @Autowired
    private OfferInterface offerInterface;


    @Override
    public void createOffer(Offer offer){
        offerInterface.createOffer(offer);
    }

    @Override
    public List<Offer> showAllOffers(){
        return offerInterface.showAllOffers();
    }

    @Override
    public void deleteComplitedOffers(){
        offerInterface.deleteComplitedOffers();
    }

    @Override
    public List<Offer> findUncomplitedOffers(){
        return offerInterface.findUncomplitedOffers();
    }
}
