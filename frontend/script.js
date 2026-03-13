async function analyze(){

const code = document.getElementById("code").value;

const response = await fetch("http://localhost:8080/analyze",{
method:"POST",
body:code
});

const result = await response.text();

document.getElementById("result").innerText =
"Time Complexity: " + result;

}