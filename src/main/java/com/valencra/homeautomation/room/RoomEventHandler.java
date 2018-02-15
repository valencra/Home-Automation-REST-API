package com.valencra.homeautomation.room;

import com.valencra.homeautomation.user.User;
import com.valencra.homeautomation.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RepositoryEventHandler(Room.class)
public class RoomEventHandler {
  private final UserRepository users;

  @Autowired
  public RoomEventHandler(UserRepository users) {
    this.users = users;
  }


  @HandleBeforeCreate
  public void addUserAsRoomAdminIfAdmin(Room room) {
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    User user = users.findByUsername(username);
    if(Arrays.asList(user.getRoles()).contains("ROLE_ADMIN")) {
      room.addAdministrator(user);
    } else {
      throw new AccessDeniedException(String.format("%s is not authorized to create rooms", user.getUsername()));
    }

  }
}
