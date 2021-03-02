package ru.optima.persist.model.equipments;

import org.hibernate.annotations.Cascade;
import ru.optima.persist.model.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kits")
public class Kit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "kit")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Equipment> equipments;

    public Kit(Bag bag, User user) {
        this.user = user;
        this.equipments = new ArrayList<>();
        this.equipments.addAll(bag.getEquipments());
    }
}
