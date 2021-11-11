package com.ebook.Server;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.ResourceProvider;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class BookStoreServer {

    public static void main(String[] args) throws Exception {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(
        		com.ebook.service.customer.resource.CustomerResource.class,
        		com.ebook.service.item.resource.ProductResource.class, 
        		com.ebook.service.Order.resource.OrderResource.class
//        new com.ebook.model.service.Partner.PartnerResource,class
        		);
//        /Setting up providers/
        List<ResourceProvider> rps = new ArrayList<ResourceProvider>();
        
        rps.add(new SingletonResourceProvider(new com.ebook.service.customer.resource.CustomerResource()));
    	rps.add(new SingletonResourceProvider(new com.ebook.service.item.resource.ProductResource()));
    	rps.add(new SingletonResourceProvider(new com.ebook.service.Order.resource.OrderResource( )));
//    	rps.add(new SingletonResourceProvider(new com.ebook.model.service.Partner.PartnerResource()));
    	factoryBean.setResourceProviders(rps);
        
        
        factoryBean.setAddress("http://localhost:8080/");
        
        Server server = factoryBean.create();

        System.out.println("Bookstore System Restful Server ready...............................");
    }
}