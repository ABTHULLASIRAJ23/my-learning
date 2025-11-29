package org.entity;

import java.util.Date;

public class POJO_support {
	private int messageId;
    private int tenantId;
    private String subject;
    private String message;
    private Date sentAt;
    
    public POJO_support(int messageId,int tenantId,String subject,String message,Date sentAt) {
    	this.messageId = messageId;
        this.tenantId = tenantId;
        this.subject = subject;
        this.message = message;
        this.sentAt = sentAt;
    }

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getSentAt() {
		return sentAt;
	}

	public void setSentAt(Date sentAt) {
		this.sentAt = sentAt;
	}
    
}
