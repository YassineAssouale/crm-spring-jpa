package crm.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import crm.jpa.model.Order;

public interface MyOrderRepository extends JpaRepository{

	List<Order> findByStatusAndType(String status, String type);
	
	@Query("SELECT o FROM Order WHERE o.numberOfDays > :ndOfDays")
	List<Order> findByNumberOfDays(@Param("nbOfDays") Double nfOfDays);
}
