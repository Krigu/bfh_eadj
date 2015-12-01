package ch.bfh.ejad.finaljpaexercise.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Product extends BaseEntity {

    private String name;

    @ManyToOne
    private Employee productOwner;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Platform platform;

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform plattform) {
        this.platform = plattform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(Employee productOwner) {
        this.productOwner = productOwner;
    }
}
