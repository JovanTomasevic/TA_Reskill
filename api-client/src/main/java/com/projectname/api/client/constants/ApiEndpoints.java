package com.projectname.api.client.constants;

//List of endpoint as constants
public class ApiEndpoints {

    public static final String USERS = "api/users";

    public static final String users(String userId) {
        return USERS + "/" + userId;
    }

    public static final String ACTIVITIES = "/api/v1/Activities";

    public static final String ACTIVITY(Integer activityId) {
        return ACTIVITIES + "/" + activityId;
    }

    public static final String AUTHORS = "/api/v1/Authors";

    public static final String AUTHOR(Integer authorId) {
        return AUTHORS + "/" + authorId;
    }

    public static final String AUTHOR_BY_BOOKID(Integer bookId) {
        return AUTHORS + "/authors/books/" + bookId;
    }

    public static final String BOOKS = "/api/v1/Books";

    public static final String BOOK(Integer bookId) {
        return BOOKS + "/" + bookId;
    }

    public static final String COVER_PHOTOS = "/api/v1/CoverPhotos";

    public static final String COVER_PHOTO(Integer coverPhotoId) {
        return COVER_PHOTOS + "/" + coverPhotoId;
    }

    public static final String COVER_PHOTO_BY_BOOKID(Integer bookId) {
        return COVER_PHOTOS + "/books/covers/" + bookId;
    }
    public static final String LOGIN_USER = "auth/token/login/";
    public static final String REGISTER_USER = "user/register/";
    public static final String GET_MY_CROCODILE(Integer id) {
        return CROCODILES + id+ "/";
    }
    public static final String CROCODILES = "my/crocodiles/";

}