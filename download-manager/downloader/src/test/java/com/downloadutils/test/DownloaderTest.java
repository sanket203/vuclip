package com.downloadutils.test;



import static org.junit.Assert.*;

import org.junit.Test;

import com.downloadutils.downloader.Downloader;

public class DownloaderTest {
	
	@Test()
	    public void startDownloadNullTestBothParamtersNull(){
	        Downloader downloader = new Downloader();
	        assertNotNull(downloader.startDownlaod(null,null));
	        
	    }
	
	@Test()
    public void startDownloadNullTestURLNull(){
        Downloader downloader = new Downloader();
        assertNotNull(downloader.startDownlaod(null,"http://www.colorado.edu/conflict/peace/download/peace_essay.ZIP"));
        
    }
	
	@Test()
    public void startDownloadNullTestDownloadLocationNull(){
        Downloader downloader = new Downloader();
        assertNotNull(downloader.startDownlaod("http://www.colorado.edu/conflict/peace/download/peace_essay.ZIP",null));
        
    }
	 
	 @Test()
	    public void startDownloadTestValidParameters(){
	        Downloader downloader = new Downloader();
	       downloader.startDownlaod("http://www.colorado.edu/conflict/peace/download/peace_essay.ZIP","D:\\docs");
	    }
	 
	 @Test()
	    public void testUrlValid(){
	        Downloader downloader = new Downloader();
	        String url = "http://www.colorado.edu/conflict/peace/download/peace_essay.ZIP";
	        
	      assertTrue(downloader.verifyURL(url));
	    }
	 @Test()
	    public void testUrlInValidForHttp(){
	        Downloader downloader = new Downloader();
	        String url = "https://ww.colorado.edu/conflict/peace/download/peace_essay.ZIP";
	        
	      assertFalse(downloader.verifyURL(url));
	    }
	 
	 
	 
	 
	 
	 
	 

}
