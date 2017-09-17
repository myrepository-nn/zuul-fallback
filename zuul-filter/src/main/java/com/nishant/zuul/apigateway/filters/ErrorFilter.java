package com.nishant.zuul.apigateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.nishant.zuul.apigateway.utils.Constants;

public class ErrorFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		System.out.println(Constants.ERROR_FILTER_EXECUTED+RequestContext.getCurrentContext().getRequest().getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		return Constants.ERROR;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
