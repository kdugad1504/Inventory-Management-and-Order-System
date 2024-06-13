# Inventory-Management-and-Order-System
A basic inventory management system with functionalities like creating order and add quantity

Project Overview:
This project is an Inventory Management and Order System designed to manage the inventory for small business owners that put up their stalls at flea markets.For this project my inspiration was my cousin who is a owner of business "ECOMO" that sells green products. Here are four different products: Seed Pens, Wooden Tooth Brushes, Handmade Books, and Metal Straws. It allows users(cashier) to create orders (decreasing the inventory) and add quantities to the inventory. The program provides a simple text-based interface for users to interact with.  

Purpose:
The primary purpose of this project is to help manage the stock levels of various eco-friendly products by:

Allowing users to create orders, which will subtract the ordered quantities from the inventory.
Enabling users to add quantities to the inventory, such as restocking products.
Providing a way to display the current quantities of all products.

Functionality:
The project consists of two main classes: Quantity and Order.

Quantity Class:
This class is responsible for managing the quantity of individual products. It provides methods to add to and subtract from the current quantity.

Order Class:
This class extends Quantity and represents individual products. It includes static methods for managing orders and inventory, and provides a text-based menu interface for user interaction.

Error Handling:
The program handles invalid inputs by displaying an error message and prompting the user to enter a valid option. This ensures that the user provides correct input before proceeding.

Conclusion:
This project provides a simple and efficient way to manage the inventory and orders of four different eco-friendly products. The text-based menu interface is easy to use, making it suitable for users with minimal technical expertise. The project demonstrates basic concepts of object-oriented programming, including inheritance, encapsulation, and static methods.
