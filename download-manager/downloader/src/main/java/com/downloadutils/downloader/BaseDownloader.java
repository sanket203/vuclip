package com.downloadutils.downloader;

import com.downloadutils.exception.BaseException;

public abstract class BaseDownloader {
	
	public abstract String downlaod(String url,String location) throws BaseException;
	 
}
