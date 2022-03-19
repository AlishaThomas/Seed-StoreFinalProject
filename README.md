# Seed-StoreFinalProject
This is a web-based heirloom seed store where customers can browse and choose from a variety of 
products and create orders. There is a many to many relationship between the products and orders table 
where many products can be included on many orders and many orders can contain many products. The 
API allows CRUD operations on all the entities. On the customers entity, all four CRUD operations can 
be applied. The products entity is capable of the read operation when supplied with product name and 
type parameters and can also read and return a list of all available products which requires no 
parameters. The orders entity has a create operation which still needs some work but will eventually 
create an order. Also, I plan to work out how to properly save an order and calculate an order total.
