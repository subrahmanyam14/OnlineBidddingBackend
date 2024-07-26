package com.biddingsystem.utility;

public class Constants {

	public enum UserRole {
		ROLE_CUSTOMER("Customer"), ROLE_ADMIN("Admin"), ROLE_SELLER("Seller"), ROLE_DELIVERY("Delivery");

		private String role;

		private UserRole(String role) {
			this.role = role;
		}

		public String value() {
			return this.role;
		}
	}

	public enum UserStatus {
		ACTIVE("Active"), DEACTIVATED("Deactivated");

		private String status;

		private UserStatus(String status) {
			this.status = status;
		}

		public String value() {
			return this.status;
		}
	}

	public enum DeliveryStatus {
		DELIVERED("Delivered"), ON_THE_WAY("On the Way"), PENDING("Pending"), PROCESSING("Processing");

		private String status;

		private DeliveryStatus(String status) {
			this.status = status;
		}

		public String value() {
			return this.status;
		}

	}

	public enum DeliveryTime {
		MORNING("Morning"), AFTERNOON("Afternoon"), EVENING("Evening"), NIGHT("Night"), DEFAULT("");

		private String time;

		private DeliveryTime(String time) {
			this.time = time;
		}

		public String value() {
			return this.time;
		}

	}

	public enum CategoryStatus {
		ACTIVE("Active"), DEACTIVATED("Deactivated");

		private String status;

		private CategoryStatus(String status) {
			this.status = status;
		}

		public String value() {
			return this.status;
		}
	}

	public enum ProductStatus {
		AVAILABLE("Available"), DEACTIVATED("Deactivated"), SOLD("Sold"), UNSOLD("UnSold");

		private String status;

		private ProductStatus(String status) {
			this.status = status;
		}

		
		public String value() {
			return this.status;
		}
	}

	public enum ProductOfferStatus {
		ACTIVE("Active"), CANCELLED("Cancelled"), WIN("Win"), LOSE("Lose");

		private String status;

		private ProductOfferStatus(String status) {
			this.status = status;
		}

		public String value() {
			return this.status;
		}
	}

}
