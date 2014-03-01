package controllers;

import play.*;
import play.mvc.*;

import views.html.landing;

public class LandingController extends Controller {
    public static Result index() {
        return ok(landing.render());
    }
}
