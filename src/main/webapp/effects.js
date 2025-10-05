document.addEventListener('DOMContentLoaded', function() {

    // --- HIỆU ỨNG 1: FADE IN KHI CUỘN TRANG ---
    const animatedSections = document.querySelectorAll('.about-me, .featured-work, .uni-life-section, .bottom-contact');

    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('visible');
                observer.unobserve(entry.target); // Ngừng theo dõi sau khi đã hiện
            }
        });
    }, {
        threshold: 0.1 // Kích hoạt khi 10% của phần tử hiện ra
    });

    animatedSections.forEach(section => {
        observer.observe(section);
    });


    // --- HIỆU ỨNG 2: SPOTLIGHT THEO CON TRỎ CHUỘT ---
    const spotlight = document.querySelector('.spotlight');
    if (spotlight) {
        window.addEventListener('mousemove', (e) => {
            // Chỉ chạy trên màn hình lớn (khớp với media query trong CSS)
            if (window.innerWidth > 1024) {
                // Dùng requestAnimationFrame để tối ưu hiệu năng
                requestAnimationFrame(() => {
                    spotlight.style.left = `${e.clientX}px`;
                    spotlight.style.top = `${e.clientY}px`;
                });
            }
        });
    }

});