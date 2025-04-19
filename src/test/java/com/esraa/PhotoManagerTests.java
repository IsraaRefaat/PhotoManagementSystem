package com.esraa;

import com.esraa.PhotoManagementSystem.Location;
import com.esraa.PhotoManagementSystem.Photo;
import com.esraa.PhotoManagementSystem.PhotoManager;
import com.esraa.PhotoManagementSystem.PhotoManagerInterface;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;

class PhotoManagerTests {

    static private PhotoManagerInterface manager;
    private Photo photo;
    private Location cairo;

    @BeforeEach
    void clientSetup() {
        manager = new PhotoManager();
        cairo = new Location(29.95375640,31.53700030);

        photo = new Photo(
                147,
                "River Nile",
                cairo,
                Set.of("sun", "TreEs","River","Esraa")
        );
    }

    @Test
    void uploadPhotoTest() {
        boolean added = manager.uploadPhoto(photo);
        assertTrue(added);
    }

    @Test
    void uploadPhotoDuplicateTest() {
        manager.uploadPhoto(photo);
        boolean addedAgain = manager.uploadPhoto(photo);
        assertFalse(addedAgain);
    }

    @Test
    void updatePhotoNameTest() {
        manager.uploadPhoto(photo);
        boolean result = manager.updatePhotoName(photo, "cairoCity");
        assertTrue(result);

    }

    @Test
    void updatePhotoTagsTest(){
        manager.uploadPhoto(photo);
        boolean result = manager.updatePhotoTags(photo, Set.of("moon","Esra","Refaat","Mohammed"));
        assertTrue(result);
    }

    @Test
    void updatePhotoLocationTest(){
        manager.uploadPhoto(photo);
        boolean result = manager.updatePhotoLocation(photo, new Location("Egypt","Giza"));
        assertTrue(result);
    }


    @Test
    void searchByTagTest() {
        manager.uploadPhoto(photo);
        Set<Photo> result = manager.searchByTag("sun");
        assertEquals(1, result.size());
    }


    @Test
    void searchByTagsTest() {
        manager.uploadPhoto(photo);
        Set<Photo> result = manager.searchByTags(Set.of("Esraa","SUN"));
        assertEquals(1, result.size());
    }

    @Test
    void searchByNonExistTagTest() {
        manager.uploadPhoto(photo);
        Set<Photo> result = manager.searchByTag("sea");
        assertTrue(result.isEmpty());
    }

    @Test
    void searchByDateTest() {
        manager.uploadPhoto(photo);
        Set<Photo> result = manager.searchByDate(LocalDate.now());
        assertEquals(1, result.size());
    }

    @Test
    void searchByNonExistDateTest() {
        manager.uploadPhoto(photo);
        Set<Photo> result = manager.searchByDate(LocalDate.of(2024, 4, 20));
        assertEquals(0, result.size());
    }

    @Test
    void searchByYearTest() {
        manager.uploadPhoto(photo);
        Set<Photo> result = manager.searchByYear(2025);
        assertEquals(1, result.size());
    }


    @Test
    void searchByNonExistYearTest() {
        manager.uploadPhoto(photo);
        Set<Photo> result = manager.searchByYear(2020);
        assertEquals(0, result.size());
    }

    @Test
    void searchByDateRangeTest() {
        manager.uploadPhoto(photo);
        Set<Photo> result = manager
                .searchByDateRange(LocalDate.of
                                (2025, 3, 1),
                        LocalDate.of(2025, 4, 30));
        assertEquals(1, result.size());

    }

    @Test
    void searchByLocationTest() {
        manager.uploadPhoto(photo);
        Set<Photo> result = manager.searchByLocation(cairo);
        assertEquals(1, result.size());
    }

    @Test
    void searchByNonExistLocationTest() {
        manager.uploadPhoto(photo);
        Set<Photo> result = manager.searchByLocation(new Location("Egypt","Cairo"));
        assertEquals(0, result.size());
    }

    @Test
    void searchByTagAndLocationTest() {
        manager.uploadPhoto(photo);
        Set<Photo> result = manager.searchByTagAndLocation( "sun", cairo);
        assertEquals(1, result.size());
    }

    @Test
    void searchByDateAndLocationTest() {
        manager.uploadPhoto(photo);
        Set<Photo> result = manager.searchByDateAndLocation(LocalDate.now(), cairo);
        assertEquals(1, result.size());
    }

    @Test
    void searchByNonExistDateAndLocationTest() {
        manager.uploadPhoto(photo);
        Set<Photo> result = manager.
                searchByDateAndLocation(LocalDate.of(2024, 4, 20),
                        new Location("Egypt","suez"));
        assertEquals(0, result.size());
    }

    @Test
    void searchByTagAndDateTest() {
        manager.uploadPhoto(photo);
        Set<Photo> result = manager.searchByTagAndDate("sun",LocalDate.now());
        assertEquals(1, result.size());
    }

    @Test
    void searchByNonExistTagAndDateTest() {
        manager.uploadPhoto(photo);
        Set<Photo> result = manager.searchByTagAndDate("sea",LocalDate.of(2024, 4, 20));
        assertEquals(0, result.size());
    }

    @Test
    void searchTest() {
        manager.uploadPhoto(photo);
        Set<Photo> result = manager.search(null,
                LocalDate.now(),cairo);
        assertEquals(1, result.size());
    }

    @Test
    void isItThereTest() {
        manager.uploadPhoto(photo);
        boolean result = manager.isItThere(photo,cairo);
        assertTrue(result);
    }

    @Test
    void isItThereNegativeTest() {
        manager.uploadPhoto(photo);
        boolean result = manager.isItThere(photo,new Location("Egypt","Giza"));
        assertFalse(result);
    }

    @Test
    void deletePhotoTest() {
        manager.uploadPhoto(photo);
        assertTrue(manager.deletePhoto(photo));
    }

    @Test
    void clearAllPhotosTest() {
        manager.uploadPhoto(photo);
        manager.clearAllPhotos();
        assertEquals(0, manager.getPhotoCount());
    }

    @Test
    void getPhotoCountTest() {
        manager.uploadPhoto(photo);
        assertEquals(1, manager.getPhotoCount());
    }

    @AfterAll
    static void displayPhotosTest(){
        System.out.println("We are done testing PhotoManager");
        manager.displayAllPhotos();

    }
}
