let canvas = document.getElementById("canvas");

let ctx = canvas.getContext("2d");

canvas.width = innerWidth;
canvas.height = innerHeight;

let x = (canvas.width * 0.1) / 2;
let y = (canvas.height * 0.1) / 2;
let width = canvas.width * 0.9;
let height = canvas.height * 0.9;

addEventListener("resize", () => {
  canvas.width = innerWidth;
  canvas.height = innerHeight;
  x = (canvas.width * 0.1) / 2;
  y = (canvas.height * 0.1) / 2;
  width = canvas.width * 0.9;
  height = canvas.height * 0.9;
  squa.x = x;
  squa.y = y;
  squa.width = width;
  squa.height = height;
});

class Square {
  constructor(x, y, width, height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  draw() {
    ctx.beginPath();
    ctx.strokeStyle = '#333';
    ctx.rect(this.x, this.y, this.width, this.height);
    ctx.stroke();
    ctx.closePath();

    ctx.beginPath()
    ctx.strokeStyle = '#93D05E';
    ctx.moveTo(x, y);
    ctx.lineTo(x + width, y + height);
    ctx.stroke();
    ctx.closePath();

    ctx.beginPath()
    ctx.strokeStyle = '#93D05E';
    ctx.moveTo(x, y + height);
    ctx.lineTo(x + width, y);
    ctx.stroke();
    ctx.closePath();
  }
}

let squa = new Square(x, y, width, height);

function animate() {
    requestAnimationFrame(animate)
    ctx.clearRect(0, 0, canvas.width, canvas.height)
    squa.draw();
}

animate();