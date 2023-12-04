// script-project-detail.js
const APIPATH = "http://localhost:8080/";

// Function to get project number from the URL
function getProjectNumberFromURL() {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get('projectNumber');
}

async function fetchProjectDetails(projectNumber) {
    try {
        const response = await fetch(`${APIPATH}project/detail/${projectNumber}`);
        const project = await response.json();

        const mappedProject = {
            number: project.proj_num,
            name: project.proj_name,
            startDate: project.proj_start.split(' ')[0], // Extracting date part
            endDate: project.proj_end.split(' ')[0], // Extracting date part
            client: project.cust_num.cust_name, // 클라이언트 번호 또는 이름으로 변경해야 할 수 있습니다.
        };

        return mappedProject;
    } catch (error) {
        console.error('Error fetching project details:', error);
        throw error;
    }
}

// Function to fetch project participants
async function fetchProjectParticipants(projectNumber) {
    try {
        const response = await fetch(`${APIPATH}project-participant/project/${projectNumber}`);
        const participants = await response.json();
         // Map the participants data
        const mappedParticipants = await Promise.all(participants.map(mapProjectParticipants));
        return mappedParticipants;
         
    } catch (error) {
        console.error('Error fetching project participants:', error);
        throw error;
    }
}

// Function to fetch employee name by employee number
async function fetchEmployeeName(empNumber) {
    try {
        const response = await fetch(`${APIPATH}employee/name/${empNumber}`);
        const employeeName = await response.text(); // Assuming the response is a plain text with the employee name
        return employeeName;
    } catch (error) {
        console.error(`Error fetching employee name for employee ${empNumber}:`, error);
        throw error;
    }
}


async function mapProjectParticipants(participant) {
    return {
        empNumber: participant.emp_num,
        empName: await fetchEmployeeName(participant.emp_num), // Employee name data is not provided in the sample, you can update this when available.
        role: participant.role_num.role_name,
        startDate: participant.proj_in.split(' ')[0], // Extracting date part
        endDate: participant.proj_out.split(' ')[0], // Extracting date part
    };
}

// Function to display project details
function displayProjectDetails(project) {
    const projectDetails = document.getElementById('projectDetails');
    projectDetails.innerHTML = `
        <h2>${project.name}</h2>
        <span style="padding-right: 30px;">Project Number: ${project.number} </span>
        <span style="padding-right: 30px;">Client: ${project.client} </span> 
        <span style="padding-right: 30px;">Start Date: ${project.startDate} </span>
        <span style="padding-right: 30px;">End Date: ${project.endDate}</span>  <br>
        <hr />
    `;
}

// Function to display project participants
function displayProjectParticipants(participants) {
    const participantsList = document.getElementById('projectParticipantsList');
    participantsList.innerHTML = '';

    participants.forEach(participant => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${participant.empNumber}</td>
            <td>${participant.empName}</td>
            <td>${participant.role}</td>
            <td>${participant.startDate}</td>
            <td>${participant.endDate}</td>
            <td><button onclick="showParticipantDetails(${participant.empNumber})" class="project-button-details">Details</button></td>
        `;
        participantsList.appendChild(row);
    });
}

// Function to show participant details
function showParticipantDetails(empNumber) {
    window.location.href = `participant-details.html?empNumber=${empNumber}`;
}

// Load project details and participants when the page is loaded
document.addEventListener('DOMContentLoaded', async function () {
    try {
        const projectNumber = getProjectNumberFromURL();
        const project = await fetchProjectDetails(projectNumber);
        const participants = await fetchProjectParticipants(projectNumber);

        displayProjectDetails(project);
        displayProjectParticipants(participants);
    } catch (error) {
        console.error('Error loading project details:', error);
    }
});
