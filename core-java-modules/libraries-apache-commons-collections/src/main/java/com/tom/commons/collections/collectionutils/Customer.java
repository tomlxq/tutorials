/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/9
 */
package com.tom.commons.collections.collectionutils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Customer implements Comparable<Customer> {

    private Integer id;
    private String name;
    private Long phone;
    private String locality;
    private String city;
    private String zip;

    public Customer(Integer id, String name, Long phone) {
        super();
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Customer(String name) {
        super();
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int compareTo(Customer o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Customer [id=").append(id).append(", name=").append(name).append(", phone=").append(phone).append("]");
        return builder.toString();
    }
}
