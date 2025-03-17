package com.inventory_product.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory_product.dto.PriceCalculationRequest;
import com.inventory_product.dto.priceCalculationResponse;
import com.inventory_product.model.Discount;
import com.inventory_product.model.Product;
import com.inventory_product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	@Autowired
	private  ProductRepository productRepository;
	private  List<DiscountStrategy> discountStrategies;
	
	public priceCalculationResponse calculateprice(PriceCalculationRequest request) {
		Product  product = productRepository.findByProductId(request.getProductId())
				.orElseThrow(()->new IllegalArgumentException("Invalid Product ID"));
		
		BigDecimal originalPrice = product.getPrice().multiply(BigDecimal.valueOf(request.getQuantity()));
		List<Discount> appliedDiscounts = new ArrayList<>();
		BigDecimal discountAmount = BigDecimal.ZERO;
		
		
		for(DiscountStrategy strategy : discountStrategies) {
			strategy.applyDiscount(request, originalPrice).ifPresent(discount ->{
				appliedDiscounts.add(discount);
			});
			}
		
		for(Discount discount : appliedDiscounts) {
			discountAmount = discountAmount.add(originalPrice.multiply(discount.getPercentage().divide(BigDecimal.valueOf(100))));
		}
		BigDecimal finalPrice = originalPrice.subtract(discountAmount);
		
		return new priceCalculationResponse(
				request.getProductId(),
				originalPrice,
				finalPrice,
				appliedDiscounts,
				discountAmount
				);
	}

}
