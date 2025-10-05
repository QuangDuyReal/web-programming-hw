// Bạn cần tạo thêm một menu dành cho mobile trong HTML, ví dụ: <nav class="mobile-nav"></nav>
document.addEventListener('DOMContentLoaded', function() {
    const menuToggle = document.querySelector('.menu-toggle');
    const mobileNav = document.querySelector('.main-nav'); // Giả sử bạn muốn hiện ra menu này

    menuToggle.addEventListener('click', function() {
        mobileNav.classList.toggle('active'); // Thêm class 'active' để hiện menu
    });
});