package etrade;

import etrade.business.abstracts.ProductService;
import etrade.business.concretes.ProductManager;
import etrade.dataAccess.concretes.hibernateImpls.HibernateProductRepository;
import etrade.dataAccess.concretes.jdbcImpls.JdbcProductRepository;
import etrade.entities.concretes.Product;

public class Main {
	static ProductService productService = new ProductManager(new HibernateProductRepository());
	static ProductService productService2 = new ProductManager(new JdbcProductRepository());

	public static void main(String[] args) {
				
		Product product1 = new Product(1, "Telefon", 1000, 10);
		Product product2 = new Product(2, "Bilgisayar", 9000, 10);
		Product product3 = new Product(3, "Kulaklýk", 400, 10);
		
		productService.add(product1);
		productService.add(product2);
		productService.add(product3);
		
		selectAll();
		tire();		
		System.out.println(productService.getById(2).getProductName());
		
		productService.delete(product3);
		
		selectAll();
		tire();
		
		Product product4 = new Product(1, "Mouse", 100, 10);

		productService.update(product4);
		
		selectAll();
		tire();
		
		Product product5 = new Product(1, "Mouse", 100, 10);
		productService.add(product5);
		
		selectAll();
		tire();
		
		Product product6 = new Product(8, "Mouse", 100, 10);
		productService.delete(product6);
		
		selectAll();
		tire();
		
	}
	
	static void selectAll() {
		for (Product item : productService.getAll()) {
			System.out.println(item.getProductName() + " - " + item.getPrice());
		}
	}
	
	static void tire() {
		System.out.println("-------------------");
	}

}
