// script.js
const APIPATH = "http://localhost:8080/";

// 프로젝트 목록을 가져오는 함수
async function getProjects() {
    try {
        // AJAX 또는 Fetch를 사용하여 백엔드에서 프로젝트 목록을 가져오는 로직을 구현
        // 서버에서 가져온 데이터를 동적으로 테이블에 추가
        // 예제에서는 정적 데이터를 사용

        const response = await fetch(`${APIPATH}project/2023-11-28`);
        const data = await response.json();

        const projects = await Promise.all(data.map(async project => {
            const clientResponse = await fetch(`${APIPATH}/customer/${project.cust_num}`);
            const clientData = await clientResponse.text(); // 텍스트로 받아오기

            return {
                number: project.proj_num,
                name: project.proj_name,
                startDate: project.proj_start.split(' ')[0], // Extracting date part
                endDate: project.proj_end.split(' ')[0], // Extracting date part
                client: clientData,
                size: 'N/A' // You might need to adjust this based on the actual data structure
            };
        }));

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
    } catch (error) {
        //console.error('에러 발생:', error);
    }
}

// 프로젝트 상세 정보를 가져오는 함수
function showProjectDetails(projectNumber) {
    // 새로운 페이지로 이동하면서 프로젝트 번호를 URL에 전달
    window.location.href = `project-details.html?projectNumber=${projectNumber}`;
}

// 페이지 로드 시 프로젝트 목록을 가져와서 표시
document.addEventListener('DOMContentLoaded', getProjects);
