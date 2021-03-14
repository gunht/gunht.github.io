const canvas = document.getElementById("canvas");

const ctx = canvas.getContext("2d");

canvas.width = innerWidth;
canvas.height = innerHeight;

addEventListener("resize", () => {
    canvas.width = innerWidth;
    canvas.height = innerHeight;
    sqs.forEach((sq) => {
        sq.centerX = canvas.width / 2;
        sq.centerY = canvas.height / 2;
    });
});

class Square {
    constructor(centerX, centerY, width, color, rotate) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.color = color;
        this.rotate = rotate;
    }

    draw() {
        ctx.fillStyle = this.color;

        if (!this.rotate) {
            ctx.fillRect(
                this.centerX - this.width / 2,
                this.centerY - this.width / 2,
                this.width,
                this.width
            );
        } else {
            ctx.save();
            ctx.translate(this.centerX, this.centerY);
            ctx.rotate(Math.PI / 4);
            ctx.fillRect(-this.width / 2, -this.width / 2, this.width, this.width);
            ctx.restore();
        }
    }
}

let centerX = canvas.width / 2;
let centerY = canvas.height / 2;
let sqs = [];

function generate(width, centerX, centerY, numberSquare) {
    let color;
    let rotate;
    for (let i = 0; i < numberSquare; i++) {
        if (i % 2 === 0) {
            color = "#123456";
            rotate = false;
        } else {
            color = "#FFF";
            rotate = true;
        }
        let sq = new Square(
            centerX,
            centerY,
            width / Math.pow(1.414, i),
            color,
            rotate
        );
        sqs.push(sq);
    }
}

generate(400, centerX, centerY, 100);

function animate() {
    requestAnimationFrame(animate);
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    sqs.forEach(item => item.draw());
}

animate();