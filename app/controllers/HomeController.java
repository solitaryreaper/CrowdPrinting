package controllers;

import static play.data.Form.form;
import models.service.LoginService;
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
		
		boolean doesLoginExist = LoginService.doesLoginAlreadyExist(mUsername);
		if(doesLoginExist) {
			boolean isLoginSuccess = LoginService.verifyLogin(mUsername, mPassword);
			if(isLoginSuccess) {
				session("user", mUsername);
				return ok(home.render(mUsername));			
			}
			else {
				return unauthorized("Oops, you are not connected");
			}			
		}
		else {
			LoginService.createLogin(mUsername, mPassword);
			session("user", mUsername);
			return ok(home.render(mUsername));			
		}

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
