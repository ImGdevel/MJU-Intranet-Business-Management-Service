const APIPATH = "http://localhost:8080/";

async function fetchProjects() {
    try {
        let days = "2023-11-20";
        const response = await fetch(`${APIPATH}project/${days}`);
        return await response.json();
    } catch (error) {
        console.error('에러 발생:', error);
        throw error;
    }
}

async function fetchProjectTeamSize(proj_num) {
    try {
        const clientResponse = await fetch(`${APIPATH}/ParticipantNum/${proj_num}`);
        return await clientResponse.text();
    } catch (error) {
        console.error('에러 발생:', error);
        throw error;
    }
}

function mapProjectData(project) {
    return {
        number: project.proj_num,
        name: project.proj_name,
        startDate: project.proj_start.split(' ')[0],
        endDate: project.proj_end.split(' ')[0],
        client: project.cust_num.cust_name,
    };
}

async function getProjects() {
    try {
        const data = await fetchProjects();

        const projects = await Promise.all(data.map(async project => {
            const team_size = await fetchProjectTeamSize(project.proj_num);
            return {
                ...mapProjectData(project),
                size: team_size,
            };
        }));

        displayProjects(projects);
    } catch (error) {
        console.error('에러 발생:', error);
    }
}


// 추가: 확인 버튼 클릭 시 호출되는 함수
function handleConfirmation() {
    const startDate = document.getElementById('startDate').value;
    const endDate = document.getElementById('endDate').value;

    // 예외 처리: 시작날짜와 종료날짜가 선택되지 않은 경우
    if (!startDate || !endDate) {
        alert('Please select both start date and end date.');
        return;
    }
    console.log(startDate, endDate);
    getProjectsToDays(startDate, endDate);
}

// 수정: fetchProjects 함수에 매개변수 추가 (startDate, endDate)
async function fetchProjectsToDays(startDate, endDate) {
    try {
        const response = await fetch(`${APIPATH}project/period/${startDate}/${endDate}`);
        return await response.json();
    } catch (error) {
        console.error('에러 발생:', error);
        throw error;
    }
}

// 수정: getProjects 함수에 매개변수 추가 (startDate, endDate)
async function getProjectsToDays(startDate, endDate) {
    try {
        const data = await fetchProjectsToDays(startDate, endDate);

        const projects = await Promise.all(data.map(async project => {
            const team_size = await fetchProjectTeamSize(project.proj_num);
            return {
                ...mapProjectData(project),
                size: team_size,
            };
        }));

        displayProjects(projects);
    } catch (error) {
        console.error('에러 발생:', error);
    }
}

function displayProjects(projects) {
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

document.addEventListener('DOMContentLoaded', getProjects);

function showProjectDetails(projectNumber) {
    window.location.href = `project-details.html?projectNumber=${projectNumber}`;
}
