package controllers;

import play.mvc.*;

import views.html.landing;

public class LandingController extends Controller {
    public static Result index() {
        session().clear();
        
    	return ok(landing.render());
    }
}
