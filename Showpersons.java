package com.gooapp.Gdatastore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class Showpersons extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

		

		Query query = new Query("person");
		PreparedQuery pq = ds.prepare(query);

		for (Entity entity : pq.asIterable())

		{
			response.getWriter().println(entity.getProperty("name"));
			response.getWriter().println(entity.getProperty("password"));
		}

	}
}
