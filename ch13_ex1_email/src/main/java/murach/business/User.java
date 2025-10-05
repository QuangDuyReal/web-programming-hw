package murach.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users") // Tên bảng là chữ thường, số nhiều
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId; // Tên biến: userId (camelCase)

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName; // Tên biến: firstName (camelCase)

    @Column(name = "last_name")
    private String lastName; // Tên biến: lastName (camelCase)

    // Constructor mặc định (JPA yêu cầu)
    public User() {
    }

    // Getters và Setters theo đúng quy ước JavaBeans
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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