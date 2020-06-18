package com.tom.persistence.dao;


import com.tom.persistence.model.Event;
import org.springframework.stereotype.Repository;

@Repository
public class EventDao extends AbstractHibernateDao<Event> implements IEventDao {

    public EventDao() {
        super();

        setClazz(Event.class);
    }

    // API

}
