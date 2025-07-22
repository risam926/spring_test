console.log(111);
document.addEventListener("DOMContentLoaded", function () {
	console.log(222);
    // 受け取り場所の切り替え
    document.querySelectorAll('input[name="selectedLocation"]').forEach(radio => {
        radio.addEventListener('change', () => {
            document.getElementById('location1').style.display = radio.value === "1" ? "block" : "none";
            document.getElementById('location2').style.display = radio.value === "2" ? "block" : "none";
        });
    });

    // お支払情報の切り替え
    document.querySelectorAll('input[name="selectedCard"]').forEach(radio => {
        radio.addEventListener('change', () => {
            document.getElementById('cardNumber1').style.display = radio.value === "1" ? "block" : "none";
            document.getElementById('cardNumber2').style.display = radio.value === "2" ? "block" : "none";
        });
    });
});

const radios = document.querySelectorAll('input[name="selectedLocation"]');

 radios.forEach(radio => {
   radio.addEventListener('change', () => {
    console.log("あいうえお");
   });
 });