
package com.test.jaxrs.jsonb;

/**
 *
 * @author agupgupt
 */
public class EGMember {
 private String fname;
 private String lname;
 private String org;

    public EGMember() {
    }

 
    public EGMember(String fname, String lname, String role) {
        this.fname = fname;
        this.lname = lname;
        this.org = role;
    }

    @Override
    public String toString() {
        return "Person{" + "fname=" + fname + ", lname=" + lname + ", org=" + org + '}';
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String role) {
        this.org = role;
    }

 
}
