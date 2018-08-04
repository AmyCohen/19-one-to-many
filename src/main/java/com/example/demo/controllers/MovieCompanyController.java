package com.example.demo.controllers;

import com.example.demo.models.MovieCompany;
import com.example.demo.models.TheaterLocation;
import com.example.demo.repositories.MovieCompanyRepository;
import com.example.demo.repositories.TheaterLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.PostRemove;

@Controller
@RequestMapping("/moviecompanies")
public class MovieCompanyController {
    @Autowired
    MovieCompanyRepository movieCompanyRepository;

    @Autowired
    TheaterLocationRepository theaterLocationRepository;

    @PostMapping
    public String createMovieCompany(@RequestParam String name) {
        MovieCompany company = movieCompanyRepository.save(new MovieCompany(name));
        System.out.println("Succesfully added theater company: " + name);
        return "redirect:/";
    }

    @PostMapping("add-location")
    public String addTheaterLocation(@RequestParam int companyid, @RequestParam String locationName, @RequestParam String address) {

        TheaterLocation newlocation = theaterLocationRepository.save(new TheaterLocation(companyid, locationName, address));
        System.out.println("Succesfully added theater " + locationName + " at " + address + ". The company id is " + companyid);

        return "redirect:/";
    }
}
