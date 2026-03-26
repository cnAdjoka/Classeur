package com.maintenanceAdjoka.app.backend.models;
// TODO: Change the client structure to include more detailed fields about the address such as town, street name etc
public class Client{

  private String name;
  private String phoneNumber;
  private String address;
  private int seasonPrice;
  private int remainingDebt;

//Constructor for client with no specific information about the client
public Client (String name, String phoneNumber, String address, int seasonPrice){
  this.name = name;
  this.phoneNumber = phoneNumber;
  this.address = address;
  this.seasonPrice = seasonPrice;
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

public String printBalance(){

  if(this.seasonPrice != 0){
    int amountPayed = seasonPrice - remainingDebt;
    return ("Initial Amount : " + seasonPrice + "\nAmount Payed : " + amountPayed + "\nAmount Left to Pay :" + remainingDebt);
  }
  else{return "Client owes nothing";}
}

public void pay(int amountPayed){
  this.remainingDebt = remainingDebt - amountPayed;

}


}
