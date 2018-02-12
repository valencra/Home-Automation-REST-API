package com.valencra.homeautomation.room;

import com.valencra.homeautomation.core.BaseEntity;
import com.valencra.homeautomation.device.Device;
import com.valencra.homeautomation.user.User;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Room extends BaseEntity {
  @NotNull
  private String name;
  @NotNull
  @Max(value = 999, message = "Area must be less that 1000 sq. ft./ sq. m.")
  private int area;
  @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
  private List<Device> devices;
  @ManyToMany
  private List<User> administrators;

  protected Room() {
    super();
    devices = new ArrayList<>();
    administrators = new ArrayList<>();
  }

  public Room(String name, int area) {
    this();
    this.name = name;
    this.area = area;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getArea() {
    return area;
  }

  public void setArea(int area) {
    this.area = area;
  }

  public List<Device> getDevices() {
    return devices;
  }

  public void addDevice(Device device) {
    device.setRoom(this);
    devices.add(device);
  }

  public List<User> getAdministrators() {
    return administrators;
  }

  public void addAdministrator(User administrator) {
    administrators.add(administrator);
  }
}
