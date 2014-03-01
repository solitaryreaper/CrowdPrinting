package controllers;

import models.service.LoginService;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.home;
import views.html.marketplace;
import views.html.purchase;

public class HomeController extends Controller
{
	// private static String mUsername = "";
	private static String mEmail = null;
	private static String mPassword = null;

	public static Result goToHome()
	{
		if(session().containsKey("email"))
		{
			mEmail = session().get("email");
			mPassword = session().get("password");
		}
		else {
			return unauthorized("Oops, you are not connected");
		}
		
		boolean doesLoginExist = LoginService.doesLoginAlreadyExist(mEmail);
		if(doesLoginExist) {
			boolean isLoginSuccess = LoginService.verifyLogin(mEmail, mPassword);
			if(isLoginSuccess) {
				session("email", mEmail);
				return ok(home.render(mEmail));			
			}
			else {
				return unauthorized("Oops, you are not connected");
			}			
		}
		else {
			LoginService.createLogin(mEmail, mPassword);
			session("email", mEmail);
			return ok(home.render(mEmail));			
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
		// session("user", mUsername);
		if (session().containsKey("email"))
		{
			mEmail = session().get("email");
		}

		return ok(home.render(mEmail));// home.render());
	}
}
