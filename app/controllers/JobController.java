package controllers;

import models.Job;
import models.service.JobService;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.quote;

public class JobController extends Controller {

	public static Result job(int id)
	{
		Job job = JobService.getJobById(id);
		if(job == null) {
			return unauthorized("Oops, failed to find job id : " + id);
		}
		
		String user = session().get("email");
		return ok(quote.render(job.getId(), user, job.getMaterial(), job.getColor(), job.getQuantity()));
	}
}
