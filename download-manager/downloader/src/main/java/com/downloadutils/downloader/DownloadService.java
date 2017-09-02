package com.downloadutils.downloader;

import static com.downloadutils.commons.Constants.BUFFER_SIZE;
import static com.downloadutils.commons.Constants.ERROR;
import static com.downloadutils.commons.Constants.SUCCESS;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import com.downloadutils.commons.Utils;
import com.downloadutils.exception.BaseException;

public class DownloadService implements Runnable {

	private URL fileUrl;
	private long fileSize;
	private String completeFilePath;
	String status = "";

	public String startDownlaod(String url, String downloadLocation) throws BaseException {
		Thread downloadThread;

		fileUrl = Utils.validateUrl(url);
		Utils.validateDownloadLocation(downloadLocation);
		completeFilePath = Utils.getDownloadFilePath(fileUrl, downloadLocation);
		fileSize = Utils.checkIfFileExists(completeFilePath);
		downloadThread = new Thread(this);
		downloadThread.start();
		try {
			downloadThread.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new BaseException(e.getMessage());

		}

		return status;

	}

	public void run() {
		BufferedInputStream in = null;
		RandomAccessFile raf = null;

		try {

			long startByte = fileSize;
			HttpURLConnection connection = (HttpURLConnection) fileUrl.openConnection();
			connection.setConnectTimeout(10000);
			connection.setRequestProperty("Range", "bytes=" + startByte + "-");
			connection.connect();
			if (connection.getResponseCode() / 100 != 2) {
				throw new BaseException(
						"Error occured!! Connection ended with response code :" + connection.getResponseCode());
			}
			int contentLength = connection.getContentLength();
			if (contentLength < 1) {
				throw new BaseException("Error occcured!!: No file present at given URL");
			}
			fileSize = contentLength;
			System.out.println("Remaining File size: " + fileSize);
			raf = new RandomAccessFile(completeFilePath, "rw");
			in = new BufferedInputStream(connection.getInputStream());
			raf.seek(startByte);
			byte[] buffer;
			if (fileSize - startByte > BUFFER_SIZE) {
				buffer = new byte[BUFFER_SIZE];
			} else {
				buffer = new byte[(int) (fileSize)];
			}
			int numRead = -1;
			int downloaded = 0;
			while ((numRead = in.read(buffer)) != -1) {

				raf.write(buffer, 0, numRead);
				downloaded += numRead;
				String data = "\r" + downloaded + "/" + fileSize + " Downloaded";
				System.out.write(data.getBytes());

				if (downloaded == fileSize) {
					System.out.println();
					status = SUCCESS;

				}
			}

		} catch (Exception e) {

			status = ERROR;
			System.out.println(e.getMessage());
		} finally {
			if (in != null && raf != null) {
				try {
					in.close();
					raf.close();
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		}

	}

}
