package login;

import java.io.IOException;
import java.util.Scanner;

import inventory_managment.InventoryManagSystem;
import user_managment.UserManagment;

public class MainApplication 
{
	public static void main(String [] args) throws IOException
	{
		//System.out.println("****BOOKSHOP****");
		System.out.println("******WELCOME TO LOGIN******");
		System.out.println();
		
		Scanner r=new Scanner(System.in);
		boolean CanIKeepRunning=true;
		
		System.out.println("Enter login name:");
		String login=r.nextLine();
		
		System.out.println("Enter password:");
		String password=r.nextLine();
		
		if(!UserManagment.ValidateLogin(login,password))
		{
			System.out.println("###LOGIN FALILED!!YOU CANNOT PROCEED...");
			return;
		}
		while(CanIKeepRunning==true)
		{
			System.out.println("*****WELCOME TO BOOKSHOP*****");
			System.out.println();
			System.out.println("What would you like to do:");
			System.out.println("1.user managment");
			System.out.println("2.inventory managment");
			System.out.println("3.Quit");
			
			int option=r.nextInt();
			
			if(option==1)
			{
				UserManagment.usermanagment();
			}
			else if(option==2)
			{
				InventoryManagSystem.inventorymanagment();
			}
			else if(option==3)
			{
				
				CanIKeepRunning=false;
				break;
			}
			
			
			
		}
		r.close();
		
	}

}
