package com.ebook.server;


import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class PartnerRestfulServer {

		public static void main(String args[]) throws Exception {
	        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
	        factoryBean.setResourceClasses(com.ebook.model.service.Partner.PartnerResource.class);
	        factoryBean.setResourceProvider(new SingletonResourceProvider(new com.ebook.model.service.Partner.PartnerResource()));
	        factoryBean.setAddress("http://localhost:8081/");
	        Server server = factoryBean.create();

	        System.out.println("Partner System Restful Server ready...............................");      

	    }
	}