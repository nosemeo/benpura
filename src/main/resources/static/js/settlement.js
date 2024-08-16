// 商品の単価（例：10,000円）
const unitPrice = 10000;

// 数量を増やす関数
function increaseQuantity() {
	const quantityInput = document.getElementById('quantity');
	quantityInput.value = parseInt(quantityInput.value) + 1;
	updateTotal();
}

// 数量を減らす関数
function decreaseQuantity() {
	const quantityInput = document.getElementById('quantity');
	if (parseInt(quantityInput.value) > 1) {
		quantityInput.value = parseInt(quantityInput.value) - 1;
		updateTotal();
	}
}

// 合計金額を更新する関数
function updateTotal() {
	const quantity = parseInt(document.getElementById('quantity').value);
	const total = quantity * unitPrice;
	document.getElementById('totalPrice').textContent = `¥${total.toLocaleString()}`;
}

// ページ読み込み時に合計を初期化
window.onload = updateTotal;