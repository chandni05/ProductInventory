package com.inventory_product.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.inventory_product.dto.PriceCalculationRequest;
import com.inventory_product.model.Discount;
import com.inventory_product.model.DiscountType;

@Component
public class QuantityDiscount implements DiscountStrategy{
	
	@Override
	
	public Optional<Discount> applyDiscount(PriceCalculationRequest request,BigDecimal price){
		
		if(request.getQuantity()>=3) {
			return Optional.of(new Discount (DiscountType.QUANTITY,BigDecimal.valueOf(5.0)));
		}
		return Optional.empty();

}
}
