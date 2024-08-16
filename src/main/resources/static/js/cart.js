function updateTotal(selectElement) {
			const priceElement = selectElement.closest('.product').querySelector('.price');
			const fullPriceElement = selectElement.closest('.product').querySelector('.full-price');
			const quantity = selectElement.value;
			const price = parseFloat(priceElement.textContent.replace('円', ''));
			const fullPrice = parseFloat(fullPriceElement.textContent.replace('円', ''));
			const newPrice = price * quantity;
			const newFullPrice = fullPrice * quantity;

			priceElement.textContent = newPrice + '円';
			fullPriceElement.textContent = newFullPrice + '円';

			updateSubtotal();
		}

		function updateSubtotal() {
			const prices = document.querySelectorAll('.price');
			let subtotal = 0;
			prices.forEach(price => {
				subtotal += parseFloat(price.textContent.replace('円', ''));
			});
			const tax = subtotal * 0.05;
			const total = subtotal + tax;

			document.getElementById('subtotal').textContent = subtotal.toFixed(2) + '円';
			document.getElementById('tax').textContent = tax.toFixed(2) + '円';
			document.getElementById('total').textContent = total.toFixed(2) + '円';
		}