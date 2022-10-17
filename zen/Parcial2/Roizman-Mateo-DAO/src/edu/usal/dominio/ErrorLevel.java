package edu.usal.dominio;

public class ErrorLevel {
	private final boolean success;
	private final String message;
	private final String redirect;

	public ErrorLevel(boolean success, String message, String redirect) {
		this.success = success;
		this.message = message;
		this.redirect = redirect;
	}

	public ErrorLevel(String message, String redirect) {
		this(true, message, redirect);
	}

	public ErrorLevel(boolean success, String message) {
		this(success, message, "");
	}

	public ErrorLevel(String message) {
		this(true, message, "");
	}

	public ErrorLevel(boolean success) {
		this(success, "", "");
	}

	public ErrorLevel() {
		this(true, "", "");
	}

	public String getPayload() {
		return this.message;
	}

	public String getRedirect() {
		return this.redirect;
	}

	public boolean isError() {
		return !this.success;
	}
}
