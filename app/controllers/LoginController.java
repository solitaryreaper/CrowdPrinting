package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class LoginController extends Controller
{
	public static Result login()
	{
		return ok("Inside Login page ..");
	}
}
