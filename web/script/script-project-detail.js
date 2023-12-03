//script-project-detail.js
const APIPATH = "http://localhost:8080/";


// Function to get project number from the URL
function getProjectNumberFromURL() {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get('projectNumber');
}

// Function to get project details
function getProjectDetails() {
    const projectNumber = getProjectNumberFromURL();

    // Implement the logic to fetch project details from the backend using AJAX or Fetch
    // Display the data in the project details area
    // For this example, static data is used
    const project = {
        number: 1,
        name: 'Project A',
        startDate: '2023-01-01',
        endDate: '2023-02-01',
        client: 'Client A'
    };

    const projectDetails = document.getElementById('projectDetails');
    projectDetails.innerHTML = `
        <h2>${project.name}</h2>
        <span>Project Number: ${project.number}, </span>
        <span>Client: ${project.client}, </span> <br>
        <span>Start Date: ${project.startDate}, </span>
        <span>End Date: ${project.endDate}</span>  <br>
        <hr />
    `;
}

// Function to get and display project participants
function getProjectParticipants() {
    const projectNumber = getProjectNumberFromURL();

    // Implement the logic to fetch project participants from the backend using AJAX or Fetch
    // For this example, static data is used
    const participants = [
        { empNumber: '001', empName: 'John Doe', role: 'Developer', startDate: '2023-01-01', endDate: '2023-01-15' },
        { empNumber: '002', empName: 'Jane Smith', role: 'Designer', startDate: '2023-01-05', endDate: '2023-02-01' },
        // ... additional participant data
    ];

    displayProjectParticipants(participants);
}

// Function to display project participants
function displayProjectParticipants(participants) {
    const participantsList = document.getElementById('projectParticipantsList');
    participantsList.innerHTML = '';

    participants.forEach(participant => {
        // Create a row for each participant
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

function showParticipantDetails(empNumber) {
    // Redirect to the participant details page with the empNumber parameter
    window.location.href = `participant-details.html?empNumber=${empNumber}`;
}


// Load project details and participants when the page is loaded
document.addEventListener('DOMContentLoaded', function () {
    getProjectDetails();
    getProjectParticipants();
});
