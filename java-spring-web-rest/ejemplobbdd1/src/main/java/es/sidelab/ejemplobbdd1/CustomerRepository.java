package es.sidelab.ejemplobbdd1;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);
	
	List<Customer> findByFirstName(String firstName);
	
}