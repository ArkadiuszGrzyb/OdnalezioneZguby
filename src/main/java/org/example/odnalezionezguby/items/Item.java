package org.example.odnalezionezguby.items;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    //@TODO Consider if it is really needed
    private String hiddenDescription;

    //@TODO Set as DAY-MONTH-YEAR
    private Date dateFound;

    //TODO Consider requirement DAY-MONTH-YEAR
    private Date dateStored;
}
