package br.com.artech.dsdeliver.services;

import br.com.artech.dsdeliver.dto.ProductDTO;
import br.com.artech.dsdeliver.entities.Product;
import br.com.artech.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        List<Product> products = repository.findAllByOrderByNameAsc();
        return products.stream().map(product -> new ProductDTO(product)).collect(Collectors.toList());
    }
}
