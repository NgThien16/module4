//package org.example.borrow_book.validate;
//
//import org.example.ss8_songs_validate.entity.Song;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//@Component
//public class BorrowBookValidate implements Validator {
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Song.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Song song = (Song) target;
//
//        /* ---------- Song name ---------- */
//        if (song.getName() == null || song.getName().trim().isEmpty()) {
//            errors.rejectValue("name", "name.empty", "name is required");
//        } else if (song.getName().length() < 2 || song.getName().length() > 800) {
//            errors.rejectValue("name", "name.length",
//                    "name must be between 2 and 800 characters");
//        }else if (!song.getName().matches("^[a-zA-Z ]+$")) {
//        errors.rejectValue("name", "name.length",
//                "name must not be contain special character");
//        }
//
//        /* ---------- Artist name ---------- */
//        if (song.getArtist() == null || song.getArtist().trim().isEmpty()) {
//            errors.rejectValue("artist", "artist.empty", "artist name is required");
//        } else if (song.getArtist().length() < 2 || song.getArtist().length() > 300) {
//            errors.rejectValue("artist", "artist.length",
//                    "name must be between 2 and 300 characters");
//        }else if (!song.getArtist().matches("^[a-zA-Z ]+$")) {
//            errors.rejectValue("artist", "artist.length",
//                    "name must not be contain special character");
//        }
//
//        /* ---------- Genre ---------- */
//        if (song.getGenre() == null || song.getGenre().trim().isEmpty()) {
//            errors.rejectValue("genre", "genre.empty", "genre is required");
//        } else if (song.getGenre().length() < 2 || song.getGenre().length() >1000) {
//            errors.rejectValue("genre", "genre.length",
//                    "genre must be between 2 and 1000 characters");
//        }else if (!song.getGenre().matches("^[a-zA-Z ,]+$")) {
//            errors.rejectValue("genre", "genre.length",
//                    "name must not be contain special character");
//        }
//    }
//}
