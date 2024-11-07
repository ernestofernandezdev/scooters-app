package org.arquitecturas.grupo17.microserviceaccountuser.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    public static final String _ADMIN = "admin";
    public static final String _USER = "user";
    public static final String _MAINTENANCE = "maintenance";

    @Id
    private String name;



}
