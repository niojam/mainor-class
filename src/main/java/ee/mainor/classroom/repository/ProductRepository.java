package ee.mainor.classroom.repository;

import ee.mainor.classroom.model.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("""
            select * from product where name = :name
            """)
    List<Product> findAllByName(String name);


}
