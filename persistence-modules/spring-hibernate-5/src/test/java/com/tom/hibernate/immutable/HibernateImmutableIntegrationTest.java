package com.tom.hibernate.immutable;

import com.google.common.collect.Sets;
import com.tom.hibernate.immutable.entities.Event;
import com.tom.hibernate.immutable.entities.EventGeneratedId;
import com.tom.hibernate.immutable.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.persistence.PersistenceException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Configured in: immutable.cfg.xml
 */
public class HibernateImmutableIntegrationTest {

    private static Session session;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void setup() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @AfterClass
    public static void teardown() {
        HibernateUtil.getSessionFactory().close();
    }

    private static void createEvent() {
        Event event = new Event(5L, "New Event", Sets.newHashSet("guest"));
        session.save(event);
    }

    private static void createEventGenerated() {
        EventGeneratedId eventGeneratedId = new EventGeneratedId("John", "Doe");
        session.save(eventGeneratedId);
    }

    @Before
    public void before() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    @Test
    public void addEvent() {
        Event event = new Event();
        event.setId(2L);
        event.setTitle("Public Event");
        session.save(event);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void updateEvent() {
        createEvent();
        Event event = (Event) session.createQuery("FROM Event WHERE title='New Event'").list().get(0);
        event.setTitle("Private Event");
        session.update(event);
        session.flush();
        session.refresh(event);
        session.close();

        assertThat(event.getTitle(), equalTo("New Event"));
        assertThat(event.getId(), equalTo(5L));
    }

    @Test
    public void deleteEvent() {
        createEvent();
        Event event = (Event) session.createQuery("FROM Event WHERE title='New Event'").list().get(0);
        session.delete(event);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void addGuest() {
        createEvent();
        Event event = (Event) session.createQuery("FROM Event WHERE title='New Event'").list().get(0);
        String newGuest = "Sara";
        event.getGuestList().add(newGuest);

        exception.expect(PersistenceException.class);
        session.save(event);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void deleteCascade() {
        Event event = (Event) session.createQuery("FROM Event WHERE title='New Event'").list().get(0);
        String guest = event.getGuestList().iterator().next();
        event.getGuestList().remove(guest);

        exception.expect(PersistenceException.class);
        session.saveOrUpdate(event);
        session.getTransaction().commit();
    }

    @Test
    public void updateEventGenerated() {
        createEventGenerated();
        EventGeneratedId eventGeneratedId = (EventGeneratedId) session.createQuery("FROM EventGeneratedId WHERE name LIKE '%John%'").list().get(0);

        eventGeneratedId.setName("Mike");
        session.update(eventGeneratedId);
        session.flush();
        session.refresh(eventGeneratedId);
        session.close();

        assertThat(eventGeneratedId.getName(), equalTo("John"));
        assertThat(eventGeneratedId.getId(), equalTo(1L));
    }

}
