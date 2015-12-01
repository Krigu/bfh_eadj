package ch.bfh.ejad.finaljpaexercise.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Project extends BaseEntity {


    private String name;

    @OneToMany(mappedBy = "project")
    private List<ProjectCollaboration> projectCollaboration = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProjectCollaboration> getProjectCollaboration() {
        return projectCollaboration;
    }

    public void setProjectCollaboration(List<ProjectCollaboration> projectCollaboration) {
        this.projectCollaboration = projectCollaboration;
    }
}
