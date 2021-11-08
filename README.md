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



