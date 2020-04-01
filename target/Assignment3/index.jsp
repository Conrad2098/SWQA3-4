<html>
<script>
    function bmi(){

        const height = document.getElementById("height").value;
        const weight = document.getElementById("weight").value;
        let msg = "";

        if(height > 120 || height < 1 || weight > 1000 || weight < 1){
            alert("The weight must be less than 1000 pounds and the height must be less than 120 inches.\nBoth must be greater than 0.");
        }else{

            const sq = height * height;
            let bmi = 703 * (weight / sq);

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
    }

    function retire(){

        const age = parseInt(document.getElementById("age").value, 10);
        const sal = document.getElementById("salary").value;
        const saved = document.getElementById("saved").value;
        const goal = document.getElementById("goal").value;

        if(age > 99 || age < 14 || sal > 1850000000 || sal < 1 || saved > 100 || saved < 1 || goal < 1){
            alert("The ranges are the following:\n Age: 14-99\n Salary: 1-1,850,000,000\n Percent Saved: 1-100\n Goal: 1-Infinity");
        }else{

            let msg = "";

            const percent = saved / 100;
            const yearlySaved = (sal * percent) + ((sal * percent) * 0.35);
            const addNum = Math.ceil(goal / yearlySaved);
            const finalAge = Math.ceil(addNum + age);

            if(finalAge > 100){
                msg = "You would be dead by that point.";
            }

            document.getElementById("finAge").innerHTML = finalAge + ". " + msg;
        }
    }
</script>

    <body style="text-align: center;">

    <h1>Welcome to the Mostly Useless Calculator</h1>

    <h3>BMI Calculator</h3>
    <form>

        <label for="height" style="display:inline;">Height (in inches):</label>
        <input type="number" id="height" min="0" max="120" style="height: 15px;"><p style="display: inline;"> in.</p><br><br>
        <label for="weight" style="display:inline;">Weight (in pounds):</label>
        <input type="number" id="weight" min="0" max="1000" style="height: 15px;"><p style="display: inline;"> lbs.</p><br><br>

    </form>

    <label for="bmi" style="display: inline;">BMI: </label>
    <div id="bmi" style="display: inline;"></div><br><br>

    <button onclick="bmi()">BMI</button><br><br><br><br>

    <h3>Retirement Calculator</h3>
    <p></p>

    <form>

        <label for="age" style="display: inline;">Current Age: </label>
        <input type="number" id="age" min="14" max="99" style="height: 15px;"><p style="display: inline;"> y/o</p><br><br>
        <label for="salary" style="display: inline;">Annual Salary: </label>
        <p style="display: inline;">$ </p><input type="number" id="salary" min="1" max="1850000000" style="height: 15px;"><br><br>
        <label for="saved" style="display: inline;">Percentage Saved: </label>
        <input type="number" id="saved" min="1" max="100" style="height: 15px;"><p style="display: inline;"> %</p><br><br>
        <label for="goal" style="display: inline;">Savings Goal:</label>
        <p style="display: inline;">$ </p><input type="number" id="goal" min="1" style="height: 15px;"><br><br>

    </form>

    <label for="finAge" style="display: inline;">You would be: </label>
    <div id="finAge" style="display: inline;"></div><br><br>

    <button onclick="retire()">Retire</button>
    </body>
</html>