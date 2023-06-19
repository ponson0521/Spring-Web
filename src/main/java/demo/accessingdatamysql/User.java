package demo.accessingdatamysql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String account;
  private String password;
  private String extaccount;
  private String extpwd;
  private String name;
  private String sex;
  private String email;
  private String phone;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getPwd() {
    return password;
  }

  public void setPwd(String password) {
    this.password = password;
  }

  public String getExtAccount() {
    return extaccount;
  }

  public void setExtAccount(String extaccount) {
    this.extaccount = extaccount;
  }

  public String getExtPwd() {
    return extpwd;
  }

  public void setExtPwd(String extpwd) {
    this.extpwd = extpwd;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
