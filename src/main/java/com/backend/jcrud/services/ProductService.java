package com.backend.jcrud.services;

import java.util.List;
import com.backend.jcrud.models.Product;
import org.springframework.stereotype.Service;
import com.backend.jcrud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service 
public class ProductService {
    
    @Autowired 
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product getProductById(Long id){
        Product product = productRepository.findById(id).orElse(null);
        return product;
    }

    public Product createProduct(Product newProduct){
        Product product = productRepository.save(newProduct);
        return product;
    }


    public Product updateProduct(long id, Product newProductData){
        Product product = productRepository.findById(id).orElse(null);

        if (product == null){
            return null;
        }

        product.setName(newProductData.getName());
        product.setDescription(newProductData.getDescription());
        product.setPrice(newProductData.getPrice());
        productRepository.save(product);

        return product;
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

}
