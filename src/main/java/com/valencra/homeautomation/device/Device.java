package com.valencra.homeautomation.device;

import com.valencra.homeautomation.control.Control;
import com.valencra.homeautomation.core.BaseEntity;
import com.valencra.homeautomation.room.Room;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Device extends BaseEntity {
  @NotNull
  private String name;
  @ManyToOne
  private Room room;
  @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
  private List<Control> controls;

  protected Device() {
    super();
    controls = new ArrayList<>();
  }

  public Device(String name) {
    this();
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public List<Control> getControls() {
    return controls;
  }

  public void addControl(Control control) {
    control.setDevice(this);
    controls.add(control);
  }
}
