const APIPATH = "http://localhost:8080/";

async function fetchProjects() {
    try {
        const response = await fetch(`${APIPATH}project/2023-11-20`);
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
