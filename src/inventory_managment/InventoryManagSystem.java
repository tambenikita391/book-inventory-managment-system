package inventory_managment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class InventoryManagSystem
{
	static ArrayList<BookStore> al = new ArrayList();
	static Scanner r=new Scanner(System.in);
	static
	{
		try {
			LoadBookDetailsToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void inventorymanagment() throws IOException
	{
		boolean bl = true;
		while(bl==true)
		{
			System.out.println("******WELCOME TO INVENTORY MANAGMENT SYSTEM******");
			System.out.println();
			System.out.println("What would you like to do:"+"\n");
			System.out.println("1.Add book");
			System.out.println("2.Search book");
			System.out.println("3.Edit book");
			System.out.println("4.Delete book");
			System.out.println("5.Quit");
			
			int option=r.nextInt();
			if(option==1)
			{
				Addbookstore();
			}
			else if(option==2)
			{
				System.out.println("Enter the book title to search:");
				r.nextLine();
				String sb=r.nextLine();
				Searchbook(sb);
			}
			else if(option==3)
			{
				System.out.println("Enter the book title to edit:");
				r.nextLine();
				String eb=r.nextLine();
				Editbook(eb);
			}
			else if(option==4)
			{
				System.out.println("Enter the book title to delete:");
				r.nextLine();
				String db=r.nextLine();
				Deletebook(db);
			}
			else if(option==5)
			{
				File f=new File("C:\\Users\\tambe\\eclipse-workspace\\InventoryManagment\\src\\InventoryMGMT\\book.txt");
				FileWriter fw=new FileWriter(f,true);
				BufferedWriter bw=new BufferedWriter(fw);
				
				for(BookStore b : al)
				{
					bw.write(b.name+","+b.author+","+b.status+","+b.quantity+","+b.price+"\n");
				}
				
				bw.close();
				fw.close();
				f=null;
				
				System.out.println("\n");
				System.out.println("PROGRAM FINISHED!!");
				bl=false;
			}
		}
		
	}
	public static void Addbookstore()
	{
		Scanner r=new Scanner(System.in);
		BookStore b = new BookStore();
		
		System.out.println("Enter book name:");
		b.name=r.nextLine();
	
		System.out.println("Enter book author:");
		b.author=r.nextLine();
		
		System.out.println("Enter book quantity:");
		b.quantity=r.nextLine();
		
		System.out.println("Enter book status:");
		b.status=r.nextLine();
		
		System.out.println("Enter book price:");
		b.price=r.nextLine();
		
		al.add(b);
		
	}
	
	public static void Searchbook(String name)
	{
		for(BookStore b : al)
		{
			if(b.name.equalsIgnoreCase(name))
			{
				System.out.println("Book title: "+b.name);
				System.out.println("Book author: "+b.author);
				System.out.println("Book quantity: "+b.quantity);
				System.out.println("Book status: "+b.status);
				System.out.println("Book price: "+b.price);
				return;
			}
		}
		System.out.println("Book cannot tracked!!!");
	}

	public static void Deletebook(String name)
	{
		Iterator<BookStore> itr = al.iterator();
		while(itr.hasNext())
		{
			BookStore b=itr.next();
			if(b.name.equalsIgnoreCase(name))
			{
				itr.remove();
				System.out.println(b.name+" is removed");
			}
		}
		System.out.println("Book cannot tracked!!!");
	}
	
	public static void Editbook(String name)
	{
		for(BookStore b : al)
		{
			if(b.name.equalsIgnoreCase(name))
			{
				System.out.println("Enter new book name:");
				b.name=r.nextLine();
				
				
				System.out.println("Enter new book author:");
				b.author=r.nextLine();
				
				System.out.println("Enter new book quantity:");
				b.quantity=r.nextLine();
				
				System.out.println("Enter new book status:");
				b.status=r.nextLine();
				
				System.out.println("Enter new book price:");
				b.price=r.nextLine();
				return;
			}
		}
		System.out.println("Book cannot tracked!!!");
	}
	
	public static void LoadBookDetailsToFile()throws IOException
	{
		File f=new File("C:\\Users\\tambe\\eclipse-workspace\\InventoryManagment\\src\\InventoryMGMT\\book.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		
		String line=" ";
		while((line=br.readLine())!=null)
		{
			BookStore bs=new BookStore();
			String [] arr = line.split(",");
			
			if(arr.length>4)
			{
				bs.name=arr[0];
				bs.author=arr[1];
				bs.quantity=arr[2];
				bs.status=arr[3];
				bs.price=arr[4];
			}
		}
		br.close();
		fr.close();
		f=null;	
	}
	
}
