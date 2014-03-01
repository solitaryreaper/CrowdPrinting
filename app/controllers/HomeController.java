package controllers;

import static play.data.Form.form;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.home;
import views.html.marketplace;
import views.html.purchase;


public class HomeController extends Controller
{
	private static String mUsername = ""; 
	private static String mPassword= "";
	
	public static Result goToHome()
	{
		DynamicForm dynamicForm = form().bindFromRequest();
		mUsername = dynamicForm.get("username");
		mPassword = dynamicForm.get("password");
		
		session("user", mUsername);

		return ok(home.render(mUsername));//home.render());
	}

	public static Result goToPurchase()
	{
		return ok(purchase.render());
	}
	
	public static Result goToMarketPlace()
	{
		return ok(marketplace.render());
	}
	
	public static Result goToAccountInfo()
	{
		session("user", mUsername);

		return ok(home.render(mUsername));//home.render());
	}
}
