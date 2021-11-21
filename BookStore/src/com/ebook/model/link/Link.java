package com.ebook.model.link;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Link")
public class Link {
	private String relation;
	private String url;
	private String mediaType;
	
	public Link() {}
	
	public Link(String rel, String url, String mediaType) {
		this.relation = rel;
		this.url = url;
		this.mediaType = mediaType;
	}
	
	public String getRealtion() {
		return relation;
	}

	public void setRealtion(String realtion) {
		this.relation = realtion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	
}