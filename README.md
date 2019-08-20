# E_Commerce
Backend code for an E-commerce website

This code is initialized with 5 merchants and customers.
First there is main menue in which the user can choose whether he is merchant, customer or just want to know details about companies accounts or and merchant's or customer's details.


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
