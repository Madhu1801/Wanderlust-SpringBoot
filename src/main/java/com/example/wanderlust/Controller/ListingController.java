package com.example.wanderlust.Controller;


import com.example.wanderlust.Model.ListingRequest;
import com.example.wanderlust.Model.Listings;
import com.example.wanderlust.Service.ListingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListingController {

    @Autowired
    ListingService listingService;

    @GetMapping("/Listings")
    public ResponseEntity<List<Listings>> getAllListings(){

       return new ResponseEntity<>( listingService.getAllListings(), HttpStatus.OK);
    }

//    @GetMapping("/Listings/{id}")
//    public Listings getListingById(@PathVariable int id)   {
//         return  listingService.getListingById(id);
//    }
    @GetMapping("/Listings/{id}")
    public ResponseEntity<Listings> getListingById(@PathVariable int id)   {
         Listings listings =  listingService.getListingById(id);

         if(listings !=null){
             return new ResponseEntity<>(listings,HttpStatus.OK);
         }else {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }

    @PostMapping("/Listings")
    public String addListing(@Valid @RequestBody ListingRequest listingRequest){

        return listingService.addListing(listingRequest);
    }

    @PutMapping("/Listings/{id}")
    public String updateListing(@PathVariable int id,@Valid @RequestBody ListingRequest listingRequest){

        return listingService.updateListing(id, listingRequest);
    }

    @DeleteMapping("/Listings/{id}")
    public String deleteListing(@PathVariable int id) {

        return listingService.deleteListing(id);
    }

}
