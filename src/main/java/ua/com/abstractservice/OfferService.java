package ua.com.abstractservice;

import ua.com.entity.Offer;

import java.util.List;

/**
 * Created by devnull on 11.10.16.
 */
public interface OfferService{

    void createOffer(Offer offer);
    List<Offer> showAllOffers();
    void deleteComplitedOffers();
    List<Offer> findUncomplitedOffers();
}
