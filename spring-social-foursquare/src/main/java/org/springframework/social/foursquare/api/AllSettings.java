package org.springframework.social.foursquare.api;

public class AllSettings {
	
	private boolean receivePings;
	private boolean receiveCommentPings;
	private boolean sendToTwitter;
	private boolean sendMayorshipsToTwitter;
	private boolean sendBadgesToTwitter;
	private boolean sendToFacebook;
	private boolean sendMayorshipsToFacebook;
	private boolean sendBadgesToFacebook;
	private String foreignConsent;
	
	public AllSettings(boolean receivePings, boolean receiveCommentPings, boolean sendToTwitter, 
			boolean sendMayorshipsToTwitter, boolean sendBadgesToTwitter, boolean sendToFacebook, 
			boolean sendMayorshipsToFacebook, boolean sendBadgesToFacebook, String foreignConsent) {
		this.receivePings = receivePings;
		this.receiveCommentPings = receiveCommentPings;
		this.sendToTwitter = sendToTwitter;
		this.sendMayorshipsToTwitter = sendMayorshipsToTwitter;
		this.sendBadgesToTwitter = sendBadgesToTwitter;
		this.sendToFacebook = sendToFacebook;
		this.sendMayorshipsToFacebook = sendMayorshipsToFacebook;
		this.sendBadgesToFacebook = sendBadgesToFacebook;
		this.foreignConsent = foreignConsent;
	}

	public boolean receivePings() {
		return receivePings;
	}

	public boolean receiveCommentPings() {
		return receiveCommentPings;
	}

	public boolean sendToTwitter() {
		return sendToTwitter;
	}

	public boolean sendMayorshipsToTwitter() {
		return sendMayorshipsToTwitter;
	}

	public boolean sendBadgesToTwitter() {
		return sendBadgesToTwitter;
	}

	public boolean sendToFacebook() {
		return sendToFacebook;
	}

	public boolean sendMayorshipsToFacebook() {
		return sendMayorshipsToFacebook;
	}

	public boolean sendBadgesToFacebook() {
		return sendBadgesToFacebook;
	}

	public String foreignConsent() {
		return foreignConsent;
	}
}
