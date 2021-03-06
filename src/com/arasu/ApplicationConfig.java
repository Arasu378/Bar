package com.arasu;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

public class ApplicationConfig extends Application {

	 @Override
	    public Set<Class<?>> getClasses() {
	        final Set<Class<?>> classes = new HashSet<Class<?>>();
	        // register resources and features
	        classes.add(MultiPartFeature.class);
	        classes.add(TestingImageMultipart.class);
	        classes.add(LoggingFilter.class);
	        return classes;
	    }
}
