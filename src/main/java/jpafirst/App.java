package jpafirst;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpafirst.entity.Order;
import jpafirst.entity.OrderItem;
import jpafirst.entity.Product;

public class App {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-first-project");
		EntityManager em = emf.createEntityManager();
				
		Product product1 = new Product("Product 1");
		Product product2 = new Product("Product 2");
		
		
		em.getTransaction().begin();
		em.persist(product1);
		em.persist(product2);
		em.getTransaction().commit();
		
		Order order = new Order("Order 1");
		Long productId = 1L;
		Double amount = 100.;
		order.getOrderItems().add(new OrderItem(productId, amount));
		
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();

	}

}
