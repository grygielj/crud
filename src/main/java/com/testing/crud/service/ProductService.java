package com.testing.crud.service;

import com.testing.crud.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();

    public Product read(long id);

    public void create(Product product);

    public void update(Product product);

    public void delete(long id);
}
