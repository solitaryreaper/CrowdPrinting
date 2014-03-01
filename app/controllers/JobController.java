package controllers;

import models.Job;
import models.service.JobService;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.quote;
import views.html.checkout_form;
import views.html.pay_form;

public class JobController extends Controller {

	public static Result job(int id)
	{
		Job job = JobService.getJobById(id);
		if(job == null) {
			return unauthorized("Oops, failed to find job id : " + id);
		}
		
		String user = session().get("email");
		
		int delivery = 7;
		int amount = 0;
		int quoteNum = 5545948;
		
		delivery = 4 + (int)(Math.random() * ((10 - 4) + 1));
		amount = 50 + (int)(Math.random() * ((100 - 50) + 1));
		quoteNum = 5545000 + (int)(Math.random() * ((5545948 - 5545000) + 1));
		
		return ok(quote.render(job.getId(), user, job.getMaterial(), job.getColor(), job.getQuantity(), quoteNum, amount, delivery));
	}
	
	public static Result checkout()
	{
		return ok(checkout_form.render());
	}
	
	public static Result pay()
	{
		return ok(pay_form.render());
	}
}
