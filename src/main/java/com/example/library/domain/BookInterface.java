package com.example.library.domain;

import java.math.BigDecimal;
import java.util.List;

public interface BookInterface {

    String getTitle();

    List<String> getAuthors();

    String getISBN();

    String getPublishingHouse();

    String getPlaceOfDeploy();

    BigDecimal getPrice();

}
