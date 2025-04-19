package com.esraa.PhotoManagementSystem;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class Photo {

  // It's final because it's the image_id so it's not allowed to reassign it
  private final int id;
  private String imageName;
  // We can add LocalDateTime instead of just LocalDate
  // It's final because it's the date when the image uploaded, and it's autoAssigned so it's not allowed to reassign it
  private final LocalDate date;
  private Location location;
  // We used Set to prevent duplicated tags and it's O(1) for searching
  private Set<String> tags;


  public Photo(int id, String imageName, Location location, Set<String> tags) {
      this.id = id;
      this.imageName = imageName;
      //The date will be the date when the photo was uploaded (now)
      this.date = LocalDate.now();
      this.location = location;
      //We have to make sure all the tags stored in lowerCase to make searching easier later
      this.tags = tags.stream()
              .map(String::toLowerCase)
              .collect(Collectors.toSet());
  }


   //Getters
    public LocalDate getDate() {
        return date;
    }

    public Location getLocation() {
        return location;
    }

    public Set<String> getTags() {
        return tags;
    }


    //Setters
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
    }


    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", imageName='" + imageName + '\'' +
                ", date=" + date +
                ", location=" + location +
                ", tags=" + tags +
                '}';
    }
}
