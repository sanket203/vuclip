package com.downloadutils.downloadrunner;

import com.downloadutils.downloader.Downloader;

public class DownloadManager {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args[0].equalsIgnoreCase("download")){
			Downloader manager = new Downloader();
			
			String status = manager.startDownlaod(args[1],args[2]);
		}else{
			System.out.println("please enter a valid commmand to download");
			System.exit(1);
		}

	}
	
}
