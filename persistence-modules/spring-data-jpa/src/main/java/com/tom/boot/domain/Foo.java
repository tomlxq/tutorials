package com.tom.boot.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import java.io.Serializable;

@NamedNativeQueries({@NamedNativeQuery(name = "callGetAllFoos", query = "CALL GetAllFoos()", resultClass = Foo.class), @NamedNativeQuery(name = "callGetFoosByName", query = "CALL GetFoosByName(:fooName)", resultClass = Foo.class)})
@Entity
@Audited
// @Proxy(lazy = false)
@Data
@NoArgsConstructor
public class Foo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(targetEntity = Bar.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BAR_ID")
    private Bar bar = new Bar();


    public Foo(final String name) {
        super();
        this.name = name;
    }

}