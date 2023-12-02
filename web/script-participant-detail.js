// script-participant-detail.js

// Function to fetch and display participant details
function getParticipantDetails(empNumber) {
    // AJAX or Fetch logic to get participant details from the backend
    // Replace the following with your actual data retrieval logic
    
    // Example data (replace this with your actual data)
    const participantData = {
        empNumber: empNumber,
        name: 'John Doe',
        registrationNumber: '123456-7890123',
        education: "Bachelor's Degree",
        position: 'Software Engineer',
        department: 'IT Department'
    };

    // Update the #participantDetails div with the retrieved details
    const details = `
            <h2>${participantData.name}</h2>
            <p>Resident Registration Number: ${participantData.registrationNumber}</p>
            <p>Highest Education Level: ${participantData.education}</p>
            <p>Position: ${participantData.position}</p>
            <p>Department: ${participantData.department}</p>
    `;

    const participantText = document.getElementById('participantText');
    participantText.innerHTML = details;

     // Call functions to display work experience and skills
     displayProjectParticipation(empNumber);
     displayWorkExperience(empNumber);
     displaySkills(empNumber);
}

// Function to fetch and display project participation history
function displayProjectParticipation(empNumber) {
    // AJAX or Fetch logic to get project participation data from the backend
    // Replace the following with your actual data retrieval logic
    
    // Example project participation data (replace this with your actual data)
    const projectParticipationData = [
        { projectNumber: 1, projectName: 'Project A', startDate: '2022-01-01', endDate: '2022-03-01', role: 'Developer' },
        { projectNumber: 2, projectName: 'Project B', startDate: '2022-03-01', endDate: '2022-05-01', role: 'QA Engineer' },
        // Additional project participation data
    ];

    // Update the project participation table with the retrieved data
    const projectTableBody = document.getElementById('projectTableBody');
    projectParticipationData.forEach(project => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${project.projectNumber}</td>
            <td>${project.projectName}</td>
            <td>${project.startDate}</td>
            <td>${project.endDate}</td>
            <td>${project.role}</td>
        `;
        projectTableBody.appendChild(row);
    });
}


// Function to fetch and display work experience
function displayWorkExperience(empNumber) {
    // AJAX or Fetch logic to get work experience data from the backend
    // Replace the following with your actual data retrieval logic
    
    // Example work experience data (replace this with your actual data)
    const workExperienceData = [
        { name: 'Company A', date: '2020-01', duration: 24 }, // 2 years
        { name: 'Company B', date: '2022-03', duration: 18 }, // 1.5 years
        // Additional work experience data
    ];

    // Update the work experience table with the retrieved data
    const experienceTableBody = document.getElementById('experienceTableBody');
    workExperienceData.forEach(experience => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${experience.name}</td>
            <td>${experience.date}</td>
            <td>${convertMonthsToYears(experience.duration)}</td>
        `;
        experienceTableBody.appendChild(row);
    });
}

// Function to convert months to years and months
function convertMonthsToYears(months) {
    const years = Math.floor(months / 12);
    const remainingMonths = months % 12;

    // 표현을 수정하여 "months"를 추가
    if (years > 0 && remainingMonths > 0) {
        return `${years} years ${remainingMonths} months`;
    } else if (years > 0) {
        return `${years} years`;
    } else {
        return `${remainingMonths} months`;
    }
}

// Function to fetch and display skills
function displaySkills(empNumber) {
    // AJAX or Fetch logic to get skills data from the backend
    // Replace the following with your actual data retrieval logic
    
    // Example skills data (replace this with your actual data)
    const skillsData = [
        { name: 'Skill A', rank: 1 },
        { name: 'Skill B', rank: 2 },
        // Additional skills data
    ];

    // Update the skills table with the retrieved data
    const skillTableBody = document.getElementById('skillTableBody');
    skillsData.forEach(skill => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${skill.name}</td>
            <td>${mapRankToText(skill.rank)}</td>
        `;
        skillTableBody.appendChild(row);
    });
}

// Function to map rank to text
function mapRankToText(rank) {
    switch (rank) {
        case 1:
            return 'Junior';
        case 2:
            return 'Intermediate';
        case 3:
            return 'Senior';
        default:
            return 'Unknown Rank';
    }
}

// Initial function call when the page loads
document.addEventListener('DOMContentLoaded', function () {
    // Extract empNumber from the URL or other source
    const empNumber = '123'; // Replace with your actual logic to extract empNumber
    
    // Call the function to get and display participant details
    getParticipantDetails(empNumber);
});
