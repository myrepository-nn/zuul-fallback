package com.nishant.zuul.apigateway.utils;

public class Constants {

	public static final String FALLBACK = "fallback";
	public static final String OK = "OK";
	public static final int _200 = 200;

	//Type of request
	public static final String GET = "get";
	public static final String POST = "post";

	public static final String STRING_EMPTY = "";
	public static final String STRING = "/";
	public static final String STRING_DOT_SPACE = ".......";

	//Different filter sysout or logger
	public static final String POST_FILTER_EXECUTED = "............post filter executed.........";
	public static final String PRE_FILTER_EXECUTED = "............pre filter executed.........";
	public static final String ROUTE_FILTER_EXECUTED = "............route filter executed.........";
	public static final String ERROR_FILTER_EXECUTED = "............error filter executed.........";

	//Type of filter
	public static final String ERROR = "error";
	public static final String ROUTE = "route";
	public static final String PRE = "pre";
	public static final String IS_DOWN_PLEASE_CONTACT_ADMIN = " is down.Please contact admin.";

}
