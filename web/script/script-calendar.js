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

function initializeCalendar() {
  let calendarEl = document.getElementById('calendar');

  let defaultDate = '2023-12'; // 실시간 현제 날짜로
  let proj_number = getProjectNumberFromURL();

  console.log(proj_number);

  let events = [];// getEvents(proj_number);

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


// 이벤트를 가져오는 함수
async function getEvents(projectNumber) {
  try {
    const response = await fetch(`${APIPATH}Schedule/${projectNumber}`);
    
    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }

    const scheduleData = await response.json();

    // Map Spring schedule data to FullCalendar event format
    const events = scheduleData.map(schedule => ({
      title: schedule.sche_contents,
      start: schedule.sche_start_date,
      end: schedule.sche_end_date,
      color: getRandomColor(), // Use a function to get a random color or use a predefined set of colors
      id: schedule.sche_num.toString()
    }));

    return events;
  } catch (error) {
    console.error('Error fetching schedule data:', error);
    return [];
  }
}

// 페이지 로드 시 프로젝트 목록을 가져와서 표시
document.addEventListener('DOMContentLoaded', function () {
  initializeCalendar();
});