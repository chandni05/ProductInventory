package com.inventory_product.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Discount {
	
	public Discount(DiscountType promoCode, BigDecimal bigDecimal) {
		
	}
	public DiscountType getType() {
		return type;
	}
	public void setType(DiscountType type) {
		this.type = type;
	}
	public BigDecimal getPercentage() {
		return percentage;
	}
	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}
	private DiscountType type;
	private BigDecimal percentage;

}
