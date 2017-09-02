package com.downloadutils.downloadrunner;

import com.downloadutils.downloader.BaseDownloader;
import com.downloadutils.downloader.Downloader;

public class DownloadManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args[0].equalsIgnoreCase("download")) {
			BaseDownloader manager = new Downloader();

			String status = null;
			try {
				status = manager.downlaod(args[1], args[2]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			System.out.println(status);
		} else {
			System.out.println("please enter a valid commmand to download");
			System.exit(1);
		}

	}

}
