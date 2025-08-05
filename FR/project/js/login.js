// login.js

document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("loginForm");
  if (!form) return;

  form.addEventListener("submit", function (e) {
    e.preventDefault();

    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();
    const role = document.getElementById("role").value;

    if (!email || !password || !role) {
      alert("Please fill in all fields.");
      return;
    }

    // Simulated redirection
    if (role === "LANDLORD") {
      window.location.href = "landlord/ownerDashboard.html";
    } else {
      window.location.href = "tenant/tenantDashboard.html";
    }
  });
});
