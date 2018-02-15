package com.valencra.homeautomation.control;

import com.valencra.homeautomation.room.Room;
import com.valencra.homeautomation.user.User;
import com.valencra.homeautomation.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Control.class)
public class ControlEventHandler {
  private final UserRepository users;

  @Autowired
  public ControlEventHandler(UserRepository users) {
    this.users = users;
  }


  @HandleBeforeCreate
  public void setLastModifiedByBeforeCreate(Control control) {
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    User user = users.findByUsername(username);
    control.setLastModifiedBy(user);
  }

  @HandleBeforeSave
  public void setLastModifiedByBeforeSave(Control control) {
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    User user = users.findByUsername(username);
    control.setLastModifiedBy(user);
  }
}

