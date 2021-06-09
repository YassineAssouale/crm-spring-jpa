package crm.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import crm.jpa.model.Order;

public interface orderRepository extends JpaRepository<Order, Integer>{
	
	List<Order> findByStatusAndType(String status, String type);
	
	@Query("SELECT o FROM Order WHERE o.numberOfDays > :nbOfDays")
	List<Order> findByNumberOfDays(@Param("nbOfDays") Double ndOfDays);
}
