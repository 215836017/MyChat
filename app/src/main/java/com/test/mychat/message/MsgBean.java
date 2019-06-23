package com.test.mychat.message;

public class MsgBean {

    private boolean isSendMsg;
    private int msgType;
    private String msgTitle;
    private String msgContent;
    private String imageTitleUrl;
    private String msgTime;
    private int msgActionType;

    public MsgBean(boolean isSendMsg, int msgType, String msgTitle, String msgContent,
                   String imageTitleUrl, String msgTime, int msgActionType) {
        this.isSendMsg = isSendMsg;
        this.msgType = msgType;
        this.msgTitle = msgTitle;
        this.msgContent = msgContent;
        this.imageTitleUrl = imageTitleUrl;
        this.msgTime = msgTime;
        this.msgActionType = msgActionType;
    }

    public boolean isSendMsg() {
        return isSendMsg;
    }

    public void setSendMsg(boolean sendMsg) {
        isSendMsg = sendMsg;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getImageTitleUrl() {
        return imageTitleUrl;
    }

    public void setImageTitleUrl(String imageTitleUrl) {
        this.imageTitleUrl = imageTitleUrl;
    }

    public String getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }

    public int getMsgActionType() {
        return msgActionType;
    }

    public void setMsgActionType(int msgActionType) {
        this.msgActionType = msgActionType;
    }

    @Override
    public String toString() {
        return "MsgBean{" +
                "isSendMsg=" + isSendMsg +
                ", msgType=" + msgType +
                ", msgTitle='" + msgTitle + '\'' +
                ", msgContent='" + msgContent + '\'' +
                ", imageTitleUrl='" + imageTitleUrl + '\'' +
                ", msgTime='" + msgTime + '\'' +
                ", msgActionType=" + msgActionType +
                '}';
    }
}
