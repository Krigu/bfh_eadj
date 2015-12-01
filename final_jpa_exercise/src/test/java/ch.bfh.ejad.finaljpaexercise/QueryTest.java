package ch.bfh.ejad.finaljpaexercise;

import ch.bfh.ejad.finaljpaexercise.entities.Employee;
import ch.bfh.ejad.finaljpaexercise.entities.Project;
import ch.bfh.ejad.finaljpaexercise.enums.ProjectRole;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class QueryTest extends AbstractJpaTest {

    private final static Logger LOGGER = Logger.getLogger(QueryTest.class.getSimpleName());

    @Test
    public void findAllProjectsWithBusinessAnalysts() {
        TypedQuery<Project> q = em.createQuery("SELECT DISTINCT p FROM Project p "
                        + "JOIN p.projectCollaboration c WHERE c.projectRole = :projectRole",
                Project.class);

        q.setParameter("projectRole", ProjectRole.BA);
        List<Project> list = q.getResultList();

        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findDepartementsWithProductsAndMonthlyCost() {
        Query q = em.createQuery("SELECT d.name, count(product), avg(platform.monthlyCosts) " +
                "FROM Product product " +
                "JOIN product.platform platform " +
                "JOIN product.productOwner productOwner " +
                "JOIN product.productOwner.department d " +
                "GROUP BY d.name ");

        List<Object[]> list = q.getResultList();

        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }


    @Test
    public void findAllEmployeesInDateRange() throws ParseException {
        TypedQuery<Employee> q = em.createQuery("SELECT e " +
                        "FROM Employee e " +
                        "JOIN e.projects c " +
                        "WHERE :date BETWEEN c.fromDate AND c.toDate",
                Employee.class);

        DateFormat df = new SimpleDateFormat("dd.MM.YYYY");
        q.setParameter("date", df.parse("01.12.2013"));

        List<Employee> employees = q.getResultList();

        Assert.assertTrue(employees.size() > 0);
    }


}
