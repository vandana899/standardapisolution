package Rest_Assured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class dummy_api {
	String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJlbWlseXMiLCJlbWFpbCI6ImVtaWx5LmpvaG5zb25AeC5kdW1teWpzb24uY29tIiwiZmlyc3ROYW1lIjoiRW1pbHkiLCJsYXN0TmFtZSI6IkpvaG5zb24iLCJnZW5kZXIiOiJmZW1hbGUiLCJpbWFnZSI6Imh0dHBzOi8vZHVtbXlqc29uLmNvbS9pY29uL2VtaWx5cy8xMjgiLCJpYXQiOjE3MTc0MjA5NDQsImV4cCI6MTcxNzQyNDU0NH0.vbj_dkg0w7VDiQ9eG6BYDEc0DnWt2Jbdr3x0N073yhg";
	@Test(enabled = false)
	public void Login_gettoken() {
		JSONObject obj = new JSONObject();

		obj.put("username", "emilys");
		obj.put("password", "emilyspass");

		given().header("Content-Type", "application/json")
				.body(obj.toJSONString()).when()
				.post("https://dummyjson.com/auth/login").then().statusCode(200).log()
				.all();

	}
	
	@Test(enabled = false)
	public void getauthenticateduser() {
		given().header("Authorization", "Bearer " + token).get("https://dummyjson.com/auth/me").then().statusCode(200).log().all();
	}
	
	
	@Test(enabled = false)
	public void refreshtoken() {
		
		JSONObject obj = new JSONObject();
		obj.put("expiresInMins", 30);
		given().header("Authorization", "Bearer " + token).body(obj.toJSONString()).when().post("https://dummyjson.com/auth/refresh").then().log().all();
	}
	
	
	@Test(enabled = true)
	public void getallorders() {
		given().get("https://dummyjson.com/products").then().statusCode(200).log().all();
	}
	
	
	@Test(enabled = true)
	public void getasingleproduct() {
		given().get("https://dummyjson.com/products/1").then().statusCode(200).log().all();
	}
	
	
	@Test(enabled = true)
	public void searchproducts() {
		given().get("https://dummyjson.com/products/search?q=phone").then().statusCode(200).log().all();
	}
	
	
	@Test(enabled = true)
	public void limitandskipproducts() {
		given().get("https://dummyjson.com/products?limit=10&skip=10&select=title,price").then().statusCode(200).log().all();
	}
	
	
	@Test(enabled = true)
	public void sortproducts() {
		given().get("https://dummyjson.com/products?sortBy=title&order=asc").then().statusCode(200).log().all();
	}
	
	
	@Test(enabled = true)
	public void getallproductcategories() {
		given().get("https://dummyjson.com/products/categories").then().statusCode(200).log().all();
	}
	
	
	@Test(enabled = true)
	public void getproductscategorylist() {
		given().get("https://dummyjson.com/products/category-list").then().statusCode(200).log().all();
	}
	
	
	@Test(enabled = true)
	public void getproductsbyacategory() {
		given().get("https://dummyjson.com/products/category/smartphones").then().statusCode(200).log().all();
	}
	
	
	@Test(enabled = true)
	public void add_a_product() {
		JSONObject obj = new JSONObject();
		obj.put("title", "BMW Pencil");
		given().header("Content-Type", "application/json")
		.body(obj.toJSONString()).when()
		.post("https://dummyjson.com/products/add").then().statusCode(201).log()
		.all();
	}
	
	
	@Test(enabled = true)
	public void update_product() {
		JSONObject obj = new JSONObject();
		obj.put("title", "iPhone Galaxy +1");
		given().header("Content-Type", "application/json")
		.body(obj.toJSONString()).when()
		.put("https://dummyjson.com/products/1").then().statusCode(200).log()
		.all();
	}
	
	
	@Test(enabled = true)
	public void delete_product() {
		given().delete("https://dummyjson.com/products/1").then().statusCode(200).log().all();
	}
	
}
