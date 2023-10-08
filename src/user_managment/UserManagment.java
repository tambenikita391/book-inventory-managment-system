package user_managment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UserManagment
{
	static ArrayList<User> al = new ArrayList();
	
	static {
		try {
			LoadDataToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static Scanner r=new Scanner(System.in);

	public static void usermanagment()throws IOException
	{
		boolean b=true;
		while(b==true)
		{
			System.out.println("******WELCOME TO USER MANAGMENT******");
			System.out.println();
			
			System.out.println("What would you like to do:"+"\n");
			
			System.out.println("1.Add user");
			System.out.println("2.Search user");
			System.out.println("3.Edit user");
			System.out.println("4.Delete user");
			System.out.println("5.Quit");
			
			int option=r.nextInt();
			if(option==1)
			{
				Adduser();
			}
			else if(option==2)
			{
				System.out.println("Enter the name of user to search:");
				r.nextLine();
				String sn=r.nextLine();
				Searchuser(sn);
			}
			else if(option==3)
			{
				System.out.println("Enter the name of user to edit:");
				r.nextLine();
				String en=r.nextLine();
				Edituser(en);
			}
			else if(option==4)
			{
				System.out.println("Enter the name of user to delete:");
				r.nextLine();
				String dn=r.nextLine();
				Deleteuser(dn);
			}
			else if(option==5)
			{
				File f=new File("C:\\Users\\tambe\\eclipse-workspace\\InventoryManagment\\src\\UserManagment\\user.txt");
				FileWriter fw=new FileWriter(f,true);
				BufferedWriter bw=new BufferedWriter(fw);
				
				for(User u:al)
				{
					bw.write(u.username+" , "+u.login+" , "+u.password+" , "+u.password2+" , "+u.role+"\n");
				}
				bw.close();
				fw.close();
				f=null;
				
				System.out.println("PROGRAM FINISHED!!");
				b=false;
			}
			
		}
		

	}
	public static void Adduser()
	{
		Scanner r=new Scanner(System.in);
		User u=new User();
		
		System.out.println("Enter user name:");
		u.username=r.nextLine();
		
		System.out.println("Enter login name:");
		u.login=r.nextLine();
		
		System.out.println("Enter password:");
		u.password=r.nextLine();
		
		System.out.println("Enter confirm password:");
		u.password2=r.nextLine();
		
		System.out.println("Enter user role:");
		u.role=r.nextLine();
		
		al.add(u);
		
	}
	
	public static void Searchuser(String name)
	{
		for(User u:al)
		{
			if(u.username.equalsIgnoreCase(name))
			{
				System.out.println("User name is: "+u.username);
				System.out.println("Login name is: "+u.login);
				System.out.println("Password is: "+u.password);
				System.out.println("Confirm password is: "+u.password2);
				System.out.println("User role is: "+u.role);
				return;
			}
		}
		System.out.println("User not found");
	}
	
	public static void Deleteuser(String name)
	{
		Iterator <User> itr = al.iterator();
		while(itr.hasNext())
		{
			User u = itr.next();
			if(u.username.equalsIgnoreCase(name))
			{
				itr.remove();
				System.out.println(u.username+ " is removed");
				return;
			}
		}
		System.out.println("User not found!!");
	}
	
	public static void Edituser(String name)
	{
		for(User u : al)
		{
			if(u.username.equalsIgnoreCase(name))
			{
				System.out.println("New username:");
				u.username=r.nextLine();
				
				System.out.println("New login name:");
				u.login=r.nextLine();
				
				System.out.println("New password:");
				u.password=r.nextLine();
				
				System.out.println("new confirm password:");
				u.password2=r.nextLine();
				
				System.out.println("New user role:");
				u.role=r.nextLine();
				return;
			}
		}
		System.out.println("User not found!!");
	}
	
	public static void LoadDataToFile() throws IOException
	{
		File f=new File("C:\\Users\\tambe\\eclipse-workspace\\InventoryManagment\\src\\UserManagment\\user.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		
		String line=" ";
		while((line=br.readLine())!=null)
		{
			User u=new User();
			String [] arr=line.split(",");
			
			if(arr.length>4)
			{
				u.username=arr[0];
				u.login=arr[1];
				u.password=arr[2];
				u.password2=arr[3];
				u.role=arr[4];
				al.add(u);
			}
		}
		br.close();
		fr.close();
		f=null;	
	}
	
	public static boolean ValidateLogin(String loginName,String password)
	{
		Iterator <User> itr= al.iterator();
		while(itr.hasNext())
		{
			User u=itr.next();
			if(u.login.equalsIgnoreCase(loginName) && u.password.equalsIgnoreCase(password))
			{
				return true;
			}
		}
		return false;
	}
}


