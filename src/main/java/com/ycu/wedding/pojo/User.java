package com.ycu.wedding.pojo;


public class User {

  private long id;
  private String userOpenid;
  private String userAvatar;
  private String userName;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUserOpenid() {
    return userOpenid;
  }

  public void setUserOpenid(String userOpenid) {
    this.userOpenid = userOpenid;
  }


  public String getUserAvatar() {
    return userAvatar;
  }

  public void setUserAvatar(String userAvatar) {
    this.userAvatar = userAvatar;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

}
