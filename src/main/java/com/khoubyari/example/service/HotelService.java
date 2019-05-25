package com.khoubyari.example.service;

import com.khoubyari.example.domain.Hotel;
import com.khoubyari.example.dao.jpa.HotelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class HotelService {

    private static final Logger log = LoggerFactory.getLogger(HotelService.class);

    @Autowired
    private HotelRepository hotelRepository;

    public HotelService() {
    }

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel getHotel(long id) {
        return hotelRepository.findById(id).get();
    }

    public void updateHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public void deleteHotel(Long id) {
        hotelRepository.delete(getHotel(id));
    }


    public Page<Hotel> getAllHotels(Integer page, Integer size) {

        Pageable pageable = PageRequest.of(page, size);
        Page pageOfHotels = hotelRepository.findAll(pageable);

        return pageOfHotels;
    }
}
