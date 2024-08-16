// 初期価格を設定します（例: 10000円）
let unitPrice = parseFloat(initialPrice);

// 数量を増やす関数
function increaseQuantity() {
	let quantityInput = document.getElementById('quantity');
	quantityInput.value = parseInt(quantityInput.value) + 1;
	updateTotal();
}

// 数量を減らす関数
function decreaseQuantity() {
	let quantityInput = document.getElementById('quantity');
	if (quantityInput.value > 1) {
		quantityInput.value = parseInt(quantityInput.value) - 1;
		updateTotal();
	}
}

// 合計金額を更新する関数
function updateTotal() {
	let quantity = document.getElementById('quantity').value;
	let totalPrice = document.getElementById('totalPrice');
	totalPrice.textContent = '¥' + (unitPrice * quantity).toLocaleString();
}

// ページ読み込み時に合計金額を初期化
document.addEventListener('DOMContentLoaded', function() {
	updateTotal();
});