package com.ebook.model.partner;

import java.util.ArrayList;
import java.util.List;

import com.ebook.model.item.Product;

public class Partner {
    private String name;
    private String partnerId;
    private List<PartnerInventory> inventory = new ArrayList<>();
   	private String partnerInfo;
    
   public Partner(String name,String partnerInformation) {
        this.name = name;
        this.partnerInfo = partnerInformation;
      }
   public Partner() {}


    public String getPartnerName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpartnerId() {
        return partnerId;
    }

    public void setpartnerId(String id) {
        this.partnerId = id;
    }

    public String getPartnerInfo() {
		return partnerInfo;
	}
	public List<PartnerInventory> getInventory() {
		return inventory;
	}
	public void setInventory(List<PartnerInventory> inventory) {
		this.inventory = inventory;
	}
	
	public void addPartnerProduct(Product product, int quantity) {
		inventory.add(new PartnerInventory(product,quantity));
	}
}
