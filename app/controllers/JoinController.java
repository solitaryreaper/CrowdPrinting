package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.join_form;

public class JoinController extends Controller
{
	public static Result createID()
	{
		return ok(join_form.render());//"Inside Join page");
	}
}
