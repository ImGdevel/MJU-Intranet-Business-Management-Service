// script.js

// 프로젝트 목록을 가져오는 함수
function getProjects() {
    // AJAX 또는 Fetch를 사용하여 백엔드에서 프로젝트 목록을 가져오는 로직을 구현
    // 서버에서 가져온 데이터를 동적으로 테이블에 추가
    // 예제에서는 정적 데이터를 사용
    const projects = [
        { number: 1, name: 'Project A', startDate: '2023-01-01', endDate: '2023-02-01', client: 'Client A', size: '10' },
        { number: 2, name: 'Project B', startDate: '2023-02-01', endDate: '2023-03-01', client: 'Client B', size: '15' },
        // ... 추가 프로젝트 데이터
    ];

    const projectList = document.getElementById('projectList');
    projectList.innerHTML = '';

    projects.forEach(project => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td><button onclick="showProjectDetails(${project.number})" class="project-button">${project.number}</button></td>
            <td><button onclick="showProjectDetails(${project.number})" class="project-button">${project.name}</button></td>
            <td><button onclick="showProjectDetails(${project.number})" class="project-button">${project.startDate}</button></td>
            <td><button onclick="showProjectDetails(${project.number})" class="project-button">${project.endDate}</button></td>
            <td><button onclick="showProjectDetails(${project.number})" class="project-button">${project.client}</button></td>
            <td><button onclick="showProjectDetails(${project.number})" class="project-button">${project.size}</button></td>
        `;
        projectList.appendChild(row);
    });
}

// 프로젝트 상세 정보를 가져오는 함수
function showProjectDetails(projectNumber) {
    // 새로운 페이지로 이동하면서 프로젝트 번호를 URL에 전달
    window.location.href = `project-details.html?projectNumber=${projectNumber}`;
}

// 프로젝트 상세 정보를 표시하는 함수
function showProjectDetails(projectNumber) {
    getProjectDetails(projectNumber);
}

// 페이지 로드 시 프로젝트 목록을 가져와서 표시
document.addEventListener('DOMContentLoaded', function () {
    getProjects();
});