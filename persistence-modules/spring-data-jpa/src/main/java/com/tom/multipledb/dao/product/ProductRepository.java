
package com.tom.multipledb.dao.product;

import com.tom.multipledb.model.product.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {


    List<Product> findAllByPrice(double price, Pageable pageable);
}