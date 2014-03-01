package controllers;

import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.home;
import static play.data.Form.form;


public class HomeController extends Controller
{

	public static Result goToHome()
	{
		DynamicForm dynamicForm = form().bindFromRequest();
		String username = dynamicForm.get("username");
		String password = dynamicForm.get("password");
		
		session("user", username);

		return ok(home.render());//home.render());
	}

}
