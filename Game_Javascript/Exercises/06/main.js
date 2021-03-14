let canvas = document.getElementById("canvas");
let ctx = canvas.getContext("2d");

canvas.width = innerWidth;
canvas.height = innerHeight;

let centerX = canvas.width / 2;
let centerY = canvas.height / 2;
let lists = [];

addEventListener("resize", () => {
    canvas.width = innerWidth;
    canvas.height = innerHeight;
    centerX = canvas.width / 2;
    centerY = canvas.height / 2;
    lists.forEach((item) => {
        item.centerX = centerX;
        item.centerY = centerY;
    });
});

class Rect {
    constructor(centerX, centerY, width, color, isSquare) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.color = color;
        this.isSquare = isSquare;
    }

    draw() {
        ctx.fillStyle = this.color;

        if (!this.isSquare) {
            ctx.beginPath();
            ctx.arc(
                this.centerX,
                this.centerY,
                this.width / 2,
                0,
                Math.PI * 2,
                false
            );
            ctx.stroke();
            ctx.fill();
            ctx.closePath();
        } else {
            ctx.beginPath();
            ctx.rect(
                this.centerX - this.width / 2,
                this.centerY - this.width / 2,
                this.width,
                this.width
            );
            ctx.stroke();
            ctx.fill();
            ctx.closePath();
        }
    }
}

function generate(count, centerX, centerY, width) {
    let isSquare;
    let powNumber = 0;
    for (let i = 0; i < count; i++) {
        if (i % 2 === 0) {
            isSquare = false;
            console.log(width / Math.pow(1.413, powNumber))
        } else {
            isSquare = true;
            powNumber++;
            console.log(width / Math.pow(1.413, powNumber))
        }
        let rect = new Rect(
            centerX,
            centerY,
            width / Math.pow(1.413, powNumber),
            rgb(),
            isSquare
        );
        lists.push(rect);
    }
}

generate(10, centerX, centerY, 400);

function rgb() {
    color = "rgb(";
    for (var i = 0; i < 3; i++) {
        color += Math.floor(Math.random() * 255) + ",";
    }
    return color.replace(/\,$/, ")");
}

function animate() {
    requestAnimationFrame(animate);
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    lists.forEach((item) => item.draw());
}

animate();