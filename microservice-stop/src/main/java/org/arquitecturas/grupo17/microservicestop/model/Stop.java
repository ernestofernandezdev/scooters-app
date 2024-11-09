package org.arquitecturas.grupo17.microservicestop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("stop")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stop {
    @Id
    Long id;
    Integer x;
    Integer y;
}
