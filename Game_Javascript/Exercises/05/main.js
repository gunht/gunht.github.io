let canvas = document.getElementById("canvas");
canvas.width = innerWidth;
canvas.height = innerHeight;

let ctx = canvas.getContext("2d");

class Point {
  constructor(x, y) {
    this.x = x;
    this.y = y;
  }
}

class Triangle {
  constructor(pointA, pointB, pointC) {
    this.pointA = pointA;
    this.pointB = pointB;
    this.pointC = pointC;
  }

  draw() {
    ctx.beginPath();
    ctx.moveTo(this.pointA.x, this.pointA.y);
    ctx.lineTo(this.pointB.x, this.pointB.y);
    ctx.lineTo(this.pointC.x, this.pointC.y);
    ctx.lineTo(this.pointA.x, this.pointA.y);
    ctx.stroke();
    ctx.closePath();

    ctx.beginPath();
    ctx.setLineDash([5, 10]);
    ctx.strokeStyle = "blue";
    ctx.moveTo(this.pointA.x, this.pointA.y);
    ctx.lineTo(
      (this.pointB.x + this.pointC.x) / 2,
      (this.pointB.y + this.pointC.y) / 2
    );
    ctx.stroke();
    ctx.closePath();

    ctx.beginPath();
    ctx.setLineDash([5, 10]);
    ctx.strokeStyle = "blue";
    ctx.moveTo(this.pointB.x, this.pointB.y);
    ctx.lineTo(
      (this.pointA.x + this.pointC.x) / 2,
      (this.pointA.y + this.pointC.y) / 2
    );
    ctx.stroke();
    ctx.closePath();

    ctx.beginPath();
    ctx.setLineDash([5, 10]);
    ctx.strokeStyle = "blue";
    ctx.moveTo(this.pointC.x, this.pointC.y);
    ctx.lineTo(
      (this.pointB.x + this.pointA.x) / 2,
      (this.pointB.y + this.pointA.y) / 2
    );
    ctx.stroke();
    ctx.closePath();
  }
}

let pA = new Point(50, 50);
let pB = new Point(100, 700);
let pC = new Point(600, 700);

let tri = new Triangle(pA, pB, pC);
tri.draw();
