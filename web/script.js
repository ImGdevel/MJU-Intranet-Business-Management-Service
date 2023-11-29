// script.js

// 프로젝트 목록을 가져오는 함수
function getProjects() {
    // AJAX 또는 Fetch를 사용하여 백엔드에서 프로젝트 목록을 가져오는 로직을 구현
    // 서버에서 가져온 데이터를 동적으로 테이블에 추가
    // 예제에서는 정적 데이터를 사용
    const projects = [
        { number: 1, name: 'Project A', startDate: '2023-01-01', endDate: '2023-02-01', client: 'Client A' },
        { number: 2, name: 'Project B', startDate: '2023-02-01', endDate: '2023-03-01', client: 'Client B' },
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
        `;
        projectList.appendChild(row);
    });
}

// 프로젝트 상세 정보를 가져오는 함수
function getProjectDetails(projectNumber) {
    // AJAX 또는 Fetch를 사용하여 백엔드에서 프로젝트 상세 정보를 가져오는 로직을 구현
    // 서버에서 가져온 데이터를 상세 정보 영역에 표시
    // 예제에서는 정적 데이터를 사용
    const details = `
        <h2>Project Details - ${projectNumber}</h2>
        <p>Details about the project...</p>
    `;

    const projectDetails = document.getElementById('projectDetails');
    projectDetails.innerHTML = details;
}

// 프로젝트 상세 정보를 표시하는 함수
function showProjectDetails(projectNumber) {
    getProjectDetails(projectNumber);
}

// 페이지 로드 시 프로젝트 목록을 가져와서 표시
document.addEventListener('DOMContentLoaded', function () {
    getProjects();
});