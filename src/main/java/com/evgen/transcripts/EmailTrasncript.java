package com.evgen.transcripts;

import java.util.List;

public class EmailTrasncript {

    private String direction;
    private Long customerId;
    private Long contactId;
    private String workRequestId;
    private String mailFrom;

    private List<String> mailTo = null;
    private List<String> mailCC = null;
    private List<String> mailBCC = null;
    private String subject;
    private Long timestamp;
    private List<String> attachments = null;
    private String bodyEmail;
    private String messageId;

    /**
     * Empty constructor for Json
     */
/*    public EmailTranscript(){
    }*/

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getWorkRequestId() {
        return workRequestId;
    }

    public void setWorkRequestId(String workRequestId) {
        this.workRequestId = workRequestId;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public List<String> getMailTo() {
        return mailTo;
    }

    public void setMailTo(List<String> mailTo) {
        this.mailTo = mailTo;
    }

    public List<String> getMailCC() {
        return mailCC;
    }

    public void setMailCC(List<String> mailCC) {
        this.mailCC = mailCC;
    }

    public List<String> getMailBCC() {
        return mailBCC;
    }

    public void setMailBCC(List<String> mailBCC) {
        this.mailBCC = mailBCC;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    public String getBodyEmail() {
        return bodyEmail;
    }

    public void setBodyEmail(String bodyEmail) {
        this.bodyEmail = bodyEmail;
    }

    @Override
    public String toString() {
        return "EmailTranscript{" +
                "direction='" + direction + '\'' +
                ", customerId=" + customerId +
                ", contactId=" + contactId +
                ", workRequestId='" + workRequestId + '\'' +
                ", mailFrom='" + mailFrom + '\'' +
                ", mailTo=" + mailTo +
                ", mailCC=" + mailCC +
                ", mailBCC=" + mailBCC +
                ", subject='" + subject + '\'' +
                ", timestamp=" + timestamp +
                ", attachments=" + attachments +
                ", bodyEmail=*****}";
    }

    /**
     * @return the messageId
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * @param messageId the messageId to set
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
