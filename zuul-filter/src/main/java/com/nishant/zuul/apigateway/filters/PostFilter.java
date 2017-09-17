package com.nishant.zuul.apigateway.filters;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.nishant.zuul.apigateway.utils.Constants;
import com.nishant.zuul.apigateway.vo.FallbackVO;

public class PostFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext context=RequestContext.getCurrentContext();
		HttpServletRequest req=context.getRequest();
		InputStream respStream=context.getResponseDataStream();
		String reqURI=req.getRequestURI();
		String reqURL=req.getRequestURL().toString();
		String resp=context.getResponseBody();
		String respFromStream = Constants.STRING_EMPTY;
		String reqBody = Constants.STRING_EMPTY;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			if(req.getContentLength()>0) {
				reqBody=IOUtils.toString(req.getReader());
			}else {
				reqBody=Constants.STRING_EMPTY;	
			}
			if(respStream!=null) {
				respFromStream=IOUtils.toString(respStream);
			}else {
				respFromStream=Constants.STRING_EMPTY;	
			}
			if(respFromStream.equalsIgnoreCase(Constants.FALLBACK)) {
				FallbackVO fallbackVO=new FallbackVO();
				fallbackVO.setClientID(reqURI.split(Constants.STRING)[2]);
				fallbackVO.setRequestedURL(reqURL);
				fallbackVO.setMessage(reqURI.split(Constants.STRING)[2]+Constants.IS_DOWN_PLEASE_CONTACT_ADMIN);
				String respToSend=objectMapper.writeValueAsString(fallbackVO);
				context.setResponseBody(respToSend);
			}else {
				context.setResponseBody(respFromStream);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(req.getMethod().equalsIgnoreCase(Constants.POST)) {
			System.out.println(Constants.POST_FILTER_EXECUTED+reqURI+Constants.STRING_DOT_SPACE+reqBody+Constants.STRING_DOT_SPACE+resp+Constants.STRING_DOT_SPACE+respFromStream);
		}
		if(req.getMethod().equalsIgnoreCase(Constants.GET)) {
			System.out.println(Constants.POST_FILTER_EXECUTED+reqURI+Constants.STRING_DOT_SPACE+resp+Constants.STRING_DOT_SPACE+respFromStream);
		}
		return null;
	}

	@Override
	public String filterType() {
		return Constants.POST;
	}

	@Override
	public int filterOrder() {
		return 2;
	}

}
