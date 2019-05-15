package com.mcommerce.zuulserver.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class LogFilter extends ZuulFilter {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		// Pour les vérifications; savoir si il s'agit d'une requête à filtrer
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
		log.info("*** Requête interceptée " +req.getRequestURL());
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		//Définir le moment où le filtre sera exécuter (pre ou post)
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		// Ordre d'éxécution du filtre
		return 1;
	}

}
