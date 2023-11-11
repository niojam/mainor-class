package ee.mainor.classroom.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Data
@Table("product")
public class Product {

    @Id
    private Long id;

    private String name;

    private Integer price;

    private String description;

    private String currency;

    private Instant createdAt;

    private String createdBy;

    private Instant updatedAt;

    private String updatedBy;



}
