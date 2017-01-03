package com.mehmetzahit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by GUNEY on 16.12.2016.
 */
@Entity(name = "MESSAGE")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    private long messageId;

    @Column(name = "MESSAGE")
    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MESSAGE_SEND_TIME")
    private Date messageSendTime;

    @Column(name = "SENDER_MEMBER_ID")
    private long senderMemberId;

    @Column(name = "RECEIVER_MEMBER_ID")
    private long receiverMemberId;


    @ManyToOne()
    @JoinColumn(name = "FK_ADVERTISEMENT_ID",referencedColumnName = "ADVERTISEMENT_ID")
    private Advertisement advertisement;


    public Message() {
    }

    public Message(long senderMemberId, long receiverMemberId, long advertisement) {
        this.senderMemberId = senderMemberId;
        this.receiverMemberId = receiverMemberId;
        this.advertisement=new Advertisement(advertisement);

    }


    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessageSendTime() {
        return messageSendTime;
    }

    public void setMessageSendTime(Date messageSendTime) {
        this.messageSendTime = messageSendTime;
    }

    public long getSenderMemberId() {
        return senderMemberId;
    }

    public void setSenderMemberId(long senderMemberId) {
        this.senderMemberId = senderMemberId;
    }

    public long getReceiverMemberId() {
        return receiverMemberId;
    }

    public void setReceiverMemberId(long receiverMemberId) {
        this.receiverMemberId = receiverMemberId;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", message='" + message + '\'' +
                ", messageSendTime=" + messageSendTime +
                ", senderMemberId=" + senderMemberId +
                ", receiverMemberId=" + receiverMemberId +
                ", advertisement=" + advertisement +
                '}';
    }
}
