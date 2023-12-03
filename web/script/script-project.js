// script.js
const APIPATH = "http://localhost:8080/";

const express = require('express');
const app = express();

app.use((req, res, next) => {
    res.header('Access-Control-Allow-Origin', 'http://192.168.0.11:5500'); // 클라이언트의 도메인으로 설정
    res.header('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE');
    res.header('Access-Control-Allow-Headers', 'Content-Type');
    next();
});

// 나머지 서버 로직 추가...

app.listen(8080, () => {
    console.log('서버가 8080 포트에서 실행 중입니다.');
});


// 프로젝트 목록을 가져오는 함수
function getProjects() {
    // AJAX 또는 Fetch를 사용하여 백엔드에서 프로젝트 목록을 가져오는 로직을 구현
    // 서버에서 가져온 데이터를 동적으로 테이블에 추가
    // 예제에서는 정적 데이터를 사용

    fetch(`${APIPATH}project/2023-11-28`).then((response) => {
        console.log(response);
        return response.json(); // JSON으로 변환하여 데이터를 사용하도록 변경
    })
    .then(data => {
        // 서버에서 받아온 데이터를 사용하여 테이블에 추가하는 로직
        console.log(data);
        // ... 기존 로직 추가
    })
    .catch(error => {
        console.error('에러 발생:', error);
    });


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

// 페이지 로드 시 프로젝트 목록을 가져와서 표시
document.addEventListener('DOMContentLoaded', function () {
    getProjects();
});