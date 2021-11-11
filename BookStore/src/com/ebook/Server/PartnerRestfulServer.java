package com.ebook.Server;


import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class PartnerRestfulServer {

		public static void main(String args[]) throws Exception {
	        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
	        factoryBean.setResourceClasses(com.ebook.service.Partner.resource.PartnerResource.class);
	        factoryBean.setResourceProvider(new SingletonResourceProvider(new com.ebook.service.Partner.resource.PartnerResource()));
	        factoryBean.setAddress("http://localhost:8081/");
	        Server server = factoryBean.create();

	        System.out.println("Partner System Restful Server ready...............................");      

	    }
	}