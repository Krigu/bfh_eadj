package ch.bfh.ejad.finaljpaexercise.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HardwareComponent extends BaseEntity {

    private String name;

    private String serialNumber;

    private BigDecimal price;

    private String manufactrurer;

    @ManyToOne
    private HardwareComponent parent;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parent")
    private List<HardwareComponent> componentList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getManufactrurer() {
        return manufactrurer;
    }

    public void setManufactrurer(String manufactrurer) {
        this.manufactrurer = manufactrurer;
    }

    public HardwareComponent getParent() {
        return parent;
    }

    public void setParent(HardwareComponent parent) {
        this.parent = parent;
    }

    public List<HardwareComponent> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<HardwareComponent> componentList) {
        this.componentList = componentList;
    }
}
