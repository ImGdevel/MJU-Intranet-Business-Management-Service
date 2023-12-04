const APIPATH = "http://localhost:8080/";

// Function to fetch project data from the backend
async function fetchProjects() {
    try {
        const response = await fetch(`${APIPATH}project/2023-11-28`);
        return await response.json();
    } catch (error) {
        console.error('에러 발생:', error);
        throw error;
    }
}

// Function to fetch client data based on project customer number
async function fetchClientData(custNum) {
    try {
        const clientResponse = await fetch(`${APIPATH}/customer/${custNum}`);
        return await clientResponse.text();
    } catch (error) {
        console.error('에러 발생:', error);
        throw error;
    }
}

// Function to map project data to a more readable format
function mapProjectData(project) {
    return {
        number: project.proj_num,
        name: project.proj_name,
        startDate: project.proj_start.split(' ')[0],
        endDate: project.proj_end.split(' ')[0],
        size: 'N/A' // You might need to adjust this based on the actual data structure
    };
}

// Function to fetch and display projects
async function getProjects() {
    try {
        const data = await fetchProjects();

        const projects = await Promise.all(data.map(async project => {
            const clientData = await fetchClientData(project.cust_num);

            return {
                ...mapProjectData(project),
                client: clientData
            };
        }));

        displayProjects(projects);
    } catch (error) {
        console.error('에러 발생:', error);
    }
}

// Function to display projects in the table
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

// Call the getProjects function on page load
document.addEventListener('DOMContentLoaded', getProjects);

// Function to show project details
function showProjectDetails(projectNumber) {
    // Redirect to the project details page with the projectNumber parameter
    window.location.href = `project-details.html?projectNumber=${projectNumber}`;
}
