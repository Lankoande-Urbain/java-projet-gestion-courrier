/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 *
 *this is LANKOANDE Urbain code
 * Prince.COM << lankoandeurbain8@gmail.com >>
 *
 */
package classe;

/**
 *
 * @author lankoande
 */
public class session {

    private String userId;
    private String firstName;
    private String lastName;
    private Boolean userStatus;

    public session(String userId, String firstName, String lastName, Boolean userStatus) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userStatus = userStatus;
    }

    // Getters et setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Boolean userStatus) {
        this.userStatus = userStatus;
    }
}
