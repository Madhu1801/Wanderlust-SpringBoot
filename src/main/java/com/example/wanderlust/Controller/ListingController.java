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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ListingController {

    @Autowired
    ListingService listingService;

    @GetMapping("/Listings")
    public ResponseEntity<List<Listings>> getAllListings(){

       return new ResponseEntity<>( listingService.getAllListings(), HttpStatus.OK);
    }


    //Using GlobalExceptionHandler
    @GetMapping("/Listings/{id}")
    public ResponseEntity<Listings> getListingById(@PathVariable int id)   {
           Listings listings=  listingService.getListingById(id);
           return ResponseEntity.ok(listings);

    }



//    @PostMapping("/Listings")
//    public String addListing(@Valid @RequestBody ListingRequest listingRequest){
//
//        return listingService.addListing(listingRequest);
//    }

    @PostMapping("/Listings")
    public ResponseEntity<Listings> addListing(@Valid @RequestBody ListingRequest listingRequest) {
        Listings createdListing = listingService.addListing(listingRequest);

        // Build location URI: /Listings/{id}
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdListing.getId())
                .toUri();

        // Returns HTTP 201 Created with Location header and entity body

        return ResponseEntity.created(location).body(createdListing);
    }

//    @PutMapping("/Listings/{id}")
//    public String updateListing(@PathVariable int id,@Valid @RequestBody ListingRequest listingRequest){
//
//        return listingService.updateListing(id, listingRequest);
//    }

    @PutMapping("/Listings/{id}")
    public ResponseEntity<Listings> updateListing(
            @PathVariable int id,
            @Valid @RequestBody ListingRequest listingRequest) {
            //System.out.print("UpdateMethod");
        Listings updatedListing = listingService.updateListing(id, listingRequest);
        return ResponseEntity.ok(updatedListing);
    }

    @DeleteMapping("/listings/{id}")
    public ResponseEntity<String> deleteListing(@PathVariable int id) {
        listingService.deleteListing(id);
        return ResponseEntity.ok("Deleted successfully");
    }

}
