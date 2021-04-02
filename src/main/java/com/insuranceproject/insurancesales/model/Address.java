package com.insuranceproject.insurancesales.model;

/**
 * A POJO that represents the address table.
 */
public class Address {

    private  int address_id;
    private String street_address;
    private String province;
    private String city;
    private String zip_code;


    public Address(int address_id, String street_address, String province, String city, String zip_code) {
        this.address_id = address_id;
        this.street_address = street_address;
        this.province = province;
        this.city = city;
        this.zip_code = zip_code;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }
}
