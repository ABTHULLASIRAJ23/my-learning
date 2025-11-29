package org.entity;

import java.util.Date;

public class POJO_payment {
	    private int paymentId;
	    private int tenantId;
	    private double amount;
	    private String status;  // e.g. "Paid", "Pending"
	    private Date paymentDate;

	    public POJO_payment(int paymentId, int tenantId, double amount, String status, Date paymentDate) {
	        this.paymentId = paymentId;
	        this.tenantId = tenantId;
	        this.amount = amount;
	        this.status = status;
	        this.paymentDate = paymentDate;
	    }

		public int getPaymentId() {
			return paymentId;
		}

		public void setPaymentId(int paymentId) {
			this.paymentId = paymentId;
		}

		public int getTenantId() {
			return tenantId;
		}

		public void setTenantId(int tenantId) {
			this.tenantId = tenantId;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Date getPaymentDate() {
			return paymentDate;
		}

		public void setPaymentDate(Date paymentDate) {
			this.paymentDate = paymentDate;
		}

}
