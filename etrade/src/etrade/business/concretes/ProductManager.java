package etrade.business.concretes;

import java.util.List;

import etrade.business.abstracts.ProductService;
import etrade.dataAccess.abstracts.ProductRepository;
import etrade.entities.concretes.Product;

public class ProductManager implements ProductService{
	
	private ProductRepository productRepository;

	public ProductManager(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void add(Product product) {
		if (!checkIfProductNameExists(product.getProductName())) {
			if(product.getPrice() > 0) {
				if (!checkIfProductCategoryLimit(product.getCategoryId())) {
					productRepository.add(product);
				}
				else {
					System.out.println("Bu kategoriye ait ürün sayýsý 5'ten fazla olamaz");
					return;
				}
			}
			else {
				System.out.println("Ürün fiyatý 0 dan düþük olamaz");
			}
		}
		else {
			System.out.println("Bu ürün mevcut");
		}
	}
	
	@Override
	public void delete(Product product) {
		productRepository.delete(product);
	}

	@Override
	public void update(Product product) {
		productRepository.update(product);
	}

	@Override
	public List<Product> getAll() {
		return productRepository.getAll();
	}

	@Override
	public Product getById(int id) {	
		return productRepository.getById(id);
	}
	
	public boolean checkIfProductNameExists(String productName) {
		boolean exists = false;
		for (Product item : productRepository.getAll() ) {
			if(item.getProductName() == productName) {
				exists = true;
			}
		}
		return exists;
	}
	
	public boolean checkIfProductCategoryLimit(int categoryId) {
		boolean checkLimit = false;
		int count = 0;
		for (Product item : productRepository.getAll()) {
			if (item.getCategoryId() == categoryId) {
				count++;
			}
		}
		if (count > 4) {
			checkLimit = true;
		}
		return checkLimit;
	}
}
