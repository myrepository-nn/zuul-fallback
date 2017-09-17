package com.nishant.zuul.apigateway.filters;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.nishant.zuul.apigateway.utils.Constants;

public class PreFilter extends ZuulFilter {


	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext context=RequestContext.getCurrentContext();
		HttpServletRequest req=context.getRequest();
		if(req.getMethod().equalsIgnoreCase(Constants.POST)) {
			try {
				System.out.println(Constants.PRE_FILTER_EXECUTED+req.getRequestURI()+Constants.STRING_DOT_SPACE+((req.getContentLength()>0)?IOUtils.toString(req.getReader()):""));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(req.getMethod().equalsIgnoreCase(Constants.GET)) {
			System.out.println(Constants.PRE_FILTER_EXECUTED+req.getRequestURI());
		}
		return null;
	}

	@Override
	public String filterType() {
		return Constants.PRE;
	}

	@Override
	public int filterOrder() {
		return 4;
	}

}
