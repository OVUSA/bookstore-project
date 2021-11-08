
package com.ebook.model.partner;

import com.ebook.model.item.Product;

public interface Inventory {
	public void deleteProduct(Product product);
	public void increseQuantity(Product product, int amount);
	public void decreaseQuantity(Product product, int amount);
	public List<Product> reviewAllProducts();
	public void addProduct(Product product, int quantity);
}
