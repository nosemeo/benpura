// 現在表示されている日付を保持する変数
let currentDate = new Date();

// 今日の日付を取得
const today = new Date().toDateString();

// イベントデータを日付ごとに定義 (例: 日付とイベント名の配列)
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

	// 最初の日の曜日を取得し、月曜日始まりに調整
	const startDay = (firstDay.getDay() + 6) % 7;

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

		// イベントがある場合、イベントを表示
		if (events[cellDateString]) {
			events[cellDateString].forEach(event => {
				const eventDiv = document.createElement('div');
				eventDiv.className = 'event';
				eventDiv.textContent = event;
				cell.appendChild(eventDiv);
			});
		}

		row.appendChild(cell);

		if ((startDay + day) % 7 === 0) {
			calendarBody.appendChild(row);
			row = document.createElement('tr');
		}
	}

	// 最後の行に空白セルを追加して、7列に調整
	if (row.children.length > 0) {
		while (row.children.length < 7) {
			row.appendChild(document.createElement('td'));
		}
		calendarBody.appendChild(row);
	}

	// 日付の選択肢を追加
	for (let day = 1; day <= lastDay.getDate(); day++) {
		const option = document.createElement('option');
		option.value = `${year}-${String(month + 1).padStart(2, '0')}-${String(day).padStart(2, '0')}`;
		option.textContent = `${year}-${String(month + 1).padStart(2, '0')}-${String(day).padStart(2, '0')}`;
		dateSelect.appendChild(option);
	}

	// 時間の選択肢を追加
	timeSelect.innerHTML = ''; // 時間の選択肢をクリア
	for (let hour = 8; hour <= 20; hour++) {
		for (let minute = 0; minute < 60; minute += 30) {
			const option = document.createElement('option');
			option.value = `${String(hour).padStart(2, '0')}:${String(minute).padStart(2, '0')}`;
			option.textContent = `${String(hour).padStart(2, '0')}:${String(minute).padStart(2, '0')}`;
			timeSelect.appendChild(option);
		}
	}
}

// 月を変更する関数
function changeMonth(offset) {
	currentDate.setMonth(currentDate.getMonth() + offset);
	updateCalendar();
}

// 日時を選択する関数
function selectDateTime() {
	const date = document.getElementById('date-select').value;
	const time = document.getElementById('time-select').value;
	alert(`選択した日付と時間: ${date} ${time}`);
}

// 初期カレンダーを表示
updateCalendar();
