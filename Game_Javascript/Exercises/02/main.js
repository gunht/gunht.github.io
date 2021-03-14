const canvas = document.getElementById('canvas');
const ctx = canvas.getContext('2d');

canvas.width = innerWidth;
canvas.height = innerHeight;

class Ball {
    constructor(x, y, radius, color) {
        this.x = x;
        this.y = y;
        this.dx = 0
        this.isRun = false
        this.radius = radius;
        this.color = color;
    }

    draw() {
        ctx.beginPath();
        ctx.fillStyle = this.color;
        ctx.arc(this.x, this.y, this.radius, 0, Math.PI * 2, false);
        ctx.fill();
        ctx.stroke();
        ctx.closePath();
    }

    move() {

        if (this.isRun){
            this.dx += 0.02;
        } else {
            if(this.dx > 0){
                this.dx -= 0.02;
            }
        }
        this.x = this.x + this.dx;
        this.draw();
    }
}


addEventListener('keydown', function(event) {
    if (event.keyCode === 32) {
        // ball.dx = 2;
        ball.isRun = !ball.isRun;
        this.console.log('ok', ball.isRun)
    }
});


const ball = new Ball(30, canvas.height / 2, 20, 'red');
ball.draw();

function animate(){
    requestAnimationFrame(animate);
    // ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ball.move();
}

animate();