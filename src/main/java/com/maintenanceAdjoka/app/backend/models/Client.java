package com.maintenanceAdjoka.app.backend.models;

public class Client{

  private String name;
  private String phoneNumber;
  private String address;


public Client (String name, String phoneNumber, String address){
  this.name = name;
  this.phoneNumber = phoneNumber;
  this.address = address;
}

public void setName(String newName){
  this.name = newName; 
}

public String getName(){
  return this.name;
}

public void setPhoneNumber(String newPhoneNumber){
  this.phoneNumber =  newPhoneNumber;

}

public String getPhoneNumber (){
  return this.phoneNumber;
}

public void setAddress(String newAddress){
  this.address = newAddress;
}

public String getAddress(){
  return this.address;
}
}
