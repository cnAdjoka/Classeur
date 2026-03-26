package com.maintenanceAdjoka.app;
import com.maintenanceAdjoka.app.backend.models.Client;
import com.maintenanceAdjoka.app.backend.DatabaseManager;
import com.maintenanceAdjoka.app.backend.ClientDAO;
import java.util.Scanner;
import java.util.List;
// WORKFLOW

// Phase 1
// 1- Connect to the database
// 2- Run the shell
// 3- Shell Commands 
//   - Create client
//   - Delete client
//   - Edit client
//   - Get client info table
//

//Phase 2
//1- Allow field to input client total season price, Total amount left to pay
//2- Create methods that allow to update client remaining price to pay for the season
// smtn else ??
public class Main{
    public static void main(String[] args) {

  //Try database connection  
    try{
     DatabaseManager.init();
     // System.out.println("DB is connected!") ;
    }
    catch(Exception e){System.out.println("DB connection failed");}


//Shell loop

    String help = "Command not found \nAvailable Commands: \nnewcl ->      Creates a new client and saves the client information into the database \nlscl ->      lists all the clients and their informations \nexit ->      exits the shell \nfncl -> find a client by name";
    Scanner s = new Scanner(System.in);
    boolean runningShell = true; 
    while(runningShell){

      System.out.print("<Classeur-Maintenance-Adjoka> ");
      String input = s.nextLine();
      
      
      switch(input){
        case "newcl":
          
          System.out.print("\n<Classeur-Maintenance-Adjoka> ");
          System.out.println("Creating a new client...");

          System.out.print("\n<Classeur-Maintenance-Adjoka> ");
          System.out.print("Client Name:"); 
          String name = s.nextLine();  
         
          System.out.print("\n<Classeur-Maintenance-Adjoka> ");
          System.out.print("Client Phone Number: ");
          String phoneNumber = s.nextLine();

          System.out.print("\n<Classeur-Maintenance-Adjoka> ");
          System.out.print("Client Address: ");
          String address =  s.nextLine();

          System.out.print("\n<Classeur-Maintenance-Adjoka> ");
          System.out.print("Client Town: ");
          String town =  s.nextLine();


          System.out.print("\n<Classeur-Maintenance-Adjoka> ");
          System.out.print("Season price: ");
          String seasonPrice = s.nextLine();
          int price =  Integer.parseInt(seasonPrice);

          Client c = new Client(name, phoneNumber, town, address, price);


          System.out.print("\n<Classeur-Maintenance-Adjoka> ");
          try{ClientDAO.save(c);
          }
          catch(Exception e){
            System.out.println("Client has not been saved into the DB: " + e);
            break;
          }

          System.out.println("Client : "+  c.getName() +" has been saved to the databse");

          break;
        
        case "lscl":
          try{
            List<Client> clients = ClientDAO.findAll();

         for(Client cl : clients){

           System.out.println("////////////////////////////////////////////////");
           System.out.println("Client Name: "+ cl.getName());
           System.out.println("Client Phone Number: "+ cl.getPhoneNumber());
           System.out.println("Client Address: "+ cl.getAddress());
           System.out.println("Client Town: " + cl.getTown());
           System.out.println("Season price :" + cl.getSeasonPrice());
         }

          }catch(Exception e){
            System.out.println("Could not retrieve the client information:"+ e);
          }

         break;

        case "fncl":
         System.out.print("Looking up client with the name: ");
         String clientName = s.nextLine();

         try{List <Client> clients =  ClientDAO.getClientByName(clientName);

           if (clients.size() == 0){
             System.out.println("No client found with the name \""+ clientName +"\"");
             break;
        }

         for(Client cl : clients){

           System.out.println("////////////////////////////////////////////////");
           System.out.println("Client Name: "+ cl.getName());
           System.out.println("Client Phone Number: "+ cl.getPhoneNumber());
           System.out.println("Client Address: "+ cl.getAddress());
           System.out.println("Client Town: "+ cl.getTown());
           System.out.println("Season price :" + cl.printBalance());

         }break;
         }catch(Exception e){System.out.println("Error in the client search");}




          
        case ("exit"):
          runningShell = false;
          break;
          
        default:
          System.out.println(help);

      }

    }
        
    }
}


