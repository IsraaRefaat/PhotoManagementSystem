package com.esraa.PhotoManagementSystem;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PhotoManager implements PhotoManagerInterface {

    /* Firstly I implement it as indexing maps, so I had to create around 4 maps
       and the most of the code was depending on loops and if-else conditions, and
       it was working, but the code was not clean and high space complexity
       because we had many maps and not just the maps,
       I had to make "Set<Photo> result = new HashSet<>()" everytime to
       keep the result.


       In the same time I was refreshing Streams in Java and after refreshing the concepts of it
       I thought it will be cleaner and more efficient if I can replace all the external loops
       and conditions with internal loops, and with it, I will not have to use 4 maps but just
       one hashSet.


       I'm using Abstraction because I don't want to depend on the implementation which is I can change in it anytime,
       as I did.
     */


    //Because the hashSet give use O(1) for add, delete, and search
    private final Set<Photo> photos = new HashSet<>();

    @Override
    public boolean uploadPhoto(Photo photo) {
        return photos.add(photo);
    }

    @Override
    public boolean updatePhotoTags(Photo photo, Set<String> newTags) {
        if (!photos.contains(photo)) return false;
        photo.setTags(newTags);
        return true;
    }

    @Override
    public boolean updatePhotoName(Photo photo, String newName) {
        if (!photos.contains(photo)) return false;
        photo.setImageName(newName);
        return true;
    }

    @Override
    public boolean updatePhotoLocation(Photo photo, Location newLocation) {
        if (!photos.contains(photo)) return false;
        photo.setLocation(newLocation);
        return true;
    }

    @Override
    public boolean deletePhoto(Photo photo) {
        return photos.remove(photo);
    }

    @Override
    public Set<Photo> searchByTag(String tag) {
        return photos.stream()
                .filter(p -> p.getTags()
                        .contains(tag.toLowerCase()))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Photo> searchByTags(Set<String> tags) {
        return photos.stream()
                .filter(p -> p.getTags().stream().
                        anyMatch((tags.stream()
                                .map(String::toLowerCase)
                                .collect(Collectors.toSet()))::contains))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Photo> searchByDate(LocalDate date) {
        return photos.stream()
                .filter(p -> p.getDate().equals(date))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Photo> searchByYear(int year) {
        return photos.stream()
                .filter(p -> p.getDate().getYear() == year)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Photo> searchByDateRange(LocalDate startDate, LocalDate endDate){
        return photos.stream()
                .filter(p -> !p.getDate().isBefore(startDate) && !p.getDate().isAfter(endDate))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Photo> searchByLocation(Location location) {
        return photos.stream()
                .filter(p -> p.getLocation().equals(location))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Photo> searchByTagAndLocation(String tag , Location location) {
        return photos.stream()
                .filter(p -> p.getTags().contains(tag.toLowerCase()))
                .filter(p -> p.getLocation().equals(location))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Photo> searchByDateAndLocation(LocalDate date, Location location) {
        return photos.stream()
                .filter(p -> p.getDate().equals(date))
                .filter(p -> p.getLocation().equals(location))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Photo> searchByTagAndDate(String tag, LocalDate date) {
        return photos.stream()
                .filter(p-> p.getTags().contains(tag.toLowerCase()))
                .filter(p -> p.getDate().equals(date))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Photo> search(String tag, LocalDate date, Location location) {
      return photos.stream()
              .filter( p -> tag == null || p.getTags()
                .contains(tag.toLowerCase()) )
              .filter(p -> date == null || p.getDate().equals(date))
              .filter(p-> location == null || p.getLocation().equals(location))
              .collect(Collectors.toSet());
    }

    @Override
    public boolean isItThere(Photo photo , Location location) {
        return photo.getLocation().equals(location);
    }

    @Override
    public void displayAllPhotos() {
        photos.forEach(System.out::println);
    }

    @Override
    public void clearAllPhotos() {
        photos.clear();
    }

    @Override
    public int getPhotoCount() {
        return photos.size();
    }
}
