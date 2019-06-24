package com.example.library.domain;

import java.math.BigDecimal;
import java.util.List;

public interface BookInterface {

    String getTitle();

    List<String> getAuthors();

    String getIsbn();

    String getPublishingHouse();

    String getPlaceOfDeploy();

    BigDecimal getPrice();

    Boolean getIsAvailable();

}
