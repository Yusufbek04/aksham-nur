package uz.pdp.akshamnurserver.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String imagePath;

    @Column(nullable = false)

    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String aboutProduct;

    @Column(nullable = false)
    private Float price;


}

