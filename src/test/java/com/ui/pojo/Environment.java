package com.ui.pojo;

public class Environment {
	
	private String url;
	private int MAX_RETRY_ATTEMPTS;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public int getMAX_RETRY_ATTEMPTS() {
		return MAX_RETRY_ATTEMPTS;
	}

	public void setMAX_RETRY_ATTEMPTS(int mAX_RETRY_ATTEMPTS) {
		MAX_RETRY_ATTEMPTS = mAX_RETRY_ATTEMPTS;
	}
	
}
