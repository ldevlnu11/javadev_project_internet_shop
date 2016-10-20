package ua.com.dao;

import ua.com.entity.Offer;

import java.util.List;

/**
 * Created by devnull on 09.10.16.
 */
public interface OfferInterface{

    void createOffer(Offer offer);
    List<Offer> showAllOffers();
    void deleteComplitedOffers();
    List<Offer> findUncomplitedOffers();

}
