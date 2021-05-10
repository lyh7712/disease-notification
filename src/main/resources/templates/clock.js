function clock() {

    var clockTarget1 = document.querySelector('.clock');

    let data = new Date();
    let month = data.getMonth();
    let date = data.getDate();
    let day = data.getDay();
    let week = ['일', '월', '화', '수', '목', '금', '토'];

    clockTarget1.innerHTML = `${month + 1}월 ${date}일 ${week[day]}요일`;

}


function init() {
    setInterval(clock, 1000);
}


function clock2() {

    var clockTarget2 = document.querySelector('.clock2');

    let data = new Date();
    let hours = data.getHours();
    let minutes = data.getMinutes();
    let seconds = data.getSeconds();

    clockTarget2.innerHTML = `${hours}:${minutes}:${seconds}`;
    `${hours < 10 ? `0${hours}` : hours}:${minutes < 10 ? `0${minutes }`  : minutes }:${seconds < 10 ? `0${seconds }`  : seconds }`;

}
function init2() {
    setInterval(clock2, 1000);
}