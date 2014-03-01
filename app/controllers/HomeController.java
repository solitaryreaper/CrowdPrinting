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
//	private static String mUsername = ""; 
	private static String mEmail = null;
	private static String mPassword= null;
	
	public static Result goToHome()
	{
		if(session().containsKey("email")) {
			mEmail = session().get("email");
		}
		
//		if(mEmail == null)
//		{
//			DynamicForm dynamicForm = form().bindFromRequest();
//	//		mUsername = dynamicForm.get("username");
//			mEmail = dynamicForm.get("email");
//			mPassword = dynamicForm.get("password");
//			
//	//		session("user", mUsername);
//			session("email", mEmail);
//		}

		return ok(home.render(mEmail));//home.render());
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
//		session("user", mUsername);
		if(session().containsKey("email")) {
			mEmail = session().get("email");
		}

		return ok(home.render(mEmail));//home.render());
	}
}
