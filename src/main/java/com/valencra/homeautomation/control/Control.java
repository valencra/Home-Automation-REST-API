package com.valencra.homeautomation.control;

import com.valencra.homeautomation.core.BaseEntity;
import com.valencra.homeautomation.device.Device;
import com.valencra.homeautomation.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Control extends BaseEntity {
  @NotNull
  private String name;
  @ManyToOne
  private Device device;
  @NotNull
  private int value;
  @ManyToOne
  private User lastModifiedBy;

  protected Control() {
    super();
  }

  public Control(String name, int value) {
    this();
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Device getDevice() {
    return device;
  }

  public void setDevice(Device device) {
    this.device = device;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public User getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setLastModifiedBy(User lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }
}
