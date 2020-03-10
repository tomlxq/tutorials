/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/9
 */
package com.tom.commons.collections.collectionutils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String locality;
    private String city;
    private String zip;
}
