// 메인  페이지
document.addEventListener('DOMContentLoaded', function () {
    // 사이드 바 드롭다운 기능
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

    // 페이지 리다이렉트 기능
    const navLinks = document.querySelectorAll('.navbar-nav.ms-auto .nav-link');

    navLinks.forEach(link => {
        link.addEventListener('click', function (e) {
            e.preventDefault();
            const targetPage = this.getAttribute('href');
            window.location.href = targetPage;
        });
    });
});

// 탭 전환 기능
function showChart(type) {
    const movieChartContent = document.getElementById('movie-chart-content');
    const upcomingContent = document.getElementById('upcoming-content');
    const tabMovieChart = document.getElementById('tab-movie-chart');
    const tabUpcoming = document.getElementById('tab-upcoming');

    if (type === 'movie') {
        movieChartContent.classList.remove('d-none');
        upcomingContent.classList.add('d-none');
        tabMovieChart.classList.add('active');
        tabUpcoming.classList.remove('active');
    } else if (type === 'upcoming') {
        movieChartContent.classList.add('d-none');
        upcomingContent.classList.remove('d-none');
        tabMovieChart.classList.remove('active');
        tabUpcoming.classList.add('active');
    }
}

// 무비 차트 스크롤 기능
function scrollChart(direction) {
    const movieChart = document.querySelector('.movie-chart-content:not(.d-none)');
    const scrollAmount = 200;

    if (direction === 'next') {
        movieChart.scrollBy({ left: scrollAmount, behavior: 'smooth' });
    } else if (direction === 'prev') {
        movieChart.scrollBy({ left: -scrollAmount, behavior: 'smooth' });
    }
}

// 무비 버튼 표시/숨김 기능
function showButtons(element) {
    element.querySelector('.movie-buttons').style.display = 'flex';
}

function hideButtons(element) {
    element.querySelector('.movie-buttons').style.display = 'none';
}

// 스크롤 js
document.querySelector('.scroll-up').addEventListener('click', function() {
    window.scrollTo({
        top: 0,
        behavior: 'smooth' /* 부드럽게 스크롤 */
    });
});

// 페이지를 새로고침하는 함수
function refreshPage() {
    location.reload();  // 페이지 새로고침
}


