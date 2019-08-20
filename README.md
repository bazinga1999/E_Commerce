# E_Commerce
Backend code for an E-commerce website

The aim of the application is to connect merchants with customers and
make the ensuing transaction hassle-free.
The company has a few demands which have to be met:
1) The company gets a 1% transaction fee (0.5% from the merchant and 0.5% from the
customer ) for every transaction.
2) Each merchant can sell at most 10 unique items at a time. ( Quantity doesn't matter )
3) Each item has a unique code and access to it is via its code.
4) There is a Reward scheme in the app:
● Every 5th purchase of a customer gets him a reward of Rs 10 ( This Reward has
to go into a separate rewards account and not the main account of the customer).
● A merchant gets an extra slot for every Rs 100 he contributes to the company’s
account (via the transaction fees mentioned above).
5) A customer can add items from multiple merchants into his cart.
6) Customers can buy an item directly or add it to his cart. Each Customer has Rs. 100 in
his main account when the program starts.
7) Whenever a customer buys/checks out an item, money is first deducted from his main
account and then from his rewards account.
8) The merchant has to add a category for each of his items so that the user can search for
items based on the categories.
9) The merchant can introduce the following offers on any of his items:
● Buy one get one free ( if quantity is one then this offer is effectively nullified)
● 25% off


Queries for Merchant:
1) Add items for a merchant: Print item details (id,name,price,quantity,category,offer if
applied) on successful addition else print an error message.
2) Edit items for a merchant: The merchant should enter the code for his particular item
and then he can edit the price and quantity of the item. Print edited item details.
3) Searching: Can only search by categories to check his own and competitor's pricing for
items in that category. Display all the categories so that the user can choose one. Print a
list view of the details of the items under that category.
4) Add offers for an item belonging to a merchant: The merchant should enter the code
for his particular item and then he can add an offer to that item. Print details of the item.
5) Print reward: Option to see how much slots have been awarded from the reward
scheme.
6) Exit.

Queries for Customer:
1) Searching: Search using categories. Display all the categories so that the user can
choose one. The customer after searching by the category gets a list view of the items
under that category. Then the customer can choose the item by its code and quantity.
The customer has to choose a method of transaction: 1. a choice of buying an item, 2.
adding it to cart, 3. exiting the current option. Print success messages or appropriate
error messages for the first 2 options.
2) Checkout option: Items have to be checked out in a FIFO manner. If you cannot check
out a particular item ( keeping in mind the quantity, account balance, offer ) then display
an error message (e.g. out of stock, out of money) and exit current option, else display
success messages and exit current option. Also, all the items before that particular item
( in case of error ) have to be checked out.
3) Print reward: Option to see how much reward has been won.

4) List recent orders: Display the last 10 transactions in the following manner " Bought
item “item name” quantity: “item quantity” for Rs “item price” from Merchant: “Merchant
Name”.
5) Exit.



Input Sample:
Welcome to Mercury
1) Enter as Merchant
2) Enter as Customer
3) See user details
4) Company account balance
5) Exit
1
choose merchant
1 jack
2 john
3 james
4 jeff
5 joseph
1
Welcome jack
Merchant Menu
1) Add item
2) Edit item
3) Search by category
4) Add offer
5) Rewards won
6) Exit
1
Enter item details
item name:
lays
item price:

20
item quantity:
5
item category:
chips
1 lays 20 5 None chips // If there is no offer available on the item, then it shows None
Welcome jack
Merchant Menu
1) Add item
2) Edit item
3) Search by category
4) Add offer
5) Rewards won
6) Exit
2
choose item by code
1 lays 20 5 None chips
1
Enter edit details
item price:
25
item quantity:
5
1 lays 25 5 None chips
Welcome jack
Merchant Menu
1) Add item
2) Edit item
3) Search by category
4) Add offer
5) Rewards won
6) Exit
3
Choose a category
1) chips
1
1 lays 25 5 None chips
Welcome jack
Merchant Menu
1) Add item
2) Edit item
3) Search by category
4) Add offer

5) Rewards won
6) Exit
4
choose item by code
1 lays 25 5 None chips
1
choose offer
1) buy one get one
2) 25% off
2
1 lays 25 5 25% off chips
Welcome jack
Merchant Menu
1) Add item
2) Edit item
3) Search by category
4) Add offer
5) Rewards won
6) Exit
6
Welcome to Mercury
1) Enter as Merchant
2) Enter as Customer
3) See user details
4) Company account balance
5) Exit
2
choose customer
1 ali
2 nobby
3 bruno
4 borat
5 aladeen
1
Welcome ali
Customer Menu
1) Search item
2) checkout cart
3) Reward won
4) print latest orders
5) Exit
1
Choose a category

1) chips
1
choose item by code
1 lays 25 5 25% off chips
Enter item code
1
Enter item quantity
3
Choose method of transaction
1) Buy item
2) Add item to cart
3) Exit
1
Item Successfully bought
Welcome ali
Customer Menu
1) Search item
2) Checkout cart
3) Reward won
4) Print latest orders
5) Exit
4
Bought item lays quantity: 3 for Rs 75 from Merchant jack
Welcome ali
Customer Menu
1) Search item
2) Checkout cart
3) Reward won
4) Print latest orders
5) Exit
5
--End of sample test--

