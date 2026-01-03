package com.example.wanderlust.Service;

import com.example.wanderlust.Model.ListingRequest;
import com.example.wanderlust.Model.Listings;
import com.example.wanderlust.Repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingService {

    @Autowired
    ListingRepository listingRepository;

    public List<Listings> getAllListings() {
       return listingRepository.findAll();
    }

//    public Listings getListingById(int id)  {
//        Listings s = listingRepository.findById(id).orElseThrow(()-> new RuntimeException("Listing not found with id"));
//        // if (s !=null){
//             return s;
//       //  }
//       //   throw new Exception("no details found");
//    }

    public Listings getListingById(int id) {
        return listingRepository.findById(id).orElse(null);
    }


    public String addListing(ListingRequest listingRequest) {
        Listings l = new Listings();
        l.setName(listingRequest.getName());
        l.setCountry(listingRequest.getCountry());
        l.setDescription(listingRequest.getDescription());
        l.setPrice(listingRequest.getPrice());
        l.setLocation(listingRequest.getLocation());

        listingRepository.save(l);
      return "listing details added";
    }

    public String updateListing(int id, ListingRequest listingRequest) {

        Listings listing = listingRepository.findById(id).orElseThrow(()-> new RuntimeException("Listing not found with id"));
        listing.setName(listingRequest.getName());
        listing.setLocation(listingRequest.getLocation());
        listing.setCountry(listingRequest.getCountry());
        listing.setPrice(listingRequest.getPrice());
        listing.setDescription(listingRequest.getDescription());

        listingRepository.save(listing);

        return "Listing details updated";
    }

    public String deleteListing(int id) {
        Listings listing = listingRepository.findById(id).orElse(null);
        if(listing !=null){
            listingRepository.delete(listing);
            return "Deleted successfully";
        }
         return "Listing not found";
    }


}
