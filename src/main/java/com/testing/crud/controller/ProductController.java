package com.testing.crud.controller;

import com.testing.crud.service.ProductService;
import com.testing.crud.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("product_list");
        List<Product> productList = productService.getAllProducts();
        model.addObject("productList",productList);

        return model;
    }
    @RequestMapping(value = "/addProduct/", method = RequestMethod.GET)
    public ModelAndView addProduct(){
        ModelAndView model = new ModelAndView();
        Product product = new Product();
        model.addObject("productForm",product);
        model.setViewName("product_form");
        return model;
    }
    @RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.GET)
    public ModelAndView editProduct(@PathVariable long id){
        ModelAndView model = new ModelAndView();
        Product product = productService.read(id);
        model.addObject("productForm",product);
        model.setViewName("product_form");
        return model;
    }
    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("productForm") Product product){
        productService.create(product);
        return new ModelAndView("redirect:/product/list");
    }
    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") long id){
        productService.delete(id);
        return new ModelAndView("redirect:/product/list");
    }

}
