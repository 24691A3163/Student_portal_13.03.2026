//register

document.getElementById("registerForm").addEventListener("submit",async(e) => { e.preventDefault();

    const user ={
        name:document.getElementById("name").value,
    email:document.getElementById("email").value,
    password:document.getElementById("password").value
    };

    const response = await fetch("http://localhost:8080/register",{
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(user)
    });

alert(await response.text());
});


//login

document.getElementById("loginForm").addEventListener("submit", async (e) => {
  e.preventDefault();
  const user = {
    email: document.getElementById("loginEmail").value,
    password: document.getElementById("loginPassword").value
  };

  const response = await fetch("http://localhost:8080/login", {
    method: "POST",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify(user)
  });

  alert(await response.text());
});