package com.tom.hibernate.manytomany;

import com.tom.hibernate.manytomany.model.Employee;
import com.tom.hibernate.manytomany.model.Project;
import com.tom.hibernate.manytomany.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Configured in: manytomany.cfg.xml
 */
public class HibernateManyToManyAnnotationMainIntegrationTest {
    private static SessionFactory sessionFactory;

    private Session session;

    @BeforeClass
    public static void beforeTests() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @AfterClass
    public static void afterTests() {
        sessionFactory.close();
    }

    @Before
    public void setUp() {
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    @Test
    public void givenData_whenInsert_thenCreatesMtoMrelationship() {
        String[] employeeData = {"Peter Oven", "Allan Norman"};
        String[] projectData = {"IT Project", "Networking Project"};
        Set<Project> projects = new HashSet<Project>();

        for (String proj : projectData) {
            projects.add(new Project(proj));
        }

        for (String emp : employeeData) {
            Employee employee = new Employee(emp.split(" ")[0], emp.split(" ")[1]);
            assertEquals(0, employee.getProjects().size());
            employee.setProjects(projects);
            session.persist(employee);
            assertNotNull(employee);
        }
    }

    @Test
    public void givenSession_whenRead_thenReturnsMtoMdata() {
        @SuppressWarnings("unchecked")
        List<Employee> employeeList = session.createQuery("FROM Employee").list();
        assertNotNull(employeeList);
        for (Employee employee : employeeList) {
            assertNotNull(employee.getProjects());
        }
    }

    @After
    public void tearDown() {
        session.getTransaction()
                .commit();
        session.close();
    }

}
