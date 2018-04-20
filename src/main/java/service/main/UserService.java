package service.main;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * User management services.
 *
 * @author Arthur.Lee
 * @since 1.8
 */

@Service
public interface UserService {
    /**
     * Check user exists or not
     *
     * @param username username of the user
     * @param password password of the user
     * @return a JSON format string of current user's uuid
     */
    String checkUser(String username, String password) throws Exception;

    /**
     * Get user profile from database
     *
     * @param id id of the user
     * @return a JSON format string of current user's profile
     */
    String getUser(int id) throws Exception;


    /**
     * Update user profile
     *
     * @param profile updated JSON format user profile
     * @return a JSON format string of the updated user profile
     */
    String updateUser(String profile) throws Exception;

    /**
     * Sign up a new user profile
     *
     * @param profile a JSON format string of the user profile
     * @return a JSON format string of the user profile
     */
    String saveUser(String profile) throws Exception;

    /**
     * Delete user profile
     *
     * @param id uuid of the user
     * @return a bool number whether the user has been deleted
     */
    boolean removeUser(int id) throws Exception;
}
