package ch.bfh.ejad.finaljpaexercise.entities;


import ch.bfh.ejad.finaljpaexercise.enums.ProjectRole;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Entity
public class ProjectCollaboration extends BaseEntity {

    private Date fromDate;

    private Date toDate;

    @Enumerated(value = EnumType.STRING)
    private ProjectRole projectRole;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Project project;

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public ProjectRole getProjectRole() {
        return projectRole;
    }

    public void setProjectRole(ProjectRole role) {
        this.projectRole = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectCollaboration that = (ProjectCollaboration) o;

        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (toDate != null ? !toDate.equals(that.toDate) : that.toDate != null) return false;
        if (projectRole != that.projectRole) return false;
        if (employee != null ? !employee.equals(that.employee) : that.employee != null) return false;
        return !(project != null ? !project.equals(that.project) : that.project != null);

    }

    @Override
    public int hashCode() {
        int result = fromDate != null ? fromDate.hashCode() : 0;
        result = 31 * result + (toDate != null ? toDate.hashCode() : 0);
        result = 31 * result + (projectRole != null ? projectRole.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        return result;
    }
}
