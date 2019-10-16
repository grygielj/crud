package com.testing.crud.service;

import com.testing.crud.model.Product;
import com.testing.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>)productRepository.findAll();
    }

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }
    @Override
    public Product read(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);

    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }
}
