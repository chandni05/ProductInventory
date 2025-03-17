package com.inventory_product.dto;

import java.math.BigDecimal;
import java.util.List;

import com.inventory_product.model.Discount;


import lombok.Data;

@Data

public class priceCalculationResponse {
	
	public priceCalculationResponse(String productId, BigDecimal originalPrice, BigDecimal finalPrice,
			List<Discount> appliedDiscounts, BigDecimal discountAmount) {
		
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}
	public BigDecimal getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}
	public List<Discount> getAppliedDiscounts() {
		return appliedDiscounts;
	}
	public void setAppliedDiscounts(List<Discount> appliedDiscounts) {
		this.appliedDiscounts = appliedDiscounts;
	}
	public BigDecimal getTotalSavings() {
		return totalSavings;
	}
	public void setTotalSavings(BigDecimal totalSavings) {
		this.totalSavings = totalSavings;
	}
	private String productId;
	private BigDecimal originalPrice;
	private BigDecimal finalPrice;
	private List<Discount> appliedDiscounts;
	private BigDecimal totalSavings;

}
