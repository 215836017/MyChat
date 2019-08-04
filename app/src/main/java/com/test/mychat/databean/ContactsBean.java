package com.test.mychat.databean;

public class ContactsBean {

    private int contactsId;
    private String headPortraitPath;
    private String contactsName;
    private String pingYin;
    private boolean isLetter;

    public ContactsBean(int contactsId, String headPortraitPath, String contactsName, String pingYin, boolean isLetter) {
        this.contactsId = contactsId;
        this.headPortraitPath = headPortraitPath;
        this.contactsName = contactsName;
        this.pingYin = pingYin;
        this.isLetter = isLetter;
    }

    public int getContactsId() {
        return contactsId;
    }

    public void setContactsId(int contactsId) {
        this.contactsId = contactsId;
    }

    public String getHeadPortraitPath() {
        return headPortraitPath;
    }

    public void setHeadPortraitPath(String headPortraitPath) {
        this.headPortraitPath = headPortraitPath;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public String getPingYin() {
        return pingYin;
    }

    public void setPingYin(String pingYin) {
        this.pingYin = pingYin;
    }

    public boolean isLetter() {
        return isLetter;
    }

    public void setLetter(boolean letter) {
        isLetter = letter;
    }

    @Override
    public String toString() {
        return "ContactsBean{" +
                "contactsId=" + contactsId +
                ", headPortraitPath='" + headPortraitPath + '\'' +
                ", contactsName='" + contactsName + '\'' +
                ", pingYin='" + pingYin + '\'' +
                ", isLetter=" + isLetter +
                '}';
    }
}
