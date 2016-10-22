package ua.com.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import ua.com.dao.OfferInterface;
import ua.com.entity.Offer;
import ua.com.service.OfferService;

import java.util.List;

/**
 * Created by devnull on 11.10.16.
 */
@Service("OfferService")
public class OfferServiceImp implements OfferService{

    @Autowired
    private OfferService offerService;


    @Override
    public void createOffer(Offer offer){
        offerService.createOffer(offer);
    }

    @Override
    public List<Offer> showAllOffers(){
        return offerService.showAllOffers();
    }

    @Override
    public void deleteComplitedOffers(){
        offerService.deleteComplitedOffers();
    }

    @Override
    public List<Offer> findUncomplitedOffers(){
        return offerService.findUncomplitedOffers();
    }
}
