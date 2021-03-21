package com.insuranceproject.insurancesales.model;

import java.sql.Date;

public class AccidentListing {
    private int accident_id;
    private int client_id;
    private Date accident_date;
    private boolean at_fault;

    public AccidentListing(int accident_id, int client_id, Date accident_date, boolean at_fault) {
        this.accident_id = accident_id;
        this.client_id = client_id;
        this.accident_date = accident_date;
        this.at_fault = at_fault;
    }

    public int getAccident_id() {
        return accident_id;
    }

    public void setAccident_id(int accident_id) {
        this.accident_id = accident_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public Date getAccident_date() {
        return accident_date;
    }

    public void setAccident_date(Date accident_date) {
        this.accident_date = accident_date;
    }

    public boolean isAt_fault() {
        return at_fault;
    }

    public void setAt_fault(boolean at_fault) {
        this.at_fault = at_fault;
    }
}
