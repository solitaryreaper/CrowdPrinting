package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class UploadController extends Controller{
    public static Result upload() {
        return ok("Inside upload form page ..");
    }
}
