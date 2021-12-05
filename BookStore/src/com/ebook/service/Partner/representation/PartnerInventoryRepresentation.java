package com.ebook.service.Partner.representation;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ebook.service.AbstractRepresentation.AbstractRepresentation;
import com.ebook.service.item.representation.ProductRepresentation;

@XmlRootElement(name = "PartnerInventory")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

public class PartnerInventoryRepresentation extends AbstractRepresentation  {
	private ProductRepresentation product;
	private int quantity;
	
	public PartnerInventoryRepresentation(){
		
	}
	
	public PartnerInventoryRepresentation(ProductRepresentation product, int amount){
		this.product = product;
		this.quantity = amount;
	}
	
	public ProductRepresentation getProduct() {
		return product;
	}
	public void setProduct(ProductRepresentation product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
		
}