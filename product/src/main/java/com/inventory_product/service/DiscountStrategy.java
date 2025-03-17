package com.inventory_product.service;

import java.math.BigDecimal;
import java.util.Optional;

import com.inventory_product.dto.PriceCalculationRequest;
import com.inventory_product.model.Discount;

public interface DiscountStrategy {
	
	Optional<Discount> applyDiscount(PriceCalculationRequest request,BigDecimal price);
	


}
