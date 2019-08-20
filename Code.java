import java.util.*; 
import java.lang.*; 
import java.math.BigInteger;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*; 

import javax.swing.*;


interface user{
	ArrayList<item> items = new ArrayList<item>();
	HashSet<String> items_category = new HashSet<String>();
	

	int id();
	String name();
	
}

class merchant implements user{
	private int id;
	private String name;
	
	public merchant(int id , String name){
		this.id = id;
		this.name = name;
	}
	
	public int id() {return id;}
	public String name() {return name;}
}

class customer implements user{

	private int id;
	private String name;
	
	public customer(int id , String name){
		this.id = id;
		this.name = name;
	}
	
	public int id() {return id;}
	public String name() {return name;}
	
}

class item{
	int id;
	String name;
	double price;
	int quantity;
	String category;
	String merchant;
	String offer = "None";
	
	public item(String name,double price,int quantity,String category){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}


}


class lab2
{ 
	
	private static Object deepCopy(Object object){
		try{
		ByteArrayOutputStream outputStream= new ByteArrayOutputStream();
		ObjectOutputStream outputStrm = new ObjectOutputStream(outputStream);
		outputStrm.writeObject(object);
		ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
		return objInputStream.readObject();
		}
		catch (Exception e){
			e.printStackTrace();return null;
		}
	}
	
	
	
	
	public static double company_balance = 0;
	
    @SuppressWarnings("static-access")
	public static void main (String[] args) 
    { 
    	
    	Scanner in = new Scanner(System.in);
    	ArrayList<user> merchants = new ArrayList<user>();
    	ArrayList<user> customers = new ArrayList<user>();
    	ArrayList<item> all_items = new ArrayList<item>();
    	HashSet<String> categories = new HashSet<String>(); 

    	

    	
    	//Defining merchants
	    	user Raju = new merchant(1,"Raju");
	    	user Pinki = new merchant(2,"Pinki");
	    	user Ramesh = new merchant(3,"Ramesh");
	    	user Phoolmati = new merchant(4,"Phoolmati");
	    	user Chutki = new merchant(5,"Chutki");
	    	merchants.add(Raju);
	    	merchants.add(Pinki);
	    	merchants.add(Ramesh);
	    	merchants.add(Phoolmati);
	    	merchants.add(Chutki);
	    	double[] merchants_contribution = new double[merchants.size()];
	    	int[] items_sold = new int[merchants.size()];


	    
	    //Defining customers
	    	user Sanjay = new customer(1,"Sanjay");
	    	user Sheela = new customer(2,"Sheela");
	    	user Munni = new customer(3,"Munni");
	    	user Rambabu = new customer(4,"Rambabu");
	    	user Sukhdev = new customer(5,"Sukhdev");
	    	customers.add(Sanjay);
	    	customers.add(Sheela);
	    	customers.add(Munni);
	    	customers.add(Rambabu);
	    	customers.add(Sukhdev);
	    	double[] customers_contribution = new double[customers.size()];
	    	int[] items_bought = new int[customers.size()];
	    	double[] customer_acc = {100,100,100,100,100};
	    	double[] customers_reward = new double[customers.size()];

	    	
	    	
	    	
	    //Making intro menue	
	    System.out.println("Welcome to Mercury");
	    System.out.println("1) Enter as Merchant");
	    System.out.println("2) Enter as Customer");
	    System.out.println("3) See user details");
	    System.out.println("4) Company account balance");
	    System.out.println("5) Exit");
	    
	    int query_menue = in.nextInt();
	    while(query_menue != 5){
	    	
	    	//Making merchant menue
	    	if(query_menue == 1){
	    		System.out.println("Choose merchant");
	    		System.out.println("1) Raju");
	    		System.out.println("2) Pinki");
	    		System.out.println("3) Ramesh");
	    		System.out.println("4) Phoolmati");
	    		System.out.println("5) Chutki");
	    		
//	    		user curr_merchant = new merchant(0,"");
	    		
	    		int which_merchant = in.nextInt();
	    		
//	    		curr_merchant = (user) deepCopy(merchants.get(which_merchant-1));

	    		
	    		System.out.println("Welcome "+merchants.get(which_merchant-1).name());
	    		System.out.println("Merchant Menue");
	    	    System.out.println("1) Add item");
	    	    System.out.println("2) Edit item");
	    	    System.out.println("3) Search by category");
	    	    System.out.println("4) Add offer");
	    	    System.out.println("5) Rewards won");
	    	    System.out.println("6) Exit");
	    	    
	    	    int merchant_query = in.nextInt();
	    	    while(merchant_query != 6){
	    	    	
	    	    	//add item
	    	    	if(merchant_query == 1){
	    	    		if(merchants.get(which_merchant-1).items_category.size() >= 10 + merchants_contribution[which_merchant-1]/100)
	    	    		{
	    	    			System.out.println("Cannot add more items");
	    	    		}else{
		    	    		System.out.println("Enter Item Details");
		    	    		System.out.println("Item name");
		    	    		String name = in.next();
		    	    		System.out.println("Item Price");
		    	    		double price = in.nextDouble();
		    	    		System.out.println("Item Quantity");
		    	    		int quantity = in.nextInt();
		    	    		System.out.println("Item Category");
		    	    		String category = in.next();
		    	    		
		    	    		item temp = new item(name,price,quantity,category);
		    	    		temp.id =merchants.get(which_merchant-1).items.size() + 1;
		    	    		temp.merchant = merchants.get(which_merchant-1).name();
		    	    		merchants.get(which_merchant-1).items.add(temp);
		    	    		all_items.add(temp);
		    	    		categories.add(temp.category);
		    	    		merchants.get(which_merchant-1).items_category.add(temp.category);
		    	    		ArrayList<item> itm = merchants.get(which_merchant-1).items;
		    	    		int index = merchants.get(which_merchant-1).items.size()-1;
		    	    		System.out.println(itm.get(index).id + " " +itm.get(index).name + " " +itm.get(index).price + " " + itm.get(index).quantity + " " + itm.get(index).offer + " " + itm.get(index).category );
			    	    	
//		    	    		merchants.set(which_merchant-1, curr_merchant);

	    	    		}

	    	    	}
	    	    	
	    	    	
	    	    	//edit item
	    	    	else if(merchant_query == 2){
	    	    		//changing item in merchant's item list
	    	    		ArrayList<item> itm = merchants.get(which_merchant-1).items;
	    	    		System.out.println("Choose item by code");
	    	    		for(int i = 0;i<itm.size();i++){
		    	    		System.out.println(itm.get(i).id + " " +itm.get(i).name + " " +  " " + itm.get(i).price + " " + itm.get(i).quantity + " " + itm.get(i).offer + " " + itm.get(i).category );
	    	    		}
	    	    		int which_item = in.nextInt();
	    	    		System.out.println("Enter edit details");
	    	    		System.out.println("Item price");
	    	    		itm.get(which_item - 1).price = in.nextDouble();
	    	    		System.out.println("Item quantity");
	    	    		itm.get(which_item - 1).quantity = in.nextInt();
	    	    		merchants.get(which_merchant-1).items.set(which_item-1,itm.get(which_item-1));
	    	    		
	    	    		int index = which_item - 1;
	    	    		System.out.println(itm.get(index).id + " " +itm.get(index).name + " " +itm.get(index).price + " " + itm.get(index).quantity + " " + itm.get(index).offer + " " + itm.get(index).category );
	    	    		
	    	    		
	    	    		//changing item in all_items
	    	    		for(int i = 0;i<all_items.size();i++){
	    	    			if(all_items.get(i).merchant.equals(merchants.get(which_merchant).name()) && all_items.get(i).name.equals(merchants.get(which_merchant).items.get(which_item).name) ){
	    	    				all_items.set(i, merchants.get(which_merchant).items.get(which_item));
	    	    			}
	    	    		}
	    	    		
	    	    	}
	    	    	
	    	    	//search by category
	    	    	else if(merchant_query == 3){
	    	    		System.out.println("Choose a category");
	    	            Iterator<String> i=categories.iterator();
	    	            String[] category = new String[categories.size()];
	    	            int count = 0;
	    	            while(i.hasNext()){
	    	            	String cat = i.next();
	    	            	category[count] = cat;
	    	            	count++;
	    	    			System.out.println(count + ") " + cat);
	    	    		}
	    	            
	    	            int category_index = in.nextInt();
	    	            int index = 0;
	    	    		for(int j = 0;j<all_items.size();j++){
	    	    			if(all_items.get(j).category.equals(category[category_index-1])){
	    	    				index++;
	    	    				System.out.println(index + ") " + all_items.get(j).name + " " + all_items.get(j).price + " " + all_items.get(j).quantity + " " + all_items.get(j).offer + " " + all_items.get(j).category);
	    	    			}
	    	    		}
	    	    	}
	    	    	
	    	    	//add offer
	    	    	else if(merchant_query == 4){
	    	    		ArrayList<item> itm = merchants.get(which_merchant-1).items;
	    	    		System.out.println("Choose item by code");
	    	    		for(int i = 0;i<itm.size();i++){
		    	    		System.out.println(itm.get(i).id + ") " +itm.get(i).name + " " +  " " + itm.get(i).price + " " + itm.get(i).quantity + " " + itm.get(i).offer + " " + itm.get(i).category );
	    	    		}
	    	    		int item_index = in.nextInt();
	    	    		System.out.println("Choose offer");
	    	    		System.out.println("1) Buy One Get One Free");
	    	    		System.out.println("2) 25% off");
	    	    		
	    	    		int offer_index = in.nextInt();
	    	    		
	    	    		if(offer_index == 1){itm.get(item_index-1).offer = "Buy One Get One Free";}else{itm.get(item_index-1).offer = "25% off";}
	    	    		int index = item_index - 1;
	    	    		System.out.println(itm.get(index).id + ") " +itm.get(index).name + " " +itm.get(index).price + " " + itm.get(index).quantity + " " + itm.get(index).offer + " " + itm.get(index).category );	    	    	}
	    	    	
	    	    	//rewards won
	    	    	else if(merchant_query == 5){
	    	    		System.out.println("Slots rewarded = " + (int) merchants_contribution[which_merchant-1]/100);
	    	    	}	
	    	    	
	    	    	
	    	    	
	    	    	
		    		System.out.println("Welcome "+merchants.get(which_merchant-1).name());
	    	    	System.out.println("Merchant Menue");
		    	    System.out.println("1) Add item");
		    	    System.out.println("2) Edit item");
		    	    System.out.println("3) Search by category");
		    	    System.out.println("4) Add offer");
		    	    System.out.println("5) Rewards won");
		    	    System.out.println("6) Exit");
		    	    merchant_query = in.nextInt();
	    	    }
	    	    
	    	    
	    		
	    	}
	    	
	    	//making customer menue
	    	else if(query_menue == 2){
	    		System.out.println("Choose customer");
	    		System.out.println("1) Sanjay");
	    		System.out.println("2) Sheela");
	    		System.out.println("3) Munni");
	    		System.out.println("4) Rambabu");
	    		System.out.println("5) Sukhdev");
	    		
	    		int which_customer = in.nextInt();
//	    		user curr_customer = new customer(0, "");
	    		
//	    		curr_customer = (user) deepCopy(customers.get(which_customer-1));
//	    		curr_customer = customers.get(which_customer-1);
	    		
	    		System.out.println("Welcome " + customers.get(which_customer-1).name());
	    		System.out.println("Customer menue");
	    		System.out.println("1) Search item");
	    		System.out.println("2) Checkout cart");
	    		System.out.println("3) Reword won");
	    		System.out.println("4) Print latest orders");
	    		System.out.println("5) Exit");

	    		int customer_query = in.nextInt();
	    		
	    		ArrayList<item> cart = new ArrayList<item>();
	    		while(customer_query!= 5){
	    			
	    			//Search item
	    			if(customer_query == 1 ){
	    				System.out.println("Choose a category");
	    				Iterator<String> i=categories.iterator();
	    				String[] category = new String[categories.size()];
	    				int count = 0;
	    				while(i.hasNext()){
	    					String cat = i.next();
		    	          	category[count] = cat;
		    	           	count++;
		    	   			System.out.println(count + ") " + cat);
		    	   		}
		    	        
		    	        int category_index = in.nextInt();
		    	        System.out.println("Choose item by code");
		    	        int[] index_arr = new int[all_items.size()];
		    	        count = 0;
		    	        for(int j = 0;j<all_items.size();j++){
		    	        	if(all_items.get(j).category.equals(category[category_index-1])){
			    	        	System.out.println((count+1)+ ") " + all_items.get(j).name + " " + all_items.get(j).price + " " + all_items.get(j).quantity + " " + all_items.get(j).offer + " " + all_items.get(j).category);
			    	        	index_arr[count] =j; 
			    	        	count++;
		    	        	}
		    	        }
		    	        
		    	        System.out.println("Enter item code");
		    	        int item_code = in.nextInt();
		    	        System.out.println("Enter item quantity");
		    	        int item_quantity = in.nextInt();
		    	        
		    	        System.out.println("Choose meathod of transcation");
		    	        System.out.println("1) Buy item");
		    	        System.out.println("2) Add item to cart");
		    	        System.out.println("3) Exit");
		    	        
		    	        item_code = index_arr[item_code-1] + 1;
		    	        int buying_query = in.nextInt();
		    	        
		    	        
		    	        
		    	        
		    	        //buying the item and updating quantities and accounts
		    	        if(buying_query == 1){
		    	        	
		    	        	String offer = all_items.get(item_code-1).offer;
		    	        	
		    	        	System.out.println("Account - " + customer_acc[which_customer-1]);
		    	        	
		    	        	
		    	        	if(all_items.get(item_code-1).quantity >= item_quantity && (customer_acc[which_customer-1] + customers_reward[which_customer-1]) >= item_quantity * all_items.get(item_code-1).price )
		    	        	{
		    	        		
		    	        		
		    	        		if(offer.equals("Buy One Get One Free") && all_items.get(item_code-1).quantity >= 2*item_quantity && customer_acc[which_customer-1] + customers_reward[which_customer-1] >= 2 * item_quantity * all_items.get(item_code-1).price)
		    	        		{
		    	        			
		    	        			customer_acc[which_customer-1] -= item_quantity * all_items.get(item_code-1).price*(1.005) ;
		    	        			if(customer_acc[which_customer-1]<0){
		    	        				customers_reward[which_customer-1] += customer_acc[which_customer-1];
		    	        				customer_acc[which_customer-1]= 0;
		    	        			}
		    	        			
		    	        			item updated_item = all_items.get(item_code-1);
			    	        		updated_item.quantity -=2*item_quantity;
			    	        		all_items.set(item_code-1,updated_item);
			    	        		
			    	        		customers.get(which_customer-1).items.add(updated_item);
			    	        		for(int j = 0;j<merchants.size();j++){
			    	        			if(merchants.get(j).name().equals(updated_item.merchant)){

			    	        				merchants_contribution[j] += (item_quantity) * all_items.get(item_code-1).price * (0.005);
			    	        				items_sold[j]++;
			    	        				company_balance+=(item_quantity) * all_items.get(item_code-1).price * (0.005);

			    	        			}
			    	        		}
			    	        		
			    	        		customers_contribution[which_customer-1] += (item_quantity) * all_items.get(item_code-1).price * (0.005);
			    	        		items_bought[which_customer-1]++;
			    	        		company_balance +=(item_quantity) * all_items.get(item_code-1).price * (0.005);
			    	        		if(items_bought[which_customer-1]%5 == 0){
			    	        			customers_reward[which_customer-1] += 10;
			    	        		}
			    	        		
			    	        		System.out.println("Item successfully bought");
			    	        	}
		    	        	
		    	        		else if(offer.equals("25% off") && customer_acc[which_customer-1] + customers_reward[which_customer-1] >= item_quantity * all_items.get(item_code-1).price * (0.75) )
		    	        		{
		    	        			customer_acc[which_customer-1] -=item_quantity * all_items.get(item_code-1).price*(1.005)*(0.75);
		    	        			if(customer_acc[which_customer-1]<0){
		    	        				customers_reward[which_customer-1] += customer_acc[which_customer-1];
		    	        				customer_acc[which_customer-1] = 0;
		    	        			}
		    	        			item updated_item = all_items.get(item_code-1);
			    	        		updated_item.quantity -=item_quantity;
			    	        		all_items.set(item_code-1,updated_item);
			    	        		
			    	        		customers.get(which_customer-1).items.add(updated_item);
			    	        		for(int j = 0;j<merchants.size();j++){
			    	        			if(merchants.get(j).name().equals(updated_item.merchant)){

			    	        				merchants_contribution[j] += item_quantity * all_items.get(item_code-1).price * (0.005) *(0.75);
			    	        				items_sold[j]++;
			    	        				company_balance+=(item_quantity) * all_items.get(item_code-1).price * (0.005);

			    	        			}
			    	        		}
			    	        		customers_contribution[which_customer-1] += item_quantity * all_items.get(item_code-1).price * (0.005);
			    	        		items_bought[which_customer-1]++;
	    	        				company_balance+=(item_quantity) * all_items.get(item_code-1).price * (0.005);

			    	        		if(items_bought[which_customer-1]%5 == 0){
			    	        			customers_reward[which_customer-1] += 10;
			    	        		}
			    	        		
			    	        		System.out.println("Item successfully bought");


		    	        		}else if(offer.equals("None")){
		    	        			customer_acc[which_customer-1] -=item_quantity * all_items.get(item_code-1).price*(1.005);
		    	        			if(customer_acc[which_customer-1]<0){
		    	        				customers_reward[which_customer-1] += customer_acc[which_customer-1];
		    	        				customer_acc[which_customer-1] = 0;
		    	        			}
		    	        			item updated_item = all_items.get(item_code-1);
			    	        		updated_item.quantity -=item_quantity;
			    	        		all_items.set(item_code-1,updated_item);
			    	        		
			    	        		customers.get(which_customer-1).items.add(updated_item);
			    	        		for(int j = 0;j<merchants.size();j++){
			    	        			if(merchants.get(j).name().equals(updated_item.merchant)){

			    	        				merchants_contribution[j] += item_quantity * all_items.get(item_code-1).price * (0.005);
			    	        				items_sold[j]++;
			    	        				company_balance+=(item_quantity) * all_items.get(item_code-1).price * (0.005);

			    	        			}
			    	        		}
			    	        		customers_contribution[which_customer-1] += item_quantity * all_items.get(item_code-1).price * (0.005);
			    	        		items_bought[which_customer-1]++;
	    	        				company_balance += item_quantity * all_items.get(item_code-1).price * (0.005);

			    	        		if(items_bought[which_customer-1]%5 == 0){
			    	        			customers_reward[which_customer-1] += 10;
			    	        		}
			    	        		
			    	        		System.out.println("Item successfully bought");

		    	        		}else{
			    	        		System.out.println("Unable to process transcation");

		    	        		}
		    	        	}else{
		    	        		System.out.println("Unable to process transcation");
		    	        	}
		    	        }
		    	        
		    	        //adding to cart
		    	        else if(buying_query == 2){
		    	        	
		    	        	String offer = all_items.get(item_code-1).offer;
		    	        	if(all_items.get(item_code-1).quantity >= item_quantity && customer_acc[which_customer-1] + customers_reward[which_customer-1] >= item_quantity * all_items.get(item_code-1).price )
		    	        	{
		    	        		if(offer.equals("Buy One Get One Free") && all_items.get(item_code-1).quantity >= 2*item_quantity && customer_acc[which_customer-1] + customers_reward[which_customer-1] >= 2 * item_quantity * all_items.get(item_code-1).price)
		    	        		{
		    	        			
		    	        			item temp = new item(all_items.get(item_code-1).name,all_items.get(item_code-1).price,all_items.get(item_code-1).quantity,all_items.get(item_code-1).category);
		    	        			temp.quantity = item_quantity;
		    	        			cart.add(temp);
			    	        		System.out.println("Item successfully added to cart");
			    	        	}
		    	        		else if(offer.equals("25% off") && customer_acc[which_customer-1] + customers_reward[which_customer-1] >= item_quantity * all_items.get(item_code-1).price * (0.75) )
		    	        		{
//		    	        			item temp = all_items.get(item_code-1);
		    	        			item temp = new item(all_items.get(item_code-1).name,all_items.get(item_code-1).price,all_items.get(item_code-1).quantity,all_items.get(item_code-1).category);
		    	        			temp.quantity = item_quantity;
		    	        			cart.add(temp);			    	        		
		    	        			System.out.println("Item successfully added to cart");
		    	        		}else if(offer.equals("None")){
		    	        			item temp = new item(all_items.get(item_code-1).name,all_items.get(item_code-1).price,all_items.get(item_code-1).quantity,all_items.get(item_code-1).category);
		    	        			temp.quantity = item_quantity;
		    	        			cart.add(temp);			    	        		
		    	        			System.out.println("Item successfully added to cart");
		    	        		}else{
			    	        		System.out.println("Unable to add to cart");
		    	        		}
		    	        	}else{
		    	        		System.out.println("Unable to add to cart");
		    	        	}
		    	        }
		    	        
		    	        
	    				
	    	
	    			}
	    			//checkout cart
	    			else if(customer_query == 2){
	    				while(cart.size()>0){
	    					item itm = cart.get(cart.size()-1);
	    					int item_quantity = itm.quantity;
	    					int item_code = 1;
	    					for(int j = 0;j<all_items.size();j++){
	    						if(all_items.get(j).name.equals(itm.name) && all_items.get(j).merchant.equals(itm.merchant) && all_items.get(j).category.equals(itm.category)){
	    							item_code+= j;
	    						}
	    					}
	    					
	    					String offer = all_items.get(item_code-1).offer;
		    	        	
		    	        	if(all_items.get(item_code-1).quantity >= item_quantity && customer_acc[which_customer-1] + customers_reward[which_customer-1] >= item_quantity * all_items.get(item_code-1).price )
		    	        	{
		    	        		
		    	        		if(offer.equals("Buy One Get One Free") && all_items.get(item_code-1).quantity >= 2*item_quantity && customer_acc[which_customer-1] + customers_reward[which_customer-1] >= 2 * item_quantity * all_items.get(item_code-1).price)
		    	        		{
		    	        			customer_acc[which_customer-1] -= item_quantity * all_items.get(item_code-1).price*(1.005) ;
		    	        			if(customer_acc[which_customer-1]<0){
		    	        				customers_reward[which_customer-1] += customer_acc[which_customer-1];
		    	        				customer_acc[which_customer-1] = 0;
		    	        			}
		    	        			
		    	        			item updated_item = all_items.get(item_code-1);
			    	        		updated_item.quantity -=2*item_quantity;
			    	        		all_items.set(item_code-1,updated_item);
			    	        		
			    	        		customers.get(which_customer-1).items.add(updated_item);
			    	        		for(int j = 0;j<merchants.size();j++){
			    	        			if(merchants.get(j).name().equals(updated_item.merchant)){
			    	        				merchants_contribution[j] += (item_quantity) * all_items.get(item_code-1).price * (0.005);
			    	        				items_sold[j]++;
			    	        				company_balance+=(item_quantity) * all_items.get(item_code-1).price * (0.005);

			    	        			}
			    	        		}
			    	        		customers_contribution[which_customer-1] += (item_quantity) * all_items.get(item_code-1).price * (0.005);
			    	        		
			    	        		items_bought[which_customer-1]++;
			    	        		company_balance +=(item_quantity) * all_items.get(item_code-1).price * (0.005);
			    	        		if(items_bought[which_customer-1]%5 == 0){
			    	        			customers_reward[which_customer-1] += 10;
			    	        		}
			    	        		
			    	        		System.out.println(itm.name + " "+ "successfully bought");
			    	        	}
		    	        	
		    	        		else if(offer.equals("25% off") && customer_acc[which_customer-1] + customers_reward[which_customer-1] >= item_quantity * all_items.get(item_code-1).price * (0.75) )
		    	        		{
		    	        			customer_acc[which_customer-1] -=item_quantity * all_items.get(item_code-1).price*(1.005)*(0.75);
		    	        			if(customer_acc[which_customer-1]<0){
		    	        				customers_reward[which_customer-1] += customer_acc[which_customer-1];
		    	        				customer_acc[which_customer-1] = 0;
		    	        			}
		    	        			item updated_item = all_items.get(item_code-1);
			    	        		updated_item.quantity -=item_quantity;
			    	        		all_items.set(item_code-1,updated_item);
			    	        		
			    	        		customers.get(which_customer-1).items.add(updated_item);
			    	        		for(int j = 0;j<merchants.size();j++){
			    	        			if(merchants.get(j).name().equals(updated_item.merchant)){

			    	        				merchants_contribution[j] += item_quantity * all_items.get(item_code-1).price * (0.005)*(0.75);
			    	        				items_sold[j]++;
			    	        				company_balance+=(item_quantity) * all_items.get(item_code-1).price * (0.005);

			    	        			}
			    	        		}
			    	        		customers_contribution[which_customer-1] += item_quantity * all_items.get(item_code-1).price * (0.005);
			    	        		items_bought[which_customer-1]++;
	    	        				company_balance+=(item_quantity) * all_items.get(item_code-1).price * (0.005);

			    	        		if(items_bought[which_customer-1]%5 == 0){
			    	        			customers_reward[which_customer-1] += 10;
			    	        		}
			    	        		
			    	        		System.out.println(itm.name + " "+ "successfully bought");


		    	        		}else if(offer.equals("None")){
		    	        			customer_acc[which_customer-1] -=item_quantity * all_items.get(item_code-1).price*(1.005);
		    	        			if(customer_acc[which_customer-1]<0){
		    	        				customers_reward[which_customer-1] += customer_acc[which_customer-1];
		    	        				customer_acc[which_customer-1] = 0;
		    	        			}
		    	        			item updated_item = all_items.get(item_code-1);
			    	        		updated_item.quantity -=item_quantity;
			    	        		all_items.set(item_code-1,updated_item);
			    	        		
			    	        		customers.get(which_customer-1).items.add(updated_item);
			    	        		for(int j = 0;j<merchants.size();j++){
			    	        			if(merchants.get(j).name().equals(updated_item.merchant)){

			    	        				merchants_contribution[j] += item_quantity * all_items.get(item_code-1).price * (0.005);
			    	        				items_sold[j]++;
			    	        				
//			    	        				System.out.println( item_quantity +" "+ all_items.get(item_code-1).price +" "+ "(0.005)");
//			    	        				System.out.println(item_quantity * all_items.get(item_code-1).price * (0.005));
//			    	        				System.out.println(merchants.get(j).contribution[0]);
			    	        				
			    	        				company_balance+=(item_quantity) * all_items.get(item_code-1).price * (0.005);

			    	        			}
			    	        		}
//	    	        				System.out.println( item_quantity +" "+ all_items.get(item_code-1).price +" "+ "(0.005)");
//	    	        				System.out.println(item_quantity * all_items.get(item_code-1).price * (0.005));
			    	        		customers_contribution[which_customer-1] += item_quantity * all_items.get(item_code-1).price * (0.005);
			    	        		items_bought[which_customer-1]++;
	    	        				company_balance+=(item_quantity) * all_items.get(item_code-1).price * (0.005);

			    	        		if(items_bought[which_customer-1]%5 == 0){
			    	        			customers_reward[which_customer-1] += 10;
			    	        		}
			    	        		
			    	        		System.out.println(itm.name + " "+ "successfully bought");

		    	        		}else{
			    	        		System.out.println("Unable to buy" + " " + itm.name);

		    	        		}
		    	        	}else{
		    	        		System.out.println("Unable to buy" + " " + itm.name);
		    	        	}
		    	        	cart.remove(cart.size()-1);
	    				}
	    				
	    				
	    				
	    			}
	    			
	    			//reward won
	    			else if(customer_query == 3){
	    	    		System.out.println("Reward won = " + customers_reward[which_customer-1]);
	    			}
	    			
	    			//print latest orders
	    			else if(customer_query == 4){
	    				int count =0;
	    				int index = customers.get(which_customer-1).items.size()-1;
	    				while(count<=10 && index>=0 ){
	    					System.out.println("Bought " + customers.get(which_customer-1).items.get(index).name + " quantity:" +customers.get(which_customer-1).items.get(index).quantity +" for Rs " + customers.get(which_customer-1).items.get(index).price + " from " + customers.get(which_customer-1).items.get(index).merchant);
	    					count++;
	    					index--;
	    					
	    				}
	    			}
	    			
	    			
	    			
	    			
	    			System.out.println("Welcome " + customers.get(which_customer-1).name());
		    		System.out.println("Customer menue");
		    		System.out.println("1) Search item");
		    		System.out.println("2) Checkout cart");
		    		System.out.println("3) Reword won");
		    		System.out.println("4) Print latest orders");
		    		System.out.println("5) Exit");
		    		customer_query = in.nextInt();
	    		} 
	    		
	    	}
	    	
	    	//user details
	    	else if(query_menue == 3){
	    		
	    		for(int j = 0;j<merchants.size();j++){
	    			System.out.println("M "+merchants.get(j).id() + " " +merchants.get(j).name());
	    		}
	    		for(int j = 0;j<customers.size();j++){
	    			System.out.println("C "+customers.get(j).id() + " " +customers.get(j).name());
	    		}
	    		
	    		
	    		String which_user = in.next();
	    		int user_id = in.nextInt();
	    		if(which_user.equals("M")){
	    			System.out.println(merchants.get(user_id-1).name() + " " + merchants.get(user_id-1).id() + " " +merchants_contribution[user_id-1] );
	    		}else if(which_user.equals("C")){
	    			System.out.println(customers.get(user_id-1).name() + " " + customers.get(user_id-1).id() + " " +items_bought[user_id-1] );

	    		}
	    		
	    	}
	    	
	    	//company account balance
	    	else if(query_menue == 4){
	    		System.out.println("Company Acc. Balance = " + company_balance);
	    	}
	    	
	    	System.out.println("Welcome to Mercury");
	  	    System.out.println("1) Enter as Merchant");
	  	    System.out.println("2) Enter as Customer");
	  	    System.out.println("3) See user details");
	  	    System.out.println("4) Company account balance");
	  	    System.out.println("5) Exit");
	  	    query_menue = in.nextInt();
	    	
	    }
    
    } 
}