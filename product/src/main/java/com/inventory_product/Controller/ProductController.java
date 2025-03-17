package com.inventory_product.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory_product.dto.PriceCalculationRequest;
import com.inventory_product.dto.priceCalculationResponse;
import com.inventory_product.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
	@Autowired
	private  ProductService productService;
	
	@PostMapping("/price-calculation")
	public priceCalculationResponse calculatePrice(@Valid @RequestBody PriceCalculationRequest request) {
		return productService.calculateprice(request);
	}
	

}
