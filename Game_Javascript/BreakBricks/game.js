const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");

//Add border Canvas
canvas.style.border = "2px solid black";
//Create the paddle
class Paddle {
    constructor(x, y, width, height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    draw() {
        ctx.fillStyle = "gray";
        ctx.fillRect(this.x, this.y, this.width, this.height);
    }

    move() {
        this.x = event.offsetX;
        if (this.x + this.width > canvas.width) {
            this.x = canvas.width - this.width;
        }
    }
}

class Ball {
    constructor(x, y, radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.dx = 0;
        this.dy = 0;
        this.speed = 5;
        this.life = 3;

    }

    draw() {
        ctx.beginPath();
        ctx.arc(this.x, this.y, this.radius, 0, Math.PI * 2);
        ctx.fillStyle = "red";
        ctx.fill();
        ctx.closePath();
    }

    move() {
        //Collision Wall
        if (this.x + this.radius > canvas.width || this.x - this.radius < 0) {
            this.dx = -this.dx;
        }
        if (this.y - this.radius < 0) {
            this.dy = -this.dy;
        }
        if (this.y + this.radius > canvas.height) {
            this.life--;
            Life_lost.play();
            this.resetBall();
        }
        if (this.x + this.radius > paddle.x &&
            this.x - this.radius < paddle.x + paddle.width &&
            this.y + this.radius > paddle.y &&
            this.y - this.radius < paddle.y + paddle.height) {

            Paddle_hit.play();

            //check where the ball hit paddle
            let collidePoint = this.x - (paddle.x + paddle.width / 2);
            collidePoint /= paddle.width / 2;

            //angle of the ball
            let angle = collidePoint * (Math.PI / 3);

            this.dx = this.speed * Math.sin(angle);
            this.dy = -this.speed * Math.cos(angle);
        }

        this.x += this.dx;
        this.y += this.dy;
        this.draw();
    }

    resetBall() {
        this.x = canvas.width / 2;
        this.y = paddle.y - 20;
        this.dx = 4 * (Math.random() * 2 - 1);
        this.dy = -4;
    }
}

class Brick {
    constructor(x, y, width, height, status) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.status = status;
    }

    draw() {
        ctx.beginPath();
        ctx.fillStyle = "blue";
        ctx.fillRect(this.x, this.y, this.width, this.height);
        ctx.closePath();
    }

}

class BrickManager {
    constructor(row, col) {
        this.row = row;
        this.col = col;

        this.bricks = [];
        this.width = 55;
        this.height = 20;
        this.padding = 20;
        this.marginTop = 40;

        this.score = 0;
        this.score_win = this.row * this.col;

        this.generate();
    }

    draw() {
        this.bricks.forEach(item => {
            if (item.status) {
                item.draw();
            }
        })
    }

    generate() {
        for (let r = 0; r < this.row; r++) {
            for (let c = 0; c < this.col; c++) {
                let brick = new Brick(
                    c * (this.padding + this.width) + this.padding,
                    r * (this.padding + this.height) + this.padding + this.marginTop,
                    this.width,
                    this.height,
                    true
                );
                this.bricks.push(brick);
            }
        }
    }

    collistionDetection() {
        for (let i in this.bricks) {
            if (this.bricks[i].status) {
                if (ball.x > this.bricks[i].x - ball.radius &&
                    ball.x < this.bricks[i].x + this.width + ball.radius &&
                    ball.y > this.bricks[i].y - ball.radius &&
                    ball.y < this.bricks[i].y + this.height + ball.radius) {
                    Brick_hit.play();
                    ball.dy = -ball.dy;
                    this.bricks[i].status = false;
                    this.score++;
                }
            }
        }
        this.draw();
    }
}

class Scene {
    constructor() {
        this.level = 1;
        this.max_level = 3;
        this.Game_Over = false;
    }

    drawBg() {
        ctx.drawImage(BG, 0, 0);
    }

    drawScore() {
        ctx.beginPath();
        ctx.fillStyle = "#000";
        ctx.font = "25px Germania One";
        ctx.fillText(brickManager.score * 100, 35, 25);
        ctx.drawImage(Score, 5, 5, 25, 25);
        ctx.closePath();
    }

    drawLevel() {
        ctx.beginPath();
        ctx.fillStyle = "#000";
        ctx.font = "25px Germania One";
        ctx.fillText(this.level, canvas.width / 2, 25);
        ctx.drawImage(Level, canvas.width / 2 - 30, 5, 25, 25);
        ctx.closePath();
    }

    drawLife() {
        ctx.beginPath();
        ctx.fillStyle = "#000";
        ctx.font = "25px Germania One";
        ctx.fillText(ball.life, canvas.width - 25, 25);
        ctx.drawImage(Life, canvas.width - 55, 5, 25, 25);
        ctx.closePath();
    }

    gameOver() {
        if (ball.life <= 0) {
            showYouLose();
            this.Game_Over = true;
            return;
        }
    }

    levelUp() {
        let levelDone = true;
        for (let i in brickManager.bricks) {
            levelDone = levelDone && !brickManager.bricks[i].status;
        }
        if (levelDone) {
            Win.play();
            if (this.level >= this.max_level) {
                showYouWin();
                this.Game_Over = true;
                return;
            }
            brickManager.row++;
            ball.speed++;
            ball.resetBall();
            brickManager.generate();
            this.level++;
        }
    }
}

let paddle = new Paddle(canvas.width / 2 - 50, canvas.height - 70, 100, 10);
let ball = new Ball(canvas.width / 2, paddle.y - 20, 10);
let brickManager = new BrickManager(3, 5);
let scene = new Scene();

addEventListener("mousemove", () => paddle.move());

addEventListener("keydown", (event) => {
    if (event.keyCode == 32) {
        ball.dx = 3 * (Math.random() * 2 - 1);
        ball.dy = -3;
    }
});

function animate() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    scene.gameOver();
    scene.levelUp();
    scene.drawBg();
    scene.drawScore();
    scene.drawLevel();
    scene.drawLife();
    paddle.draw();
    ball.move();
    brickManager.collistionDetection();


    if (!scene.Game_Over) {
        requestAnimationFrame(animate);
    }
}
animate();