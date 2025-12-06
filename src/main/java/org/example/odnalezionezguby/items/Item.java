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
    private String itemColor;
    private String additionalInfo;
    //@TODO Set as DAY-MONTH-YEAR
    private Date foundDate;
    private String location;
    private String foundPlace;
    //TODO Consider requirement DAY-MONTH-YEAR
    private Date notificationDate;
    private String warehousePlace;
}
