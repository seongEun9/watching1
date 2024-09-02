// 메인  페이지
// 사이드 바 드롭다운1
document.addEventListener('DOMContentLoaded', function () {
    // Dropdowns
    const dropdowns = document.querySelectorAll('.navbar-nav .dropdown');

    dropdowns.forEach(dropdown => {
        dropdown.addEventListener('mouseenter', function () {
            const dropdownMenu = this.querySelector('.dropdown-menu');
            if (dropdownMenu) {
                dropdownMenu.classList.add('show');
            }
        });

        dropdown.addEventListener('mouseleave', function () {
            const dropdownMenu = this.querySelector('.dropdown-menu');
            if (dropdownMenu) {
                dropdownMenu.classList.remove('show');
            }
        });
    });

    // Page redirects
    const navLinks = document.querySelectorAll('.navbar-nav.ms-auto .nav-link');

    navLinks.forEach(link => {
        link.addEventListener('click', function (e) {
            e.preventDefault();
            const targetPage = this.getAttribute('href');
            window.location.href = targetPage;
        });
    });
});
