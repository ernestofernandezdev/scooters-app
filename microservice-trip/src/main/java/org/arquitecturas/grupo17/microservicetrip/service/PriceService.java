package org.arquitecturas.grupo17.microservicetrip.service;

import org.arquitecturas.grupo17.microservicetrip.dto.PriceDTO;
import org.arquitecturas.grupo17.microservicetrip.model.Price;
import org.arquitecturas.grupo17.microservicetrip.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class PriceService {
    private PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public void save(PriceDTO priceDto) {
        Price price = new Price(priceDto.getSince(), priceDto.getPrice(), priceDto.getPenaltyPrice());
        priceRepository.save(price);
    }

    public int find(int scooterId) {
        Price price = this.priceRepository.findActualPrice(Timestamp.valueOf(LocalDateTime.now()));
        return price.getPrice();
    }

    public void updatePenaltyPrice(long idPrice, int newPenaltyPrice) {
        Price price = priceRepository.findById(idPrice)
                .orElseThrow(() -> new RuntimeException("Price not found with id " + idPrice));

        price.setPenaltyPrice(newPenaltyPrice);
        priceRepository.save(price);
    }
}
