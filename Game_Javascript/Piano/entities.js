const WHITE_KEY = 0;
const BLACK_KEY = 1;
class Key extends Entity {
    constructor(x, y, width, height, color, type, src) {
        super();
        [this.x, this.y] = [x, y];
        [this.width, this.height] = [width, height];
        this.color = color;

        this.origin_color = color;
        this.type = type;
        this.audio = new Audio();
        this.audio.src = src;
    }

    update() {

    }

    render() {
        gameEngine.context.beginPath();
        gameEngine.context.fillStyle = this.color;
        gameEngine.context.strokeStyle = "black";
        gameEngine.context.fillRect(this.x, this.y, this.width, this.height);
        gameEngine.context.strokeRect(this.x, this.y, this.width, this.height);
        gameEngine.context.closePath();

    }

    contains(x, y) {
        if (x > this.x && y > this.y && x < this.x + this.width && y < this.y + this.height) {
            return true;
        } else {
            return false;
        }
    }

    play() {
        this.audio.currentTime = 0;
        this.audio.play();

        this.keyActive();
    }

    keyActive() {
        this.color = "gray";
        setTimeout(() => this.color = this.origin_color, 0.1);
        gameEngine.context.fillRect(this.x, this.y, this.width, this.height);
    }

}


class Piano extends Entity {
    constructor(x, y, width, height, color) {
        super();
        [this.x, this.y] = [x, y];
        [this.width, this.height] = [width, height];
        this.color = color;

        this.whiteKeys = [];
        this.blackKeys = [];
        this.keys = [];

        this.generateKey();
    }

    update() {
        if (mouse.downTick || mouse.dragging) {
            let whiteKey = null;
            for (let i in this.keys) {
                let key = this.keys[i];
                if (key.contains(mouse.x, mouse.y)) {
                    if (key.type === BLACK_KEY) {
                        key.play();
                        whiteKey = null;
                        break;
                    } else {
                        whiteKey = key;
                    }
                }
            }
            if (whiteKey) {
                whiteKey.play();
            }
        }
    }

    render() {
        gameEngine.context.beginPath();
        gameEngine.context.strokeStyle = this.color;
        gameEngine.context.fillStyle = "#678";
        gameEngine.context.rect(this.x, this.y, this.width, this.height);
        gameEngine.context.stroke();
        gameEngine.context.fill();
        gameEngine.context.closePath();
    }

    generateKey() {
        for (let i in keyNotes) {
            if (!/[s]/.test(keyNotes[i].name)) {
                keyNotes[i].x = (this.width / 12) + (this.whiteKeys.length * 100);
                this.whiteKeys.push(keyNotes[i]);
            } else {
                keyNotes[i].x = (this.width / 12) + (this.whiteKeys.length * 100) - (100 / 4);
                this.blackKeys.push(keyNotes[i]);
            }
        };

        for (let i in this.whiteKeys) {
            let whiteKey = new Key(
                this.whiteKeys[i].x, (this.height / 2 - 150), 100, 300,
                "white", WHITE_KEY, this.whiteKeys[i].src);
            this.keys.push(whiteKey);
        }
        for (let i in this.blackKeys) {
            let blackKey = new Key(
                this.blackKeys[i].x, (this.height / 2 - 150), 50, 175,
                "black", BLACK_KEY, this.blackKeys[i].src);
            this.keys.push(blackKey);
        }
    }
}