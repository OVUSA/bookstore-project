package com.ebook.service.Partner.representation;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ebook.model.partner.PartnerInventory;
import com.ebook.service.AbstractRepresentation.AbstractRepresentation;



@XmlRootElement(name = "Partner")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

public class PartnerRepresentation extends AbstractRepresentation  {
	private String partnerID;
	private String partnerName;
	private String partnerInfo;
	private List<PartnerInventory> inventory;
	
	public PartnerRepresentation(){
		
	}

	public String getPartnerID() {
		return partnerID;
	}
	
	public void setPartnerID(String id) {
		this.partnerID = id;
	}
	
	public String getPartnerName() {
		return partnerName;
	}
	
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public String getPartnerInfo() {
		return partnerInfo;
	}

	public void setPartnerInfo(String partnerInfo) {
		this.partnerInfo = partnerInfo;
	}

	public List<PartnerInventory> getInventory() {
		return inventory;
	}

	public void setInventory(List<PartnerInventory> inventory) {
		this.inventory = inventory;
	}

}

