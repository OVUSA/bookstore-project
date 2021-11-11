package com.ebook.Server;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class OrderApplicationServer {

    public static void main(String[] args) throws Exception {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(com.ebook.service.Order.resource.OrderResource.class);
        factoryBean.setResourceProvider(new SingletonResourceProvider(new com.ebook.service.Order.resource.OrderResource()));
        factoryBean.setAddress("http://localhost:8081/");
        Server server = factoryBean.create();
        
        System.out.println("----------------Order RestAPI----------------");
    }
}