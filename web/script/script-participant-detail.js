const APIPATH = "http://localhost:8080/";

// Function to fetch and display participant details
async function getParticipantDetails(empNumber) {
    try {
        const participantData = await fetchParticipantDetails(empNumber);

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
        await displayProjectParticipation(empNumber);
        await displayWorkExperience(empNumber);
        await displaySkills(empNumber);
    } catch (error) {
        console.error('에러 발생:', error);
    }
}

// Function to fetch participant details from the backend
async function fetchParticipantDetails(empNumber) {
    try {
        const response = await fetch(`${APIPATH}employee/detail/${empNumber}`);
        return await response.json();
    } catch (error) {
        console.error(`Error fetching participant details for employee ${empNumber}:`, error);
        throw error;
    }
}

// Function to fetch and display project participation history
async function displayProjectParticipation(empNumber) {
    try {
        const projectParticipationData = await fetchProjectParticipation(empNumber);

        const projectTableBody = document.getElementById('projectTableBody');
        projectTableBody.innerHTML = '';

        projectParticipationData.forEach(project => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${project.projectNumber}</td>
                <td>${project.projectName}</td>
                <td>${project.role}</td>
                <td>${project.startDate}</td>
                <td>${project.endDate}</td>
            `;
            projectTableBody.appendChild(row);
        });
    } catch (error) {
        console.error(`Error fetching project participation for employee ${empNumber}:`, error);
        throw error;
    }
}

// Function to fetch project participation data from the backend
async function fetchProjectParticipation(empNumber) {
    try {
        const response = await fetch(`${APIPATH}employee/project-participation/${empNumber}`);
        return await response.json();
    } catch (error) {
        console.error(`Error fetching project participation for employee ${empNumber}:`, error);
        throw error;
    }
}

// Function to fetch and display work experience
async function displayWorkExperience(empNumber) {
    try {
        const workExperienceData = await fetchWorkExperience(empNumber);

        const experienceTableBody = document.getElementById('experienceTableBody');
        experienceTableBody.innerHTML = '';

        workExperienceData.forEach(experience => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${experience.name}</td>
                <td>${experience.date}</td>
                <td>${convertMonthsToYears(experience.duration)}</td>
            `;
            experienceTableBody.appendChild(row);
        });
    } catch (error) {
        console.error(`Error fetching work experience for employee ${empNumber}:`, error);
        throw error;
    }
}

// Function to fetch work experience data from the backend
async function fetchWorkExperience(empNumber) {
    try {
        const response = await fetch(`${APIPATH}employee/work-experience/${empNumber}`);
        return await response.json();
    } catch (error) {
        console.error(`Error fetching work experience for employee ${empNumber}:`, error);
        throw error;
    }
}

// Function to fetch and display skills
async function displaySkills(empNumber) {
    try {
        const skillsData = await fetchSkills(empNumber);

        const skillTableBody = document.getElementById('skillTableBody');
        skillTableBody.innerHTML = '';

        skillsData.forEach(skill => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${skill.name}</td>
                <td>${mapRankToText(skill.rank)}</td>
            `;
            skillTableBody.appendChild(row);
        });
    } catch (error) {
        console.error(`Error fetching skills for employee ${empNumber}:`, error);
        throw error;
    }
}

// Function to fetch skills data from the backend
async function fetchSkills(empNumber) {
    try {
        const response = await fetch(`${APIPATH}employee/skills/${empNumber}`);
        return await response.json();
    } catch (error) {
        console.error(`Error fetching skills for employee ${empNumber}:`, error);
        throw error;
    }
}

// Function to convert months to years and months
function convertMonthsToYears(months) {
    const years = Math.floor(months / 12);
    const remainingMonths = months % 12;

    if (years > 0 && remainingMonths > 0) {
        return `${years} years ${remainingMonths} months`;
    } else if (years > 0) {
        return `${years} years`;
    } else {
        return `${remainingMonths} months`;
    }
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

function getEmpNumberFromURL() {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get('empNumber');
}

// Initial function call when the page loads
document.addEventListener('DOMContentLoaded', async function () {
    try {
        // Extract empNumber from the URL
        const empNumber = getEmpNumberFromURL();

        // Call the function to get and display participant details
        await getParticipantDetails(empNumber);
    } catch (error) {
        console.error('에러 발생:', error);
    }
});