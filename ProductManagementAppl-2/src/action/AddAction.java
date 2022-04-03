package action;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport; 

import dao.LoginDAO;
import dao.ProductManagementDAO;
import pojo.LoginInfo;
import pojo.Product;

public class AddAction extends ActionSupport{

	private String productId;
	private String productName;
	private String productCategory;
	private Integer productPrice;
	
	public String execute() {
		String statusCode = "";
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		String createdDateStr = formatter.format(new Date());
		Product product = new Product(productId, productName, productCategory, productPrice, createdDateStr);
		int recordAdded = ProductManagementDAO.addProduct(product);
		if (recordAdded == 1) {
			statusCode = "success";
		} else {
			statusCode = "error";
		}
		return statusCode;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	
}
