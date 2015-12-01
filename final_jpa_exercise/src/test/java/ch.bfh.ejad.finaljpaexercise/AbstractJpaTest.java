package ch.bfh.ejad.finaljpaexercise;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;


public class AbstractJpaTest {
    protected static final Logger LOGGER = java.util.logging.Logger.getLogger(AbstractJpaTest.class.getName());
    protected static EntityManagerFactory emf;
    protected static EntityManager em;
    protected static Connection con;
    protected static IDatabaseConnection dbConnection;
    protected static FlatXmlDataSet dataSet;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        emf = Persistence.createEntityManagerFactory("hr");
        em = emf.createEntityManager();


        con = DriverManager.getConnection("jdbc:derby://localhost:1527/hr", "hr", "hr");
        dbConnection = new DatabaseConnection(con);

        InputStream strm = AbstractJpaTest.class.getClassLoader().getResourceAsStream("hrdata.xml");
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        builder.setColumnSensing(true);
        dataSet = builder.build(strm);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

    @Before
    public void insertTestData() throws Exception {
        em.clear();
        emf.getCache().evictAll();

        DatabaseOperation.CLEAN_INSERT.execute(dbConnection, dataSet);
    }

    @After
    public void deleteTestData() throws Exception {
//        DatabaseOperation.DELETE_ALL.execute(dbConnection, dataSet);
    }
}
