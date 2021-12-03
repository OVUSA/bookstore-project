package com.ebook.service.AbstractRepresentation;


import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import com.ebook.model.link.Link;


public abstract class AbstractRepresentation {

	@XmlElement(name="link", namespace="")
	protected List<Link> links;
	
	public List<Link> getLinks() {
		return links;
	}
	
	public void setLinks(Link...links) {
		this.links = Arrays.asList(links);
	}
	
	public void setDeatiledLinks(Link...links) {
		this.links = Arrays.asList(links);
	}
	
	/*public void addLinks(Link link){
		links.add(link);
	}*/
}