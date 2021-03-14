class GameManager {
    constructor(cards) {
        this.timeLimit = document.getElementById('time-remaining').value;
        this.cardsArray = cards;
        this.audioController = new AudioController();
    }

    startGame() {
        document.getElementById('time-remaining').value = 198;
        this.timeRemaining = this.timeLimit;
        setTimeout(() => this.countDown = this.countDownTime(), 1000)

        this.cardToCheck = null;
        this.matchedCards = [];
        this.shuffleCards();
        this.waitTime = false;
        this.audioController.startMusic();
        this.resetCards();
    }

    resetCards() {
        this.cardsArray.forEach(card => {
            card.classList.remove('flip');
            card.classList.remove('matched');
            card.classList.remove('hidden');
        });
    }

    countDownTime() {
        return setInterval(() => {
            this.timeRemaining--;
            document.getElementById('time-remaining').value = this.timeRemaining;
            if (this.timeRemaining === 0) {
                this.gameOver();
            }
        }, 1000);
    }

    shuffleCards() {
        this.cardsArray.forEach(card => {
            let ranIndex = Math.floor(Math.random() * (this.cardsArray.length - 1));
            card.style.order = ranIndex;
        })
    }

    checkFlipCard(card) {
        return !this.waitTime &&
            !this.matchedCards.includes(card) &&
            card !== this.cardToCheck;
    }

    flipCard(card) {
        if (this.checkFlipCard(card)) {
            this.audioController.flipCardSound();
            card.classList.add('flip');

            if (this.cardToCheck) {
                this.checkCardMath(card);
            } else {
                this.cardToCheck = card;
            }
        }
    }

    checkCardMath(card) {
        if (this.getValueCard(card) === this.getValueCard(this.cardToCheck)) {
            this.correctCard(card, this.cardToCheck);
        } else {
            this.incorrectCard(card, this.cardToCheck);
        }
        this.cardToCheck = null;
    }

    correctCard(card1, card2) {
        this.matchedCards.push(card1);
        this.matchedCards.push(card2);
        card1.classList.add('matched');
        card2.classList.add('matched');
        card1.classList.add('hidden');
        card2.classList.add('hidden');
        this.audioController.flipCorrectSound();
        if (this.matchedCards.length === this.cardsArray.length) {
            this.victory();
        }
    }

    incorrectCard(card1, card2) {
        this.waitTime = true;
        setTimeout(() => {
            card1.classList.remove('flip');
            card2.classList.remove('flip');
            this.audioController.flipIncorrectSound();
            this.waitTime = false;
        }, 800);

    }

    getValueCard(card) {
        return card.getElementsByClassName('card-value')[0].src;
    }

    victory() {
        clearInterval(this.countDown);
        this.audioController.victorySound();
        document.getElementById('victory').classList.add('visible');
    }

    gameOver() {
        clearInterval(this.countDown);
        this.audioController.gameOverSound();
        document.getElementById('game-over').classList.add('visible');
    }
}

class AudioController {
    constructor() {
        this.bgMusic = new Audio('./audio/bg.mp3');
        this.correctSound = new Audio('./audio/correct.mp3');
        this.incorrectSound = new Audio('./audio/incorrect.mp3');
        this.flipSound = new Audio('./audio/flip.mp3');
        this.winSound = new Audio('./audio/victory.mp3');
        this.loseSound = new Audio('./audio/gameover.mp3');
        this.bgMusic.volume = 0.3;
    }

    startMusic() {
        this.bgMusic.play();
    }

    stopMusic() {
        this.bgMusic.pause();
        this.bgMusic.currentTime = 0;
    }

    flipCardSound() {
        this.flipSound.play();
        this.flipSound.currentTime = 0;
    }

    flipCorrectSound() {
        this.correctSound.play();
        this.correctSound.currentTime = 0;

    }

    flipIncorrectSound() {
        this.incorrectSound.play();
        this.incorrectSound.currentTime = 0;;
    }

    victorySound() {
        this.stopMusic();
        this.winSound.play();
    }

    gameOverSound() {
        this.stopMusic();
        this.loseSound.play();
    }
}


function gameReady() {
    let textLayers = Array.from(document.getElementsByClassName('text-layer'));
    let cards = Array.from(document.getElementsByClassName('card'));
    let game = new GameManager(cards);

    let n = Math.floor(Math.random() * 3 + 1);
    document.body.style.background = `url(./img/bg${n}.png) center center no-repeat`;
    document.body.style.backgroundSize = "cover";

    textLayers.forEach(textLayer => {
        textLayer.addEventListener('click', () => {
            textLayer.classList.remove('visible');
            game.startGame();
        });
    });

    cards.forEach(card => {
        card.addEventListener('click', () => {
            game.flipCard(card);
        });
    });
}

if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', gameReady());
} else {
    gameReady();
}