/**
 * @param {number} width
 * @param {number} height
 */
var Robot = function(width, height) {
    this.width = width;
    this.height = height;
    this.perimeter = 2 * (width + height) - 4;
    this.index = 0;
    this.moved = false;
};

/**
 * @param {number} num
 * @return {void}
 */
Robot.prototype.step = function(num) {
    this.moved = true;
    let steps = num % this.perimeter;
    if (steps === 0) {
        steps = this.perimeter;
    }
    this.index = (this.index + steps) % this.perimeter;
};

/**
 * @return {number[]}
 */
Robot.prototype.getPos = function() {
    return [this.getX(), this.getY()];
};

/**
 * @return {string}
 */
Robot.prototype.getDir = function() {
    if (this.index === 0) {
        return this.moved ? "South" : "East";
    }
    if (this.index < this.width) {
        return "East";
    }
    if (this.index < this.width + this.height - 1) {
        return "North";
    }
    if (this.index < 2 * this.width + this.height - 2) {
        return "West";
    }
    return "South";
};

Robot.prototype.getX = function() {
    if (this.index < this.width) {
        return this.index;
    }
    if (this.index < this.width + this.height - 1) {
        return this.width - 1;
    }
    if (this.index < 2 * this.width + this.height - 2) {
        return 2 * this.width + this.height - 3 - this.index;
    }
    return 0;
};

Robot.prototype.getY = function() {
    if (this.index < this.width) {
        return 0;
    }
    if (this.index < this.width + this.height - 1) {
        return this.index - this.width + 1;
    }
    if (this.index < 2 * this.width + this.height - 2) {
        return this.height - 1;
    }
    return this.perimeter - this.index;
};

/**
 * Your Robot object will be instantiated and called as such:
 * var obj = new Robot(width, height)
 * obj.step(num)
 * var param_2 = obj.getPos()
 * var param_3 = obj.getDir()
 */
