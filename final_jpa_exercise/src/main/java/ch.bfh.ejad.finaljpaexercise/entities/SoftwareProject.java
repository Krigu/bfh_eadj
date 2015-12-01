package ch.bfh.ejad.finaljpaexercise.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class SoftwareProject extends Project {

    private String programmingLanguage;

    @OneToOne
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }


}
