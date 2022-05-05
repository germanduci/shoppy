package com.ar.shoppy.enums;

public enum orderStatus {

    STANDBY("Sin tratar"),INPROCESS("En proceso"),FINISHED("Terminado");

    private String status;

    private orderStatus(String orderStatus) {this.status = orderStatus;}

    public String getValue() {return status;}
}

