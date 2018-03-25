package service;

import java.util.UUID;

/**
 * User management services.
 *
 * @author Arthur.Lee
 * @since 1.8
 */

public abstract class UserService {
    /**
     * Get user profile from database
     *
     * @param username name of the user
     * @param password password of the user
     * @return a JSON format string of current user's profile
     */
    public abstract String getUser(String username, String password);


    /**
     * Update user profile
     *
     * @param uuid    uuid of the user
     * @param profile updated JSON format user profile
     * @return a JSON format string of the updated user profile
     */
    public abstract String updateUser(UUID uuid, String profile);

    /**
     * Sign up a new user profile
     *
     * @param profile a JSON format string of the user profile
     * @return a JSON format string of the user profile
     */
    public abstract String saveUser(String profile);

    /**
     * Delete user profile
     *
     * @param uuid uuid of the user
     * @return a bool number whether the user has been deleted
     */
    public abstract boolean removeUser(UUID uuid);
}
