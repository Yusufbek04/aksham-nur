package uz.pdp.akshamnurserver.entity;

import lombok.*;
import uz.pdp.akshamnurserver.entity.enums.PageEnum;
import uz.pdp.akshamnurserver.entity.enums.PermissionEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PageEnum defaultPage;

    @CollectionTable(name = "role_permission",
            joinColumns =
            @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Column(name = "permission", nullable = false)
    private Set<PermissionEnum> permissions;
}
