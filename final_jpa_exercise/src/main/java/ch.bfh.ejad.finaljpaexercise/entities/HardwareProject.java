package ch.bfh.ejad.finaljpaexercise.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HardwareProject extends Project {

    @OneToMany
    private List<HardwareComponent> components = new ArrayList<>();

    public List<HardwareComponent> getComponents() {
        return components;
    }

    public void setComponents(List<HardwareComponent> components) {
        this.components = components;
    }
}
