const APIPATH = "http://localhost:8080/";


//색깔표
const textColors = [
  '#FF4136', // 진한 빨간색 배경
  '#FFDC00', // 진한 노란색 배경
  '#2ECC40', // 진한 초록색 배경
  '#FF851B', // 진한 주황색 배경
  '#7FDBFF', // 진한 보라색 배경
  '#0074D9', // 진한 초록빛 파란색 배경
  '#B10DC9', // 진한 연두색 배경
  '#FF1493', // 진한 분홍색 배경
  '#808080', // 진한 회색 배경
  '#8B4513', // 진한 갈색 배경
  '#D3D3D3', // 진한 은색 배경
  '#FFD700', // 진한 황갈색 배경
  '#32CD32', // 진한 연두색 배경
  '#4B0082', // 진한 인디고 배경
  '#808000', // 진한 올리브색 배경
  '#00FFFF', // 진한 아쿠아색 배경
  '#00FF00', // 진한 라임색 배경
  '#FF00FF'  // 진한 마젠타색 배경
];

// Function to get project number from the URL
function getProjectNumberFromURL() {
  const urlParams = new URLSearchParams(window.location.search);
  return urlParams.get('projectNumber');
}

let colorIndex = 0; // 전역 변수로 선언하여 색상 인덱스를 유지

function getNextColor() {
  const color = textColors[colorIndex];
  colorIndex = (colorIndex + 1) % textColors.length; // 다음 색상 인덱스로 업데이트
  return color;
}


// 이벤트를 가져오는 함수
async function getEvents(projectNumber) {
  try {
    console.log(`Schedule/${projectNumber}`);
    const response = await fetch(`${APIPATH}Skhedule/${projectNumber}`);
    console.log(response)

    const scheduleData = await response.json();

    console.log(scheduleData);

    const events = await Promise.all(scheduleData.map(async schedule => ({
      title: schedule.sche_contents,
      start: schedule.sche_start_date.split(' ')[0],
      end: schedule.sche_end_date.split(' ')[0],
      color: getNextColor(),
      id: await fetchEmployeeName(schedule.emp_num)
    })));

    return events;
  } catch (error) {
    console.error('Error fetching schedule data:', error);
    return [];
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


async function initializeCalendar(projectNumber) {
  let calendarEl = document.getElementById('calendar');

  let defaultDate = '2023-11'; // 실시간 현제 날짜로
  console.log(projectNumber);

  let events = await getEvents(projectNumber);

  console.log(events);

  var calendar = new FullCalendar.Calendar(calendarEl, {
    plugins: ['interaction', 'dayGrid'],
    header: {
      left: 'prevYear,prev,next,nextYear today',
      center: 'title',
      right: 'dayGridMonth,dayGridWeek,dayGridDay'
    },
    defaultDate: defaultDate,
    navLinks: true,
    editable: true,
    eventLimit: true,
    events: events,
    views: {
      dayGridMonth: {
        eventLimit: false
      }
    },
    eventRender: renderEventContent
  });

  calendar.render();
}

// 이벤트 렌더링 함수
function renderEventContent(info) {
  var eventContent = '';
  eventContent += '<div class="event-title">' + '● ' + info.event.id + ' ' + info.event.title + '</div>';

  info.el.innerHTML = eventContent;
  info.el.style.display = 'flex';
  info.el.style.height = '17px';
}


document.addEventListener('DOMContentLoaded', function () {
  // 프로젝트 번호를 원하는 값으로 설정
  const projectNumber = getProjectNumberFromURL();
  
  // FullCalendar 초기화
  initializeCalendar(projectNumber);
});