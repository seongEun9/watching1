document.addEventListener('DOMContentLoaded', function () {
    const genderChartCanvas = document.getElementById('genderChart').getContext('2d');
    const ageChartCanvas = document.getElementById('ageChart').getContext('2d');

    const genderChart = new Chart(genderChartCanvas, {
        type: 'doughnut',
        data: {
            labels: ['남', '여'],
            datasets: [{
                label: '성별 예매 분포',
                data: [34.6, 65.4],
                backgroundColor: ['#34495e', '#ce1c6a'],
                borderWidth: 1,
                hoverOffset: 4,
            }],
        },
        options: {
            plugins: {
                title: {
                    display: true,
                    text: '성별 예매 분포',
                    font: {
                        size: 18
                    },
                    padding: {
                        top: 10,
                        bottom: 10
                    }
                },
                tooltip: {
                    callbacks: {
                        label: function (context) {
                            return context.label + ': ' + context.raw + '%';
                        }
                    }
                },
            },
            maintainAspectRatio: false,
            responsive: true,
            scales: {},
        },
    });

    const ageChart = new Chart(ageChartCanvas, {
        type: 'bar',
        data: {
            labels: ['10대', '20대', '30대', '40대', '50대'],
            datasets: [{
                label: '연령별 예매 분포',
                data: [8, 26.1, 26.1, 29.5, 10.4],
                backgroundColor: function (context) {
                    const index = context.dataIndex;
                    return index === 3 ? '#e37d90' : '#2c3e50';
                },
                borderWidth: 1,
            }],
        },
        options: {
            plugins: {
                title: {
                    display: true,
                    text: '연령별 예매 분포',
                    font: {
                        size: 18
                    },
                    padding: {
                        top: 10,
                        bottom: 10
                    }
                },
                tooltip: {
                    callbacks: {
                        label: function (context) {
                            return context.label + ': ' + context.raw + '%';
                        }
                    }
                },
                legend: {
                    display: false,
                },
                datalabels: {
                    anchor: 'end',
                    align: 'end',
                    color: '#444',
                    font: {
                        weight: 'bold'
                    },
                    formatter: Math.round,
                }
            },
            maintainAspectRatio: false,
            responsive: true,
            scales: {
                x: {
                    grid: {
                        display: false, // X축 실선 제거
                    },
                },
                y: {
                    beginAtZero: true,
                    grid: {
                        display: false, // Y축 실선 제거
                    },
                    ticks: {
                        callback: function (value) {
                            return value + '%';
                        }
                    }
                }
            },
            layout: {
                padding: {
                    left: 0,
                    right: 0,
                    top: 0,
                    bottom: 0
                }
            },
            borderColor: 'rgba(0, 0, 0, 0)',
        },
    });
});
