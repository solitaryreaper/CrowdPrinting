package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.login_form;

public class LoginController extends Controller
{
	public static Result login()
	{
		return ok(login_form.render());
	}
	
	public static Result logout()
	{
		session().clear();

		// Redirect the user to login page
		return redirect("/");
	}
}
