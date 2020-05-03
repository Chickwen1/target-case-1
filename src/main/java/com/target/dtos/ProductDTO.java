package com.target.dtos;

/*
 * Defining Data Transfer Object to remove code smell/vulnerabilities when receiving a RequestBody
 */
public class ProductDTO {

		private String productId;
		
		private String title;
		
		private double price;

		public ProductDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ProductDTO(String productId, String title, double price) {
			super();
			this.productId = productId;
			this.title = title;
			this.price = price;
		}

		public String getProductId() {
			return productId;
		}

		public void setProductId(String productId) {
			this.productId = productId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
}
