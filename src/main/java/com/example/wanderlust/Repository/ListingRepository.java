package com.example.wanderlust.Repository;

import com.example.wanderlust.Model.Listings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends JpaRepository<Listings , Integer> {

}
