package murach.business;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "users") // Chỉ định tên bảng là "users" (chữ thường, số nhiều) - đây là quy ước phổ biến
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id") // Đổi từ userId -> user_id
    private Long userId;

    // Giữ nguyên email vì nó đã là chữ thường
    @Column(name = "email")
    private String email;

    @Column(name = "first_name") // Đổi từ firstName -> first_name
    private String firstName;

    @Column(name = "last_name") // Đổi từ lastName -> last_name
    private String lastName;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}