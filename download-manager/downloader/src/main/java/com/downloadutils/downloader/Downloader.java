package com.downloadutils.downloader;

import com.downloadutils.exception.BaseException;

public class Downloader extends BaseDownloader {

	public String downlaod(String url, String location) throws BaseException{
		String status = null;

		DownloadService service = new DownloadService();
		status = service.startDownlaod(url, location);

		return status;
	}

}
