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
}

// Initial function call when the page loads
document.addEventListener('DOMContentLoaded', function () {
    // Extract empNumber from the URL or other source
    const empNumber = '123'; // Replace with your actual logic to extract empNumber
    
    // Call the function to get and display participant details
    getParticipantDetails(empNumber);
});
