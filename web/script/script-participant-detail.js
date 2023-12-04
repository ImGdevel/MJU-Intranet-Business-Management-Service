const APIPATH = "http://localhost:8080/";

async function getParticipantDetails(empNumber) {
    try {
        const participantData = await fetchParticipantDetails(empNumber);

        const details = `
            <h2>${participantData.emp_name}</h2>
            <p>Resident Registration Number: ${participantData.person_num}</p>
            <p>Highest Education Level: ${participantData.edu_level}</p>
            <p>Position: ${participantData.position}</p>
            <p>Department: ${participantData.dept_num.dept_name}</p>
        `;

        const participantText = document.getElementById('participantText');
        participantText.innerHTML = details;

        // Call functions to display work experience, skills, and project participation history
        await displayProjectParticipationHistory(empNumber);
        await displayCareerInformation(empNumber);
        await displaySkills(empNumber);
    } catch (error) {
        console.error('에러 발생:', error);
    }
}

async function fetchParticipantDetails(empNumber) {
    try {
        const response = await fetch(`${APIPATH}employee/${empNumber}`);
        return await response.json();
    } catch (error) {
        console.error(`Error fetching participant details for employee ${empNumber}:`, error);
        throw error;
    }
}

// Function to fetch and display project participation history for a participant
async function displayProjectParticipationHistory(empNumber) {
    try {
        const projectParticipationHistory = await fetchProjectParticipationHistory(empNumber);

        const projectParticipationTableBody = document.getElementById('projectParticipationTableBody');
        projectParticipationTableBody.innerHTML = '';

        // Use Promise.all to handle multiple asynchronous operations concurrently
        const rows = await Promise.all(projectParticipationHistory.map(async record => {
            const projectName = await fetchProjectName(record.proj_num);
            
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${record.proj_num}</td>
                <td>${projectName}</td>
                <td>${record.role_num.role_name}</td>
                <td>${record.proj_in.split(' ')[0]}</td>
                <td>${record.proj_out.split(' ')[0]}</td>
            `;
            return row;
        }));

        // Append all rows to the table body
        rows.forEach(row => {
            projectParticipationTableBody.appendChild(row);
        });
    } catch (error) {
        console.error(`Error fetching project participation history for employee ${empNumber}:`, error);
        throw error;
    }
}


async function fetchProjectName(projectId) {
    try {
        const response = await fetch(`${APIPATH}project/name/${projectId}`);
        const projectName = await response.text(); // Assuming the response is plain text with the project name
        return projectName;
    } catch (error) {
        console.error(`Error fetching project name for project ${projectId}:`, error);
        throw error;
    }
}

// Function to fetch project participation history data from the backend
async function fetchProjectParticipationHistory(empNumber) {
    try {
        const response = await fetch(`${APIPATH}project-participant/emp/${empNumber}`);
        return await response.json();
    } catch (error) {
        console.error(`Error fetching project participation history for employee ${empNumber}:`, error);
        throw error;
    }
}


// Function to fetch and display career information
async function displayCareerInformation(empNumber) {
    try {
        const careerData = await fetchCareerInformation(empNumber);

        const experienceTableBody = document.getElementById('experienceTableBody');
        experienceTableBody.innerHTML = '';

        careerData.forEach(career => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${career.cr_text}</td>
                <td>${career.cr_start_date.split(' ')[0]}</td>
                <td>${convertDaysToYearsAndMonths(career.cr_period)}</td>
            `;
            experienceTableBody.appendChild(row);
        });
    } catch (error) {
        console.error(`Error fetching career information for employee ${empNumber}:`, error);
        throw error;
    }
}

// Function to fetch career information from the backend
async function fetchCareerInformation(empNumber) {
    try {
        const response = await fetch(`${APIPATH}Career/${empNumber}`);
        return await response.json();
    } catch (error) {
        console.error(`Error fetching career information for employee ${empNumber}:`, error);
        throw error;
    }
}

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

// Function to fetch skill name based on skill number
async function fetchSkillName(skillNumber) {
    try {
        const response = await fetch(`${APIPATH}SkillClassification/${skillNumber}`);
        const skillName = await response.text(); // Assuming the response is plain text with the skill name
        return skillName;
    } catch (error) {
        console.error(`Error fetching skill name for skill ${skillNumber}:`, error);
        throw error;
    }
}

// Function to fetch skills data from the backend
async function fetchSkills(empNumber) {
    try {
        const response = await fetch(`${APIPATH}Skill/${empNumber}`);
        return await response.json();
    } catch (error) {
        console.error(`Error fetching skills for employee ${empNumber}:`, error);
        throw error;
    }
}


// Inside the displaySkills function
async function displaySkills(empNumber) {
    try {
        const skillsData = await fetchSkills(empNumber);

        const skillTableBody = document.getElementById('skillTableBody');
        skillTableBody.innerHTML = '';

        skillsData.forEach(async skill => {
            const skillName = await fetchSkillName(skill.skill_num);

            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${skillName}</td>
                <td>${mapSkillLevelToText(skill.skill_level)}</td>
            `;
            skillTableBody.appendChild(row);
        });
    } catch (error) {
        console.error(`Error fetching skills for employee ${empNumber}:`, error);
        throw error;
    }
}

function convertDaysToYearsAndMonths(days) {
    const years = Math.floor(days / 365);
    const remainingDays = days % 365;
    const months = Math.floor(remainingDays / 30); // Assuming an average month has 30 days
    const remainingMonths = remainingDays % 30;

    if (years > 0 && months > 0) {
        return `${years} 년 ${months} 개월`;
    } else if (years > 0) {
        return `${years} 년`;
    } else {
        return `${months} 개월`;
    }
}



function mapSkillLevelToText(rank) {
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

document.addEventListener('DOMContentLoaded', async function () {
    try {
        const empNumber = getEmpNumberFromURL();
        console.log(empNumber);
        await getParticipantDetails(empNumber);
    } catch (error) {
        console.error('에러 발생:', error);
    }
});
