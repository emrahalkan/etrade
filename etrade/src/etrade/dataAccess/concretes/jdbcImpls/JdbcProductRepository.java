package etrade.dataAccess.concretes.jdbcImpls;

import java.util.ArrayList;
import java.util.List;

import etrade.dataAccess.abstracts.ProductRepository;
import etrade.entities.concretes.Product;

public class JdbcProductRepository implements ProductRepository{
	
	private List<Product> products;

	public JdbcProductRepository() {
		products = new ArrayList<Product>();
	}

	@Override
	public void add(Product product) {
		products.add(product);
	}

	@Override
	public void delete(Product product) {
		Product findToProduct = getById(product.getId());
		if (findToProduct != null) {
			products.remove(findToProduct);
			System.out.println("�r�n Silindi");
		}
		else {
			System.out.println("�r�n bulunamad�");
		}
	}

	@Override
	public void update(Product product) {
		Product findToProduct = getById(product.getId());
		if (findToProduct != null) {
			findToProduct.setProductName(product.getProductName());
			findToProduct.setPrice(product.getPrice());
			System.out.println("�r�n g�ncellendi");
		}
		else {
			System.out.println("�r�n bulunamad�");
		}
	}

	@Override
	public List<Product> getAll() {
		return products;
	}

	@Override
	public Product getById(int id) {
		Product findToProduct = null;
		for (Product product : products) {
			if (product.getId() == id) {
				findToProduct = product;
			}
		}
		return findToProduct;
	}

}
