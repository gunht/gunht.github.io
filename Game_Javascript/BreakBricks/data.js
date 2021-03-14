//Images
const BG = new Image();
BG.src = "./images/bg.jpg";

const Life = new Image();
Life.src = "./images/life.png";

const Level = new Image();
Level.src = "./images/level.png";

const Score = new Image();
Score.src = "./images/score.png";

//Audio
const Paddle_hit = new Audio();
Paddle_hit.src = "./audio/paddle_hit.mp3";

const Brick_hit = new Audio();
Brick_hit.src = "./audio/brick_hit.mp3";

const Life_lost = new Audio();
Life_lost.src = "./audio/life_lost.mp3";

const Win = new Audio();
Win.src = "./audio/win.mp3";

//Show Gameover on HTML
const game_over = document.getElementById("game_over");
const you_won = document.getElementById("you_won");
const you_lose = document.getElementById("you_lose");
const play_again = document.getElementById("play_again");

play_again.addEventListener("click", () => location.reload());

function showYouWin() {
    game_over.style.display = "block";
    you_won.style.display = "block";
}

function showYouLose() {
    game_over.style.display = "block";
    you_lose.style.display = "block";
}