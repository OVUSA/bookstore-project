# book-store-app
luc ecommerce bookstore app

# API
Featured here are some sample responses and requests from the various service endpoints. Currently, each endpoint accepts JSON and XML, but all sample responses and requests are shown in XML. Additionally, each endpoint and its respective HTTP verb are shown.

# Customer

The Customer endpoint has the following URIs and corresponding methods:

Get Customer by ID:
```
@GET
/customer/{CustomerId} 
```
Get all customers:

```
@GET
/customers
```
Add customer:


```
@POST
/customers
```
Delete customer:

```
@DELETE
/customer/{CustomerId} 
```

# Below are some sample requests and responses

```CustomerRequest ``` sample :

```
<?xml version="1.0" encoding="UTF-8"?>
<CustomerRequest>
        <firstName>John</firstName>
        <lastName>Smith</lastName>
</CustomerRequest>
```

```Customer ``` sample :

```
<?xml version="1.0" encoding="UTF-8"?>
<Customer>
        <customerID>XY1111</customerID>
        <firstName>John</firstName>
        <lastName>Smith</lastName>
</Customer>
```
# Product

The Product endpoint has the following URIs and corresponding methods:

Get product by ID:

```
@GET
/productservice/product/{productId} 
```
GET METHOD Response: ....{"Product":{"productId":"XY1111","title":"Mocking Jay","price":2350,"description":"Book on Mocking Jay","author":"John Smith"}}

````````
Get all products:

```
@GET
productservice/product
```
GET All METHOD Response: ....{"Product":[{"productId":"XY1111","title":"Mocking Jay","price":2350,"description":"Book on Mocking Jay","author":"John Smith"},{"productId":"XY1756","title":"Mocking Jay Part 3","price":100,"description":"Sequel of the part 2","author":"Alvin Chip"},{"productId":"XY1112","title":"Mocking Jay Part 2","price":2353,"description":"Series book on Mocking Jay","author":"John Smith"}]}

`````````

Add a product:
```
@POST
/productservice/product

payload/body: 
<Product><productId>XY1756</productId><title>Mocking Jay Part 3</title><price>100.0</price><description>Sequel of the part 2</description><author>Alvin Chip</author></Product>

```
POST MEDTHOD Response .........<?xml version="1.0" encoding="UTF-8" standalone="yes"?><Product><productId>XY1756</productId><title>Mocking Jay Part 3</title><price>100.0</price><description>Sequel of the part 2</description><author>Alvin Chip</author></Product>


Delete a product:

```
@DELETE
/productservice/product/{productId}
```
DELETE MEDTHOD Response ......... OK


# Partner

The Partner endpoint has the following URIs and corresponding methods:

Get partner by ID:

```
@GET
/partner/{partnerId} 
```
Get all partners:

```
@GET
/partners
```
Respond:
```
<?xml version="1.0" encoding="UTF-8"?>
<Partners>
    <Partner>
        <partnerID>PI123</partnerID>
        <partnerName>Shiny Owl Books</partnerName>
        <partnerInfo>Welcome to Shiny Owl Books, a general bookshop with several room with 15,000 books in the shop. We sell a wide variety of Fiction, Factual and Childrens Books including many thousands of paperback novels, childrens books and popular non-fiction titles</partnerInfo>
    </Partner>
    <Partner>
        <partnerID>PI147</partnerID>
        <partnerName>Amazon Books</partnerName>
        <partnerInfo>Amazon Books is a customer-focused store, designed to spur discovery; a place where customers can find great books and products of paperback novels, childrens books and popular non-fiction titles</partnerInfo>
    </Partner>
</Partners>
```
Add a partner:

```
@POST
/partners
```

Delete a partner:

```
@DELETE
/partner/{partnerID}
```

# Below are some sample requests and responses
```PartnerRequest``` sample :

```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<PartnerRequest>
    <partnerName>Ozon</partnerName>
    <partnerInfo>Children books</partnerInfo>
</PartnerRequest>
```

```Partner```sample:

```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Partner>
    <partnerID>PI5</partnerID>
    <partnerName>Ozon</partnerName>
    <partnerInfo>Children books</partnerInfo>
</Partner>
```
# Order
The order endpoint has the following URIs and corresponding methods:

Create Order by ID:
```
@POST
/orderservice/order
```
Json Postman body

```
{"orderRequest":{
    	
    	"orderDetails":[{
    		"quantity":1,
    		"product" :{
    			"id":2112233,
    			"title":"2NewTitle",
    			 "price":290.00,
    			 "description": "2-Testing the input"
    		}
    	}], 
	"paymentReceived": true,
	"orderState": "Open",
	"payment":{
		"paymentId": 247,
		"paymentStatus": "Completed",
		"subTotal": 290.00,
		"paymentType": "Cash"
} 			
    }
}
```

To update orders
```
@POST
/orderservice/order/update
```
Json Postman body
```
{"orderUpdateRequest":
{ "orderId": "d6ae44d9-9826-4b95-9a58-10576097affa",
    "status": "Pending"
}
}
```

Get All orders:
```
@GET
/orderservice/orders
```
Get Order by ID:

```
@Get
/orderservice/order/{order-id}
```



