package controllers;

import models.service.JobService;
import play.Logger;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.upload_form_step1;
import views.html.upload_form_step2;
import views.html.upload_form_step3;
import static play.data.Form.form;

public class UploadController extends Controller{
	
    public static Result uploadStep1() {
        return ok(upload_form_step1.render());
    }
    
    public static Result uploadStep2() {
		DynamicForm dynamicForm = form().bindFromRequest();
		String email = dynamicForm.get("email");
		String zip = dynamicForm.get("zip");
		int quantity = Integer.parseInt(dynamicForm.get("quantity"));
		String filePath = dynamicForm.get("file_path");
		
		session("quantity", dynamicForm.get("quantity"));
		
		Logger.info("Email : " + email);
		session("user", email);
		
        return ok(upload_form_step2.render());
    }    
    
    public static Result uploadStep3() {
		DynamicForm dynamicForm = form().bindFromRequest();
		String material = dynamicForm.get("materials");
		String color = dynamicForm.get("colors");
		String resolution = dynamicForm.get("resolution");
		String comment = dynamicForm.get("comments");
		
		int quantity = 20;
		if(session().containsKey("quantity")) {
			quantity = Integer.parseInt(session().get("quantity"));
		}
		
		String email = session().get("user");
		int jobId = JobService.insertJob(email, material, color, "/tmp", quantity);
		
		Logger.info("Job Id : " + jobId);
		
        return ok(upload_form_step3.render(material, color, resolution, comment, jobId, quantity));
    }       
}
