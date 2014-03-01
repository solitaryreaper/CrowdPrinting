package controllers;

import static play.data.Form.form;
import play.Logger;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.join_form;
import views.html.join_printerinfo_form;
import views.html.join_paymentinfo_form;
import views.html.join_downloadtestfile_form;

public class JoinController extends Controller
{
	public static Result getPersonalInfo()
	{
		return ok(join_form.render());
	}
	
	private static String mEmail = null;
	public static Result getPrinterInfo()
	{
		DynamicForm dynamicForm = form().bindFromRequest();
		mEmail = dynamicForm.get("email");
		session("email", mEmail);
				
		return ok(join_printerinfo_form.render());
	}
	
	public static Result getPaymentInfo()
	{
		Logger.info("GETPAYMENTINFO PRAKHAR");
		
		return ok(join_paymentinfo_form.render());
	}
	
	public static Result downloadTestFile()
	{
		return ok(join_downloadtestfile_form.render());
	}
	
}
