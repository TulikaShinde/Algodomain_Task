# Algodomain_Task

To run the application:
1. Import the project in your IDE.
2. In application.properties file, edit the details for your database connection
   #DB properties
   spring.datasource.url=jdbc:mysql://localhost:3306/YOURDATABASENAME?useSSL=false&allowPublicKeyRetrieval=true
   spring.datasource.username=YOURUSERNAME
   spring.datasource.password=PASSWORD
3. Right click on the project and select Run As -> Spring Boot App.
   Hibernate will create the tables in database.
4. Open MySQL and to add the data in Category Table, run the folowing commands
   insert into category_algodomain values("Electronics", 350, 15, 18);
   insert into category_algodomain values("Home Appliances", 800, 22, 24);
   insert into category_algodomain values("Clothing", 0, 40, 12);
   insert into category_algodomain values("Furniture", 300, 10, 18);
5. Open Postman Tool
   Run the following URLs : 
   Add Product : use POST method
   url : 
   http://localhost:8080/algodomain_task/algodomain
   Body : Raw :JSON
   {
        "productId" : 1005,
        "productName": "Neelkamal Been Bag",
        "productType": "Sofa Set",
        "productCategory": {
            "productCategory": "Furniture"
        },
        "productPrice" : 350
    }
    Likewise add all the products
