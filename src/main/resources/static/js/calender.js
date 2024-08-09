// 現在表示されている日付を保持する変数
let currentDate = new Date();

// 今日の日付を取得
const today = new Date().toDateString();

// イベントデータを日付ごとに定義
const events = {
    "2024-08-04": ["イベントA"],
    "2024-08-10": ["イベントB"],
    "2024-08-15": ["イベントC"],
    "2024-08-25": ["イベントD", "イベントE"],
};

// カレンダーを更新する関数
function updateCalendar() {
    const calendarBody = document.getElementById('calendar-body');
    const monthYear = document.getElementById('month-year');
    const dateSelect = document.getElementById('date-select');
    const timeSelect = document.getElementById('time-select');
    calendarBody.innerHTML = ''; // カレンダーの中身をクリア
    dateSelect.innerHTML = ''; // 日付の選択肢をクリア

    // 現在の月の最初の日と最後の日を取得
    const year = currentDate.getFullYear();
    const month = currentDate.getMonth();
    const firstDay = new Date(year, month, 1);
    const lastDay = new Date(year, month + 1, 0);

    // 月と年を表示
    const options = { year: 'numeric', month: 'long' };
    monthYear.textContent = currentDate.toLocaleDateString('ja-JP', options);

    // 最初の日の曜日を取得
    const startDay = (firstDay.getDay() + 6) % 7; // 月曜始まりに修正

    // カレンダーの日付を埋める
    let row = document.createElement('tr');
    for (let i = 0; i < startDay; i++) {
        row.appendChild(document.createElement('td')); // 空白セルを追加
    }

    // 月の日付を埋める
    for (let day = 1; day <= lastDay.getDate(); day++) {
        const cell = document.createElement('td');
        const cellDate = new Date(year, month, day);
        const cellDateString = cellDate.toISOString().split('T')[0];
        cell.textContent = day;

        // 今日の日付の場合、クラスを追加して強調表示
        if (cellDate.toDateString() === today) {
            cell.classList.add('today');
        }

        // イベントがある日付にイベントを表示
        if (events[cellDateString]) {
            events[cellDateString].forEach(event => {
                const eventElement = document.createElement('div');
                eventElement.classList.add('event');
                eventElement.textContent = event;
                cell.appendChild(eventElement);
            });
        }

        row.appendChild(cell);

        // 週の終わりに行を追加
        if ((startDay + day) % 7 === 0) {
            calendarBody.appendChild(row);
            row = document.createElement('tr');
        }

        // 日付の選択肢を追加
        const option = document.createElement('option');
        option.value = cellDateString;
        option.textContent = `${cellDateString} (${['日', '月', '火', '水', '木', '金', '土'][cellDate.getDay()]})`;
        dateSelect.appendChild(option);
    }

    // 最後の行を追加
    calendarBody.appendChild(row);

    // 時間の選択肢を設定（30分おき）
    for (let hour = 21; hour < 24; hour++) {
        for (let minute = 0; minute < 60; minute += 30) {
            const option = document.createElement('option');
            option.value = `${hour.toString().padStart(2, '0')}:${minute.toString().padStart(2, '0')}`;
            option.textContent = `${hour.toString().padStart(2, '0')}:${minute.toString().padStart(2, '0')}`;
            timeSelect.appendChild(option);
        }
    }
    for (let hour = 0; hour <= 20; hour++) {
        for (let minute = 0; minute < 60; minute += 30) {
            const option = document.createElement('option');
            option.value = `${hour.toString().padStart(2, '0')}:${minute.toString().padStart(2, '0')}`;
            option.textContent = `${hour.toString().padStart(2, '0')}:${minute.toString().padStart(2, '0')}`;
            timeSelect.appendChild(option);
        }
    }
}

// 月を変更する関数
function changeMonth(offset) {
    currentDate.setMonth(currentDate.getMonth() + offset);
    updateCalendar();
}

// 日時選択の処理
function selectDateTime() {
    const dateSelect = document.getElementById('date-select');
    const timeSelect = document.getElementById('time-select');
    const selectedDate = dateSelect.value;
    const selectedTime = timeSelect.value;
    alert(`選択された日時: ${selectedDate} ${selectedTime}`);
}

// 初期表示のカレンダーを更新
document.addEventListener('DOMContentLoaded', updateCalendar);
