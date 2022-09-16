const hoursElement = document.querySelector('.hours')
const datamesanoElement = document.querySelector('.datamesano')

function convertDate(value) {
    // String.format("%02d", month);
    return String(value).padStart(2, "0");


}

function getDate() {
    const date = new Date();
    const hours = date.getHours() > 24 ? convertDate(date.getHours() - 24) : convertDate(date.getHours());
    const minuts = convertDate(date.getMinutes());
    const seconds = convertDate(date.getSeconds());
    const day = date.getDate();
    const month = (date.getMonth()+2).toString().padStart(2, '0');
    const year = date.getFullYear();
    return { hours, minuts, seconds, day, month, year };
}

function montDOM() {
    const { hours, minuts, seconds, year, month, day } = getDate();
    hoursElement.innerHTML = `${hours}:${minuts}:${seconds}`;
    datamesanoElement.innerHTML = `${day}/${month}/${year}`;
}

function enableClock() {
    const init = () => setInterval(montDOM, 1000);
    return { init }
}

const clock = enableClock();
clock.init();
