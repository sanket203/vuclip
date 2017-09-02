package com.downloadutils.commons;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import com.downloadutils.exception.BaseException;

public class Utils {
	
	private Utils(){
		
	}

	/**
	 * Verify whether an URL is valid
	 * 
	 * @param fileURL
	 * @return the verified URL, null if invalid
	 * @throws MalformedURLException 
	 * 
	 **/
	public static URL validateUrl(String url) throws BaseException {
		URL fileUrl = null;
		if (!(url == null || url.isEmpty())) {

			if (!url.toLowerCase().startsWith("http://")) {
				throw new BaseException("Error Occured!!Invalid URL");
			}
			try {
				fileUrl = new URL(url);
			} catch (MalformedURLException e) {
				throw new BaseException(e.getMessage());
			}

			if (fileUrl.getFile().length() < 2) {
				throw new BaseException("Error Ocurred!!Invalid URL");
			}
		} else {
			throw new BaseException("URL can not be empty");
		}
		return fileUrl;

	}

	public static void validateDownloadLocation(String downloadLocation) throws BaseException {
		
		if (downloadLocation == null || downloadLocation.isEmpty()) {
			throw new BaseException("Download Location can not be empty");
			
		}

	}
	
	/**
	 * To create the file path from provide downloadLocation and fileName
	 * 
	 * @param url
	 * @param downloadLocation
	 * @return
	 */

	public static String getDownloadFilePath(URL url, String location) {
		String filePath = "";
		String fileName = url.getFile();
		fileName = fileName.substring(fileName.lastIndexOf('/') + 1);
		filePath = location + "/" + fileName;
		return filePath;

	}

	/**
	 * To check if file already exists at given location
	 * 
	 * @return fileSize
	 */

	public static long checkIfFileExists(String completeFilePath) {
		File file = new File(completeFilePath);
		if (file.exists() && file.isFile()) {
			return file.length();
		}
		return 0;
	}

}
