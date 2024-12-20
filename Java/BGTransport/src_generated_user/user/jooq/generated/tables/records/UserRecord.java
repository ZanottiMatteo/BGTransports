/*
 * This file is generated by jOOQ.
 */
package user.jooq.generated.tables.records;


import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;

import user.jooq.generated.tables.User;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>user.username</code>.
     */
    public void setUsername(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>user.username</code>.
     */
    public String getUsername() {
        return (String) get(0);
    }

    /**
     * Setter for <code>user.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>user.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>user.surname</code>.
     */
    public void setSurname(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>user.surname</code>.
     */
    public String getSurname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>user.dateOfBirth</code>.
     */
    public void setDateofbirth(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>user.dateOfBirth</code>.
     */
    public String getDateofbirth() {
        return (String) get(3);
    }

    /**
     * Setter for <code>user.address</code>.
     */
    public void setAddress(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>user.address</code>.
     */
    public String getAddress() {
        return (String) get(4);
    }

    /**
     * Setter for <code>user.town</code>.
     */
    public void setTown(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>user.town</code>.
     */
    public String getTown() {
        return (String) get(5);
    }

    /**
     * Setter for <code>user.cap</code>.
     */
    public void setCap(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>user.cap</code>.
     */
    public String getCap() {
        return (String) get(6);
    }

    /**
     * Setter for <code>user.password</code>.
     */
    public void setPassword(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>user.password</code>.
     */
    public String getPassword() {
        return (String) get(7);
    }

    /**
     * Setter for <code>user.mail</code>.
     */
    public void setMail(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>user.mail</code>.
     */
    public String getMail() {
        return (String) get(8);
    }

    /**
     * Setter for <code>user.role</code>.
     */
    public void setRole(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>user.role</code>.
     */
    public Integer getRole() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>user.IconNumber</code>.
     */
    public void setIconnumber(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>user.IconNumber</code>.
     */
    public Integer getIconnumber() {
        return (Integer) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(String username, String name, String surname, String dateofbirth, String address, String town, String cap, String password, String mail, Integer role, Integer iconnumber) {
        super(User.USER);

        setUsername(username);
        setName(name);
        setSurname(surname);
        setDateofbirth(dateofbirth);
        setAddress(address);
        setTown(town);
        setCap(cap);
        setPassword(password);
        setMail(mail);
        setRole(role);
        setIconnumber(iconnumber);
        resetChangedOnNotNull();
    }
}
