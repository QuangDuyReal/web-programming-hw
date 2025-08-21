package murach.data;

import murach.business.User;

public class UserDB {
    // Trong một ứng dụng thực tế, phương thức này sẽ kết nối
    // và lưu dữ liệu vào cơ sở dữ liệu.
    // Ở đây, chúng ta chỉ in ra để mô phỏng.
    public static void insert(User user) {
        System.out.println("Đã thêm người dùng sau vào cơ sở dữ liệu:");
        System.out.println("Email: " + user.getEmail());
        System.out.println("First Name: " + user.getFirstName());
        System.out.println("Last Name: " + user.getLastName());
    }
}