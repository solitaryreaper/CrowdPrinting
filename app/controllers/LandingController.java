package controllers;

import play.*;
import play.mvc.*;

public class LandingController extends Controller {
    public static Result index() {
        return ok("Welcome to Crowd Printing - 3d printing redfined !!");
    }
}
