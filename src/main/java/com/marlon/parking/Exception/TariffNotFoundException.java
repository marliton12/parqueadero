package com.marlon.parking.Exception;

public class TariffNotFoundException extends RuntimeException {
    public TariffNotFoundException() {
      super("the tariff was not found");
    }
}
