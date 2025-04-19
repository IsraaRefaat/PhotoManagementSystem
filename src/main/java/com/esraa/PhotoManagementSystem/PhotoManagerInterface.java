package com.esraa.PhotoManagementSystem;

import java.time.LocalDate;
import java.util.Set;

public interface PhotoManagerInterface {

     boolean uploadPhoto(Photo photo);

     boolean updatePhotoName(Photo photo, String newName);

     boolean updatePhotoTags(Photo photo, Set<String> newTags);

     boolean updatePhotoLocation(Photo photo, Location newLocation);

     boolean deletePhoto(Photo photo);

     Set<Photo> searchByTag(String tag);

     Set<Photo> searchByTags(Set<String> tags);

     Set<Photo> searchByDate(LocalDate date);

     Set<Photo> searchByYear(int year);

     Set<Photo> searchByDateRange(LocalDate startDate, LocalDate endDate);

     Set<Photo> searchByLocation(Location location);

     Set<Photo> searchByTagAndLocation(String tag , Location location);

     Set<Photo> searchByDateAndLocation(LocalDate date, Location location);

     Set<Photo> searchByTagAndDate(String tag, LocalDate date);

     Set<Photo> search(String tag, LocalDate date, Location location);

     boolean isItThere(Photo photo , Location location);

     void displayAllPhotos();

     void clearAllPhotos();

     int getPhotoCount();

}
