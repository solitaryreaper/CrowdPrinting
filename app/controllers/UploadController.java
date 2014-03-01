package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.upload_form_step1;
import views.html.upload_form_step2;
import views.html.upload_form_step3;

public class UploadController extends Controller{
	
    public static Result uploadStep1() {
        return ok(upload_form_step1.render());
    }
    
    public static Result uploadStep2() {
        return ok(upload_form_step2.render());
    }    
    
    public static Result uploadStep3() {
        return ok(upload_form_step3.render());
    }       
}
