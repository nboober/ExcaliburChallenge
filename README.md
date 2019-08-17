**Excalibur Coding Challenge**

**My Project**

My project creates 3 tables in a MySQL database called access

The information for two of these tables (orderDate & orderDetail) are passed through inputs in html forms by using Hibernate through Java's Java Persistance API(JPA)

The information passed into these forms are validated using springboot before being saved to the database

These collections are then joined into a third table (orderCombined)

**How To Run**

clone project to your local repository

Create and use a database in MySQL called access

From the DemoApplication class run the main function

open up your browser and enter localhost:8080/ as your URL

**Requirements of Project**

Create Access DB with 3 tables (could be MySQL or PostGre DB)
- order_date with 2 columns (order_id: key, order_date: date)
- order_detail with 3 columns (order_id: key, order_amount: currency, order_description: string)
- order_combined with 4 columns (order_id: key, order_date: date, order_amount: currency,
order_description: string)


• Create a web service, which will take 3 inputs: filter for date, filter for amount, filter for description. For example filter for date should accommodate the FROM DATE and To DATE, for current year condition.
Filter for amount should accommodate something like greater than 300.00 doll or less than 20.00 doll
conditions.


• Have WS retrieve order_date and order_detail tables into 2 java collections using Hibernate


• Create generic java function to sort these collections in ascending by date, descending by amount order


• Join these collections into third collection using lambda expressions


• Write this new collection back to the DB into order_combined table using Hibernate


• If order_combined already has data in it, delete prior to writing new data


• Demonstrate WS calls with various input filters