package kpu.computer.jwshin.domain.payment;

public class PaymentVO {
	private int payment_id;
	private String userid;
	private String product_name;
	private int product_amount;
	private int payment_amount;
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_amount() {
		return product_amount;
	}
	public void setProduct_amount(int product_amount) {
		this.product_amount = product_amount;
	}
	public int getPayment_amount() {
		return payment_amount;
	}
	public void setPayment_amount(int payment_amount) {
		this.payment_amount = payment_amount;
	}
	@Override
	public String toString() {
		return "PaymentVO [payment_id=" + payment_id + ", userid=" + userid + ", product_name=" + product_name
				+ ", product_amount=" + product_amount + ", payment_amount=" + payment_amount + "]";
	}
	
}
