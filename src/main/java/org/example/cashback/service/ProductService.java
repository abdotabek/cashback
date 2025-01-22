package org.example.cashback.service;

import lombok.RequiredArgsConstructor;
import org.example.cashback.dto.ProductDTO;
import org.example.cashback.entity.Product;
import org.example.cashback.exception.ExceptionUtil;
import org.example.cashback.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDTO create(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        return toDTO(productRepository.save(product));
    }

    public ProductDTO get(Long id) {
        return toDTO(productRepository.findById(id).orElseThrow(
                () -> ExceptionUtil.throwNotFoundException("product with id does not exist!")));
    }

    public List<ProductDTO> getList() {
        return productRepository.findAll().stream().map(this::toDTO).toList();
    }

    public ProductDTO update(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> ExceptionUtil.throwNotFoundException("product with id does not exist!"));
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        return toDTO(productRepository.save(product));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    private ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }
}
