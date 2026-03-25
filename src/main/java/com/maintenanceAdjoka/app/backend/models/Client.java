package com.maintenanceAdjoka.app.backend.models;

public class Client{

  private String name;
  private String phoneNumber;
  private String address;
  private int seasonPrice;
  private int remainingDebt;

public Client (String name, String phoneNumber, String address){
  this.name = name;
  this.phoneNumber = phoneNumber;
  this.address = address;
  this.seasonPrice = 0;
  this.remainingDebt = seasonPrice;
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

public void setSeasonPrice(int amount){
  this.seasonPrice =  amount;
}

public int getSeasonPrice(){
  return this.seasonPrice;
}

public void printBalance(){
  int amountPayed = seasonPrice - remainingDebt;

  if(this.seasonPrice != 0){

    System.out.println("Initial Amount : " + seasonPrice);
    System.out.println("Amount Payed : " + amountPayed);
    System.out.println("Amount Left to Pay :" + remainingDebt);
  }

  else{System.out.println("Client owes nothing");}
}

public void pay(int amountPayed){
  this.remainingDebt = remainingDebt - amountPayed;

}


}
