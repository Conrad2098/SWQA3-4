function bmi(){

var height = document.getElementById("height").value;
var weight = document.getElementById("weight").value;
var msg =- "";

var sq = height * height;
var bmi = 703 * (weight / sq);

bmi = bmi.toFixed(2);

if(bmi < 18.5){
msg = "\nYour BMI classification is Underweight.";
}else if( bmi >= 18.5 && bmi <= 24.9){
msg = "\nYour BMI classification is Normal Weight.";
}else if( bmi >= 25 && bmi <= 29.9){
msg = "\nYour BMI classification is Overweight.";
}else if( bmi > 30){
msg = "\nYour BMI classification is Obese.";
}

document.getElementById("bmi").innerHTML = bmi + " " + msg;
}

function retire(){

var age = parseInt(document.getElementById("age").value, 10);
var sal = document.getElementById("salary").value;
var saved = document.getElementById("saved").value;
var goal = document.getElementById("goal").value;

var msg = "";

var percent = saved / 100;
var yearlySaved = (sal * percent) + ((sal * percent) * 0.35);
var addNum = Math.ceil(goal / yearlySaved);
var finalAge = Math.ceil(addNum + age);

if(finalAge > 100){
msg = "You would be dead by that point.";
}

document.getElementById("finAge").innerHTML = finalAge + ". " + msg;
}