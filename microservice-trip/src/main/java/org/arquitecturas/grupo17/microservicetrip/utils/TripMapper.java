package org.arquitecturas.grupo17.microservicetrip.utils;

import org.arquitecturas.grupo17.microservicetrip.dto.TripDTO;
import org.arquitecturas.grupo17.microservicetrip.model.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripMapper {

    public TripDTO toDTO(Trip trip){
        if(trip == null){
            return null;
        }
        return new TripDTO(trip.getTripId(), trip.getScooterId(), trip.getDistance(), trip.getStart(), trip.getEnd());
    }

    public Trip toEntity(TripDTO tripDTO){
        if(tripDTO == null){
            return null;
        }
        return new Trip(tripDTO.getUserId(), tripDTO.getScooterId(), tripDTO.getDistance(), tripDTO.getStart(), tripDTO.getEnd());
    }

    public void updateEntityFromDTO(TripDTO tripDTO, Trip trip) {
        trip.setUserId(tripDTO.getUserId());
        trip.setScooterId(tripDTO.getScooterId());
        trip.setDistance(tripDTO.getDistance());
        if (tripDTO.getStart() != null) {
            trip.setStart(tripDTO.getStart());
        }
        if (tripDTO.getEnd() != null) {
            trip.setEnd(tripDTO.getEnd());
        }
    }
}
