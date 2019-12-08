package edu.upb.transitourbano.repository;

public class Repository {
    private static final Repository ourInstance = new Repository();

    public static Repository getInstance() {
        return ourInstance;
    }

    private Repository() {
    }
}
