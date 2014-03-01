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
	private static String mPassword = null;
	public static Result getPrinterInfo()
	{
		DynamicForm dynamicForm = form().bindFromRequest();
		mEmail = dynamicForm.get("email");
		mPassword = dynamicForm.get("password");
		session("email", mEmail);
		session("password", mPassword);
		Logger.info(dynamicForm.get("email"));
				
		return ok(join_printerinfo_form.render());
	}
	
	public static Result getPaymentInfo()
	{
//		DynamicForm dynamicForm = form().bindFromRequest();
//		mbp_b_str = dynamicForm.get("mbp_b"); 
//		mbp_w_str = dynamicForm.get("mbp_w"); 
//		mbp_h_str = dynamicForm.get("mbp_h"); 
//		model = dynamicForm.get("printer_model"); 
//		resolution = dynamicForm.get("printer_resolution"); 
//		
//		session("mbp_b", mbp_b_str);
//		session("mbp_w", mbp_w_str);
//		session("mbp_h", mbp_h_str);
//		session("model", model);
//		session("resolution", resolution);
		
		Logger.info("GETPAYMENTINFO PRAKHAR");
		
		return ok(join_paymentinfo_form.render());
	}
	
	public static Result downloadTestFile()
	{
		return ok(join_downloadtestfile_form.render());
	}
	
}
