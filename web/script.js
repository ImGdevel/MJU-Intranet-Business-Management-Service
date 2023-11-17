
document.addEventListener("DOMContentLoaded", function() {
    // 가상의 프로젝트 데이터 (실제로는 서버에서 가져와야 함)
    const projects = [
        { id: 1, name: "Project A", startDate: "2023-01-01", endDate: "2023-03-01", client: "Client X" },
        { id: 2, name: "Project B", startDate: "2023-02-01", endDate: "2023-04-01", client: "Client Y" },
        // 추가 프로젝트 데이터...
    ];

    // 프로젝트 목록을 보여주는 엘리먼트
    const projectListElement = document.getElementById("project-list");

    // 프로젝트 목록을 동적으로 생성
    projects.forEach(project => {
        const projectElement = document.createElement("div");
        projectElement.classList.add("project-item");

        projectElement.innerHTML = `
            <h3>${project.name}</h3>
            <p>Project ID: ${project.id}</p>
            <p>Start Date: ${project.startDate}</p>
            <p>End Date: ${project.endDate}</p>
            <p>Client: ${project.client}</p>
        `;

        projectListElement.appendChild(projectElement);
    });
});