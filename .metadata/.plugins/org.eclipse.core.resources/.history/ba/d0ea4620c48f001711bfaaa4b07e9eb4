package com.downloadutils.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.downloadutils.downloader.DownloadService;
import com.downloadutils.exception.BaseException;

public class DownloaderTest {

	@Test
	public void downlaodForValidParameters() throws BaseException {

		String url = "http://www.colorado.edu/conflict/peace/download/peace_essay.ZIP";
		String location = "D:\\docs";

		DownloadService service = new DownloadService();
		String status = service.startDownlaod(url, location);
		assertEquals(status, "Download Successfull.");

	}

	@Test(expected = Exception.class)
	public void downlaodForInValidUrlParameter() throws BaseException {

		String url = "https://www.colorado.edu/conflict/peace/download/peace_essay";
		String location = "D:\\docs";

		DownloadService service = new DownloadService();
		service.startDownlaod(url, location);

	}

	@Test(expected = Exception.class)
	public void downlaodForNullUrlParameter() throws BaseException {

		String url = null;
		String location = "D:\\docs";

		DownloadService service = new DownloadService();
		service.startDownlaod(url, location);

	}

	@Test(expected = Exception.class)
	public void downlaodForNullLocationParameter() throws BaseException {

		String url = "http://www.colorado.edu/conflict/peace/download/peace_essay.ZIP";
		String location = null;

		DownloadService service = new DownloadService();
		service.startDownlaod(url, location);

	}

	@Test(expected = Exception.class)
	public void downlaodForNullParameters() throws BaseException {

		String url = null;
		String location = null;

		DownloadService service = new DownloadService();
		service.startDownlaod(url, location);

	}
}
