package com.inventory_product.service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.inventory_product.dto.PriceCalculationRequest;
import com.inventory_product.model.Discount;
import com.inventory_product.model.DiscountType;

@Component
public class PromoCodeDiscount implements DiscountStrategy {

	private static final Map<String,BigDecimal>promoCodes= Map.of(
			"SPRING25",BigDecimal.valueOf(25.0),
			"WELCOME10",BigDecimal.valueOf(10.0)); 
		
	@Override
	
	public Optional<Discount> applyDiscount(PriceCalculationRequest request,BigDecimal price){
		if(promoCodes.containsKey(request.getPromoCode())) {
			return Optional.of(new Discount (DiscountType.PROMO_CODE,promoCodes.get(request.getPromoCode())));
			
		}
		
		return Optional.empty();
	}
	

}
