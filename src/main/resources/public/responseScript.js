function LoginMsg(username, password) {
    let url = "/login?username=" + username.value + "&password=" + password.value;
  
    fetch(url, { method: "POST" })
      .then((x) => x.text())
      .then((y) => (document.getElementById("LoginMsg").innerHTML = y));
  }